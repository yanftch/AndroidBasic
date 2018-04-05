package com.yanftch.basic.entity;

import java.io.Serializable;

/**
 * Author : yanftch
 * Date : 2018/3/14
 * Time : 16:17
 * Desc :
 */

public class User implements Serializable{
    private String name;
    private int age;


    public User() {
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public int getAge() {
        return age;
    }

    public User setAge(int age) {
        this.age = age;
        return this;
    }
}
