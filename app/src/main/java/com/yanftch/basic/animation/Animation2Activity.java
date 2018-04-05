package com.yanftch.basic.animation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.yanftch.applibrary.base.BaseActivity;
import com.yanftch.basic.R;

import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Author : yanftch
 * Date   : 2018/4/5
 * Time   : 15:40
 * Desc   : 动画
 */

public class Animation2Activity extends BaseActivity {
    private static final String TAG = "dah_Animation2Activity";
    @BindView(R.id.btnVAnim1)
    Button mBtnVAnim1;
    @BindView(R.id.imageTestAninm)
    ImageView mImageTestAninm;
    @BindView(R.id.textViewShowInfo)
    TextView mTextViewShowInfo;
    @BindView(R.id.btnVAnim2)
    Button mBtnVAnim2;

    @Override
    public int setLayout() {
        return R.layout.activity_animation2;
    }

    @Override
    public void setTitle() {

    }

    @Override
    public void initWidget() {
        mBtnVAnim1.setOnClickListener(this);
        mBtnVAnim2.setOnClickListener(this);
    }

    @Override
    public void widgetClick(View v) {
        switch (v.getId()) {
            case R.id.btnVAnim1:
                ValueAnimator1();
                break;
            case R.id.btnVAnim2:
                Random random = new Random();
                int index = random.nextInt(4) + 1;
                Toast.makeText(this, "index===" + index, Toast.LENGTH_SHORT).show();
                if (index == 1) {
                    ObjectAnimator1();
                } else if (index == 2) {
                    ObjectAnimator2();
                } else if (index == 3) {
                    ObjectAnimator3();
                } else if (index == 4) {
                    ObjectAnimator4();
                }
                break;
        }
    }

    /**
     * 透明度
     */
    private void ObjectAnimator1() {
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(mTextViewShowInfo, "alpha", 1f, 0f, 1f);
        objectAnimator.setDuration(5000);
        objectAnimator.start();
        objectAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationCancel(Animator animation) {
                super.onAnimationCancel(animation);
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
                super.onAnimationRepeat(animation);
            }

            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
            }

            @Override
            public void onAnimationPause(Animator animation) {
                super.onAnimationPause(animation);
            }

            @Override
            public void onAnimationResume(Animator animation) {
                super.onAnimationResume(animation);
            }
        });
    }

    /**
     * 旋转
     */
    private void ObjectAnimator2() {
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(mTextViewShowInfo, "rotation", 0f, 360f);
        objectAnimator.setDuration(5000);
        objectAnimator.start();
    }

    private void ObjectAnimator3() {
        float curTranslationX = mTextViewShowInfo.getTranslationX();
        ObjectAnimator animator = ObjectAnimator.ofFloat(mTextViewShowInfo, "translationX", curTranslationX, -500f, curTranslationX);
        animator.setDuration(5000);
        animator.start();
    }

    private void ObjectAnimator4() {
        ObjectAnimator animator = ObjectAnimator.ofFloat(mTextViewShowInfo, "scaleY", 1f, 3f, 1f);
        animator.setDuration(5000);
        animator.start();
    }

    private void ValueAnimator1() {
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(1f, 0f);
        valueAnimator.setDuration(5000);//5s内实现过渡
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float animatedValue = (float) animation.getAnimatedValue();
                Log.e(TAG, "onAnimationUpdate: " + animatedValue);
                mTextViewShowInfo.setText("ValueAnimator 当前的值是：" + animatedValue);
            }
        });
        valueAnimator.start();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
