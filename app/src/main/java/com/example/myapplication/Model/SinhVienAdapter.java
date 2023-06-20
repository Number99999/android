package com.example.myapplication.Model;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

public class SinhVienAdapter extends BaseAdapter {
    private Context context;
    private int id;
    private List<SinhVien> listSV;

    public SinhVienAdapter(Context context, int id, List<SinhVien> listSV) {
        this.context = context;
        this.id = id;
        this.listSV = listSV;
    }

    @Override
    public int getCount() {
        return listSV.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
