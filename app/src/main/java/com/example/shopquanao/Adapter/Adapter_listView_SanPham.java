package com.example.shopquanao.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.shopquanao.Model.DanhMuc;
import com.example.shopquanao.Model.SanPham;
import com.example.shopquanao.R;

import java.util.List;

public class Adapter_listView_SanPham extends ArrayAdapter<SanPham> {
    public Adapter_listView_SanPham(@NonNull Context context, @NonNull List<SanPham> objects) {
        super(context, 0, objects);
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View converView, @NonNull ViewGroup parent) {


        SanPham model=getItem(position);

        converView= LayoutInflater.from(getContext()).inflate(R.layout.title_sanpham,parent,false);


        TextView txt_caption=converView.findViewById(R.id.textView3);


        txt_caption.setText(model.getTenSP());


        return converView;
    }
}
