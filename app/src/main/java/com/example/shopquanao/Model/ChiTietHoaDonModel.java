package com.example.shopquanao.Model;

import com.example.shopquanao.DB.ConnectionDB;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.Statement;

public class ChiTietHoaDonModel implements Serializable {
    ConnectionDB connectionDB = new ConnectionDB();
    String z="";

    Connection con = connectionDB.CONN();
    Statement statement;


    public boolean ThemCTHoaDon(int maCTHoaDon,int maHD, int maSP, int sl,float tongTien) {
        try {
            if (con == null) {
                z = "Loi Ket Noi SQL";
                return false;
            } else {
                String query = "insert into ChiTietHD values ("+maCTHoaDon+","+maHD+","+maSP+","+tongTien+")";
                statement.executeQuery(query);
                return true;
            }
        }catch (Exception e){
            e.getMessage();
        }
        return true;


    }


}