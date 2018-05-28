package com.yanftch.basic.glide;

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
import com.yanftch.applibrary.base.BaseActivity;
import com.yanftch.basic.R;
import com.yanftch.basic.constant.ConstantValue;

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
    @BindView(R.id.btnLoadImg2)
    Button mBtnLoadImg2;
    @BindView(R.id.btnLoadImg3)
    Button mBtnLoadImg3;
    @BindView(R.id.btnLoadImg4)
    Button mBtnLoadImg4;

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
        mBtnLoadImg2.setOnClickListener(this);
        mBtnLoadImg3.setOnClickListener(this);
        mBtnLoadImg4.setOnClickListener(this);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void widgetClick(View v) {
        switch (v.getId()) {
            case R.id.btnLoadImg:
                int lollipop = Build.VERSION_CODES.LOLLIPOP;

//                Intent intent = new Intent(mContext, HandlerActivity.class);
//                ActivityOptions options = ActivityOptions.makeScaleUpAnimation(mLlContainer, mLlContainer.getWidth() / 2, mLlContainer.getHeight() / 2, 0, 0);
//                startActivity(intent, options.toBundle());
                loadImage(ConstantValue.imgUrl);
                break;
            case R.id.btnLoadImg2:
                loadImage(ConstantValue.girUrl2);
                break;
            case R.id.btnLoadImg3:
                loadImage(ConstantValue.gir_xiaoda1);
                break;
            case R.id.btnLoadImg4:
                loadImage(ConstantValue.gir_xiaoda2);
                break;
        }
    }

    private void loadImage(String imgURl) {
        Glide
                .with(mContext)
                .load(imgURl)
                .asGif()
                .placeholder(R.drawable.loading_loading)
                .error(R.drawable.loading_error)
                .override(300, 300)
                .into(mIvGlideDemo);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
