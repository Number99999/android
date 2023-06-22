package com.example.myapplication.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.myapplication.Model.Lop;
import com.example.myapplication.Model.SinhVien;
import com.example.myapplication.Model.SinhVien_Lop;

public class DatabaseHandler extends SQLiteOpenHelper {
    private static final String DBName = "duongdeptrai";
    private static final int version = 1;
    private Context context;

    public DatabaseHandler(Context context) {
        super(context, DBName, null, version);
        this.context = context;
    }

    public void addSinhVien(SinhVien sv) {
        SQLiteDatabase sqlDB = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("name", sv.getName());
        values.put("queQuan", sv.getQueQuan());
        values.put("namSinh", sv.getDate());
        values.put("namHoc", sv.getNamHoc());
        long rowId = sqlDB.insert("SinhVien", null, values);
    }

    public void addLopHoc(Lop lop) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("name", lop.getTenLop());
        values.put("soTin", lop.getSoTin());
        values.put("moTa", lop.getMoTa());
        long row = db.insert("LopHoc", null, values);
    }

    public void addSV_Lop(SinhVien sv, Lop lop) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();

        SinhVien_Lop s = new SinhVien_Lop();
        s.setTenLop(lop.getTenLop());
        s.setTenSV(sv.getName());
        s.setIdLop(lop.getId());
        s.setIdSV(lop.getId());

        values.put("idSV", s.getIdSV());
        values.put("idLop", s.getIdLop());
        values.put("tenSV", s.getTenSV());
        values.put("tenLop", s.getTenLop());
        long row = db.insert("SV_Lop", null, values);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE IF NOT EXISTS SinhVien (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, queQuan TEXT, namSinh TEXT, namHoc TEXT)";
        db.execSQL(sql);

        sql = "create table if not exists LopHoc(id INTEGER primary key autoincrement, name text, soTin text, moTa text)";
        db.execSQL(sql);
        
        sql = "create table if not exists SV_Lop(id integer primary key autoincrement, idSV text, idLop text, tenSV text, tenLop text)";
        db.execSQL(sql);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


}
