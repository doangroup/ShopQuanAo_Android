package com.example.shopquanao.Model;

import java.io.Serializable;

public class HoaDon implements Serializable {
int maHD,maKh,maNv,tinhTrang;
String ngayBan,ngayGiao;
float tongTien;

    public HoaDon(int maHD, int maKh, int maNv, int tinhTrang, String ngayBan, String ngayGiao, float tongTien) {
        this.maHD = maHD;
        this.maKh = maKh;
        this.maNv = maNv;
        this.tinhTrang = tinhTrang;
        this.ngayBan = ngayBan;
        this.ngayGiao = ngayGiao;
        this.tongTien = tongTien;
    }
    public HoaDon(){}

    public int getMaHD() {
        return maHD;
    }

    public int getMaKh() {
        return maKh;
    }

    public int getMaNv() {
        return maNv;
    }

    public int getTinhTrang() {
        return tinhTrang;
    }

    public String getNgayBan() {
        return ngayBan;
    }

    public String getNgayGiao() {
        return ngayGiao;
    }

    public float getTongTien() {
        return tongTien;
    }

    public void setMaHD(int maHD) {
        this.maHD = maHD;
    }

    public void setMaKh(int maKh) {
        this.maKh = maKh;
    }

    public void setMaNv(int maNv) {
        this.maNv = maNv;
    }

    public void setTinhTrang(int tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public void setNgayBan(String ngayBan) {
        this.ngayBan = ngayBan;
    }

    public void setNgayGiao(String ngayGiao) {
        this.ngayGiao = ngayGiao;
    }

    public void setTongTien(float tongTien) {
        this.tongTien = tongTien;
    }

    @Override
    public String toString() {
        return "HoaDon{" +
                "maHD=" + maHD +
                ", maKh=" + maKh +
                ", maNv=" + maNv +
                ", tinhTrang=" + tinhTrang +
                ", ngayBan='" + ngayBan + '\'' +
                ", ngayGiao='" + ngayGiao + '\'' +
                ", tongTien=" + tongTien +
                '}';
    }
}
