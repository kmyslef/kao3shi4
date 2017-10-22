package com.example.dike.kao3shi4;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class AngserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_angser);

        ViewPager pager = (ViewPager)findViewById(R.id.viewPager);

        ArrayList<AngserInfo> list = new ArrayList<>();

        for (int i = 0; i < 5; i++)
        {
            AngserInfo info = new AngserInfo();
            info.setName("dfdslfkjdkslfjdlksf");
            info.setNameId("123");
            ArrayList<AngserOpionInfo> infoList = new ArrayList<>();
            AngserOpionInfo listInfo = new AngserOpionInfo();
            listInfo.setDetail("zcvxcvxcvcvcvxcvxcv");
            listInfo.setOptionId("567");
            infoList.add(listInfo);
            info.setOptions(infoList);
            list.add(info);
        }


        AngserPageAdpter adpter = new AngserPageAdpter(list, AngserActivity.this);
        pager.setAdapter(adpter);

    }
}
