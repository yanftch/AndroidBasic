package com.yanftch.basic.design_model.singleton;

/**
 * Author : yanftch
 * Date : 2018/5/7
 * Time : 16:49
 * Desc : 懒汉线程安全
 */
//懒汉线程安全
public class LazySafeSingleton {

    private static LazySafeSingleton instance;

    private LazySafeSingleton() {
    }

    public static LazySafeSingleton getInstance() {
        synchronized (LazySafeSingleton.class) {
            if (instance == null) {
                instance = new LazySafeSingleton();
            }
        }
        return instance;
    }
}
