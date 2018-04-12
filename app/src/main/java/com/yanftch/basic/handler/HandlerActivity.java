package com.yanftch.basic.handler;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.yanftch.applibrary.base.BaseActivity;
import com.yanftch.basic.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HandlerActivity extends BaseActivity {
    private static final String TAG = "dah_HandlerActivity";
    @BindView(R.id.textViewHandler)
    TextView mTextViewHandler;
    private static MyHandler mMyHandler;
    @BindView(R.id.btnAsyncTask)
    Button mBtnAsyncTask;
    @BindView(R.id.ivAnchor)
    ImageView mIvAnchor;
    private MyAsyncTask mMyAsyncTask;
    private boolean isRunning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }


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
    }

    @Override
    public void initWidget() {
        mMyAsyncTask = new MyAsyncTask();

        mBtnAsyncTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isRunning) {
                    mMyAsyncTask.cancel(true);
                } else {
                    mMyAsyncTask.execute();
                }
            }
        });
    }

    @Override
    public void widgetClick(View v) {
        switch (v.getId()) {
            case R.id.btnTest:
                break;
        }
    }

    class MyAsyncTask extends AsyncTask<String, Integer, List<String>> {

        @Override
        protected List<String> doInBackground(String... strings) {

            try {
                int count = 0;
                while (count < 9) {
                    count = count + 1;
                    publishProgress(count);
                    Log.e(TAG, "doInBackground: " + count);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Toast.makeText(HandlerActivity.this, "开始了...", Toast.LENGTH_SHORT).show();
        }

        @Override
        protected void onPostExecute(List<String> strings) {
            super.onPostExecute(strings);
            Toast.makeText(HandlerActivity.this, "结束了...", Toast.LENGTH_SHORT).show();
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            mBaseTitleBarView.setTitleText("进度值:" + values[0]);
        }
    }
}
