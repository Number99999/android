package com.example.myapplication.Model;

public class SinhVien_Lop {
    private int id;
    private int idSV;
    private int idLop;
    private String tenSV, tenLop;

    public SinhVien_Lop() {

    }

    public SinhVien_Lop(int idSV, String tenSV, String tenLop) {
        this.idSV = idSV;
        this.tenSV = tenSV;
        this.tenLop = tenLop;
    }

    public SinhVien_Lop(int id, int idSV, int idLop, String tenSV, String tenLop) {
        this.id = id;
        this.idLop = idLop;
        this.idSV = idSV;
        this.tenSV = tenSV;
        this.tenLop = tenLop;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenSV() {
        return tenSV;
    }

    public void setTenSV(String tenSV) {
        this.tenSV = tenSV;
    }

    public String getTenLop() {
        return tenLop;
    }

    public void setTenLop(String tenLop) {
        this.tenLop = tenLop;
    }

    public int getIdSV() {
        return idSV;
    }

    public void setIdSV(int idSV) {
        this.idSV = idSV;
    }

    public int getIdLop() {
        return idLop;
    }

    public void setIdLop(int idLop) {
        this.idLop = idLop;
    }
}
