package com.example.dike.kao3shi4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by dike on 2017/10/18.
 */
public class AngserListAdpter extends BaseAdapter {

    public AngserListAdpter(ArrayList<AngserOpionInfo> list, Context context) {
        this.list = list;
        this.context = context;
    }

    private ArrayList<AngserOpionInfo> list;
    private Context context;

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        AngserOpionInfo info = list.get(i);


        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.angser_cell, viewGroup, false);
        }


        TextView text1 = (TextView)view.findViewById(R.id.textnum);
        TextView text = (TextView)view.findViewById(R.id.txt_icon);

        text1.setText(String.valueOf(i));

        text1.setText(info.getDetail());

        return view;
    }
}
