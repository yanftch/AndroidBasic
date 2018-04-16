package com.yanftch.basic.what;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.yanftch.applibrary.base.BaseActivity;
import com.yanftch.basic.R;
import com.yanftch.basic.constant.CommonDataUtils;

import butterknife.BindView;

/**
 * Author : yanftch
 * Date   : 2018/4/15
 * Time   : 22:23
 * Desc   : 垂直RV和水平RV嵌套使用
 */

public class DoubleRecyclerViewActivity extends BaseActivity {
    private static final String TAG = "dah_DoubleRecyclerViewActiv";
    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;
    private DoubleOutAdapter mDoubleOutAdapter;


    @Override
    public int setLayout() {
        return R.layout.activity_double_recycler_view;
    }

    @Override
    public void setTitle() {
        mBaseTitleBarView.setTitleText("RV 垂直&横向嵌套");
    }

    @Override
    public void initWidget() {
        mDoubleOutAdapter = new DoubleOutAdapter(CommonDataUtils.getCommonTestDataList());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setAdapter(mDoubleOutAdapter);


        mDoubleOutAdapter.setOnItemClickListener(new DoubleOutAdapter.onItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(DoubleRecyclerViewActivity.this, "OUT------position====" + position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void widgetClick(View v) {

    }
}
