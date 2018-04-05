package com.yanftch.basic.entity;

/**
 * Author : yanftch
 * Date : 2018/3/15
 * Time : 17:10
 * Desc :
 */

public class Item {
    private String name;
    private int index;
    private Class clazz;

    public Item(String name, int index) {
        this.name = name;
        this.index = index;
    }

    public Item() {
    }

    public Item(String name, int index, Class clazz) {
        this.name = name;
        this.index = index;
        this.clazz = clazz;
    }

    public String getName() {
        return name;
    }

    public Item setName(String name) {
        this.name = name;
        return this;
    }

    public int getIndex() {
        return index;
    }

    public Item setIndex(int index) {
        this.index = index;
        return this;
    }

    public Class getClazz() {
        return clazz;
    }

    public Item setClazz(Class clazz) {
        this.clazz = clazz;
        return this;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", index=" + index +
                ", clazz=" + clazz +
                '}';
    }
}
