package com.example.dike.kao3shi4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView grid = (GridView)findViewById(R.id.gridView);

        ArrayList<MainGridInfo> list = new ArrayList<>();
        MainGridInfo info = new MainGridInfo();
        info.setIcon(R.mipmap.main_answer);
        info.setTitle("考试题库");
        list.add(info);

        info = new MainGridInfo();
        info.setIcon(R.mipmap.main_mu2ni3);
        info.setTitle("模拟考试");
        list.add(info);

        info = new MainGridInfo();
        info.setIcon(R.mipmap.main_error);
        info.setTitle("错题回顾");
        list.add(info);

        info = new MainGridInfo();
        info.setIcon(R.mipmap.main_tong3ji4);
        info.setTitle("答题统计");
        list.add(info);

        info = new MainGridInfo();
        info.setIcon(R.mipmap.main_history);
        info.setTitle("历史回顾");
        list.add(info);

        info = new MainGridInfo();
        info.setIcon(R.mipmap.main_shang4chuan2);
        info.setTitle("新题上传");
        list.add(info);

        info = new MainGridInfo();
        info.setIcon(R.mipmap.main_setting);
        info.setTitle("考题设置");
        list.add(info);

        GridAdpter adpter = new GridAdpter(list, MainActivity.this);
        grid.setAdapter(adpter);

        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0){
                    startActivity(new Intent(MainActivity.this, jiheActivity.class));
                }else{
                    startActivity(new Intent(MainActivity.this, AngserActivity.class));
                }

            }
        });
    }
}
