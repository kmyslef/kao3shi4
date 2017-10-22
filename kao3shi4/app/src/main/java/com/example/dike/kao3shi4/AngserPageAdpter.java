package com.example.dike.kao3shi4;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by dike on 2017/10/17.
 */
public class AngserPageAdpter extends PagerAdapter {

    private ArrayList<AngserInfo> list;
    private Context context;

    public AngserPageAdpter(ArrayList<AngserInfo> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        View view = LayoutInflater.from(context).inflate(R.layout.angser_viewpager, container, false);

        AngserInfo info = list.get(position);
        ListView list = (ListView)view.findViewById(R.id.list);
        AngserListAdpter adpter = new AngserListAdpter(info.getOptions(), context);
        list.setAdapter(adpter);

        View header = LayoutInflater.from(context).inflate(R.layout.angser_cellheader, null, false);
        TextView text = header.findViewById(R.id.head);
        text.setText(info.getName());
        list.addHeaderView(header);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        View view = container.findViewById(R.id.pagerView);
        container.removeView(view);
    }

}
