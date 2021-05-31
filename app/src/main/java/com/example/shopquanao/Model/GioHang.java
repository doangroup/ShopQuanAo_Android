package com.example.shopquanao.Model;

import java.io.Serializable;

public class GioHang implements Serializable {

    public  int maSP;
    public String tenSP;
    public  float gia;
    public String hinhSP;
    public int soLuong;

    public GioHang(int maSP, String tenSP, float gia, String hinhSP, int soLuong) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.gia = gia;
        this.hinhSP = hinhSP;
        this.soLuong = soLuong;
    }

    public int getMaSP() {
        return maSP;
    }

    public void setMaSP(int maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public float getGia() {
        return gia;
    }

    public void setGia(float gia) {
        this.gia = gia;
    }

    public String getHinhSP() {
        return hinhSP;
    }

    public void setHinhSP(String hinhSP) {
        this.hinhSP = hinhSP;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
}
