package com.yanftch.applibrary.net;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Author : yanftch
 * Date : 2018/2/9
 * Time : 11:03
 * Desc :
 */

public class RetrofitManager {
    private final HttpService mHttpService;
    private String base_url ="http://dat.dahuobaoxian.com/";
    private volatile static RetrofitManager instance;

    public static RetrofitManager getInstance() {
        if (instance == null) {
            synchronized (RetrofitManager.class) {
                if (instance == null) {
                    instance = new RetrofitManager();
                }
            }
        }
        return instance;
    }

    private RetrofitManager() {
        Retrofit.Builder builder = new Retrofit.Builder();
        Retrofit retrofit = builder.client(HttpClientConfig.getInstance().getHttpClient())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(base_url).build();
        mHttpService = retrofit.create(HttpService.class);
    }

    public static HttpService getService() {
        return getInstance().mHttpService;
    }
}
