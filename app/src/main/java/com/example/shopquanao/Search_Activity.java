package com.example.shopquanao;

import android.content.Intent;
import android.os.Bundle;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shopquanao.Adapter.Adapter_recycleView_SanPham;
import com.example.shopquanao.Model.SanPham;
import com.example.shopquanao.Model.SanPhamModel;

import java.util.ArrayList;

public class Search_Activity extends AppCompatActivity implements Adapter_recycleView_SanPham.OnItemClickListener {
    RecyclerView recyclerView;

    ArrayList<SanPham> arrayList;
    SearchView searchView;
    SanPhamModel sanPhamModel= new SanPhamModel();
    Adapter_recycleView_SanPham adapter_recycleView_sanPham;
    SanPham sanPham;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        searchView=findViewById(R.id.inputSearch);
        recyclerView=findViewById(R.id.recycleView_search);
        arrayList=sanPhamModel.lay_SanPham();
        adapter_recycleView_sanPham=new Adapter_recycleView_SanPham(arrayList,this);
        recyclerView.setAdapter(adapter_recycleView_sanPham);
        adapter_recycleView_sanPham.setOnItemClickListener(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText)
            {
                Filler(newText);
                return true;
            }
        });
    }
    public void Filler(String text){
        ArrayList<SanPham> tam = new ArrayList<>();
        if (text.isEmpty()){
            tam=arrayList;
        }else {
            for (SanPham furniture :arrayList)
            {
                if (furniture.getTenSP().toLowerCase().contains(text.toLowerCase()))
                {
                    tam.add(furniture);
                }
            }
        }
        adapter_recycleView_sanPham.UpdateList(tam);
    }
    @Override
    public void onItemClick(int position) {
        sanPham = arrayList.get(position);
        Toast.makeText(this, ""+position, Toast.LENGTH_LONG).show();

        Intent i = new Intent(this, Detail_Item_Activity.class);
        i.putExtra("MaSP", arrayList.get(position).getMaSP());
        i.putExtra("TenSP", arrayList.get(position).getTenSP());
        i.putExtra("DonGia",arrayList.get(position).getDonGia());
        i.putExtra("HinhAnh", arrayList.get(position).getHinhAnh());

        this.startActivity(i);
    }
}
