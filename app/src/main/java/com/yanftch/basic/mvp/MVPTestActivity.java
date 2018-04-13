package com.yanftch.basic.mvp;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.yanftch.applibrary.base.BaseActivity;
import com.yanftch.applibrary.net.HttpManager;
import com.yanftch.applibrary.net.ICallBack;
import com.yanftch.applibrary.net.MyTestBean;
import com.yanftch.applibrary.net.RetrofitManager;
import com.yanftch.basic.R;

import butterknife.BindView;

public class MVPTestActivity extends BaseActivity {
    private static final String TAG = "dah_MVPTestActivity";
    @BindView(R.id.btnGetHome)
    Button mBtnGetHome;
    @BindView(R.id.tvHomeData)
    TextView mTvHomeData;
    @BindView(R.id.tvHomeData2)
    TextView mTvHomeData2;

    @Override
    public int setLayout() {
        return R.layout.activity_mvptest;
    }

    @Override
    public void setTitle() {

    }

    @Override
    public void initWidget() {
        mBtnGetHome.setOnClickListener(this);
    }

    @Override
    public void widgetClick(View v) {
        switch (v.getId()) {
            case R.id.btnGetHome:
                http_getHome();
                break;
        }
    }

    private void http_getHome() {
        HttpManager.getInstance()
                .with(mContext)
                .setObservable(RetrofitManager.getService().getFengHome())
                .setCallBack(true, new ICallBack<MyTestBean>() {
                    @Override
                    public void onSuccess(MyTestBean normalBean) {
                        if (null != normalBean && normalBean.getProductIntr() != null) {
                            Log.e(TAG, "onSuccess: " + normalBean.getBannerList());
                            mTvHomeData.setText(normalBean.getProductIntr().getPiTitle());
                            for (int i = 0; i < normalBean.getBannerList().size(); i++) {
                                Log.e(TAG, "onSuccess: " + normalBean.getBannerList().get(i).getAdTitle());
                            }
                            mTvHomeData2.setText(normalBean.getProductIntr().getImageUrl());
                        } else {
                            Toast.makeText(MVPTestActivity.this, "空数据", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onError(String message) {
                        Log.e(TAG, "--------------------" + message);
                    }
                });
    }
}
