package com.yanftch.basic.diy_view.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;

/**
 * Author : yanftch
 * Date : 2018/4/13
 * Time : 14:17
 * Desc :
 */

public class DiyView extends BaseView {
    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    private static final String TAG = "dah_DiyView";

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        Log.e(TAG, "onMeasure: measuredWidth==" + measuredWidth + "    measuredHeight===" + measuredHeight);
        setMeasuredDimension(measuredWidth,measuredHeight);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        Log.e(TAG, "onLayout: ");
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.e(TAG, "onDraw: ");
        canvas.drawColor(Color.parseColor("#00ff00"));
    }

    public DiyView(Context context) {
        super(context);
    }

    public DiyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DiyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
