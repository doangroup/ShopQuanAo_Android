package com.example.shopquanao.Model;

import com.example.shopquanao.DB.ConnectionDB;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class SanPhamModel implements Serializable {
    ConnectionDB connectionDB = new ConnectionDB();
    String z="";
    boolean kiemTra = false;
    ResultSet rs;
    Connection con = connectionDB.CONN();


    public ArrayList<SanPham> lay_SanPham(){
        ArrayList<SanPham> arrayList = new ArrayList<>();
        try {
            if (z==null)
            {
                z="Connection DB Fail!";
            }else
            {
                PreparedStatement statement = con.prepareStatement("exec lay_SanPham");

                rs = statement.executeQuery();

                while (rs.next()) {
                    arrayList.add( new SanPham( rs.getInt("MaSP"),rs.getInt("MaDM"),rs.getString("TenSP"),rs.getInt("SoLuong"),rs.getInt("DonGia"),rs.getString("HinhAnh"),rs.getString("GhiChu") ));// Đọc dữ liệu từ ResultSet
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
