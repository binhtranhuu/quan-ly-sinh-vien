package com.example.qlsv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.qlsv.adapter.adapterClass;
import com.example.qlsv.database.database;
import com.example.qlsv.model.Class;

import java.util.ArrayList;

public class ManStudentClass extends AppCompatActivity {

    ListView lvListClass;
    Button btnAddStudentClass;

    ArrayList<Class> classArrayList;

    adapterClass adapterClass;

    database databaseQLSV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_student_class);

        databaseQLSV =  new database(this);

        // Ánh xạ
        lvListClass = findViewById(R.id.lvListClass);
        btnAddStudentClass = findViewById(R.id.btnAddStudentClass);

        btnAddStudentClass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ManStudentClass.this, ManDangKyHoc.class);
                startActivity(intent);
            }
        });

        classArrayList = databaseQLSV.getAllClass();
        adapterClass = new adapterClass(getApplicationContext(), classArrayList);
        lvListClass.setAdapter(adapterClass);
    }
}