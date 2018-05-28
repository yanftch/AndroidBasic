package com.yanftch.basic.event;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;

/**
 * Author : yanftch
 * Date : 2018/3/22
 * Time : 16:53
 * Desc :
 */

public class MyViewGroup extends RelativeLayout {
    private static final String TAG = "debug_MyViewGroup";


    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.d(TAG, "dispatchTouchEvent: " +printEventName(ev.getAction()));
        return super.dispatchTouchEvent(ev);
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

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.d(TAG, "onInterceptTouchEvent: " + printEventName(ev.getAction()));
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        Log.d(TAG, "onTouchEvent: " + printEventName(ev.getAction()));
        return super.onTouchEvent(ev);
    }

    public MyViewGroup(Context context) {
        super(context);
        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e(TAG, "onClick: 11111111111");
            }
        });
    }

    public MyViewGroup(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyViewGroup(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
