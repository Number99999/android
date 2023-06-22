package com.example.myapplication.View;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.Database.DatabaseHandler;
import com.example.myapplication.Model.Lop;
import com.example.myapplication.Model.LopAdapter;
import com.example.myapplication.R;

import java.util.ArrayList;

public class ShowListLop extends AppCompatActivity {
    DatabaseHandler db;
    ArrayList<Lop> list;
    ListView listView;
    LopAdapter lopAdapter;

    Button button;

    @SuppressLint({"ResourceType", "MissingInflatedId"})
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_lop);

        list = new ArrayList<>();

        button = findViewById(R.id.ListLopVeMenu);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ShowListLop.this, MainActivity.class);
            }
        });

        db = new DatabaseHandler(getBaseContext());
        SQLiteDatabase sql = db.getReadableDatabase();
        String query = "Select * from lopHoc";
        Cursor cursor = sql.rawQuery(query, null);
        if (cursor != null && cursor.moveToFirst()) {
            do {
                @SuppressLint("Range") int id = cursor.getInt(cursor.getColumnIndex("id"));
                @SuppressLint("Range") String name = cursor.getString(cursor.getColumnIndex("name"));
                @SuppressLint("Range") String soTin = cursor.getString(cursor.getColumnIndex("soTin"));
                @SuppressLint("Range") String moTa = cursor.getString(cursor.getColumnIndex("moTa"));
                Lop l = new Lop(id, name, soTin, moTa);
                list.add(l);
            }
            while (cursor.moveToNext());
        }

        lopAdapter = new LopAdapter(this, R.layout.lop_row, list);
        listView = findViewById(R.id.listLop);
        listView.setAdapter(lopAdapter);
    }
}
