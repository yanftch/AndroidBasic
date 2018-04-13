package com.yanftch.basic.diy_view.view;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.LinearLayout;

/**
 * Author : yanftch
 * Date : 2018/4/13
 * Time : 14:18
 * Desc :
 */

public class DiyViewGroup extends LinearLayout {
    private static final String TAG = "dah_DiyViewGroup";

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        Log.e(TAG, "onMeasure: measuredWidth==" + measuredWidth + "    measuredHeight===" + measuredHeight);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        Log.e(TAG, "onLayout: ");
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.e(TAG, "onDraw: ");
    }

    public DiyViewGroup(Context context) {
        super(context);
    }

    public DiyViewGroup(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }


    public DiyViewGroup(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
