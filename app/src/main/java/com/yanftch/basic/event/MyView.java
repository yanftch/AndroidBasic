package com.yanftch.basic.event;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Author : yanftch
 * Date : 2018/3/22
 * Time : 16:54
 * Desc :
 */

public class MyView extends View {
    private static final String TAG = "debug_MyView";

    @Override
    public void setOnClickListener(@Nullable OnClickListener l) {
        super.setOnClickListener(l);
    }

    @Override
    public void setOnLongClickListener(@Nullable OnLongClickListener l) {
        super.setOnLongClickListener(l);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.w(TAG, "dispatchTouchEvent: " + printEventName(ev.getAction()));
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        Log.w(TAG, "onTouchEvent: " + printEventName(ev.getAction()));
        return super.onTouchEvent(ev);
    }

    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private String printEventName(int code) {
        String string = "";
        if (code == 0) {
            string = "ACTION_DOWN";
        } else if (code == 1) {
            string = "ACTION_UP";
        } else if (code == 2) {
            string = "ACTION_MOVE";
        } else if (code == 3) {
            string = "ACTION_CANCEL";
        }
        return string;
    }

}
