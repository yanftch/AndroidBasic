package com.yanftch.basic.diy_view.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Author : yanftch
 * Date : 2018/3/29
 * Time : 21:26
 * Desc :
 */

public class TestMethodView extends View {

    private static final String TAG = "dah_TestMethodView";


    private Paint mPaint;

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);


        Log.e(TAG, "onMeasure: widthMode==" + widthMode + "   widthSize==" + widthSize + "  heightMode==" + heightMode + "  heightSize==" + heightSize);


//        Log.e(TAG, "onMeasure: ");
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        Log.e(TAG, "onLayout: changed=" + changed + "  left=" + left + "  top=" + top + "  right=" + right + "  bottom=" + bottom);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.setBackgroundColor(Color.parseColor("#00ffff"));
        Log.e(TAG, "onDraw: ");
        canvas.drawLine(100, 100, 300, 300, getPaint());
    }

    private Paint getPaint() {
        mPaint = new Paint();
        mPaint.setAntiAlias(false);
        mPaint.setColor(Color.parseColor("#ff0000"));
        mPaint.setStrokeWidth(10);
        return mPaint;
    }

    public TestMethodView(Context context) {
        super(context);
    }

    public TestMethodView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public TestMethodView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
