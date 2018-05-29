package com.yanftch.applibrary.net;

/**
 * Author : yanftch
 * Date : 2018/2/9
 * Time : 11:46
 * Desc :
 */

public class BaseResponse<T> {
    //    private String msg;
//    private int code;
//    private T content;
    private T data;
    private int errorCode;
    private String errorMsg;

    public T getData() {
        return data;
    }

    public BaseResponse setData(T data) {
        this.data = data;
        return this;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public BaseResponse setErrorCode(int errorCode) {
        this.errorCode = errorCode;
        return this;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public BaseResponse setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
        return this;
    }

}
