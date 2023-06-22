package com.example.myapplication.Model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.myapplication.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class LopAdapter extends BaseAdapter {
    Context context;
    int layout;
    ArrayList<Lop> list;

    public LopAdapter(Context context, int layout, ArrayList<Lop> lops) {
        this.context = context;
        this.layout = layout;
        this.list = lops;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(this.layout, null);
        Lop lop = list.get(position);

        TextView idLop = convertView.findViewById(R.id.idLop);
        TextView tenLop = convertView.findViewById(R.id.tenLop);
        TextView sotin = convertView.findViewById(R.id.SoTin);
        TextView mota = convertView.findViewById(R.id.Mota);

        idLop.setText(lop.getId());
        tenLop.setText(lop.getTenLop());
        sotin.setText(lop.getSoTin());
        mota.setText(lop.getMoTa());
        return convertView;
    }
}
