package com.yanftch.basic.diy_view.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.animation.AccelerateDecelerateInterpolator;

/**
 * Author : yanftch
 * Date : 2018/4/13
 * Time : 08:45
 * Desc :
 */

public class AnimView extends BaseView {
    private static final String TAG = "dah_AnimView";
    private RectF mRectF;
    private float progress = 0;

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        Log.e(TAG, "onMeasure: ");
        int width = 0;
        int height = 0;

        if (MeasureSpec.getMode(widthMeasureSpec) == MeasureSpec.EXACTLY) {
            width = MeasureSpec.getSize(widthMeasureSpec);
        } else {

        }

        int size = Math.max(width, height);
        setMeasuredDimension(size, size);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        Log.e(TAG, "onLayout: ");
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.e(TAG, "onDraw: progress===" + progress);
        mRectF = new RectF(0, 0, 400, 400);
        canvas.drawArc(mRectF, -90, progress, true, getDefaultPaint());
    }


    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        Log.e(TAG, "onFinishInflate: ");
        start();
    }

    public void start() {
        initAnimator();
    }

    private void initAnimator() {
        ValueAnimator anim = ValueAnimator.ofFloat(0, 360);
        anim.setDuration(10000);
        anim.setInterpolator(new AccelerateDecelerateInterpolator());
        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                progress = (float) valueAnimator.getAnimatedValue();
                invalidate();
            }
        });
        anim.start();
    }


    public AnimView(Context context) {
        super(context);
        start();
    }

    public AnimView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        start();
    }

    public AnimView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        start();
    }
}
