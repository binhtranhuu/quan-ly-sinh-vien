package com.example.qlsv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.qlsv.adapter.adapterThongKe;
import com.example.qlsv.database.database;
import com.example.qlsv.model.Class;
import com.example.qlsv.model.ThongKe;

import java.util.ArrayList;

public class ManThongKe extends AppCompatActivity {

    ListView lvThongKe;

    ArrayList<Class> classArrayList;
    ArrayList<ThongKe> thongKeArrayList;

    adapterThongKe adapterThongKe;

    database databaseQLSV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_thong_ke);

        databaseQLSV = new database(this);

        lvThongKe = findViewById(R.id.lvThongKe);

        lvThongKe.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ManThongKe.this, ManListStudentOfClass.class);
                int idLopHoc = thongKeArrayList.get(position).getId();
                String tenLopHoc = thongKeArrayList.get(position).getName();
                intent.putExtra("idLopHoc", idLopHoc);
                intent.putExtra("tenLopHoc", tenLopHoc);
                startActivity(intent);
            }
        });

        thongKeArrayList = new ArrayList<>();

        classArrayList = databaseQLSV.getAllClass();
        for (int i = classArrayList.size() - 1; i >= 0; i--) {
            int id = classArrayList.get(i).getId();
            String name = classArrayList.get(i).getName();
            int sum = databaseQLSV.getTotalStudentByClassId(classArrayList.get(i).getId());
            thongKeArrayList.add(new ThongKe(id, name, Integer.toString(sum)));
        }

        adapterThongKe = new adapterThongKe(getApplicationContext(), thongKeArrayList);
        lvThongKe.setAdapter(adapterThongKe);

    }
}