package com.yanftch.basic.service;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.yanftch.applibrary.base.BaseActivity;
import com.yanftch.basic.R;
import com.yanftch.basic.entity.User;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ServiceActivity extends BaseActivity {
    private static final String TAG = "dah_ServiceActivity";
    @BindView(R.id.btnStartService)
    Button mBtnStartService;
    @BindView(R.id.btnStopService)
    Button mBtnStopService;
    @BindView(R.id.btnBindService)
    Button mBtnBindService;
    @BindView(R.id.btnUnbingService)
    Button mBtnUnbingService;
    @BindView(R.id.btnStartIntentService)
    Button mBtnStartIntentService;
    @BindView(R.id.btnStopIntentService)
    Button mBtnStopIntentService;

    private MyCon mMyCon;
    List<User> list = new ArrayList<>();


    @Override
    public int setLayout() {
        return R.layout.activity_service;
    }

    @Override
    public void setTitle() {
        mMyCon = new MyCon();
        for (int i = 0; i < 20; i++) {
            list.add(new User("name" + i, i));
        }
        /**------------------方法一------------------*/
        Log.e(TAG, "setTitle: 方法1---begin:" + System.currentTimeMillis());
        Iterator<User> iterator = list.iterator();
        while (iterator.hasNext()) {
            int age = iterator.next().getAge();
            if (age == 18) {
                iterator.remove();
            }
        }
        Log.e(TAG, "setTitle: 方法1---end:" + System.currentTimeMillis());

        /**------------------方法二------------------*/

        /**------------------方法三------------------*/
        for (int i = 0; i < list.size(); i++) {
            Log.e(TAG, "setTitle: " + list.get(i).toString());
        }

    }

    @Override
    public void initWidget() {
        mBtnStartService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, MyService.class);
                startService(intent);
            }
        });
        mBtnStopService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, MyService.class);
                stopService(intent);
            }
        });
        /**------------------------------------------*/
        mBtnBindService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                createDialog();
                Intent intent = new Intent(mContext, MyBindService.class);
                bindService(intent, mMyCon, BIND_AUTO_CREATE);
            }
        });
        mBtnUnbingService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, MyBindService.class);
                unbindService(mMyCon);
            }
        });
        /**------------------------------------------*/
        mBtnStartIntentService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, MyIntentService.class);
                intent.putExtra("tag", "000");
                startService(intent);
            }
        });
    }

    @Override
    public void widgetClick(View v) {

    }

    MyBindService mMyBindService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    class MyCon implements ServiceConnection {

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.e(TAG, "onServiceConnected: 此处进行后台操作，比如偷偷的下载文件。。。。。。。。");
            ((MyBindService.MyBinder) service).showToastLong("long.....");
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.e(TAG, "onServiceDisconnected: name===" + name);
        }
    }

    private void createDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        builder.setTitle("title")
                .setMessage("content")
                .setNegativeButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
        Dialog dialog = builder.create();
        dialog.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);
        dialog.show();
    }
}
