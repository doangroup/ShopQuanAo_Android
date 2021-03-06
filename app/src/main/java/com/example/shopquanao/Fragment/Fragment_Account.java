package com.example.shopquanao.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.shopquanao.Login;
import com.example.shopquanao.Model.KhachHang;
import com.example.shopquanao.Model.KhachHangModel;
import com.example.shopquanao.Model.QuanLySession;
import com.example.shopquanao.R;

import java.util.ArrayList;
import java.util.HashMap;

public class Fragment_Account extends Fragment {
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
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_account, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);




        session = new QuanLySession(getContext());

        HashMap<String, String> user = session.getUserDetails();
        sdt = user.get(QuanLySession.KEY_sdt);
        mk = user.get(QuanLySession.KEY_mk);
        data_account = model.lay_KhachHang(sdt);
        textView_ten = view.findViewById(R.id.editTextTextPersonName2);
        textView_dc = view.findViewById(R.id.editTextTextPersonName3);
        textView_sdt = view.findViewById(R.id.editTextTextPassword);
        textView_mk = view.findViewById(R.id.editTextTextPassword2);


        for (KhachHang khachHang : data_account) {
            textView_ten.setText(khachHang.getTenKhachHang());
            textView_dc.setText(khachHang.getDiaChi());
            textView_sdt.setText(khachHang.getsDT());
            textView_mk.setText(khachHang.getMatKhau());
        }


        button = view.findViewById(R.id.btn_signin);
        button2 = view.findViewById(R.id.btn_cancel);

        if (!session.isLoggedIn()){
            button2.setVisibility(View.INVISIBLE);
            button.setVisibility(View.VISIBLE);
        }else {
            button.setVisibility(View.INVISIBLE);
            button2.setVisibility(View.VISIBLE);
        }
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(getContext(), Login.class);
                startActivity(myIntent);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                session.logoutUser();
            }
        });
    }


}
