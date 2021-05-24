package com.example.shopquanao.Model;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.shopquanao.DB.ConnectionDB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class KhachHangModel {
    ConnectionDB connectionDB = new ConnectionDB();
    String z="";
    boolean kiemTra = false;
    ResultSet rs;
    Connection con = connectionDB.CONN();






}
