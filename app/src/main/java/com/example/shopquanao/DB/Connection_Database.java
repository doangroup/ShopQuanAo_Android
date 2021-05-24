package com.example.shopquanao.DB;
import android.os.StrictMode;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connection_Database {
    Connection con;
    String username,password,ip,port,database;

    public  Connection_Database Connect(){
        ip="172.1.1.0";
        database="QLSHOPQUANAO";
        username="sa";
        password="sa2012";
        port="1433";

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Connection connection=null;
        String ConnectionURL=null;
        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            ConnectionURL="jdbc:jtds:sqlserver://"+ip+":"+port+";"+"databasename="+database+";user="+username+";password="+password+";";
            connection= DriverManager.getConnection(ConnectionURL);
        }catch (Exception e)
        {
            Log.e("Error Connect",e.getMessage());
        }
        return (Connection_Database) connection;
    }
}
