package com.example.shopquanao.Model;

import com.example.shopquanao.DB.ConnectionDB;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class HoaDonModel implements Serializable {
    ConnectionDB connectionDB = new ConnectionDB();
    String z="";
    boolean kiemTra = false;
    ResultSet rs;
    Connection con = connectionDB.CONN();
    Statement statement;


    public boolean ThemHoaDon(int maHoaDon,int maKh, int maNV, int tinhTrang, String ngayBan, String ngayGiao,float tongTien) {
try {
    if (con == null) {
        z = "Loi Ket Noi SQL";
        return false;
    } else {
        String query = "insert into HoaDon \n" +
                "values (" + maHoaDon + "," + maKh + "," + maNV + "," + tinhTrang + ",'" + ngayBan + "','" + ngayGiao + "'," + tongTien + ")";
statement.executeQuery(query);
        return true;
    }
}catch (Exception e){
    e.getMessage();
}
return true;


    }


}
