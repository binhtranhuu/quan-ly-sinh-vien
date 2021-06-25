package com.example.qlsv;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.qlsv.adapter.adapterStudent;
import com.example.qlsv.database.database;
import com.example.qlsv.model.Class;
import com.example.qlsv.model.Student;
import com.example.qlsv.model.StudentClass;

import java.util.ArrayList;

public class ManStudent extends AppCompatActivity {

    ListView lvStudent;
    Button btnAddStudent;

    ArrayList<Student> studentArrayList;
    ArrayList<StudentClass> studentClassArrayList;

    adapterStudent adapterStudent;

    database databaseQLSV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_student);

        databaseQLSV = new database(this);

        lvStudent = findViewById(R.id.lvStudent);
        btnAddStudent = findViewById(R.id.btnAddStudent);

        lvStudent.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                dialogAlert(position);
            }
        });

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

    private void dialogAlert(int position) {
        // Tạo đối tượng Dialog
        Dialog dialog = new Dialog(this);

        // Nạp layout vào dialog
        dialog.setContentView(R.layout.dialogapp);

        // Tắt click ra ngoài là đóng, chỉ click nó mới đóng
        dialog.setCanceledOnTouchOutside(false);

        //Ánh xạ
        Button btnUpdate = dialog.findViewById(R.id.btnUpdate);
        Button btnDelete = dialog.findViewById(R.id.btnDelete);

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int studentId = studentArrayList.get(position).getId();

                databaseQLSV.deleteStudent(studentId);

                studentClassArrayList = databaseQLSV.getAllStudentClass();
                for (int i = studentClassArrayList.size() - 1; i >= 0; i--) {
                    if (studentClassArrayList.get(i).getId_student() == studentId) {
                        databaseQLSV.deleteStudent1(studentId);
                    }
                }

                // Cập nhật lại Activity
                Intent intent = new Intent(ManStudent.this, ManStudent.class);
                finish();
                startActivity(intent);

                Toast.makeText(ManStudent.this, "Xóa sinh viên thành công", Toast.LENGTH_SHORT).show();
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        // run dialog
        dialog.show();
    }
}