package com.example.qlsv.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.qlsv.R;
import com.example.qlsv.model.ThongKe;

import java.util.ArrayList;

public class adapterThongKe extends BaseAdapter {

    private Context context;
    private ArrayList<ThongKe> thongKeArrayList;

    public adapterThongKe(Context context, ArrayList<ThongKe> thongKeArrayList) {
        this.context = context;
        this.thongKeArrayList = thongKeArrayList;
    }

    @Override
    public int getCount() {
        return thongKeArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return thongKeArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.thongke, null);

        TextView tvTenLopHoc = (TextView) convertView.findViewById(R.id.tvTenLopHoc);
        TextView tvSoLuongSV = (TextView) convertView.findViewById(R.id.tvSoLuongSV);

        ThongKe thongKe = thongKeArrayList.get(position);

        tvTenLopHoc.setText(thongKe.getName());
        tvSoLuongSV.setText(thongKe.getTotal());

        return convertView;
    }
}