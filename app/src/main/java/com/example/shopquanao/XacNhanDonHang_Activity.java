package com.example.shopquanao;

import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.shopquanao.Adapter.Adapter_XacNhanGioHang;
import com.example.shopquanao.Model.ChiTietHoaDon;
import com.example.shopquanao.Model.ChiTietHoaDonModel;
import com.example.shopquanao.Model.GioHang;
import com.example.shopquanao.Model.HoaDon;
import com.example.shopquanao.Model.HoaDonModel;
import com.example.shopquanao.Model.KhachHang;
import com.example.shopquanao.Model.KhachHangModel;
import com.example.shopquanao.Model.QuanLySession;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class XacNhanDonHang_Activity extends AppCompatActivity {
    ListView listView;
    Adapter_XacNhanGioHang adapter_gioHang;
    TextView textView_ten, textView_sc, textView_sdt, textView_tt;
    ArrayList<KhachHang> data;
    KhachHangModel model = new KhachHangModel();
    QuanLySession session;
    String sdt;
    Button button;
    int maKhach;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        session = new QuanLySession(this);
        button = findViewById(R.id.btn_XacNhanDonHang);
        HashMap<String, String> user = session.getUserDetails();
        sdt = user.get(QuanLySession.KEY_sdt);
        data = model.lay_KhachHang(sdt);
        setContentView(R.layout.activity_xacnhandonhang);
        listView = findViewById(R.id.listview_giohang_xacnhandonhang);
        adapter_gioHang = new Adapter_XacNhanGioHang(this, Main_Home.arrayList_GioHang);
        listView.setAdapter(adapter_gioHang);


        anhXa();
        for (KhachHang k : data
        ) {
            textView_ten.setText(k.getTenKhachHang());
            textView_sc.setText(k.getDiaChi());
            textView_sdt.setText(k.getsDT());
            maKhach = k.getMaKhachHang();
        }
        tongTien();
//        button.setOnClickListener(new View.OnClickListener() {
//            @RequiresApi(api = Build.VERSION_CODES.O)
//            @Override
//            public void onClick(View v) {
//try {
//    Add();
//}catch (Exception e){
//    e.getMessage();
//}
//
//            }
//        });


    }
@RequiresApi(api = Build.VERSION_CODES.O)
public  void Add(){
    Random rd = new Random();
    int maHD = rd.nextInt(10000);
    int macthd = rd.nextInt(5000);
    HoaDon hd = new HoaDon();
    hd.setMaKh(maKhach);
    hd.setMaNv(1);
    hd.setMaHD(maHD);
    hd.setNgayBan(java.time.LocalDate.now().toString());
    hd.setNgayGiao(null);
    hd.setTinhTrang(0);
    hd.setTongTien(tongTienhd());

    HoaDonModel hoaDonModel = new HoaDonModel();
    try {
        if (hoaDonModel.ThemHoaDon(hd.getMaHD(), hd.getMaKh(), hd.getMaNv(), hd.getTinhTrang(), hd.getNgayBan(), hd.getNgayGiao(), hd.getTongTien()) == true) {
            try {
                for (GioHang item : Main_Home.arrayList_GioHang
                ) {

                    ChiTietHoaDon chiTietHoaDon = new ChiTietHoaDon();
                    chiTietHoaDon.setMaHD(hd.getMaHD());
                    chiTietHoaDon.setMaSP(item.maSP);
                    chiTietHoaDon.setSoLuong(item.soLuong);
                    chiTietHoaDon.setThanhTien(item.gia);
                    ChiTietHoaDonModel chiTietHoaDonModel = new ChiTietHoaDonModel();
                    if (chiTietHoaDonModel.ThemCTHoaDon(macthd, chiTietHoaDon.getMaHD(), chiTietHoaDon.getMaSP(), chiTietHoaDon.getSoLuong(), chiTietHoaDon.getThanhTien()) == true) {

                    }
                }
            } catch (Exception e) {
                e.getMessage();
            }

        }
    } catch (Exception e) {
        e.getMessage();
    }


}
    public void anhXa() {
        textView_ten = findViewById(R.id.txt_gantenkhachhangxndh);
        textView_sc = findViewById(R.id.txt_gandiachixndh);
        textView_sdt = findViewById(R.id.txt_gansdtxndh);
        textView_tt = findViewById(R.id.txt_tien);
    }

    public void tongTien() {
        float tongTien = 0;
        for (int i = 0; i < Main_Home.arrayList_GioHang.size(); i++) {
            tongTien += Main_Home.arrayList_GioHang.get(i).getGia();
        }
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        textView_tt.setText(decimalFormat.format(tongTien) + " " + "vnd");
    }

    public float tongTienhd() {
        float tongTien = 0;
        for (int i = 0; i < Main_Home.arrayList_GioHang.size(); i++) {
            tongTien += Main_Home.arrayList_GioHang.get(i).getGia();
        }

        return tongTien;
    }
}
