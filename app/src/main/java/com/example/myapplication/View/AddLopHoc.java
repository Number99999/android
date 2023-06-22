package com.example.myapplication.View;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.Database.DatabaseHandler;
import com.example.myapplication.Model.Lop;
import com.example.myapplication.R;

public class AddLopHoc extends AppCompatActivity {
    private EditText tenLop, gioiThieu, soTin;
    private Button addLop;
    private DatabaseHandler db;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_lop_hoc);

        tenLop = findViewById(R.id.tenLoptxt);
        gioiThieu = findViewById(R.id.gioiThieutxt);
        soTin = findViewById(R.id.soTinChitxt);

        addLop = findViewById(R.id.addLop);

        db = new DatabaseHandler(getBaseContext());

        addLop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Lop lop = new Lop(tenLop.getText().toString(), gioiThieu.getText().toString(), soTin.getText().toString());
                db.addLopHoc(lop);
                Intent intent = new Intent(AddLopHoc.this, ShowListLop.class);
                startActivity(intent);
            }
        });


    }
}
