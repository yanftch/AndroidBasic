package com.yanftch.applibrary.net;

/**
 * Author : yanftch
 * Date : 2018/2/9
 * Time : 15:15
 * Desc :
 */

public class LoginBody {
    private String phone;
    private String secretPasswd;

    public String getPhone() {
        return phone;
    }

    public LoginBody setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getSecretPasswd() {
        return secretPasswd;
    }

    public LoginBody setSecretPasswd(String secretPasswd) {
        this.secretPasswd = secretPasswd;
        return this;
    }
}
