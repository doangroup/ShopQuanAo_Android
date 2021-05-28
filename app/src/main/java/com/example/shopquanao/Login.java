package com.example.shopquanao;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.shopquanao.DB.ConnectionDB;
import com.example.shopquanao.Model.KhachHangLogin;
import com.example.shopquanao.Model.QuanLySession;

public class Login extends AppCompatActivity {
    EditText editText_tk, editText_mk;
    Button button;
    ConnectionDB connectionDB;
    String tk_SDT,tk_MK;
    QuanLySession session;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        connectionDB = new ConnectionDB();
        session = new QuanLySession(getApplicationContext());

        Intent intent = getIntent();

        tk_SDT = intent.getStringExtra("a1");
        tk_MK = intent.getStringExtra("a2");

        editText_tk = findViewById(R.id.editTextTextPersonName);
        editText_mk = findViewById(R.id.editTextTextPassword);

        editText_tk.setText(tk_SDT);
        editText_mk.setText(tk_MK);

        button = findViewById(R.id.button_DangNhap);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tk_SDT = editText_tk.getText().toString();
                tk_MK = editText_mk.getText().toString();

                KhachHangLogin khachHangLogin = new KhachHangLogin();
                String kq = khachHangLogin.Login(tk_SDT, tk_MK);
                session.createLoginSession(tk_SDT,tk_MK);
                Intent myIntent = new Intent(Login.this, Main_Home.class);
                startActivity(myIntent);
                Toast.makeText(Login.this, "Chào Mừng Khách Hàng Đến Với LoGan Shop", Toast.LENGTH_LONG).show();

              }
        });

    }
}
