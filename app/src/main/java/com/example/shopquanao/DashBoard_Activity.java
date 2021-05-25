package com.example.shopquanao;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shopquanao.Adapter.Adapter_recycleView_SanPham;
import com.example.shopquanao.Model.DanhMucModel;
import com.example.shopquanao.Model.SanPham;

import java.util.ArrayList;

public class DashBoard_Activity extends AppCompatActivity implements Adapter_recycleView_SanPham.OnItemClickListener {
    int maDanhMuc;
    TextView textView;

    RecyclerView recyclerView;
    DanhMucModel danhMucModel=new DanhMucModel();
    Adapter_recycleView_SanPham adapter_recycleView_sanPham;
    SanPham sanPham;
    ArrayList<SanPham> arrayList= new ArrayList<>();;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo);

        Intent intent = getIntent();
        maDanhMuc = intent.getIntExtra("MaDanhMuc",1);

        recyclerView=findViewById(R.id.recycle_View_DM);
        arrayList=danhMucModel.lay_DS_SanPham_Theo_Danh_Muc(maDanhMuc);
        adapter_recycleView_sanPham=new Adapter_recycleView_SanPham(arrayList,this);
        recyclerView.setAdapter(adapter_recycleView_sanPham);
        adapter_recycleView_sanPham.setOnItemClickListener(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

    }

    @Override
    public void onItemClick(int position) {
        sanPham = arrayList.get(position);
        Toast.makeText(this, ""+position, Toast.LENGTH_LONG).show();

        Intent i = new Intent(this, Detail_Item_Activity.class);
        i.putExtra("TenSP", arrayList.get(position).getTenSP());
        i.putExtra("DonGia",arrayList.get(position).getDonGia());
        i.putExtra("HinhAnh", arrayList.get(position).getHinhAnh());

        this.startActivity(i);
    }
}
