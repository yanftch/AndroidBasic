package com.yanftch.applibrary.util;

import android.os.Looper;

/**
 * Author : yanftch
 * Date : 2018/4/17
 * Time : 08:56
 * Desc :
 */

public class Utils {
    /**
     * 判断是否是主线程
     * 借助于Looper来实现判断
     */
    private static boolean isOnMainThread() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public static boolean isOnBackgroundThread() {
        return !isOnMainThread();
    }
}
