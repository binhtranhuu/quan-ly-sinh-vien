package com.example.qlsv.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.qlsv.R;
import com.example.qlsv.model.Class;

import java.util.ArrayList;

public class adapterClass extends BaseAdapter {

    private Context context;
    private ArrayList<Class> classArrayList;

    public adapterClass(Context context, ArrayList<Class> classArrayList) {
        this.context = context;
        this.classArrayList = classArrayList;
    }

    @Override
    public int getCount() {
        return classArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return classArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.lophoc, null);

        TextView tenLopHoc = (TextView) convertView.findViewById(R.id.tenLopHoc);
        TextView moTaLop = (TextView) convertView.findViewById(R.id.moTaLop);

        Class classLH = classArrayList.get(position);

        tenLopHoc.setText(classLH.getName());
        moTaLop.setText(classLH.getDetail());

        return convertView;
    }
}