package com.example.solarsoluce;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListAdaptateur extends ArrayAdapter<String> {

    private Context mContext;
    private final ArrayList<String> arrayList;

    public ListAdaptateur(Context context, ArrayList<String> items) {
        super(context, R.layout.elementlistesolar,items);
        this.mContext = context;
        this.arrayList =items;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.elementlistesolar, parent, false);
        TextView text = (TextView) rowView.findViewById(R.id.idelementliste);
        text.setText(arrayList.get(position));
        return rowView;
    }
}