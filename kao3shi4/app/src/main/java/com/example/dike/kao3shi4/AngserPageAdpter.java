package com.example.dike.kao3shi4;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dike on 2017/10/17.
 */
public class AngserPageAdpter extends PagerAdapter {

    private List<QuestionsInfo.Question> list;
    private Context context;
    private Map<String, Object> viewmap;
    private int startnum;

    public AngserPageAdpter(List<QuestionsInfo.Question> list, Context context, int startnum) {
        this.list = list;
        this.context = context;
        this.startnum = startnum;

        viewmap = new HashMap<String, Object>();
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

        View view = null;
        String key = String.valueOf(position);
        View temView = (View)viewmap.get(key);
        if (temView == null){

            view = LayoutInflater.from(context).inflate(R.layout.angser_viewpager, container, false);
            QuestionsInfo.Question info = list.get(position);
            ListView list = (ListView)view.findViewById(R.id.list);
            AngserListAdpter adpter = new AngserListAdpter(info.getOptons(), context, info.getExplain(), info.getAnswerid());
            list.setAdapter(adpter);

            View header = LayoutInflater.from(context).inflate(R.layout.angser_cellheader, null, false);
            TextView text = header.findViewById(R.id.head);
            String headinfo = String.valueOf(position + 1 + startnum) + "、" + info.getQuestion();
            text.setText(headinfo);
            list.addHeaderView(header);

            container.addView(view);

            viewmap.put(key, view);
        }else{
            view = temView;
        }



        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
//        String key = String.valueOf(position);
//        View temView = (View)viewmap.get(key);
//
//        if (temView != null){
//            container.removeView(temView);
//        }

    }

}
