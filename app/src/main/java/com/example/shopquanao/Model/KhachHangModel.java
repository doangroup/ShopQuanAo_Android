package com.example.shopquanao.Model;

import com.example.shopquanao.DB.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class KhachHangModel {
    ConnectionDB connectionDB = new ConnectionDB();
    String z="";
    boolean kiemTra = false;
    ResultSet rs;
    Connection con = connectionDB.CONN();



    public ArrayList<KhachHang> lay_KhachHang(String sdt){
        ArrayList<KhachHang> arrayList = new ArrayList<>();
        try {
            if (z==null)
            {
                z="Connection DB Fail!";
            }else
            {
                PreparedStatement statement = con.prepareStatement("exec lay_KhachHang'"+sdt+"'");

                rs = statement.executeQuery();

                while (rs.next()) {
                    arrayList.add(new KhachHang(rs.getInt("MaKH"),rs.getString("TenKH"),rs.getString("DiaChi"),rs.getString("SDT"),rs.getString("MatKhau")));// Đọc dữ liệu từ ResultSet
                }

             //   con.close();// Đóng kết nối
            }
        }catch (Exception e)
        {
            z = "Exceptions";
        }
        return  arrayList;
    }

    public boolean DangKyThanhVien(int maKH,String tenKH,String diaChi,String SDT,String matKhau){

        try {

            PreparedStatement statement = con.prepareStatement("exec DangKyThanhVien'"+maKH+"','"+tenKH+"','"+diaChi+"','"+SDT+"','"+matKhau+"'");
            kiemTra = true;
            rs = statement.executeQuery();
            con.close();
        } catch (Exception ex) {
            z = "Exceptions";
        }

        return kiemTra;
    }
}
