package com.yanftch.basic.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

/**
 * Author : yanftch
 * Date : 2018/5/8
 * Time : 18:46
 * Desc : 自定义柱状图
 */

public class ColumeView extends BaseView {
    private static final String TAG = "debug_ColumeView";
    //色值
    private static final String DEFAULT_PAINT_COLOR = "#999999";
    private static final String COLOR_FEFEFE = "#fefefe";
    //
    private int width;
    private int height;


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int wMode = MeasureSpec.getMode(widthMeasureSpec);
        int hMode = MeasureSpec.getMode(heightMeasureSpec);
        int wSize = MeasureSpec.getSize(widthMeasureSpec);
        int hSize = MeasureSpec.getSize(heightMeasureSpec);
        hSize = 1000;
        setMeasuredDimension(wSize, hSize);//重新赋值尺寸大小
    }


    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    /**
     * 默认画笔定义
     */
    private Paint getDefaultPaint() {
        Paint tPaint = new Paint();
        tPaint.setStrokeWidth(5);
        tPaint.setStyle(Paint.Style.FILL);
        tPaint.setAntiAlias(true);//抗锯齿
        tPaint.setColor(Color.parseColor(DEFAULT_PAINT_COLOR));
        return tPaint;
    }

    private void init() {

    }

    public ColumeView(Context context) {
        this(context, null);
    }


    public ColumeView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ColumeView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @Override
    protected void drawColumn(Canvas canvas, Paint paint) {

    }

    @Override
    protected void drawYAxisScaleValue(Canvas canvas, Paint paint) {

    }

    @Override
    protected void drawYAxisScale(Canvas canvas, Paint paint) {

    }

    @Override
    protected void drawXAxisScaleValue(Canvas canvas, Paint paint) {

    }

    @Override
    protected void drawXAxisScale(Canvas canvas, Paint paint) {

    }

    @Override
    protected void drawYAxis(Canvas canvas, Paint paint) {

    }

    @Override
    protected void drawXAxis(Canvas canvas, Paint paint) {

    }
}
