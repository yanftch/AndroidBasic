package com.yanftch.basic.recyclerview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.yanftch.applibrary.base.BaseActivity;
import com.yanftch.basic.R;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewHeadFootActivity extends BaseActivity {
    private static final String TAG = "dah_RecyclerViewHeadFootAct";
    private RecyclerView recyclerView;
    private List<String> datas;
    private MyHeaderFooterAdapter mAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.open_from_right, R.anim.close_from_right);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        overridePendingTransition(R.anim.open_from_right, R.anim.close_from_right);
    }

    @Override
    public int setLayout() {
        return R.layout.activity_recycler_view_head_foot;
    }

    @Override
    public void setTitle() {
        mBaseTitleBarView.setTitleText("Recyclerview添加Head Foot");
    }

    @Override
    public void initWidget() {


        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        datas = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            datas.add("Item" + i);
        }
        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);
        mAdapter = new MyHeaderFooterAdapter(this, datas);
        TextView headView = new TextView(this);
        headView.setText("Head  信息");
        headView.setTextSize(40);
        headView.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
        headView.setWidth(1000);
        TextView footView = new TextView(this);
        footView.setText("It is Footer");
        footView.setTextSize(40);
        footView.setTextColor(getResources().getColor(R.color.colorAccent));
        footView.setGravity(Gravity.CENTER);


        recyclerView.setAdapter(mAdapter);
        mAdapter.setHeadView(headView);
        mAdapter.setFootView(footView);


        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });

    }

    @Override
    public void widgetClick(View v) {

    }
}
