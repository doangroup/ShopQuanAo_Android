package com.example.shopquanao.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.shopquanao.Model.KhachHang;
import com.example.shopquanao.Model.KhachHangModel;
import com.example.shopquanao.R;

import java.util.ArrayList;

public class Fragment_Account extends Fragment {
    TextView textView_ten,textView_dc,textView_sdt,textView_mk;
    KhachHangModel khachHangModel=new KhachHangModel();
    ArrayList<KhachHang> arrayList;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_account,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        arrayList=khachHangModel.lay_KhachHang();

        textView_ten=view.findViewById(R.id.editTextTextPersonName2);
        textView_dc=view.findViewById(R.id.editTextTextPersonName3);
        textView_sdt=view.findViewById(R.id.editTextTextPassword);
        textView_mk=view.findViewById(R.id.editTextTextPassword2);

        textView_ten.setText(arrayList.get(0).getTenKhachHang());
        textView_dc.setText(arrayList.get(0).getDiaChi());
        textView_sdt.setText(arrayList.get(0).getsDT());
        textView_mk.setText(arrayList.get(0).getMatKhau());
    }
}
