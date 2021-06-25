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

public class ManEditStudent extends AppCompatActivity {

    EditText edTenSVEd, edNamSinhSVEd, edQueQuanSVed;
    Button btnUpdateSV;
    String ar[] = {"Nam 1", "Nam 2", "Nam 3", "Nam 4", "Nam 5"};
    Spinner spNamHocSVed;

    database databaseQLSV;

    int id;
    String name, birthday, home, year;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_edit_student);

        databaseQLSV = new database(this);

        Intent intent = getIntent();
        id = intent.getIntExtra("id", 1);
        name = intent.getStringExtra("name");
        birthday = intent.getStringExtra("birthday");
        home = intent.getStringExtra("home");


        AnhXa();

        edTenSVEd.setText(name);
        edNamSinhSVEd.setText(birthday);
        edQueQuanSVed.setText(home);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, ar);
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        spNamHocSVed.setAdapter(adapter);

        btnUpdateSV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Student student = new Student(
                        edTenSVEd.getText().toString().trim(),
                        edNamSinhSVEd.getText().toString().trim(),
                        edQueQuanSVed.getText().toString().trim(),
                        spNamHocSVed.getSelectedItem().toString().trim()
                );

                databaseQLSV.updateStudent(student, id);

                Toast.makeText(ManEditStudent.this, "Cập nhật thành công", Toast.LENGTH_LONG).show();

                Intent intent = new Intent(ManEditStudent.this, ManStudent.class);
                finish();
                startActivity(intent);
            }
        });
    }

    private void AnhXa() {
        edTenSVEd = findViewById(R.id.edTenSVEd);
        edNamSinhSVEd = findViewById(R.id.edNamSinhSVEd);
        edQueQuanSVed = findViewById(R.id.edQueQuanSVed);
        btnUpdateSV = findViewById(R.id.btnUpdateSV);
        spNamHocSVed = findViewById(R.id.spNamHocSVed);
    }
}