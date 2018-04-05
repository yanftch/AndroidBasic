package com.yanftch.basic.glide;

import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Debug;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.yanftch.applibrary.base.BaseActivity;
import com.yanftch.basic.R;
import com.yanftch.basic.constant.ConstantValue;
import com.yanftch.basic.handler.HandlerActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Author : yanftch
 * Date   : 2018/4/3
 * Time   : 09:56
 * Desc   :
 */

public class GlideDemoActivity extends BaseActivity {
    private static final String TAG = "dah_GlideDemoActivity";
    @BindView(R.id.btnLoadImg)
    Button mBtnLoadImg;
    @BindView(R.id.ivGlideDemo)
    ImageView mIvGlideDemo;
    @BindView(R.id.llContainer)
    LinearLayout mLlContainer;

    @Override
    public int setLayout() {
        return R.layout.activity_glide_demo;
    }

    @Override
    public void setTitle() {
        mBaseTitleBarView.setVisibility(View.GONE);
    }

    @Override
    public void initWidget() {
        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        boolean debuggerConnected = Debug.isDebuggerConnected();
        Log.e(TAG, "initWidget: debuggerConnected===" + debuggerConnected);
        mBtnLoadImg.setOnClickListener(this);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void widgetClick(View v) {
        switch (v.getId()) {
            case R.id.btnLoadImg:
                int lollipop = Build.VERSION_CODES.LOLLIPOP;

                Intent intent = new Intent(mContext, HandlerActivity.class);
                ActivityOptions options = ActivityOptions.makeScaleUpAnimation(mLlContainer, mLlContainer.getWidth() / 2, mLlContainer.getHeight() / 2, 0, 0);
                startActivity(intent, options.toBundle());
                loadImage();
                break;
        }
    }

    private void loadImage() {
        Glide
                .with(mContext)
                .load(ConstantValue.imgUrl)
                .placeholder(R.drawable.loading_loading)
                .error(R.drawable.loading_error)
                .diskCacheStrategy(DiskCacheStrategy.NONE)//不做缓存 处理
                .override(400, 200)
                .into(mIvGlideDemo);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
