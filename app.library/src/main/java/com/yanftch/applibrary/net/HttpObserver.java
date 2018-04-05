package com.yanftch.applibrary.net;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.JsonParseException;
import com.yanftch.applibrary.net.loading.LoadingView;

import java.lang.ref.WeakReference;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.util.concurrent.TimeoutException;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import retrofit2.HttpException;
import retrofit2.Response;

/**
 * Author : yanftch
 * Date : 2018/2/9
 * Time : 13:05
 * Desc :
 */

public class HttpObserver<T> implements Observer<T> {
    private static final String TAG = "dah_HttpObserver";
    private WeakReference<Context> context;
    private LoadingView mLoadingView;
    private ICallBack mICallBack;
    private boolean showLoading;//是否显示默认数据加载狂


    public HttpObserver(WeakReference<Context> context, ICallBack ICallBack, boolean showLoading) {
        this.context = context;
        this.showLoading = showLoading;
        mICallBack = ICallBack;
        initProgressDialog();
    }

    @Override
    public void onSubscribe(Disposable d) {
        if (showLoading) {
            showProgressDialog();
        }
    }

    @Override
    public void onComplete() {
        if (showLoading) {
            dismissProgressDialog();
        }
    }

    @Override
    public void onNext(T t) {
        if (null != mICallBack) {
            mICallBack.onSuccess(t);
        }
    }

    @Override
    public void onError(Throwable e) {
        Log.e(TAG, "onError: ==63行==" + e);
        dismissProgressDialog();
        Context context = this.context.get();
        if (context == null) return;
        boolean gConnected = NetWorkUtil.is3gConnected(context);
        boolean wifiConnected = NetWorkUtil.isWifiConnected(context);
        boolean netConnected = NetWorkUtil.isNetConnected(context);
        if (!gConnected && !wifiConnected && !netConnected) {
            if (null != mICallBack) {
                mICallBack.onError("请检查网络连接");
            }
            return;
        }
        //////////////////////////////////////////////////////////////////////////
        String message = "网络异常";
        if (e instanceof ConnectException) {
            message = "网络连接异常";
        } else if (e instanceof TimeoutException || e instanceof SocketTimeoutException) {
            message = "网络连接超时";
        } else if (e instanceof JsonParseException) {
            message = "解析异常";
        } else if (e instanceof HttpException) {
            Response<?> response = ((HttpException) e).response();
            int code = ((HttpException) e).response().code();
            Log.e(TAG, "onError: code===" + code);
            message = code + "";
        } else {
            if (!TextUtils.isEmpty(e.getMessage())) {
                message = e.getMessage();
            }
        }

        if (null != mICallBack) {
            mICallBack.onError(message);
        }
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    private void initProgressDialog() {
        Context context = this.context.get();
        if (null == mLoadingView || !mLoadingView.isShowing()) {
            mLoadingView = LoadingView.getInstance(context);
        }
    }

    private void showProgressDialog() {
        Context context = this.context.get();
        if (mLoadingView != null && !mLoadingView.isShowing()) {
            mLoadingView.show();
        }
    }

    private void dismissProgressDialog() {
        if (mLoadingView != null && mLoadingView.isShowing()) {
            mLoadingView.disMiss();
        }
    }

}
