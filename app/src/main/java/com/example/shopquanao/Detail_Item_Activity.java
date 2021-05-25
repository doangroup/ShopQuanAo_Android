package com.example.shopquanao;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Detail_Item_Activity extends AppCompatActivity {
    TextView textView_TenSP, textView_DonGia;
    ImageView imageView_HinhAnh;
    String tenSP,  hinhAnh;
    int donGia;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_detail_item);
        Intent intent = getIntent();
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
    }
}
