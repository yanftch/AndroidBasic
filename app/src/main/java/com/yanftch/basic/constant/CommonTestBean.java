package com.yanftch.basic.constant;

import java.io.Serializable;

/**
 * Author : yanftch
 * Date : 2018/4/15
 * Time : 22:16
 * Desc :
 */

public class CommonTestBean implements Serializable {
    private String title;
    private String imgUrl;
    private int count;
    private String desc;

    public CommonTestBean(String title) {
        this.title = title;
    }

    public CommonTestBean(String title, String imgUrl) {
        this.title = title;
        this.imgUrl = imgUrl;
    }

    public CommonTestBean(String title, String imgUrl, int count, String desc) {
        this.title = title;
        this.imgUrl = imgUrl;
        this.count = count;
        this.desc = desc;
    }

    public CommonTestBean() {
    }

    @Override
    public String toString() {
        return "CommonTestBean{" +
                "title='" + title + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", count=" + count +
                ", desc='" + desc + '\'' +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public CommonTestBean setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public CommonTestBean setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
        return this;
    }

    public int getCount() {
        return count;
    }

    public CommonTestBean setCount(int count) {
        this.count = count;
        return this;
    }

    public String getDesc() {
        return desc;
    }

    public CommonTestBean setDesc(String desc) {
        this.desc = desc;
        return this;
    }
}
