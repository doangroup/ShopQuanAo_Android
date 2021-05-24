package com.example.shopquanao.Adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.shopquanao.Model.DanhMuc;
import com.example.shopquanao.Model.KhachHang;
import com.example.shopquanao.Model.KhachHangModel;
import com.example.shopquanao.R;


import java.util.ArrayList;

public class Adapter_listView extends BaseAdapter {
    final ArrayList<DanhMuc> listProduct;

    public Adapter_listView(ArrayList<DanhMuc> listProduct) {
        this.listProduct = listProduct;
    }


    @Override
    public int getCount() {
        return listProduct.size();
    }

    @Override
    public Object getItem(int position) {
        return listProduct.get(position).getMaDanhMuc();
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
      DanhMuc product = (DanhMuc) getItem(position);

        ((TextView) viewProduct.findViewById(R.id.textView2)).setText( product.getTenDanhMuc());


        return viewProduct;
    }
}
