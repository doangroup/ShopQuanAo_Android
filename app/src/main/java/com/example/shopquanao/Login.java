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
    Button button, button2;
    ConnectionDB connectionDB;
    String tk_SDT, tk_MK;
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

        button2 = findViewById(R.id.button_DangKy);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Login.this, Main_Home.class);
                startActivity(myIntent);


            }
        });
        button = findViewById(R.id.button_DangNhap);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tk_SDT = editText_tk.getText().toString();
                tk_MK = editText_mk.getText().toString();

                KhachHangLogin khachHangLogin = new KhachHangLogin();
                String kq = khachHangLogin.Login(tk_SDT, tk_MK);
                if (kq == "true") {
                    session.createLoginSession(tk_SDT, tk_MK);
                    Intent myIntent = new Intent(Login.this, Main_Home.class);
                    startActivity(myIntent);
                    Toast.makeText(Login.this, "Ch??o M???ng Kh??ch H??ng ?????n V???i LoGan Shop", Toast.LENGTH_LONG).show();

                } else {
                    Toast.makeText(Login.this, "Sai User ho???c M???t Kh???u", Toast.LENGTH_LONG).show();
                }


            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Login.this, DangKy_Activity.class);
                startActivity(myIntent);
            }
        });
    }
}
