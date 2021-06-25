package com.example.qlsv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.qlsv.database.database;
import com.example.qlsv.model.Class;
import com.example.qlsv.model.Student;
import com.example.qlsv.model.StudentClass;

import java.util.ArrayList;

public class ManDangKyHoc extends AppCompatActivity {

    String term[] = {"Hoc ky 1", "Hoc ky 2", "Hoc ky 3"};
    String credit[] = {"1", "2", "3", "4"};
    ArrayList<Student> studentArrayList;
    ArrayList<Class> classArrayList;
    Spinner spSinhVien, spLopHoc, spTerm, spCredit;
    Button btnDangKyHoc;

    database databaseQLSV;

    int idSinhVien, idLopHoc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_dang_ky_hoc);

        databaseQLSV = new database(this);

        AnhXa();

        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, term);
        spTerm.setAdapter(adapter1);

        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, credit);
        spCredit.setAdapter(adapter2);

        // Thiết lập spinner cho sinh viên
        studentArrayList = databaseQLSV.getAllStudent();
        ArrayAdapter<Student> adapter3 = new ArrayAdapter<Student>(this, R.layout.support_simple_spinner_dropdown_item, studentArrayList);
        spSinhVien.setAdapter(adapter3);

        // Bắt sự kiện chọn một sinh viên
        spSinhVien.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Student student = (Student) parent.getSelectedItem();
                idSinhVien = student.getId();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        // Thiết lập spinner cho lớp học
        classArrayList = databaseQLSV.getAllClass();
        ArrayAdapter<Class> adapter4 = new ArrayAdapter<Class>(this, R.layout.support_simple_spinner_dropdown_item, classArrayList);
        spLopHoc.setAdapter(adapter4);

//         Bắt sự kiện chọn một lớp học
        spLopHoc.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Class classLH = (Class) parent.getSelectedItem();
                idLopHoc = classLH.getId();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        // Bắt sự kiện click Đăng ký học
        dangKyHoc();

    }

    private void dangKyHoc() {
        btnDangKyHoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StudentClass studentClass = new StudentClass(
                        idSinhVien,
                        idLopHoc,
                        spTerm.getSelectedItem().toString().trim(),
                        spCredit.getSelectedItem().toString().trim()
                );

                databaseQLSV.addStudentClass(studentClass);

                Toast.makeText(ManDangKyHoc.this, "Đăng ký học thành công", Toast.LENGTH_LONG).show();

                Intent intent = new Intent(ManDangKyHoc.this, ManStudentClass.class);
                finish();
                startActivity(intent);
            }
        });
    }

    private void AnhXa() {
        spSinhVien = findViewById(R.id.spSinhVien);
        spLopHoc = findViewById(R.id.spLopHoc);
        spTerm = findViewById(R.id.spTerm);
        spCredit = findViewById(R.id.spCredit);
        btnDangKyHoc = findViewById(R.id.btnDangKyHoc);
    }
}