package com.example.shopquanao.Model;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import com.example.shopquanao.DB.ConnectionDB;
public class KhachHangLogin {
    ConnectionDB connectionDB = new ConnectionDB();
    String z="";
    Connection con = connectionDB.CONN();

    public String Login(String username, String password) {
        try {

            if (con == null) {
                z = "Error in connection with SQL server";
            } else {
                String query = "select * from KhachHang where SDT='" + username + "' and MatKhau='" + password + "'";
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(query);

                if (rs.next()) {

                    z = "Đăng Nhập Thành Công";

                } else {
                    z = "Sai User hoặc Mật Khẩu";
                }

            }
        } catch (Exception ex) {
            z = "Exceptions";
        }
        return z;
    }
}
