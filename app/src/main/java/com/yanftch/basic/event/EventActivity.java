package com.yanftch.basic.event;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;

import com.yanftch.basic.R;

/**
 * Author : yanftch
 * Date   : 2018/3/22
 * Time   : 16:50
 * Desc   : 事件分发
 */

public class EventActivity extends AppCompatActivity {
    private static final String TAG = "debug_EventActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.e(TAG, "dispatchTouchEvent: " + ev);
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e(TAG, "onTouchEvent: " + event);
        return super.onTouchEvent(event);
    }
}
