package com.example.myapplication.View;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_sinh_vien);



        button = findViewById(R.id.sinhVienVeMenu);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ShowListSinhVien.this, MainActivity.class);
                startActivity(intent);
            }
        });



        db = new DatabaseHandler(getBaseContext());
        SQLiteDatabase sql = db.getReadableDatabase();
        ArrayList<SinhVien> studentList = new ArrayList<>();
        String query = "SELECT * FROM SinhVien";
        Cursor cursor = sql.rawQuery(query, null);
        if (cursor != null && cursor.moveToFirst()) {
            do {
                @SuppressLint("Range") int id = cursor.getInt(cursor.getColumnIndex("id"));
                @SuppressLint("Range") String name = cursor.getString(cursor.getColumnIndex("name"));
                @SuppressLint("Range") String queQuan = cursor.getString(cursor.getColumnIndex("queQuan"));
                @SuppressLint("Range") String namSinh = cursor.getString(cursor.getColumnIndex("namSinh"));
                @SuppressLint("Range") String namHoc = cursor.getString(cursor.getColumnIndex("namHoc"));
                SinhVien sv = new SinhVien(id, name, queQuan, namSinh, namHoc);
                studentList.add(sv);
            }
            while (cursor.moveToNext());
        }

        sinhVienAdapter = new SinhVienAdapter(this, R.layout.sinh_vien_row, studentList);
        listView = findViewById(R.id.listSinhVien);
        listView.setAdapter(sinhVienAdapter);
    }
}
