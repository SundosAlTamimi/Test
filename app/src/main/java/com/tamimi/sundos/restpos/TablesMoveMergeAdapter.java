package com.tamimi.sundos.restpos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.tamimi.sundos.restpos.Models.Items;

import java.util.ArrayList;
import java.util.List;

public class TablesMoveMergeAdapter extends BaseAdapter {
    Context context;
    List<String> items;

    TablesMoveMergeAdapter(Context context , List<String> items) {
        this.context = context ;
        this.items = items ;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view1 = inflater.inflate(R.layout.table_raw_activity, null);

        TextView tableNo = (TextView) view1.findViewById(R.id.tableNo);
        tableNo.setText("table no: " + items.get(position));

        return view1;
    }
}