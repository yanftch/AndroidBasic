package com.yanftch.basic.design_model.singleton;

/**
 * Author : yanftch
 * Date : 2018/5/7
 * Time : 16:49
 * Desc : 懒汉线程安全
 */
//DCL双重锁机制
public class DclSingleton {

//    private static DclSingleton instance;
    private static volatile DclSingleton instance;

    private DclSingleton() {
    }

    public static DclSingleton getInstance() {
        //去掉不必要的同步
        if (instance == null) {
            synchronized (DclSingleton.class) {
                if (instance == null) {
                    instance = new DclSingleton();//非原子操作
                }
            }
        }
        return instance;
    }
}
