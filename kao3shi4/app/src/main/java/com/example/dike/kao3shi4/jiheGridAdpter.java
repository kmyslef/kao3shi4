package com.example.dike.kao3shi4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by dik on 2018/3/12.
 */

public class jiheGridAdpter extends BaseAdapter {

    private List<GroupInfo.Info> list;
    private Context context;

    public jiheGridAdpter(List<GroupInfo.Info> grouparray, Context context) {
        this.list = grouparray;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.jihe_grid, viewGroup, false);
        }

        GroupInfo.Info info = list.get(i);

        TextView text = (TextView)view.findViewById(R.id.jihetxt);
        if (i %2 == 0){
            view.setBackgroundResource(R.color.grid1);
        }else{
            view.setBackgroundResource(R.color.grid2);
        }

        int startnum = info.getPagenum() * info.getPagesize();
        int endnum = startnum + info.getShowsize();
        String showStr = String.valueOf(startnum + 1) + "--" + String.valueOf(endnum);
        text.setText(showStr);


        return view;
    }
}
