package com.example.shopquanao.Model;
import com.example.shopquanao.DB.ConnectionDB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
public class KhachHangLogin {
    ConnectionDB connectionDB = new ConnectionDB();
    String z="";
    Connection con = connectionDB.CONN();

    public String Login(String username, String password) {
        try {

            if (con == null) {
                z = "Loi Ket Noi SQL";
            } else {
                String query = "select * from KhachHang where SDT='" + username + "' and MatKhau='" + password + "'";
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(query);

                if (rs.next()) {

                    z = "true";

                } else {
                    z = "false";
                }

            }
        } catch (Exception ex) {
            z = "Exceptions";
        }
        return z;
    }
}
