package com.example.shopquanao.Model;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.shopquanao.DB.JDBCController;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class KhachHangModel {
    private JDBCController jdbcController = new JDBCController();
    private Connection connection;
Context context;
    public KhachHangModel() {
        connection = jdbcController.ConnnectionData(); // Tạo kết nối tới database
    }

    public  ArrayList<KhachHang> getKhachHangList() throws SQLException {

        ArrayList<KhachHang> list = new ArrayList<>();
        Statement statement = connection.createStatement();// Tạo đối tượng Statement.
        String sql = "select * from KhachHang";
        // Thực thi câu lệnh SQL trả về đối tượng ResultSet. // Mọi kết quả trả về sẽ được lưu trong ResultSet
        try (ResultSet rs = statement.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new KhachHang(rs.getInt("maKhachHang"), rs.getString("tenKhachHang"), rs.getString("diaChi"), rs.getString("sDT"), rs.getString("matKhau")));// Đọc dữ liệu từ ResultSet
            }
        }catch (Exception e)
        {
            Toast.makeText(context,"loi ket noi",Toast.LENGTH_LONG).show();
            Log.e("loi sql",e.getMessage());
        }
        connection.close();// Đóng kết nối
        return list;
    }
 public boolean kt(){
        if (connection==jdbcController.ConnnectionData())
        {
            return true;
        }
        else {
            return  false;
        }
 }
}
