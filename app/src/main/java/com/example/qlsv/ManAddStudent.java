package com.example.qlsv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.qlsv.database.database;
import com.example.qlsv.model.Student;

public class ManAddStudent extends AppCompatActivity {

    EditText edTenSV, edNamSinhSV, edQueQuanSV;
    Button btnThemSV;
    String ar[] = {"Nam 1", "Nam 2", "Nam 3", "Nam 4", "Nam 5"};
    Spinner spNamHocSV;

    database databaseQLSV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_add_student);
        databaseQLSV = new database(this);

        AnhXa();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, ar);
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        spNamHocSV.setAdapter(adapter);

        btnThemSV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Student student = new Student(
                        edTenSV.getText().toString().trim(),
                        edNamSinhSV.getText().toString().trim(),
                        edQueQuanSV.getText().toString().trim(),
                        spNamHocSV.getSelectedItem().toString().trim()
                );

                databaseQLSV.addStudent(student);
                Toast.makeText(ManAddStudent.this, "Đăng ký thành công", Toast.LENGTH_LONG).show();

                Intent intent = new Intent(ManAddStudent.this, ManStudent.class);
                finish();
                startActivity(intent);
            }
        });
    }

    private void AnhXa() {
        edTenSV = findViewById(R.id.edTenSV);
        edNamSinhSV = findViewById(R.id.edNamSinhSV);
        edQueQuanSV = findViewById(R.id.edQueQuanSV);
        btnThemSV = findViewById(R.id.btnThemSV);
        spNamHocSV = findViewById(R.id.spNamHocSV);
    }
}