package com.yanftch.basic.canvas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.yanftch.basic.R;

import java.util.Random;

/**
 * Author : yanftch
 * Date : 2018/4/7
 * Time : 22:19
 * Desc :
 */

public class CanvasView extends View {
    private static final String TAG = "dah_CanvasView";
    private int width;
    private int height;
    private Paint mPaint;
    private final String DEFAULTCOLORSTR = "#FF0000";
    private PointF mPointF;


    private Paint getDefaultPaint() {
        Paint p = new Paint();
        p.setStrokeWidth(5);
        p.setAntiAlias(true);
        p.setColor(Color.parseColor(DEFAULTCOLORSTR));
        return p;
    }

    private Paint getGreenPaint() {
        Paint defaultPaint = getDefaultPaint();
        defaultPaint.setColor(Color.parseColor("#00ff00"));
        return defaultPaint;
    }


    @Override
    protected void onDraw(final Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawLine(0, 0, height, width, getDefaultPaint());
        //裁剪
        RectF rect = new RectF(150, 150, 450, 450);
//        canvas.drawRect(rect, getGreenPaint());
        Paint greenPaint = getGreenPaint();
        greenPaint.setStrokeWidth(30);
//        greenPaint.setStrokeCap(Paint.Cap.SQUARE);
//        greenPaint.setStrokeCap(Paint.Cap.BUTT);
        greenPaint.setStrokeCap(Paint.Cap.ROUND);
//        canvas.drawPoint(200, 300, greenPaint);
        greenPaint.setStyle(Paint.Style.STROKE);
//        canvas.drawOval(rect,greenPaint);


    }

    private PointF getPointF() {
        PointF p = new PointF();
        Random random = new Random();
        int nextInt = random.nextInt(599) + 1;
        p.set(nextInt, nextInt);
        return p;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(600, 600);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        width = w;
        height = h;
        Log.e(TAG, "onSizeChanged: width==" + width + "     height==" + height);
    }

    public CanvasView(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        mPointF = new PointF();
        this.setBackgroundColor(context.getResources().getColor(R.color.color_999999));
    }

    public CanvasView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public CanvasView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

}
