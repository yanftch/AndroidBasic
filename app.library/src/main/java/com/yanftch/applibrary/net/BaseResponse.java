package com.yanftch.applibrary.net;

/**
 * Author : yanftch
 * Date : 2018/2/9
 * Time : 11:46
 * Desc :
 */

public class BaseResponse<T> {
    private String msg;
    private int code;
    private T content;

    public String getMsg() {
        return msg;
    }

    public BaseResponse setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public int getCode() {
        return code;
    }

    public BaseResponse setCode(int code) {
        this.code = code;
        return this;
    }

    public T getContent() {
        return content;
    }

    public BaseResponse setContent(T content) {
        this.content = content;
        return this;
    }
}
