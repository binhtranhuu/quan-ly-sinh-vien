package com.example.qlsv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.qlsv.adapter.adapterStudent;
import com.example.qlsv.database.database;
import com.example.qlsv.model.Student;

import java.util.ArrayList;

public class ManStudent extends AppCompatActivity {

    ListView lvStudent;
    Button btnAddStudent;

    ArrayList<Student> studentArrayList;

    adapterStudent adapterStudent;

    database databaseQLSV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_student);

        databaseQLSV = new database(this);

        lvStudent = findViewById(R.id.lvStudent);
        btnAddStudent = findViewById(R.id.btnAddStudent);

        btnAddStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ManStudent.this, ManAddStudent.class);
                startActivity(intent);
            }
        });

        studentArrayList = databaseQLSV.getAllStudent();

        adapterStudent = new adapterStudent(getApplicationContext(), studentArrayList);
        lvStudent.setAdapter(adapterStudent);
    }
}