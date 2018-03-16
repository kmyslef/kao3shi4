package com.example.dike.kao3shi4;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.xiasuhuei321.loadingdialog.view.LoadingDialog;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;



/**
 * Created by dik on 2018/2/24.
 */

public class jiheActivity extends BaseActivity {

    private LoadingDialog ld;
    GridView grid;
    private boolean intercept_back_event = false;
    private int style = LoadingDialog.STYLE_LINE;
    private List<GroupInfo.Info> grouparray;
    private String detailstr;
    private List<QuestionsInfo.Question> detailarray;
    private int curnum;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jihe);

        grid = (GridView)findViewById(R.id.jihegridView);

//        grouparray = new List<GroupInfo.Info>();

        curnum = 0;

        ld = new LoadingDialog(this);
        ld.setInterceptBack(intercept_back_event)
                .setLoadingText("加载中...")
                .setLoadStyle(style)
                .setInterceptBack(true)
                .show();

        getDataAsync();

        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ld = new LoadingDialog(jiheActivity.this);
                ld.setInterceptBack(intercept_back_event)
                        .setLoadingText("加载中...")
                        .setLoadStyle(style)
                        .setInterceptBack(true)
                        .show();
                getDetailData(i);
//                startActivity(new Intent(jiheActivity.this, AngserActivity.class));
            }
        });

    }

    private void getDetailData(int i){

        curnum = i;

        GroupInfo.Info temInfo = grouparray.get(i);
        String url = PeiZhi.getPath() + "zhuguan/alluserlist?page=" + temInfo.getPagenum() + "&size=" + temInfo.getPagesize();
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .build();
        String token = PeiZhi.getAccountid();
        Request request = new Request.Builder().url(url).header("token", token).build();

        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                jiheActivity.this.runOnUiThread(new Runnable() {
                    @Override public void run() {
                        ld.close();
                        //刷新ui
                        Toast.makeText(jiheActivity.this, "获取数据失败", Toast.LENGTH_SHORT).show();
                    }
                });
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if(response.isSuccessful()){//回调的方法执行在子线程。
                    Log.d("kwwl","获取数据成功了");
                    Log.d("kwwl","response.code()=="+response.code());

                    //解析response.body()
                    ResponseBody bodys = response.body();

                    String bodystr = bodys.string();
                    Log.d("kwwl","response.body().string()=="+bodystr);

//                    QuestionsInfo data = GsonUtil.parseJsonWithGson(bodystr, QuestionsInfo.class);
//                    detailarray = data.getData();
                    detailstr = bodystr;



                    jiheActivity.this.runOnUiThread(new Runnable() {
                        @Override public void run() {
                            ld.close();

                            Intent inten = new Intent(jiheActivity.this, AngserActivity.class);
//                            inten.putExtra("listobj", (Serializable) detailarray);
                            inten.putExtra("obj", detailstr);
                            GroupInfo.Info temInfo = grouparray.get(curnum);
                            int startnum = temInfo.getPagenum() * temInfo.getPagesize();

                            inten.putExtra("startnum", startnum);
                            startActivity(inten);


                            //刷新ui
//                            Toast.makeText(jiheActivity.this, String.valueOf(response.code()), Toast.LENGTH_SHORT).show();
                        }
                    });


                }
            }

        });

    }

    private void getDataAsync() {

        String url = PeiZhi.getPath() + "zhuguan/group";
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .build();
        String token = PeiZhi.getAccountid();
        Request request = new Request.Builder().url(url).header("token", token).build();

        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                jiheActivity.this.runOnUiThread(new Runnable() {
                    @Override public void run() {
                        ld.close();
                        //刷新ui
                        Toast.makeText(jiheActivity.this, "获取数据失败", Toast.LENGTH_SHORT).show();
                    }
                });
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if(response.isSuccessful()){//回调的方法执行在子线程。
                    Log.d("kwwl","获取数据成功了");
                    Log.d("kwwl","response.code()=="+response.code());

                    //解析response.body()
                    ResponseBody bodys = response.body();

                    String bodystr = bodys.string();
                    Log.d("kwwl","response.body().string()=="+bodystr);


                    GroupInfo datainfo = GsonUtil.parseJsonWithGson(bodystr, GroupInfo.class);
                    grouparray = datainfo.getData();

                    jiheActivity.this.runOnUiThread(new Runnable() {
                        @Override public void run() {
                            ld.close();

                            jiheGridAdpter adpter = new jiheGridAdpter(grouparray, jiheActivity.this);
                            grid.setAdapter(adpter);

                            //刷新ui
//                            Toast.makeText(jiheActivity.this, String.valueOf(response.code()), Toast.LENGTH_SHORT).show();
                        }
                    });


                }
            }

        });
    }

}
