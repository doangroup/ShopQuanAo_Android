package com.example.shopquanao.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.shopquanao.Adapter.Adapter_listView_SanPham;
import com.example.shopquanao.Model.SanPham;
import com.example.shopquanao.Model.SanPhamModel;
import com.example.shopquanao.R;

import java.util.ArrayList;

public class Fragment_Home extends Fragment {
    ListView listView;

    SanPhamModel sanPhamModel = new SanPhamModel();

    Adapter_listView_SanPham adapter_listView_sanPham;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ArrayList<SanPham> arrayList;

        listView=view.findViewById(R.id.list_view_2);
        arrayList=sanPhamModel.lay_SanPham();
        adapter_listView_sanPham=new Adapter_listView_SanPham(getContext(),arrayList);
        listView.setAdapter(adapter_listView_sanPham);
    }
}
