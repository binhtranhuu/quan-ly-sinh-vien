package com.example.qlsv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.qlsv.database.database;
import com.example.qlsv.model.Class;

public class ManAddClass extends AppCompatActivity {

    EditText edTenLH, edMoTaLH;
    Button btnThemLH;

    database databaseQLSV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_add_class);

        databaseQLSV = new database(this);

        // Ánh xạ
        edTenLH = findViewById(R.id.edTenLH);
        edMoTaLH = findViewById(R.id.edMoTaLH);
        btnThemLH = findViewById(R.id.btnThemLH);

        // Bắt sự kiện click thêm lớp học
        btnThemLH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Class classLH = new Class(edTenLH.getText().toString().trim(),
                        edMoTaLH.getText().toString().trim());

                databaseQLSV.addClass(classLH);

                Toast.makeText(ManAddClass.this, "Thêm lớp thành công", Toast.LENGTH_LONG).show();

                Intent intent = new Intent(ManAddClass.this, ManClass.class);
                finish();
                startActivity(intent);
            }
        });
    }
}