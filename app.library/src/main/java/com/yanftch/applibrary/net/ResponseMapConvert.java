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
        if (tBaseResponse.getErrorCode() == 0 || tBaseResponse.getErrorCode() == 1) {
            return tBaseResponse.getData();
        } else {
            throw new RuntimeException("请求失败(code=" + tBaseResponse.getErrorCode() + ",message=" + tBaseResponse.getErrorMsg() + ")");
        }
    }
}
