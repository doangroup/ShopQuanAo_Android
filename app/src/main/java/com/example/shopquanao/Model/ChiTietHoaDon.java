package com.example.shopquanao.Model;

import java.io.Serializable;

public class ChiTietHoaDon implements Serializable {
    int maCTHD,maHD,maSP,soLuong;
    float thanhTien;

    public ChiTietHoaDon(int maCTHD, int maHD, int maSP, int soLuong, float thanhTien) {
        this.maCTHD = maCTHD;
        this.maHD = maHD;
        this.maSP = maSP;
        this.soLuong = soLuong;
        this.thanhTien = thanhTien;
    }
    public  ChiTietHoaDon(){}

    @Override
    public String toString() {
        return "ChiTietHoaDon{" +
                "maCTHD=" + maCTHD +
                ", maHD=" + maHD +
                ", maSP=" + maSP +
                ", soLuong=" + soLuong +
                ", thanhTien=" + thanhTien +
                '}';
    }

    public int getMaCTHD() {
        return maCTHD;
    }

    public void setMaCTHD(int maCTHD) {
        this.maCTHD = maCTHD;
    }

    public int getMaHD() {
        return maHD;
    }

    public void setMaHD(int maHD) {
        this.maHD = maHD;
    }

    public int getMaSP() {
        return maSP;
    }

    public void setMaSP(int maSP) {
        this.maSP = maSP;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public float getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(float thanhTien) {
        this.thanhTien = thanhTien;
    }
}
