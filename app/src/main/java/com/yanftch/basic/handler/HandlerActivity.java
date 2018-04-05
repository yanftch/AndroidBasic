package com.yanftch.basic.handler;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.yanftch.applibrary.base.BaseActivity;
import com.yanftch.basic.R;

import butterknife.BindView;

public class HandlerActivity extends BaseActivity {
    private static final String TAG = "dah_HandlerActivity";
    @BindView(R.id.btnTest)
    Button mBtnTest;
    @BindView(R.id.textViewHandler)
    TextView mTextViewHandler;
    private static MyHandler mMyHandler;


    static class MyHandler extends Handler {
        @Override
        public void handleMessage(final Message msg) {
            super.handleMessage(msg);
            if (msg.what == 100) {
                Log.e(TAG, "handleMessage: " + msg.obj.toString());
            }
        }
    }

    @Override
    public int setLayout() {
        return R.layout.activity_handler;
    }

    @Override
    public void setTitle() {
        mBaseTitleBarView.setTitleText("Handler相关");
        mBaseTitleBarView.setVisibility(View.GONE);
    }

    @Override
    public void initWidget() {
        mBtnTest.setOnClickListener(this);
    }

    @Override
    public void widgetClick(View v) {
        switch (v.getId()) {
            case R.id.btnTest:
                Message message = new Message();
                message.what = 100;
                message.obj = "123456789";
                mMyHandler.sendEmptyMessageDelayed(message.what, 1000);
                break;
        }
    }

}
