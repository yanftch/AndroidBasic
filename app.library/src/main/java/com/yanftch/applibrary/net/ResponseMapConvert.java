package com.yanftch.applibrary.net;

import io.reactivex.functions.Function;

/**
 * Author : yanftch
 * Date : 2018/2/9
 * Time : 11:47
 * Desc :
 */

public class ResponseMapConvert<T> implements Function<BaseResponse<T>, T> {
    @Override
    public T apply(BaseResponse<T> tBaseResponse) throws Exception {
        if (tBaseResponse.getCode() == 0 || tBaseResponse.getCode() == 1) {
            return tBaseResponse.getContent();
        } else {
            throw new RuntimeException("请求失败(code=" + tBaseResponse.getCode() + ",message=" + tBaseResponse.getMsg() + ")");
        }
    }
}
