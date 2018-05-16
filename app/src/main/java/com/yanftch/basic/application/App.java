package com.yanftch.basic.application;

import android.app.Application;
import android.content.Context;

import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

/**
 * Author : yanftch
 * Date : 2018/4/4
 * Time : 21:54
 * Desc :
 */

public class App extends Application {
    private static final String TAG = "dah_App";
    private RefWatcher refWatcher;
    public static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        refWatcher = setupLeakCanary();
        mContext = this;
    }

    private RefWatcher setupLeakCanary() {
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return RefWatcher.DISABLED;
        }
        return LeakCanary.install(this);
    }

    public static RefWatcher getRefWatcher(Context context) {
        App leakApplication = (App) context.getApplicationContext();
        return leakApplication.refWatcher;
    }
}
