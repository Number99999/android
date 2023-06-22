package com.example.myapplication.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class SinhVien {
    private int id;
    private String name;
    private String date;
    private String queQuan, namHoc;

    public SinhVien() {
    }

    public SinhVien(String name, String date, String queQuan, String namHoc) {
        this.name = name;
        this.date = date;
        this.queQuan = queQuan;
        this.namHoc = namHoc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getQueQuan() {
        return queQuan;
    }

    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }

    public String getNamHoc() {
        return namHoc;
    }

    public void setNamHoc(String namHoc) {
        this.namHoc = namHoc;
    }
}
