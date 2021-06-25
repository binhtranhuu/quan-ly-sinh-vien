package com.example.qlsv.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.qlsv.R;
import com.example.qlsv.model.Student;

import java.util.ArrayList;

public class adapterStudent extends BaseAdapter {

    private Context context;
    private ArrayList<Student> studentArrayList;

    public adapterStudent(Context context, ArrayList<Student> studentArrayList) {
        this.context = context;
        this.studentArrayList = studentArrayList;
    }

    @Override
    public int getCount() {
        return studentArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return studentArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.sinhvien, null);

        TextView tenSinhVien = (TextView) convertView.findViewById(R.id.tenSinhVien);
        TextView namHocSV = (TextView) convertView.findViewById(R.id.namHocSV);

        Student student = studentArrayList.get(position);

        tenSinhVien.setText(student.getName());
        namHocSV.setText(student.getYear());

        return convertView;
    }
}
