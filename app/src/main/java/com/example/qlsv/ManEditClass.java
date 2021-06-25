package com.example.qlsv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.qlsv.database.database;
import com.example.qlsv.model.Class;

public class ManEditClass extends AppCompatActivity {

    EditText edTenLHEd, edMoTaLHEd;
    Button btnUpdateLH;

    database databaseQLSV;

    int id;
    String name, detail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_edit_class);

        databaseQLSV = new database(this);

        Intent intent = getIntent();
        id = intent.getIntExtra("id", 1);
        name = intent.getStringExtra("name");
        detail = intent.getStringExtra("detail");

        // Ánh xạ
        edTenLHEd = findViewById(R.id.edTenLHEd);
        edMoTaLHEd = findViewById(R.id.edMoTaLHEd);
        btnUpdateLH = findViewById(R.id.btnUpdateLH);

        edTenLHEd.setText(name);
        edMoTaLHEd.setText(detail);

        btnUpdateLH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Class classLH = new Class(edTenLHEd.getText().toString().trim(),
                        edMoTaLHEd.getText().toString().trim());

                databaseQLSV.updateClass(classLH, id);

                Toast.makeText(ManEditClass.this, "Cập nhật thành công", Toast.LENGTH_LONG).show();

                Intent intent = new Intent(ManEditClass.this, ManClass.class);
                finish();
                startActivity(intent);
            }
        });
    }
}