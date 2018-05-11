package com.yanftch.basic.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;

import com.yanftch.basic.R;

/**
 * Author : yanftch
 * Date : 2018/5/8
 * Time : 19:25
 * Desc :
 */

public abstract class BaseView extends View {
    //视图宽高
    private int width;
    private int height;
    //原始点坐标
    private int originalX = 100;
    private int originalY = 800;

    //
    protected Context mContext;
    private Paint mPaint;
    //属性
    private String mGraphTitle;
    private String mXAxisName;
    private String mYAxisName;
    private float mAxisTextSize;
    private int mAxisTextColor;

    public BaseView(Context context) {
        this(context, null);
    }

    public BaseView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BaseView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        //获取自定义样式
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.graphStyle);
        mGraphTitle = typedArray.getString(R.styleable.graphStyle_graphTitle);
        mXAxisName = typedArray.getString(R.styleable.graphStyle_xAxisName);
        mYAxisName = typedArray.getString(R.styleable.graphStyle_yAxisName);
        mAxisTextColor = typedArray.getColor(R.styleable.graphStyle_axisTextColor, context.getResources().getColor(android.R.color.black));
        mAxisTextSize = typedArray.getFloat(R.styleable.graphStyle_axisTextSize, 20);

        //记得回收资源
        if (null != typedArray) {
            typedArray.recycle();
        }
        initPaint();
    }

    private void initPaint() {
        if (mPaint == null) {
            mPaint = new Paint();
            mPaint.setAntiAlias(true);
            mPaint.setDither(true);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        width = getWidth() - originalX;
        height = (originalY > getHeight() ? getHeight() : originalY) - 200;
        //开始绘制
        drawXAxis(canvas, mPaint);
        drawYAxis(canvas, mPaint);
        drawTitle(canvas, mPaint);
        drawXAxisScale(canvas, mPaint);
        drawXAxisScaleValue(canvas, mPaint);
        drawYAxisScale(canvas, mPaint);
        drawYAxisScaleValue(canvas, mPaint);
        //绘制箭头
        drawXAxisArrow(canvas, mPaint);
        drawYAxisArrow(canvas, mPaint);
        //柱形
        drawColumn(canvas, mPaint);
    }

    //绘制标题，最底部绘制
    private void drawTitle(Canvas canvas, Paint paint) {
        mGraphTitle = "标题党";
        if (!TextUtils.isEmpty(mGraphTitle)) {
            paint.setColor(mAxisTextColor);
            paint.setTextSize(mAxisTextSize);
            //Title居中显示
            canvas.drawText(mGraphTitle, (getWidth() / 2) - (paint.measureText(mGraphTitle) / 2), originalY + 40, paint);
        }
    }

    //绘制Y轴箭头
    private void drawYAxisArrow(Canvas canvas, Paint paint) {

    }

    //绘制X轴箭头
    private void drawXAxisArrow(Canvas canvas, Paint paint) {
        Path pathX = new Path();
        pathX.moveTo(originalX + width + 30, originalY);
        pathX.lineTo(originalX + width, originalY + 10);//下
        pathX.lineTo(originalX + width, originalY - 10);//上
        pathX.close();
        canvas.drawPath(pathX, paint);
        canvas.drawText(mXAxisName, originalX + width, originalY + 50, paint);
    }

    protected abstract void drawColumn(Canvas canvas, Paint paint);

    //绘制Y轴刻度值
    protected abstract void drawYAxisScaleValue(Canvas canvas, Paint paint);

    //绘制Y轴刻度
    protected abstract void drawYAxisScale(Canvas canvas, Paint paint);

    //绘制X轴刻度值
    protected abstract void drawXAxisScaleValue(Canvas canvas, Paint paint);

    //绘制X轴刻度
    protected abstract void drawXAxisScale(Canvas canvas, Paint paint);

    //绘制Y轴
    protected abstract void drawYAxis(Canvas canvas, Paint paint);

    //绘制X轴
    protected abstract void drawXAxis(Canvas canvas, Paint paint);
}
