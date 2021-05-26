package com.example.shopquanao;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.shopquanao.Model.GioHang;

import java.util.ArrayList;

public class Detail_Item_Activity extends AppCompatActivity {
    TextView textView_TenSP, textView_DonGia;
    ImageView imageView_HinhAnh;
    String tenSP,  hinhAnh;
    int maSP;
    int donGia;
public ArrayList<GioHang> arrayList_GioHang;
Button button;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_item);
        Intent intent = getIntent();
        maSP = intent.getIntExtra("MaSP",000);
        tenSP = intent.getStringExtra("TenSP");
        donGia = intent.getIntExtra("DonGia",000);
        hinhAnh = intent.getStringExtra("HinhAnh");

        textView_TenSP = findViewById(R.id.txt_TenSP_detail);
        textView_DonGia = findViewById(R.id.txt_Dongia_detail);
        imageView_HinhAnh = findViewById(R.id.imgae_view_deatail);

        Context c = getApplication();
        int id =getResources().getIdentifier("drawable/"+hinhAnh.replace(".jpg",""), null, c.getPackageName());
        textView_TenSP.setText(tenSP);
        textView_DonGia.setText(String.valueOf(donGia)+"vnd");
        imageView_HinhAnh.setImageResource(id);


        button=findViewById(R.id.btn_themgioHang_Detail);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Main_Home.arrayList_GioHang.size()>0)
                {
int sl=1;
boolean tonTai=false;
for (int i=0;i<Main_Home.arrayList_GioHang.size();i++){
    if (Main_Home.arrayList_GioHang.get(i).getMaSP()==maSP){
        Main_Home.arrayList_GioHang.get(i).setSoLuong(Main_Home.arrayList_GioHang.get(i).getSoLuong()+sl);
        if (Main_Home.arrayList_GioHang.get(i).getSoLuong()>=10){
            Main_Home.arrayList_GioHang.get(i).setSoLuong(10);
        }
        Main_Home.arrayList_GioHang.get(i).setSoLuong(donGia*Main_Home.arrayList_GioHang.get(i).getSoLuong());

    }
    if (tonTai==false){

        int tongTien=sl*donGia;
        Main_Home.arrayList_GioHang.add(new GioHang(maSP,tenSP,tongTien,hinhAnh,sl));
    }
}
                }else {
                    int sl=1;
                    int tongTien=sl*donGia;
Main_Home.arrayList_GioHang.add(new GioHang(maSP,tenSP,tongTien,hinhAnh,sl));
                }
                Toast.makeText(Detail_Item_Activity.this,"Đăng ký thành công",Toast.LENGTH_LONG).show();
            }
        });
    }

}
