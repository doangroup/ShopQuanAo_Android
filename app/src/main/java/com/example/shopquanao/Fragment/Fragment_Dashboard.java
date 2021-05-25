package com.example.shopquanao.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.shopquanao.Adapter.Adapter_listView_DanhMuc;
import com.example.shopquanao.DashBoard_Activity;
import com.example.shopquanao.Model.DanhMuc;
import com.example.shopquanao.Model.DanhMucModel;
import com.example.shopquanao.R;

import java.util.ArrayList;

public class Fragment_Dashboard extends Fragment {
    ListView listView;
    DanhMucModel model = new DanhMucModel();
    TextView textView;
    Adapter_listView_DanhMuc adapter_listView;

    Adapter_listView_DanhMuc adapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_dashboard, container, false);


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ArrayList<DanhMuc> data;

        data = model.lay_DanhMuc();

        listView = view.findViewById(R.id.list_view);
        textView = view.findViewById(R.id.textView2);

        ArrayAdapter arrayAdapter = new ArrayAdapter(getContext(), R.layout.title_danhmuc, data);
        adapter_listView = new Adapter_listView_DanhMuc(getContext(), data);
        listView.setAdapter(adapter_listView);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                DanhMuc danhMuc = (DanhMuc) adapter_listView.getItem(position);
                Toast.makeText(getContext(), "" + danhMuc.getMaDanhMuc(), Toast.LENGTH_LONG).show();


                Intent i = new Intent(getContext(), DashBoard_Activity.class);
                i.putExtra("MaDanhMuc", danhMuc.getMaDanhMuc());


                getContext().startActivity(i);
            }
        });


    }


}
