package com.yanftch.basic.test;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Region;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

/**
 * Author : yanftch
 * Date : 2018/5/11
 * Time : 10:29
 * Desc :
 */

public class TestView extends View {
    private static final String TAG = "dah_TestView";
    private Paint mPaint;
    private Path path;
    Region re = new Region();

    private void init() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setStrokeWidth(5);
        mPaint.setColor(Color.BLUE);
        mPaint.setStyle(Paint.Style.FILL);
        path = new Path();
//        Shader shader = new BitmapShader()

    }


    private void drawTemp(Canvas canvas) {
        //        //起始顶点，绘制的方向为左下右上。
//        path.moveTo(100, 100);
//        path.lineTo(100, 150);
//        //绘制一个贝塞尔曲线，第一个顶点是来控制曲线的弧度和方向，第二个顶点是弧线的结束顶点。
//        path.quadTo(230, 150, 300, 200);
//        path.quadTo(200, 150, 300, 200);
//        path.quadTo(200, 120, 150, 100);
        path.moveTo(50, 50);
        path.lineTo(200, 50);
        path.lineTo(100, 100);
        path.lineTo(200, 150);
        path.lineTo(100, 200);
        path.close();
        canvas.drawPath(path, mPaint);
        //构造一个区域对象，左闭右开的。
        RectF r = new RectF();
        //计算控制点的边界
        path.computeBounds(r, true);
        //设置区域路径和剪辑描述的区域
        re.setPath(path, new Region((int) r.left, (int) r.top, (int) r.right, (int) r.bottom));
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            Toast.makeText(getContext().getApplicationContext(), "" + re.contains((int) event.getX(), (int) event.getY()), Toast.LENGTH_SHORT).show();
        }
        return true;
    }

    public TestView(Context context) {
        super(context);
        init();
    }

    public TestView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TestView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    // TODO: 2018/5/15 生命周期
    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        Log.e(TAG, "onFinishInflate: 自定义view");
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        Log.e(TAG, "onAttachedToWindow: 自定义view");
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        Log.e(TAG, "onMeasure: 自定义view");
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        Log.e(TAG, "onLayout: 自定义view");
    }

    @Override
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        super.onWindowFocusChanged(hasWindowFocus);
        Log.e(TAG, "onWindowFocusChanged: 自定义view");
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.e(TAG, "onDraw: 自定义view");
        drawTemp(canvas);
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Log.e(TAG, "onDetachedFromWindow: 自定义view");
    }


}
