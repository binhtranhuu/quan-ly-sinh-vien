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

public class ManClass extends AppCompatActivity {

    ListView lvClass;
    Button btnAddClass;

    ArrayList<Class> classArrayList;

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

        classArrayList = databaseQLSV.getAllClass();
        adapterClass = new adapterClass(getApplicationContext(), classArrayList);
        lvClass.setAdapter(adapterClass);
    }
}