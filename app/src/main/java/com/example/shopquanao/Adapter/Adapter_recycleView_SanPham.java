package com.example.shopquanao.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shopquanao.Model.SanPham;
import com.example.shopquanao.R;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Adapter_recycleView_SanPham extends RecyclerView.Adapter<Adapter_recycleView_SanPham.SanPhamHolder> {
@NonNull


ArrayList<SanPham> arrayList;
        Context context;
private OnItemClickListener mOnItemClickListener;



public Adapter_recycleView_SanPham(ArrayList<SanPham> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
        }


public interface OnItemClickListener {
    void onItemClick(int position);
}

    public void setOnItemClickListener( OnItemClickListener Listener) {
        this.mOnItemClickListener = Listener;
    }

    @Override
    public SanPhamHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View convertView = LayoutInflater.from(context).inflate(R.layout.title_sanpham, parent, false);
        return new SanPhamHolder(convertView);
    }

    @Override
    public void onBindViewHolder(@NonNull SanPhamHolder holder, int position) {
        SanPham sp = arrayList.get(position);
        Context c = context;
        int id = c.getResources().getIdentifier("drawable/"+sp.getHinhAnh().replace(".jpg",""), null, c.getPackageName());
        holder.txt_tenSP.setText(arrayList.get(position).getTenSP());
        DecimalFormat decimalFormat=new DecimalFormat("###,###,###");
        holder.txt_gia.setText(decimalFormat.format(arrayList.get(position).getDonGia()) +" "+"vnd");
        holder.imageView.setImageResource(id);



    }
    public void UpdateList(ArrayList<SanPham> tam){
        arrayList=tam;
        notifyDataSetChanged();
    }
    @Override
    public int getItemCount() {
        return arrayList.size();
    }

public class SanPhamHolder extends RecyclerView.ViewHolder {
    TextView txt_tenSP;
    TextView txt_gia;
    ImageView imageView;

    public SanPhamHolder(@NonNull View itemView) {
        super(itemView);
        txt_tenSP = itemView.findViewById(R.id.textView_TenSP);
        txt_gia = itemView.findViewById(R.id.textView_DonGia);
        imageView = itemView.findViewById(R.id.image_Hinh_sanPham);


        //add to fav btn

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnItemClickListener != null) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        mOnItemClickListener.onItemClick(position);
                    }
                }
            }
        });
    }
}}







