package com.example.shopquanao;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
Handler handler=new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        handler.postDelayed(chuyenCanh, 3000);
    }

    Runnable chuyenCanh = new Runnable() {
        @Override
        public void run() {

            Intent i = new Intent(MainActivity.this, Main_Home.class);
            startActivity(i);
            finish();

        }
    };
}
