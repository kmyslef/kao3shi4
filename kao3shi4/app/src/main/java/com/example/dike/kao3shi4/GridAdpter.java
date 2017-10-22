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
 * Created by dike on 2017/10/17.
 */
public class GridAdpter extends BaseAdapter {

    private ArrayList<MainGridInfo> list;
    private Context context;

    public GridAdpter(ArrayList<MainGridInfo> list, Context context) {
        this.list = list;
        this.context = context;
    }

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

        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.main_grid, viewGroup, false);
        }

        MainGridInfo info = list.get(i);

        ImageView image = (ImageView)view.findViewById(R.id.img_icon);
        TextView text = (TextView)view.findViewById(R.id.txt_icon);

        image.setImageResource(info.getIcon());
        text.setText(info.getTitle());


        return view;
    }
}
