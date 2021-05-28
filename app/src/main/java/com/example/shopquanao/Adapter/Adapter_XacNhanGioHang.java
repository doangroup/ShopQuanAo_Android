package com.example.shopquanao.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.shopquanao.Model.GioHang;
import com.example.shopquanao.R;

import java.util.ArrayList;

public class Adapter_XacNhanGioHang extends BaseAdapter {
    Context context;
    ArrayList<GioHang> arrayList;
    Adapter_XacNhanGioHang.ViewHolder viewHolder = null;






    public Adapter_XacNhanGioHang(Context context, ArrayList<GioHang> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class ViewHolder {
        public TextView txt_ten, txt_gia;
        ImageView imageView_giohang;
        Button btn_so;

    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        if (view == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.title_xacnhangiohang, null);

            viewHolder.txt_ten = view.findViewById(R.id.txt_ten_item_GioHnag);
            viewHolder.txt_gia = view.findViewById(R.id.txt_gia_gio_hang);
            viewHolder.imageView_giohang = view.findViewById(R.id.image_cart);
            viewHolder.btn_so= view.findViewById(R.id.btn_So_gioHang);

            view.setTag(viewHolder);
        } else {
            viewHolder = (Adapter_XacNhanGioHang.ViewHolder) view.getTag();
        }

        GioHang gioHang = (GioHang) getItem(position);
        viewHolder.txt_ten.setText(gioHang.getTenSP());
        viewHolder.txt_gia.setText(String.valueOf(gioHang.getGia()));
        Context c = context;
        int id = c.getResources().getIdentifier("drawable/" + gioHang.getHinhSP().replace(".jpg", ""), null, c.getPackageName());
        viewHolder.imageView_giohang.setImageResource(id);

        viewHolder.btn_so.setText(String.valueOf(gioHang.getSoLuong()));




        return view;
    }
}
