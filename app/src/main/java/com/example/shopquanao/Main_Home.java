package com.example.shopquanao;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.shopquanao.Fragment.Fragment_Account;
import com.example.shopquanao.Fragment.Fragment_Cart;
import com.example.shopquanao.Fragment.Fragment_Dashboard;
import com.example.shopquanao.Fragment.Fragment_Home;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Main_Home extends AppCompatActivity {
    BottomNavigationView navView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_home);
        navView=findViewById(R.id.nav_view_thuvien);
        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);
        navView.setSelectedItemId(R.id.nav_home);
    }


    private BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            switch (item.getItemId())
            {
                case R.id.nav_home:
                    fragment= new Fragment_Home();
                    loadFragment(fragment);

                    return true;

                case R.id.nav_list:

                    fragment=new Fragment_Dashboard();
                    loadFragment(fragment);

                    return true;
                case R.id.nav_cart:

                    fragment=new Fragment_Cart();
                    loadFragment(fragment);
                    return true;
                case R.id.nav_ACCOUNT:
                    fragment=new Fragment_Account();
                    loadFragment(fragment);

                    return true;


            }
            return false;
        }};


    private  void loadFragment(Fragment fragment)
    {
        //load fragment
        FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.nav_fragment_thuvien,fragment);
        //transaction.addToBackStack(null);
        transaction.commit();
    }
}
