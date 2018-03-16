package com.example.dike.kao3shi4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by dike on 2017/10/18.
 */
public class AngserListAdpter extends BaseAdapter {

    public AngserListAdpter(List<QuestionsInfo.Question.OptonInfo> list, Context context, String detailInfo, String anserid) {
        this.list = list;
        this.context = context;
        this.detailInfo = detailInfo;
        this.anserid = anserid;

    }

    private List<QuestionsInfo.Question.OptonInfo> list;
    private Context context;
    String[] optext = {"A", "B", "C", "D", "E", "F"};
    String detailInfo;
    String anserid;

    @Override
    public int getCount() {
        return list.size() + 1;
    }

    @Override
    public Object getItem(int i) {
        if (i == list.size()){
            return detailInfo;
        }
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if (i < list.size()){

            if (view == null) {
                view = LayoutInflater.from(context).inflate(R.layout.angser_cell, viewGroup, false);
            }

            QuestionsInfo.Question.OptonInfo info = list.get(i);

            TextView text1 = (TextView)view.findViewById(R.id.textnum);
            TextView text = (TextView)view.findViewById(R.id.textconxt);

            String indexpath = optext[i] + "、";
            text1.setText(indexpath);

            text.setText(info.getContext());

            if (info.getUuid().equals(anserid)){

                view.setBackgroundResource(R.color.readright);

            }else{

                view.setBackgroundResource(R.color.readnomal);
            }

        }else{

            if (view == null) {
                view = LayoutInflater.from(context).inflate(R.layout.angseroption_cell, viewGroup, false);
            }

            TextView text = (TextView)view.findViewById(R.id.optiondetailinfo);

            text.setText(detailInfo);
        }



        return view;
    }
}
