package com.yanftch.applibrary.net;

/**
 * Author : yanftch
 * Date : 2018/2/9
 * Time : 11:53
 * Desc :
 */

public interface ICallBack<T> {
    void onSuccess(T t);

    void onError(String  message);
}
