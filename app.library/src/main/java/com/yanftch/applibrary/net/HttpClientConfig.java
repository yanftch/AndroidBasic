package com.yanftch.applibrary.net;

import android.text.TextUtils;
import android.util.Log;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Author : yanftch
 * Date : 2018/2/9
 * Time : 11:05
 * Desc :
 */

public class HttpClientConfig {
    private static final String TAG = "dah_HttpClientConfig";
    private volatile static HttpClientConfig instance;
    private boolean debugMode;

    public static HttpClientConfig getInstance() {
        if (null == instance) {
            synchronized (HttpClientConfig.class) {
                instance = new HttpClientConfig();
            }
        }
        return instance;
    }

    public OkHttpClient getHttpClient() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
//                Log.e(TAG, "log: " + message.toString());
                if (TextUtils.isEmpty(message)) return;
                String s = message.substring(0, 1);
                //如果收到响应是json才打印
                if ("{".equals(s) || "[".equals(s)) {
                    Log.e(TAG, "------the response json------>" + message + "<---");
                }
            }
        });
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(10, TimeUnit.SECONDS);//超时时间
        builder.readTimeout(10, TimeUnit.SECONDS);
        builder.writeTimeout(10, TimeUnit.SECONDS);
        builder.addInterceptor(new HeaderInterceptor());
        builder.addInterceptor(loggingInterceptor);
        //builder.addInterceptor(new ResponseInterceptor());//返回拦截器
        return builder.build();
    }


    /**
     * 添加请求消息头
     */
    class HeaderInterceptor implements Interceptor {
        @Override
        public Response intercept(Chain chain) throws IOException {
            //向请求头写入Content-Type参数，设置参数搁置为application/json
//            newHeaders.add("Content-Type", "application/json;charset=UTF-8");
//            Request.Builder newRequest = origin.newBuilder()
//                    .headers(newHeaders.build());

            Request request = chain.request();
            Request.Builder builder = request.newBuilder();
            /*.addHeader("Content-type", "application/json; charset=utf-8")*/
            builder.addHeader("User-Agent", "Android")
                    .addHeader("memberType", "4")
                    .addHeader("appVersion", "1.3.0-debug")
                    .addHeader("memberIdentity", "AB_HX")
                    .addHeader("os", "android")
                    .addHeader("security", "862772032328875")
                    .addHeader("teamIdentity", "2")
                    .addHeader("token", "nU0Q5Pd+wPlW/lMINAsfNKnNumE");
            request = builder.build();
            Log.e(TAG, "intercept: 请求URL : " + request.url().toString());
            return chain.proceed(request);
        }
    }

    /**
     * 响应拦截器
     */
    class ResponseInterceptor implements Interceptor {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            Response response = chain.proceed(request);
            if (response.code() == 200) {
                String string = chain.proceed(request).body().string();
                Log.e(TAG, "------the response json------>" + string + "<---");
            }
            return chain.proceed(request);
        }
    }
}
