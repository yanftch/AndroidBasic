package com.yanftch.basic.mvp.base;

import java.lang.ref.Reference;
import java.lang.ref.SoftReference;

/**
 * Author : yanftch
 * Date : 2018/5/16
 * Time : 10:14
 * Desc :
 */

public abstract class BasePresenter<T> {
    //View的软引用
    protected Reference<T> mViewRef;

    //绑定
    public void attachView(T view) {
        mViewRef = new SoftReference<T>(view);
    }

    //获取view
    public T getView() {
        return mViewRef.get();
    }

    //判断当前是否已经绑定了
    public boolean isViewAttached() {
        return mViewRef != null && mViewRef.get() != null;
    }

    //解绑
    public void detachView() {
        if (mViewRef != null) {
            mViewRef.clear();
        }
    }

}
