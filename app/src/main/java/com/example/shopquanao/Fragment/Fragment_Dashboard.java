package com.example.shopquanao.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.shopquanao.Adapter.adapter;
import com.example.shopquanao.Model.KhachHang;
import com.example.shopquanao.Model.KhachHangModel;
import com.example.shopquanao.R;

import java.sql.SQLException;
import java.util.ArrayList;

public class Fragment_Dashboard extends Fragment {
    ListView listView;
KhachHangModel model;



    com.example.shopquanao.Adapter.adapter adapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_dashboard, container, false);


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ArrayList<KhachHang> data= null;

        try {
            adapter = new adapter(model.getKhachHangList());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        listView = view.findViewById(R.id.list_view);
        listView.setAdapter(adapter);
    }
}
