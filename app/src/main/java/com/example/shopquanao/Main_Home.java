package com.example.shopquanao;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.shopquanao.Fragment.Fragment_Account;
import com.example.shopquanao.Fragment.Fragment_Cart;
import com.example.shopquanao.Fragment.Fragment_Dashboard;
import com.example.shopquanao.Fragment.Fragment_Home;
import com.example.shopquanao.Model.GioHang;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class Main_Home extends AppCompatActivity {
    BottomNavigationView navView;
    EditText searchView;
    public static ArrayList<GioHang> arrayList_GioHang;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_home);
        if (arrayList_GioHang != null) {

        } else {
            arrayList_GioHang = new ArrayList<>();
        }
        navView = findViewById(R.id.nav_view_thuvien);
        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);
        navView.setSelectedItemId(R.id.nav_home);
        searchView = findViewById(R.id.search_view);
        searchView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main_Home.this, Search_Activity.class);
                startActivity(intent);
            }
        });
    }


    private BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            switch (item.getItemId()) {
                case R.id.nav_home:
                    fragment = new Fragment_Home();
                    loadFragment(fragment);

                    return true;

                case R.id.nav_list:

                    fragment = new Fragment_Dashboard();
                    loadFragment(fragment);

                    return true;
                case R.id.nav_cart:

                    fragment = new Fragment_Cart();
                    loadFragment(fragment);
                    return true;
                case R.id.nav_ACCOUNT:
                    fragment = new Fragment_Account();
                    loadFragment(fragment);

                    return true;


            }
            return false;
        }
    };


    private void loadFragment(Fragment fragment) {
        //load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.nav_fragment_thuvien, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
