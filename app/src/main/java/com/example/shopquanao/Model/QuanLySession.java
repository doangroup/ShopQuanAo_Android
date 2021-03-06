package com.example.shopquanao.Model;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import com.example.shopquanao.Login;
import com.example.shopquanao.Main_Home;
import com.example.shopquanao.XacNhanDonHang_Activity;

import java.util.HashMap;

public class QuanLySession {
    // Shared Preferences
    SharedPreferences pref;

    // Editor for Shared preferences
    Editor editor;

    // Context
    Context _context;

    // Shared pref mode
    int PRIVATE_MODE = 0;

    // Sharedpref file name
    private static final String PREF_NAME = "AndroidHivePref";

    // All Shared Preferences Keys
    private static final String IS_LOGIN = "IsLoggedIn";




    public static final String KEY_sdt = "sdt";


    public static final String KEY_mk = "mk";

    // Constructor
    public QuanLySession(Context context){
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    /**
     * Create login session
     * */
    public void createLoginSession(String sdt, String mk){
        // Storing login value as TRUE
        editor.putBoolean(IS_LOGIN, true);


        // Storing name in pref
        editor.putString(KEY_sdt, sdt);

        // Storing email in pref
        editor.putString(KEY_mk, mk);


        // commit changes
        editor.commit();
    }

    /**
     * Check login method wil check user login status
     * If false it will redirect user to login page
     * Else won't do anything
     * */
    public void checkLogin(){
        // Check login status
        if(!this.isLoggedIn()){
            // user is not logged in redirect him to Login Activity
            Intent i = new Intent(_context, Login.class);
            // Closing all the Activities
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

            // Add new Flag to start new Activity
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            // Staring Login Activity
            _context.startActivity(i);
        }else {
            Intent i1=new Intent(_context, XacNhanDonHang_Activity.class);
            _context.startActivity(i1);

        }

    }


    public HashMap<String, String> getUserDetails(){
        HashMap<String,String> user = new HashMap<String,String>();
        // user name

        user.put(KEY_sdt, pref.getString(KEY_sdt, null));
        user.put(KEY_mk, pref.getString(KEY_mk, null));
        // return user
        return user;
    }



    public void logoutUser(){
        // Clearing all data from Shared Preferences
        Main_Home.arrayList_GioHang=null;
        editor.clear();
        editor.commit();

        // After logout redirect user to Loing Activity
        Intent i = new Intent(_context, Login.class);
        // Closing all the Activities
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        // Add new Flag to start new Activity
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        // Staring Login Activity
        _context.startActivity(i);
    }

    /**
     * Quick check for login
     * **/
    // Get Login State
    public boolean isLoggedIn(){
        return pref.getBoolean(IS_LOGIN, false);
    }
}
