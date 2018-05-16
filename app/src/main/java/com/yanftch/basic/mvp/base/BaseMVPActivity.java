package com.yanftch.basic.mvp.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;

/**
 * Author : yanftch
 * Date : 2018/5/16
 * Time : 10:26
 * Desc :
 */

public abstract class BaseMVPActivity<V, T extends BasePresenter> extends FragmentActivity {
    public String TAG = getClass().getSimpleName();
    protected T mPresenter;
    public Context mContext;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setLayout());
        mContext = BaseMVPActivity.this;
        //创建Presenter
        mPresenter = createPresenter();
        initView();

        getData();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mPresenter != null) {
            mPresenter.attachView((V) this);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachView();
        }
    }

    protected abstract void getData();

    protected abstract T createPresenter();

    protected abstract int setLayout();

    protected abstract void initView() ;
}
