package com.example.shopquanao;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.shopquanao.Adapter.Adapter_XacNhanGioHang;
import com.example.shopquanao.Model.KhachHang;
import com.example.shopquanao.Model.KhachHangModel;
import com.example.shopquanao.Model.QuanLySession;

import java.util.ArrayList;
import java.util.HashMap;

public class XacNhanDonHang_Activity extends AppCompatActivity { ListView listView;
    Adapter_XacNhanGioHang adapter_gioHang;
    TextView textView_ten,textView_sc,textView_sdt,textView_tt;
    ArrayList<KhachHang> data;
    KhachHangModel model = new KhachHangModel();
    QuanLySession session;
    String sdt;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        session = new QuanLySession(this);

        HashMap<String, String> user = session.getUserDetails();
        sdt = user.get(QuanLySession.KEY_sdt);
        data = model.lay_KhachHang(sdt);
        setContentView(R.layout.activity_xacnhandonhang);
        listView=findViewById(R.id.listview_giohang_xacnhandonhang);
        adapter_gioHang = new Adapter_XacNhanGioHang(this, Main_Home.arrayList_GioHang);
        listView.setAdapter(adapter_gioHang);


        anhXa();
        for (KhachHang k: data
        ) {
            textView_ten.setText(k.getTenKhachHang());
            textView_sc.setText(k.getDiaChi());
            textView_sdt.setText(k.getsDT());
        }
        tongTien();



    }

    public void anhXa(){
        textView_ten=findViewById(R.id.txt_gantenkhachhangxndh);
        textView_sc=findViewById(R.id.txt_gandiachixndh);
        textView_sdt=findViewById(R.id.txt_gansdtxndh);
        textView_tt=findViewById(R.id.txt_tien);
    }
    public  void tongTien() {
        int tongTien = 0;
        for (int i = 0; i < Main_Home.arrayList_GioHang.size(); i++) {
            tongTien += Main_Home.arrayList_GioHang.get(i).getGia();
        }

        textView_tt.setText(String.valueOf(tongTien)+""+"vnd");
    }
}
