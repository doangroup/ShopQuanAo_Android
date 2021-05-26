package com.example.shopquanao.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.shopquanao.Fragment.Fragment_Cart;
import com.example.shopquanao.Main_Home;
import com.example.shopquanao.Model.GioHang;
import com.example.shopquanao.R;

import java.util.ArrayList;

public class Adapter_GioHang extends BaseAdapter {
    Context context;
    ArrayList<GioHang> arrayList;
    ViewHolder viewHolder = null;




    public Adapter_GioHang(Context context, ArrayList<GioHang> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class ViewHolder {
        public TextView txt_ten, txt_gia;
        ImageView imageView_giohang;
        Button btn_tru, btn_so, btn_cong;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        if (view == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.title_giohang, null);

            viewHolder.txt_ten = view.findViewById(R.id.txt_ten_item_GioHnag);
            viewHolder.txt_gia = view.findViewById(R.id.txt_gia_gio_hang);
            viewHolder.imageView_giohang = view.findViewById(R.id.image_cart);
            viewHolder.btn_tru = view.findViewById(R.id.btn_tru_gioHang);
            viewHolder.btn_so = view.findViewById(R.id.btn_So_gioHang);
         viewHolder.btn_cong = (Button) view.findViewById(R.id.btn_cong_gioHang);

            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        GioHang gioHang = (GioHang) getItem(position);
        viewHolder.txt_ten.setText(gioHang.getTenSP());
        viewHolder.txt_gia.setText(String.valueOf(gioHang.getGia()));
        Context c = context;
        int id = c.getResources().getIdentifier("drawable/" + gioHang.getHinhSP().replace(".jpg", ""), null, c.getPackageName());
        viewHolder.imageView_giohang.setImageResource(id);
        viewHolder.btn_so.setText(String.valueOf(gioHang.getSoLuong()));

        int sl = Integer.parseInt(viewHolder.btn_so.getText().toString());
        if (sl>=100)
        {
            viewHolder.btn_cong.setVisibility(View.INVISIBLE);
            viewHolder.btn_tru.setVisibility(View.VISIBLE);
        }else if (sl<=1)
        {
            viewHolder.btn_tru.setVisibility(View.INVISIBLE);
        } else if (sl>=1)
        { viewHolder.btn_cong.setVisibility(View.VISIBLE);
            viewHolder.btn_tru.setVisibility(View.VISIBLE);
        }

        viewHolder.btn_cong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int slmn = Integer.parseInt(viewHolder.btn_so.getText().toString())+1;
                int slht= Main_Home.arrayList_GioHang.get(position).getSoLuong();
                int giaht=Main_Home.arrayList_GioHang.get(position).getGia();
                Main_Home.arrayList_GioHang.get(position).setSoLuong(slmn);
                int giamn=(giaht*slmn)/slht;
                Main_Home.arrayList_GioHang.get(position).setGia(giamn);
                viewHolder.txt_gia.setText(String.valueOf(giamn));
                Fragment_Cart.tongTien();
                if (slmn>100){
                    viewHolder.btn_cong.setVisibility(View.INVISIBLE);
                    viewHolder.btn_tru.setVisibility(View.VISIBLE);
                    viewHolder.btn_so.setText(String.valueOf(slmn));
                }
                else {
                    viewHolder.btn_cong.setVisibility(View.VISIBLE);
                    viewHolder.btn_tru.setVisibility(View.VISIBLE);
                    viewHolder.btn_so.setText(String.valueOf(slmn));
                }

            }
        });
        viewHolder.btn_tru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int slmn = Integer.parseInt(viewHolder.btn_so.getText().toString())-1;
                int slht= Main_Home.arrayList_GioHang.get(position).getSoLuong();
                int giaht=Main_Home.arrayList_GioHang.get(position).getGia();
                Main_Home.arrayList_GioHang.get(position).setSoLuong(slmn);
                int giamn=(giaht*slmn)/slht;
                Main_Home.arrayList_GioHang.get(position).setGia(giamn);
                viewHolder.txt_gia.setText(String.valueOf(giamn));
                Fragment_Cart.tongTien();
                if (slmn<0){
                    viewHolder.btn_cong.setVisibility(View.INVISIBLE);
                    viewHolder.btn_tru.setVisibility(View.VISIBLE);
                    viewHolder.btn_so.setText(String.valueOf(slmn));
                }
                else {
                    viewHolder.btn_cong.setVisibility(View.VISIBLE);
                    viewHolder.btn_tru.setVisibility(View.VISIBLE);
                    viewHolder.btn_so.setText(String.valueOf(slmn));
                }
            }
        });
        return view;
    }
}
