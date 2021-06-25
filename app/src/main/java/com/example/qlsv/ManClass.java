package com.example.qlsv;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.qlsv.adapter.adapterClass;
import com.example.qlsv.database.database;
import com.example.qlsv.model.Class;
import com.example.qlsv.model.StudentClass;

import java.util.ArrayList;

public class ManClass extends AppCompatActivity {

    ListView lvClass;
    Button btnAddClass;

    ArrayList<Class> classArrayList;
    ArrayList<StudentClass> studentClassArrayList;

    adapterClass adapterClass;

    database databaseQLSV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_class);

        databaseQLSV = new database(this);

        lvClass = findViewById(R.id.lvClass);
        btnAddClass = findViewById(R.id.btnAddClass);

        btnAddClass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ManClass.this, ManAddClass.class);
                startActivity(intent);
            }
        });

        lvClass.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                dialogAlert1(position);
            }
        });

        classArrayList = databaseQLSV.getAllClass();
        adapterClass = new adapterClass(getApplicationContext(), classArrayList);
        lvClass.setAdapter(adapterClass);
    }

    private void dialogAlert1(int position) {
        // Tạo đối tượng Dialog
        Dialog dialog = new Dialog(this);

        // Nạp layout vào dialog
        dialog.setContentView(R.layout.dialogapp);

        //Ánh xạ
        Button btnUpdate = dialog.findViewById(R.id.btnUpdate);
        Button btnDelete = dialog.findViewById(R.id.btnDelete);

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int classId = classArrayList.get(position).getId();

                databaseQLSV.deleteClass(classId);

                studentClassArrayList = databaseQLSV.getAllStudentClass();
                for (int i = studentClassArrayList.size() - 1; i >= 0; i--) {
                    if (studentClassArrayList.get(i).getId_class() == classId) {
                        databaseQLSV.deleteClass1(classId);
                    }
                }

                // Cập nhật lại Activity
                Intent intent = new Intent(ManClass.this, ManClass.class);
                finish();
                startActivity(intent);

                Toast.makeText(ManClass.this, "Xóa lớp học thành công", Toast.LENGTH_SHORT).show();
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ManClass.this, ManEditClass.class);
                int id = classArrayList.get(position).getId();
                String name = classArrayList.get(position).getName();
                String detail = classArrayList.get(position).getDetail();
                intent.putExtra("id", id);
                intent.putExtra("name", name);
                intent.putExtra("detail", detail);
                startActivity(intent);
            }
        });

        // run dialog
        dialog.show();

    }
}