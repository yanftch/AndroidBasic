package com.yanftch.basic.design_model.singleton;

/**
 * Author : yanftch
 * Date : 2018/5/7
 * Time : 16:26
 * Desc : 静态内部类单例模式
 */
//静态内部类单例模式
public class StaticInnerSingleton {
    //私有构造函数
    private StaticInnerSingleton(){}
    //静态内部类
    private static class SingletonHelper{
        private static final StaticInnerSingleton instance = new StaticInnerSingleton();
    }
    //获取实例对象
    public StaticInnerSingleton getInstance(){
        return SingletonHelper.instance;
    }
//    public StaticInnerSingleton getInstance() {
//        return SingletonHolder.instance;
//    }
//
//    //私有构造
//    private StaticInnerSingleton() {
//    }
//
//    private static class SingletonHolder {
//        private static final StaticInnerSingleton instance = new StaticInnerSingleton();
//    }
}

