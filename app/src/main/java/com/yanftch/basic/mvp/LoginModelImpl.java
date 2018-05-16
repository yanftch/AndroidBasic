package com.yanftch.basic.mvp;

import android.app.Activity;
import android.util.Log;

import com.yanftch.applibrary.net.HttpManager;
import com.yanftch.applibrary.net.ICallBack;
import com.yanftch.applibrary.net.MyTestBean;
import com.yanftch.applibrary.net.RetrofitManager;

/**
 * Author : yanftch
 * Date : 2018/5/16
 * Time : 11:00
 * Desc :
 */

public class LoginModelImpl implements LoginContract.LoginModel {
    private static final String TAG = "dah_LoginModelImpl";
    @Override
    public void login(Activity activity,String name, String password, final LoginContract.LoginCallBack loginCallBack) {
        Log.e(TAG, "login: "+name+"   password="+password);
        HttpManager.getInstance()
                .with(activity)
                .setObservable(RetrofitManager.getService().getFengHome())
                .setCallBack(true, new ICallBack<MyTestBean>() {
                    @Override
                    public void onSuccess(MyTestBean normalBean) {
                        if (loginCallBack != null) {
                            loginCallBack.onSuccess(normalBean);
                        }
                    }

                    @Override
                    public void onError(String message) {
                        if (loginCallBack != null) {
                            loginCallBack.onFail(message);
                        }
                    }
                });
    }
}
