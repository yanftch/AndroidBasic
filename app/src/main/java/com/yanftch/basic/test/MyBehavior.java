package com.yanftch.basic.test;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;

/**
 * Author : yanftch
 * Date : 2018/5/10
 * Time : 10:39
 * Desc :
 */

public class MyBehavior extends CoordinatorLayout.Behavior<Button> {

    private static final String TAG = "dah_MyBehavior";
    private int width;

    public MyBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
        DisplayMetrics display = context.getResources().getDisplayMetrics();
        width = display.widthPixels;
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, Button child, View dependency) {
        return dependency instanceof TempView;
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, Button child, View dependency) {
        int top = dependency.getTop();
        int left = dependency.getLeft();

        int x = width- left-(0);
        int y = top;
        setPosition(child,x,y);


        return super.onDependentViewChanged(parent, child, dependency);
    }
    private void setPosition(View v, int x, int y) {
        CoordinatorLayout.MarginLayoutParams layoutParams = (CoordinatorLayout.MarginLayoutParams) v.getLayoutParams();
        layoutParams.leftMargin = x;
        layoutParams.topMargin = y;
        v.setLayoutParams(layoutParams);
    }
}
