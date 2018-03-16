package com.example.dike.kao3shi4;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class AngserActivity extends BaseActivity {

    private List<QuestionsInfo.Question> detailarray;
    ViewPager pager;
    TextView textView;
    int startnum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_angser);

        pager = (ViewPager)findViewById(R.id.viewPager);
        textView = (TextView)findViewById(R.id.textpage);
        Button btn = (Button)findViewById(R.id.pagebtn);

        String objstr = getIntent().getStringExtra("obj");
        startnum = getIntent().getIntExtra("startnum", 0);



        QuestionsInfo data = GsonUtil.parseJsonWithGson(objstr, QuestionsInfo.class);
        detailarray = data.getData();

        String pagestr = String.valueOf(startnum + 1) + "/" + String.valueOf(startnum + detailarray.size());
        textView.setText(pagestr);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

//        pager.setCurrentItem(3);

        pager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener(){
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);

                String pagestr = String.valueOf(startnum + position + 1) + "/" + String.valueOf(startnum + detailarray.size());
                textView.setText(pagestr);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
            }
        });



        AngserPageAdpter adpter = new AngserPageAdpter(detailarray, AngserActivity.this, startnum);
        pager.setAdapter(adpter);

    }
}
