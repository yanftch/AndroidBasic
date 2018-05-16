package com.yanftch.basic.mvp;

import android.app.Activity;
import android.text.TextUtils;

import com.yanftch.applibrary.net.MyTestBean;
import com.yanftch.basic.mvp.base.BasePresenter;

/**
 * Author : yanftch
 * Date : 2018/5/16
 * Time : 11:04
 * Desc :
 */

public class LoginPresenter extends BasePresenter<LoginContract.LoginView> {
    private LoginModelImpl mLoginModel;

    public LoginPresenter() {
        mLoginModel = new LoginModelImpl();
    }

    public void checkInfo(Activity activity,String name, String pwd) {
        if (TextUtils.isEmpty(name)) {
            getView().checkFail("请输入Name");
        } else if (TextUtils.isEmpty(pwd)) {
            getView().checkFail("请输入密码");
        } else {
            getView().checkPass();
            pLogin(activity,name,pwd);
        }
    }

    public void pLogin(Activity activity, String name, String password) {
        mLoginModel.login(activity, name, password, new LoginContract.LoginCallBack() {
            @Override
            public void onSuccess(MyTestBean myTestBean) {
                getView().onLoginSuccess(myTestBean);
            }

            @Override
            public void onFail(String errorInfo) {
                getView().onLoginFailed(errorInfo);
            }
        });
    }
}
