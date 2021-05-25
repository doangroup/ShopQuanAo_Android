package com.example.shopquanao.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shopquanao.Adapter.Adapter_recycleView_SanPham;
import com.example.shopquanao.Detail_Item_Activity;
import com.example.shopquanao.Model.SanPham;
import com.example.shopquanao.Model.SanPhamModel;
import com.example.shopquanao.R;

import java.util.ArrayList;

public class Fragment_Home extends Fragment implements Adapter_recycleView_SanPham.OnItemClickListener {
    ListView listView;
RecyclerView recyclerView;
    SanPhamModel sanPhamModel = new SanPhamModel();
Adapter_recycleView_SanPham adapter_recycleView_sanPham;
SanPham sanPham;
    ArrayList<SanPham> arrayList= new ArrayList<>();;
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


       recyclerView=view.findViewById(R.id.list_view_2);
        arrayList=sanPhamModel.lay_SanPham();
       adapter_recycleView_sanPham=new Adapter_recycleView_SanPham(arrayList,getContext());
        recyclerView.setAdapter(adapter_recycleView_sanPham);
        adapter_recycleView_sanPham.setOnItemClickListener(Fragment_Home.this);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));

    }


    @Override
    public void onItemClick(int position) {
        sanPham = arrayList.get(position);
        Toast.makeText(getContext(), ""+position, Toast.LENGTH_LONG).show();

        Intent i = new Intent(getContext(), Detail_Item_Activity.class);
        i.putExtra("TenSP", arrayList.get(position).getTenSP());
        i.putExtra("DonGia",arrayList.get(position).getDonGia());
        i.putExtra("HinhAnh", arrayList.get(position).getHinhAnh());

        getContext().startActivity(i);
    }

}
