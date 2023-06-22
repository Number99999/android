package com.example.myapplication.View;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.Database.DatabaseHandler;
import com.example.myapplication.Model.SinhVien;
import com.example.myapplication.R;
import com.google.gson.Gson;

public class AddSinhVien extends AppCompatActivity {
    private DatabaseHandler db;
    private EditText ten, namSinh, que, namHoc;
    private Button button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_sinh_vien);

        ten = findViewById(R.id.tenSinhVien);
        namSinh = findViewById(R.id.namSinh);
        que = findViewById(R.id.queQuan);
        namHoc = findViewById(R.id.namHoc);

        db = new DatabaseHandler(this);
        button = findViewById(R.id.btnAddSinhVien);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SinhVien sv = new SinhVien(ten.getText().toString(), namSinh.getText().toString(), que.getText().toString(), namHoc.getText().toString());
                db.addSinhVien(sv);


                Gson gson = new Gson();

                String svToJson = gson.toJson(sv);
                Intent intent = new Intent(AddSinhVien.this, ShowListSinhVien.class);
                intent.putExtra("sv", svToJson);
                startActivity(intent);
            }
        });
    }
}
