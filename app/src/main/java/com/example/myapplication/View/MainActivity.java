package com.example.myapplication.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.Database.DatabaseHandler;
import com.example.myapplication.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private DatabaseHandler databaseHandler;
    private Button btnAddSV;
    private Button btnAddClass;
    private Button btnListSV;
    private Button btnListClass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
        DatabaseHandler db = new DatabaseHandler((getBaseContext()));

        btnAddSV = findViewById(R.id.btnAddSV);
        btnAddClass = findViewById(R.id.btnAddClass);
        btnListSV = findViewById(R.id.btnListSV);
        btnListClass = findViewById(R.id.btnListClass);

        btnAddSV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddSinhVien.class);
                startActivity(intent);

            }
        });

        btnListSV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ShowListSinhVien.class);
//                intent.putExtra("sinhVien", )
                startActivity(intent);
            }
        });

        this.databaseHandler = new DatabaseHandler(this);

    }
}