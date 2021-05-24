package com.example.shopquanao.Adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.shopquanao.Model.KhachHang;
import com.example.shopquanao.Model.KhachHangModel;
import com.example.shopquanao.R;


import java.util.ArrayList;

public class adapter extends BaseAdapter {
    final ArrayList<KhachHang> listProduct;

    public adapter(ArrayList<KhachHang> listProduct) {
        this.listProduct = listProduct;
    }


    @Override
    public int getCount() {
        return listProduct.size();
    }

    @Override
    public Object getItem(int position) {
        return listProduct.get(position).getMaKhachHang();
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View viewProduct;
        if (convertView == null) {
            viewProduct = View.inflate(parent.getContext(), R.layout.title, null);
        } else viewProduct = convertView;

        //Bind sữ liệu phần tử vào View
       KhachHang product = (KhachHang) getItem(position);

        ((TextView) viewProduct.findViewById(R.id.textView2)).setText(String.format("Giá %d", product.getTenKhachHang()));


        return viewProduct;
    }
}
