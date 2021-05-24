package com.example.shopquanao.DB;
import com.example.shopquanao.DB.JDBCModel;
import java.sql.Connection;
public class JDBCController {
    JDBCModel JdbcModel = new JDBCModel();

    public Connection ConnnectionData() {
        return JdbcModel.getConnectionOf();
    }
}
