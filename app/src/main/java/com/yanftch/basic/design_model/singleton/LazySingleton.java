package com.yanftch.basic.design_model.singleton;

/**
 * Author : yanftch
 * Date : 2018/5/7
 * Time : 16:37
 * Desc : 懒汉式单例模式
 */
//懒汉式单例模式
public class LazySingleton {

    private static LazySingleton instance;

    private LazySingleton() {
    }

    public static LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
}
