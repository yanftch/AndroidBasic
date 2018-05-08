package com.yanftch.basic.design_model.singleton;

/**
 * Author : yanftch
 * Date : 2018/5/7
 * Time : 16:26
 * Desc : 饿汉式单例模式
 */

public class HungrySingleton {

    //私有静态变量
    private static HungrySingleton instance = new HungrySingleton();

    //私有构造
    private HungrySingleton() {
    }

    //静态调用
    public static HungrySingleton getInstance() {
        return instance;
    }
}
