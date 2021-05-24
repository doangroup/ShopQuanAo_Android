package com.example.shopquanao.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.shopquanao.Adapter.Adapter_listView;
import com.example.shopquanao.Model.DanhMuc;
import com.example.shopquanao.Model.DanhMucModel;
import com.example.shopquanao.R;

import java.util.ArrayList;

public class Fragment_Dashboard extends Fragment {
    ListView listView;
DanhMucModel model=new DanhMucModel();
TextView textView,textView_3;
Adapter_listView adapter_listView;

    Adapter_listView adapter;

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

data=model.lay_DanhMuc();

        listView = view.findViewById(R.id.list_view);
        textView=view.findViewById(R.id.textView2);

   //ArrayAdapter arrayAdapter = new ArrayAdapter(getContext(),R.layout.title,data);
      adapter_listView=new Adapter_listView(getContext(),data);
      listView.setAdapter(adapter_listView);
    }
}
