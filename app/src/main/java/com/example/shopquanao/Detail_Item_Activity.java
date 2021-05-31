package com.example.shopquanao;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.shopquanao.Model.GioHang;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Detail_Item_Activity extends AppCompatActivity {
    TextView textView_TenSP, textView_DonGia;
    ImageView imageView_HinhAnh;
    String tenSP, hinhAnh;
    int maSP;
   float donGia;
    Spinner spinner;
    public ArrayList<GioHang> arrayList_GioHang;
    Button button;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_item);
        Intent intent = getIntent();
        maSP = intent.getIntExtra("MaSP", 000);
        tenSP = intent.getStringExtra("TenSP");
        donGia = intent.getFloatExtra("DonGia", 000);
        hinhAnh = intent.getStringExtra("HinhAnh");



        spinner = findViewById(R.id.spiner_detail);
        textView_TenSP = findViewById(R.id.txt_TenSP_detail);
        textView_DonGia = findViewById(R.id.txt_Dongia_detail);
        imageView_HinhAnh = findViewById(R.id.imgae_view_deatail);
        duLieuSpiner();
        Context c = getApplication();
        int id = getResources().getIdentifier("drawable/" + hinhAnh.replace(".jpg", ""), null, c.getPackageName());
        textView_TenSP.setText(tenSP);
        DecimalFormat decimalFormat=new DecimalFormat("###,###,###");
        textView_DonGia.setText(decimalFormat.format(donGia)+" "+"vnd");
        imageView_HinhAnh.setImageResource(id);


        button = findViewById(R.id.btn_themgioHang_Detail);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Main_Home.arrayList_GioHang.size() > 0) {
                    int sl = Integer.parseInt(spinner.getSelectedItem().toString());
                    boolean tonTai = false;
                    for (int i = 0; i < Main_Home.arrayList_GioHang.size(); i++) {
                        if (Main_Home.arrayList_GioHang.get(i).getMaSP() == maSP) {
                            Main_Home.arrayList_GioHang.get(i).setSoLuong(Main_Home.arrayList_GioHang.get(i).getSoLuong() + sl);
//                            if (Main_Home.arrayList_GioHang.get(i).getSoLuong() >= 10) {
//                                Main_Home.arrayList_GioHang.get(i).setSoLuong(10);
//                            }
                            Main_Home.arrayList_GioHang.get(i).setGia(donGia * Main_Home.arrayList_GioHang.get(i).getSoLuong());
                            tonTai = true;
                        }

                        }
                    if (tonTai == false) {

                        float tongTien = sl * donGia;
                        Main_Home.arrayList_GioHang.add(new GioHang(maSP, tenSP, tongTien, hinhAnh, sl));
                    }

                    Intent i1=new Intent(Detail_Item_Activity.this, Main_Home.class);
                    Detail_Item_Activity.this.startActivity(i1);
                } else {
                    int ssl = Integer.parseInt(spinner.getSelectedItem().toString());
                    float tongTien = ssl * donGia;
                    Main_Home.arrayList_GioHang.add(new GioHang(maSP, tenSP, tongTien, hinhAnh, ssl));
                    Intent i1=new Intent(Detail_Item_Activity.this, Main_Home.class);
                    Detail_Item_Activity.this.startActivity(i1);
                }
                Toast.makeText(Detail_Item_Activity.this, "Mua thành công", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void duLieuSpiner() {
        Integer[] data = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        ArrayAdapter<Integer> arrayAdapter = new ArrayAdapter<Integer>(this, R.layout.support_simple_spinner_dropdown_item, data);
        spinner.setAdapter(arrayAdapter);
    }
}
