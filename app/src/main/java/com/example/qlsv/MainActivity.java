package com.example.qlsv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnTimKiem, btnSinhVien, btnLopHoc, btnDangKyHoc, btnThongKe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnTimKiem = findViewById(R.id.btnTimKiem);
        btnSinhVien = findViewById(R.id.btnSinhVien);
        btnLopHoc = findViewById(R.id.btnLopHoc);
        btnDangKyHoc = findViewById(R.id.btnDangKyHoc);
        btnThongKe = findViewById(R.id.btnThongKe);

        btnTimKiem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ManTimKiem.class);
                startActivity(intent);
            }
        });

        btnSinhVien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ManStudent.class);
                startActivity(intent);
            }
        });

        btnLopHoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ManClass.class);
                startActivity(intent);
            }
        });

        btnDangKyHoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ManStudentClass.class);
                startActivity(intent);
            }
        });

        btnThongKe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ManThongKe.class);
                startActivity(intent);
            }
        });
    }
}