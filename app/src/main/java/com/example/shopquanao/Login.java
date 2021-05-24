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

public class Login extends AppCompatActivity {
    EditText editText_tk, editText_mk;
    Button button;
    ConnectionDB connectionDB;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        connectionDB = new ConnectionDB();

        editText_tk = findViewById(R.id.editTextTextPersonName);
        editText_mk = findViewById(R.id.editTextTextPassword);
        button = findViewById(R.id.button_DangNhap);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String SDT = editText_tk.getText().toString();
                String MK = editText_mk.getText().toString();

                KhachHangLogin khachHangLogin = new KhachHangLogin();
                String kq = khachHangLogin.Login(SDT, MK);
                Intent myIntent = new Intent(Login.this, Main_Home.class);
                startActivity(myIntent);
                Toast.makeText(Login.this, kq, Toast.LENGTH_SHORT).show();
            }
        });

    }
}
