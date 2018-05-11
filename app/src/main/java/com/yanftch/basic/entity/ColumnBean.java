package com.yanftch.basic.entity;

/**
 * Author : yanftch
 * Date : 2018/5/9
 * Time : 09:09
 * Desc :
 */

public class ColumnBean {
    private String date;
    private double value;
    private double netValue;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public double getNetValue() {
        return netValue;
    }

    public void setNetValue(double netValue) {
        this.netValue = netValue;
    }

    @Override
    public String toString() {
        return "ColumnBean{" + " date= " + date + ",  value=" + value + ", netValue = " + netValue + '}';
    }
}
