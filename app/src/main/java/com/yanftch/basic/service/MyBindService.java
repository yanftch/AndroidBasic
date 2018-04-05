package com.yanftch.basic.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import com.yanftch.applibrary.net.HttpManager;
import com.yanftch.applibrary.net.ICallBack;
import com.yanftch.applibrary.net.MyTestBean;
import com.yanftch.applibrary.net.RetrofitManager;

/**
 * Author : yanftch
 * Date : 2018/3/14
 * Time : 11:07
 * Desc :
 */

public class MyBindService extends Service {
    private static final String TAG = "dah_MyBindService";
    private MyBinder mMyBinder;
    private Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e(TAG, "onCreate: ");
        mContext = this;
        mMyBinder = new MyBinder();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e(TAG, "onStartCommand: ");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onStart(Intent intent, int startId) {
        Log.e(TAG, "onStart: ");
        super.onStart(intent, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.e(TAG, "onBind: ");
        return mMyBinder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.e(TAG, "onUnbind: ");
        return super.onUnbind(intent);
    }

    class MyBinder extends Binder {
        public void showToastShort(String string) {
            Toast.makeText(MyBindService.this, string, Toast.LENGTH_SHORT).show();
        }

        public void showToastLong(String string) {
            Toast.makeText(MyBindService.this, string, Toast.LENGTH_LONG).show();
            HttpManager.getInstance()
                    .with(mContext)
                    .setObservable(RetrofitManager.getService().getFengHome())
                    .setCallBack(true, new ICallBack<MyTestBean>() {
                        @Override
                        public void onSuccess(MyTestBean normalBean) {
                            Log.e(TAG, "onSuccess: " + normalBean.getBannerList());
                            for (int i = 0; i < normalBean.getBannerList().size(); i++) {
                                Log.e(TAG, "onSuccess: " + normalBean.getBannerList().get(i).getAdTitle());
                            }
                        }

                        @Override
                        public void onError(String message) {
                            Log.e(TAG, "--------------------" + message);
                        }
                    });
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy: ");
    }
}
