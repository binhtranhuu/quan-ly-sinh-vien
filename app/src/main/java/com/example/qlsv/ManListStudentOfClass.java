package com.example.qlsv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.example.qlsv.adapter.adapterStudent;
import com.example.qlsv.database.database;
import com.example.qlsv.model.Student;
import com.example.qlsv.model.StudentClass;

import java.util.ArrayList;

public class ManListStudentOfClass extends AppCompatActivity {

    TextView tvLopHoc;
    ListView lvStudentOfClass;

    ArrayList<StudentClass> studentClassArrayList;
    ArrayList<Student> listStudentOfClass = new ArrayList<>();

    database databaseQLSV;

    adapterStudent adapterStudent;

    int idLopHoc;
    String tenLopHoc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_list_student_of_class);

        databaseQLSV = new database(this);

        Intent intent = getIntent();
        idLopHoc = intent.getIntExtra("idLopHoc", 1);
        tenLopHoc = intent.getStringExtra("tenLopHoc");

        AnhXa();

        tvLopHoc.setText(tenLopHoc);
        listStudentOfClass();
    }

    private void listStudentOfClass() {

        studentClassArrayList = databaseQLSV.getAllStudentClass();

        for (int i = studentClassArrayList.size() - 1; i >= 0; i--) {
            if (studentClassArrayList.get(i).getId_class() == idLopHoc) {
                Student temp = databaseQLSV.getStudentById(studentClassArrayList.get(i).getId_student());
                listStudentOfClass.add(temp);
            }
        }

        adapterStudent = new adapterStudent(getApplicationContext(), listStudentOfClass);
        lvStudentOfClass.setAdapter(adapterStudent);
    }

    private void AnhXa() {
        tvLopHoc = findViewById(R.id.tvLopHoc);
        lvStudentOfClass = findViewById(R.id.lvStudentOfClass);
    }
}