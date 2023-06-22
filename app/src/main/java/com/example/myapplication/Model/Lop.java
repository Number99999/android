package com.example.myapplication.Model;

public class Lop {
    private int id;
    private String tenLop, moTa, soTin;

    public Lop() {
    }

    public int getId() {
        return id;
    }

    public Lop(int id, String tenLop, String moTa, String soTin) {
        this.id = id;
        this.tenLop = tenLop;
        this.moTa = moTa;
        this.soTin = soTin;
    }

    public Lop(String tenLop, String moTa, String soTin) {
        this.tenLop = tenLop;
        this.moTa = moTa;
        this.soTin = soTin;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenLop() {
        return tenLop;
    }

    public void setTenLop(String tenLop) {
        this.tenLop = tenLop;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getSoTin() {
        return soTin;
    }

    public void setSoTin(String soTin) {
        this.soTin = soTin;
    }
}
