package com.yanftch.applibrary.net;

import android.content.Context;

import java.lang.ref.WeakReference;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Author : yanftch
 * Date : 2018/2/9
 * Time : 13:10
 * Desc :
 * 参考链接：https://www.jianshu.com/p/fe89c0991aed
 */

public class HttpManager {
    private volatile static HttpManager instance;
    private WeakReference<Context> context;
    private Observable observable;
    private HttpObserver observer;

    private HttpManager() {

    }

    public static HttpManager getInstance() {
        if (instance == null) {
            synchronized (HttpManager.class) {
                if (instance == null) {
                    instance = new HttpManager();
                }
            }
        }
        return instance;
    }

    public HttpManager with(Context context) {
        this.context = new WeakReference<>(context);
        return instance;
    }

    public HttpManager setObservable(Observable observable) {
        this.observable = observable.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new ResponseMapConvert());
        return instance;
    }

    public void setCallBack(boolean showLoading,ICallBack callBack) {
        observer = new HttpObserver(context, callBack,showLoading);
        observable.subscribe(observer);
    }
}
