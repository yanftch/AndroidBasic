package com.yanftch.basic.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.yanftch.applibrary.base.BaseActivity;
import com.yanftch.basic.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Author : yanftch
 * Date   : 2018/4/5
 * Time   : 15:08
 * Desc   : Fragment的add+hide+show实现，切换的时候不会重走生命周期
 * add+replace--->会重走生命周期
 */

public class FragmentChangeMainActivity extends BaseActivity {

    @BindView(R.id.btn1)
    Button mBtn1;
    @BindView(R.id.btn2)
    Button mBtn2;
    @BindView(R.id.btn3)
    Button mBtn3;

    @Override
    public int setLayout() {
        return R.layout.activity_fragment_change;
    }

    @Override
    public void setTitle() {

    }

    @Override
    public void initWidget() {
        mBtn1.setOnClickListener(this);
    }

    @Override
    public void widgetClick(View v) {
        switch (v.getId()) {
            case R.id.btn1:
                startActivity(new Intent(mContext, TabLayoutViewPagerFragmentActivity.class));
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
