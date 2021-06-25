package com.example.qlsv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ManTimKiem extends AppCompatActivity {

    EditText edTimKiem;
    Button btnTimKiem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_tim_kiem);

        edTimKiem = findViewById(R.id.edTimKiem);
        btnTimKiem = findViewById(R.id.btnTimKiem);

        btnTimKiem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textSearch = edTimKiem.getText().toString().trim();

                Intent intent = new Intent(ManTimKiem.this, ManTimKiemSinhVien.class);
                intent.putExtra("textSearch", textSearch);
                startActivity(intent);
            }
        });
    }
}