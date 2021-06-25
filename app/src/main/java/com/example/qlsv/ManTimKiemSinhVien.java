package com.example.qlsv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import com.example.qlsv.adapter.adapterStudent;
import com.example.qlsv.database.database;
import com.example.qlsv.model.Student;

import java.util.ArrayList;

public class ManTimKiemSinhVien extends AppCompatActivity {

    TextView tvTextSearch;
    ListView lvKQTimKiem;

    ArrayList<Student> studentArrayList;
    ArrayList<Student> studentNam2ArrayList = new ArrayList<>();

    adapterStudent adapterStudent;

    database databaseQLSV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_tim_kiem_sinh_vien);

        databaseQLSV = new database(this);

        Intent intent = getIntent();
        String textSearch = intent.getStringExtra("textSearch");

        tvTextSearch = (TextView) findViewById(R.id.tvTextSearch);
        lvKQTimKiem = (ListView) findViewById(R.id.lvKQTimKiem);

        tvTextSearch.setText(textSearch);

        // Hiển thị kết quả search
        studentArrayList = databaseQLSV.getStudentByName(textSearch);
//        for (int i=0; i<studentArrayList.size(); i++){
//            if (studentArrayList.get(i).getYear().equals("Nam 2")){
//                studentNam2ArrayList.add(studentArrayList.get(i));
//            }
//        }

        adapterStudent = new adapterStudent(getApplicationContext(), studentArrayList);
        lvKQTimKiem.setAdapter(adapterStudent);
    }
}