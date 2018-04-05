package com.yanftch.basic.animation;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.yanftch.applibrary.base.BaseActivity;
import com.yanftch.basic.R;
import com.yanftch.basic.handler.HandlerActivity;
import com.yanftch.basic.recyclerview.RecyclerViewHeadFootActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Author : yanftch
 * Date   : 2018/4/4
 * Time   : 13:36
 * Desc   : 动画
 * 共享动画
 */

public class AnimationActivity extends BaseActivity {
    private static final String TAG = "dah_AnimationActivity";
    @BindView(R.id.btnAnimOrigin)
    Button mBtnAnimOrigin;
    @BindView(R.id.btnAnim1)
    Button mBtnAnim1;
    @BindView(R.id.btnAnim2)
    Button mBtnAnim2;
    @BindView(R.id.btnAnim3)
    Button mBtnAnim3;
    @BindView(R.id.btnAnim4)
    Button mBtnAnim4;
    @BindView(R.id.btnAnim5)
    Button mBtnAnim5;
    @BindView(R.id.imageViewAnchor)
    ImageView mImageViewAnchor;
    @BindView(R.id.ancho2)
    ImageView mAncho2;
    private int width;
    private int height;


    ActivityOptions options;

    @Override
    public int setLayout() {
        return R.layout.activity_animation;
    }

    @Override
    public void setTitle() {
        width = mImageViewAnchor.getWidth();
        height = mImageViewAnchor.getHeight();

    }

    @Override
    public void initWidget() {
        mBtnAnimOrigin.setOnClickListener(this);
        mBtnAnim1.setOnClickListener(this);
        mBtnAnim2.setOnClickListener(this);
        mBtnAnim3.setOnClickListener(this);
        mBtnAnim4.setOnClickListener(this);
        mBtnAnim5.setOnClickListener(this);
    }

    @Override
    public void widgetClick(View v) {
        Intent intent = new Intent(mContext, HandlerActivity.class);
        switch (v.getId()) {
            case R.id.btnAnimOrigin:
                Intent intent0 = new Intent(mContext, RecyclerViewHeadFootActivity.class);
                startActivity(intent0);
                break;
            case R.id.btnAnim1:
                /**
                 *
                 */
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    options = ActivityOptions.makeScaleUpAnimation(mImageViewAnchor, 0, 0, 0, 0);
                    startActivity(intent, options.toBundle());
                }
                break;
            case R.id.btnAnim4:
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    options = ActivityOptions.makeSceneTransitionAnimation(this, mAncho2, getResources().getString(R.string.app_name));
                    startActivity(intent, options.toBundle());
                }
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
