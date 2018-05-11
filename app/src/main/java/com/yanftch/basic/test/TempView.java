package com.yanftch.basic.test;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Region;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

/**
 * Author : yanftch
 * Date : 2018/5/10
 * Time : 09:46
 * Desc :
 */

public class TempView extends RelativeLayout {
    private static final String TAG = "dah_TempView";
    private Paint mPaint;
    private Path path;
    Region mRegion = new Region();

    private void init() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setStrokeWidth(5);
        mPaint.setColor(Color.BLUE);
        mPaint.setStyle(Paint.Style.FILL);
        path = new Path();
//        Shader shader = new BitmapShader()

    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
//        setMeasuredDimension(200, 200);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawText("123", 400, 400, mPaint);
        path.moveTo(200, 200);
        path.quadTo(300, 100, 00, 200);
        path.quadTo(300, 300, 400, 400);
        path.quadTo(300, 500, 200, 400);
        path.quadTo(00, 300, 200, 200);
        path.close();
        canvas.drawPath(path, mPaint);


    }

//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        int lastX = 0;
//        int lastY = 0;
//        switch (event.getAction()) {
//            case MotionEvent.ACTION_DOWN:
//                lastX = (int) event.getRawX();
//                lastY = (int) event.getRawY();
//                Log.e(TAG, "onTouchEvent: " + lastX + "    " + lastY);
//                break;
//            case MotionEvent.ACTION_MOVE:
//                //计算出需要移动的距离
//                int dx = (int) event.getX() - lastX;
//                int dy = (int) event.getY() - lastY;
//                //将移动距离加上，现在本身距离边框的位置
//                int left = getLeft() + dx;
//                int top = getTop() + dy;
//                Log.e(TAG, "onTouchEvent: left=" + left + "        top=" + top);
//                //获取到layoutParams然后改变属性，在设置回去
//                CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams)
//                        getLayoutParams();
//                layoutParams.height = 200;
//                layoutParams.width = 200;
//                layoutParams.leftMargin = left;
//                layoutParams.topMargin = top;
//                setLayoutParams(layoutParams);
//                //记录最后一次移动的位置
//                lastX = (int) event.getX();
//                lastY = (int) event.getY();
//                invalidate();
//                break;
//
//            case MotionEvent.ACTION_UP:
//                break;
//            case MotionEvent.ACTION_CANCEL:
//                break;
//        }
//
//        return true;
//    }

    private void setPosition() {
    }

    public TempView(Context context) {
        this(context, null);
        init();
    }

    public TempView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, -1);
        init();
    }


    public TempView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }
}
