package com.example.shopquanao.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.shopquanao.Model.DanhMuc;
import com.example.shopquanao.R;


import java.util.ArrayList;
import java.util.List;

public class Adapter_listView_DanhMuc extends ArrayAdapter<DanhMuc> {

    ArrayList<DanhMuc> arrayList;
    public Adapter_listView_DanhMuc(@NonNull Context context, @NonNull List<DanhMuc> objects) {
        super(context,0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View converView, @NonNull ViewGroup parent) {


        DanhMuc model=getItem(position);

        converView= LayoutInflater.from(getContext()).inflate(R.layout.title_danhmuc,parent,false);


        TextView txt_caption=converView.findViewById(R.id.textView2);


        txt_caption.setText(model.getTenDanhMuc());


        return converView;
    }
}

