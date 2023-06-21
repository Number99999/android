package com.example.myapplication.Model;

import static android.os.Build.VERSION_CODES.R;
import com.example.myapplication.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SinhVienAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<SinhVien> listSV;

    public SinhVienAdapter(Context context, int layout, List<SinhVien> listSV) {
        this.context = context;
        this.layout = layout;
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
        LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(this.layout, null);

        TextView txtId =(TextView) convertView.findViewById(R.id.idSV);
        TextView txtName = (TextView) convertView.findViewById(R.id.name);
        TextView txtYearBirth = (TextView) convertView.findViewById(R.id.yearBirth);
        TextView txtHomeTown =  (TextView) convertView.findViewById(R.id.homeTown);
        TextView txtYear = (TextView) convertView.findViewById(R.id.year);

        return null;
    }
}
