package com.example.shopquanao.Model;

import com.example.shopquanao.DB.ConnectionDB;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DanhMucModel implements Serializable {
    ConnectionDB connectionDB = new ConnectionDB();
    String z="";
    boolean kiemTra = false;
    ResultSet rs;
    Connection con = connectionDB.CONN();


    public ArrayList<DanhMuc> lay_DanhMuc(){
        ArrayList<DanhMuc> arrayList = new ArrayList<>();
        try {
            if (z==null)
            {
                z="Connection DB Fail!";
            }else
            {
                PreparedStatement statement = con.prepareStatement("exec lay_DanhMuc");

                rs = statement.executeQuery();

                    while (rs.next()) {
                        arrayList.add( new DanhMuc( rs.getInt("MaDM"), rs.getString("TenDM")));// Đọc dữ liệu từ ResultSet
                    }

                con.close();// Đóng kết nối
            }
        }catch (Exception e)
        {
            z = "Exceptions";
        }
        return  arrayList;
    }
}
