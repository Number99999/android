package com.example.myapplication.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.myapplication.Model.SinhVien;

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
//        String sql = "insert into SinhVien ()";

        ContentValues values = new ContentValues();
        values.put("name", sv.getName());
        values.put("queQuan", sv.getQueQuan());
        values.put("namSinh", sv.getDate());
        values.put("namHoc", sv.getNamHoc());
        long rowId = sqlDB.insert("SinhVien", null, values);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE IF NOT EXISTS SinhVien (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, queQuan TEXT, namSinh TEXT, namHoc TEXT)";
        db.execSQL(sql);

        sql = "create table if not exists LopHoc(id INTEGER primary key autoincrement, name text, soTin text, moTa text)";
        db.execSQL(sql);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


}
