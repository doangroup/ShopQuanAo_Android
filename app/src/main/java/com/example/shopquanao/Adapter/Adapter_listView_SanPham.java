package com.example.shopquanao.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.shopquanao.Model.SanPham;
import com.example.shopquanao.R;

import java.text.DecimalFormat;
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


        TextView txt_tenSP=converView.findViewById(R.id.textView_TenSP);
TextView txt_gia=converView.findViewById(R.id.textView_DonGia);
        ImageView imageView=converView.findViewById(R.id.image_Hinh_sanPham);
        txt_tenSP.setText(model.getTenSP());
        DecimalFormat decimalFormat=new DecimalFormat("###,###,###");
txt_gia.setText(decimalFormat.format(model.getDonGia())+" "+"vnd");

        Context c = getContext();
        int id = c.getResources().getIdentifier("drawable/"+model.getHinhAnh().replace(".jpg",""), null, c.getPackageName());
        imageView.setImageResource(id);


        return converView;
    }
}
