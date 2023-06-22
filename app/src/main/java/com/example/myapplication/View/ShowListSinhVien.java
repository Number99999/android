package com.example.myapplication.View;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.Database.DatabaseHandler;
import com.example.myapplication.Model.SinhVien;
import com.example.myapplication.Model.SinhVienAdapter;
import com.example.myapplication.R;
import com.google.gson.Gson;

import java.util.ArrayList;

public class ShowListSinhVien extends AppCompatActivity {
    private ArrayList<SinhVien> studentList;
    private DatabaseHandler db;
    private SinhVienAdapter sinhVienAdapter;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_sinh_vien);
        db = new DatabaseHandler(getBaseContext());
        SQLiteDatabase sql = db.getReadableDatabase();
        ArrayList<SinhVien> studentList = new ArrayList<>();
        String query = "SELECT * FROM SinhVien";
        Cursor cursor = sql.rawQuery(query, null);
        if (cursor != null && cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndex("id"));
                String name = cursor.getString(cursor.getColumnIndex("name"));
                String queQuan = cursor.getString(cursor.getColumnIndex("queQuan"));
                String namSinh = cursor.getString(cursor.getColumnIndex("namSinh"));
                String namHoc = cursor.getString(cursor.getColumnIndex("namHoc"));
            }
            while (cursor.moveToNext());
        }
//        Intent intent = getIntent();
//        String svJson = intent.getStringExtra("sv");
//        Gson json = new Gson();
//        SinhVien sv = json.fromJson(svJson, SinhVien.class);
//
//        studentList.add(sv);
        sinhVienAdapter = new SinhVienAdapter(this, R.layout.sinh_vien_row, studentList);
        listView = findViewById(R.id.listSinhVien);
        listView.setAdapter(sinhVienAdapter);
    }
}
