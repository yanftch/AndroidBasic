package com.yanftch.basic.mvp;

import android.app.Activity;

import com.yanftch.applibrary.net.MyTestBean;

/**
 * Author : yanftch
 * Date : 2018/5/16
 * Time : 10:56
 * Desc : 契约类
 */

public class LoginContract {
    //view
    public interface  LoginView{
            void checkPass();
            void checkFail(String message);
            void onLoginSuccess(MyTestBean myTestBean);
            void onLoginFailed(String failMsg);
    }
    //model
    public interface LoginModel{
        void login(Activity activity,String name, String password, LoginCallBack loginCallBack);
    }
    public interface LoginCallBack{
        void onSuccess(MyTestBean myTestBean);

        void onFail(String errorInfo);
    }

}
