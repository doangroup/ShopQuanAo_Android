package com.example.shopquanao.Fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.shopquanao.Adapter.Adapter_GioHang;
import com.example.shopquanao.Main_Home;
import com.example.shopquanao.Model.QuanLySession;
import com.example.shopquanao.R;

public class Fragment_Cart extends Fragment {
    ListView listView;
    Adapter_GioHang adapter_gioHang;
    TextView textView_thongbao;
    public static TextView textView_tongTien;
    Button button_thanhToan;
    QuanLySession session;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_cart, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        listView = view.findViewById(R.id.listview_giohang_xacnhandonhang);
        textView_thongbao = view.findViewById(R.id.txt_thongbao);
        textView_tongTien = view.findViewById(R.id.txt_tien);
        button_thanhToan = view.findViewById(R.id.btn_ThanhToan);

        session = new QuanLySession(getContext());

        adapter_gioHang = new Adapter_GioHang(getContext(), Main_Home.arrayList_GioHang);
        listView.setAdapter(adapter_gioHang);
        kiem_Tra_Mang();
        tongTien();
        CactOnItemListView();
        button_thanhToan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                session.checkLogin();

            }
        });
    }

    private void kiem_Tra_Mang() {
        if (Main_Home.arrayList_GioHang.size() <= 0) {
            adapter_gioHang.notifyDataSetChanged();
            textView_thongbao.setVisibility(View.VISIBLE);
            listView.setVisibility(View.INVISIBLE);
        } else {
            adapter_gioHang.notifyDataSetChanged();
            textView_thongbao.setVisibility(View.INVISIBLE);
            listView.setVisibility(View.VISIBLE);
        }
    }

    public static void tongTien() {
        int tongTien = 0;
        for (int i = 0; i < Main_Home.arrayList_GioHang.size(); i++) {
            tongTien += Main_Home.arrayList_GioHang.get(i).getGia();
        }

        textView_tongTien.setText(String.valueOf(tongTien));
    }

    private void CactOnItemListView() {
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setTitle("Xác Nhận Xóa Sản Phẩm");
                builder.setMessage("Bạn Chắc Chắn muốn xóa ?");
                builder.setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        if (Main_Home.arrayList_GioHang.size() <= 0) {
                            textView_thongbao.setVisibility(view.INVISIBLE);
                        } else {
                            Main_Home.arrayList_GioHang.remove(position);
                            adapter_gioHang.notifyDataSetChanged();
                            tongTien();
                            if (Main_Home.arrayList_GioHang.size() <= 0) {
                                textView_thongbao.setVisibility(view.VISIBLE);
                            } else {
                                textView_thongbao.setVisibility(view.INVISIBLE);
                                adapter_gioHang.notifyDataSetChanged();
                                tongTien();
                            }
                        }
                    }
                });
                builder.setNegativeButton("Hủy", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        adapter_gioHang.notifyDataSetChanged();
                        tongTien();
                    }
                });
                builder.show();
                return true;
            }
        });
    }
}
