package com.yanftch.applibrary.net;

import com.yanftch.applibrary.entity.HomeListBean;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;

/**
 * Author : yanftch
 * Date : 2018/2/9
 * Time : 11:03
 * Desc :
 */

public interface HttpService {


    /**
     * 玩Android  API
     * add by yanftch at 2018/5/29 16:34
     */
    //首页列表
    @GET("article/list/{page}/json")
    Observable<BaseResponse<HomeListBean>> getWanAndroidHomeList(@Path("page") int page);


    /**
     * -------------end------------
     */


    @POST("member/app/getHome")
    Observable<BaseResponse<MyTestBean>> getFengHome();

    //    Observable<MyTestBean.ContentBean> getFengHome();
//    phone=18310257489&secretPasswd=6b15bacf132e7f28054b78874799f9b1
    @POST("member/login/login")
    Observable<BaseResponse> getLoginApi(@Body LoginBody body);


    @HTTP(method = "GET", path = "member/login", hasBody = true)
    Observable<BaseResponse> test0(@Path("id") int id);

    @FormUrlEncoded
    Observable<BaseResponse> test1(@Field("key1") int key, @Field("key2") int key2);


    @Multipart
    Observable<BaseResponse> test2(@Part("name") RequestBody name, @Part("age") MultipartBody.Part file);

//    Observable<BaseResponse> getLoginApi(@Query("phone")String phone, @Query("secretPasswd") String secretPasswd);

}
