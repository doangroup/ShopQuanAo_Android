package com.example.shopquanao;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.shopquanao.Model.KhachHang;
import com.example.shopquanao.Model.KhachHangModel;
import com.example.shopquanao.Model.QuanLySession;

import java.util.ArrayList;
import java.util.Random;

public class DangKy_Activity extends AppCompatActivity {
    TextView textView_ten, textView_dc, textView_sdt, textView_mk;
    KhachHangModel khachHangModel = new KhachHangModel();
    ArrayList<KhachHang> arrayList;
    Button button, button2;
    KhachHang khachHang = new KhachHang();
    QuanLySession session;
    String sdt, mk;
    KhachHangModel model = new KhachHangModel();
    public static ArrayList<KhachHang> data_account;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acticity_dangky);
        AnhXa();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final int min = 1000;
                final int max = 8000;
                Random random = new Random();
                int maKhach = random.nextInt((max - min) + 1) + min;
                // int maKhach=random.nextInt(300);
                boolean kiemTra = false;

                khachHang.setMaKhachHang(maKhach);
                khachHang.setTenKhachHang(textView_ten.getText().toString());
                khachHang.setDiaChi(textView_dc.getText().toString());
                khachHang.setsDT(textView_sdt.getText().toString());
                khachHang.setMatKhau(textView_mk.getText().toString());

                kiemTra = khachHangModel.DangKyThanhVien(khachHang.getMaKhachHang(), khachHang.getTenKhachHang(), khachHang.getDiaChi(), khachHang.getsDT(), khachHang.getMatKhau());

                if (kiemTra == true) {
                    Toast.makeText(DangKy_Activity.this, "Đăng ký thành công", Toast.LENGTH_LONG).show();
                    Intent i = new Intent(DangKy_Activity.this, Login.class);
                    i.putExtra("a1", textView_sdt.getText().toString());
                    i.putExtra("a2", textView_mk.getText().toString());
                    i.putExtra("a3", textView_ten.getText().toString());
                    i.putExtra("a4", textView_dc.getText().toString());
                    startActivity(i);
                } else {
                    Toast.makeText(DangKy_Activity.this, "Đăng ký thất bại", Toast.LENGTH_LONG).show();
                }

            
            }
        });
    }

    public void AnhXa() {
        textView_ten = findViewById(R.id.editTextTextPersonName2_d);
        textView_dc = findViewById(R.id.editTextTextPersonName3_d);
        textView_sdt = findViewById(R.id.editTextTextPassword_d);
        textView_mk = findViewById(R.id.editTextTextPassword2_d);
        button = findViewById(R.id.btn_signin_d);
        button2 = findViewById(R.id.btn_cancel_d);
    }
}
