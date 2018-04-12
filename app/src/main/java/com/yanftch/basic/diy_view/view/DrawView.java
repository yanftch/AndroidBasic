package com.yanftch.basic.diy_view.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.PathEffect;
import android.graphics.RectF;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

/**
 * Author : yanftch
 * Date : 2018/4/8
 * Time : 21:52
 * Desc : 绘制
 */

public class DrawView extends View {
    private static final String TAG = "dah_DrawView";
    private final static String DEFAULT_COLOR = "#FF0000";

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //不要嫌弃我在onDraw里边实例化这么多画笔。。。只是为了好看而已o(╯□╰)o
        //绘制背景色
        canvas.drawColor(Color.parseColor("#999999"));
        //绘制圆点
        Paint paintRound = getDefaultPaint();
        paintRound.setStrokeCap(Paint.Cap.ROUND);
        canvas.drawPoint(10, 10, paintRound);
        //绘制矩形点
        Paint paintSquare = getDefaultPaint();
        paintSquare.setStrokeCap(Paint.Cap.BUTT);//或者是：SQUARE
        canvas.drawPoint(20, 20, paintSquare);
        //画线
        canvas.drawLine(50, 50, 50, 200, getDefaultPaint());
        //画矩形
        Paint rectPaint = getDefaultPaint();
        rectPaint.setColor(Color.parseColor("#2480df"));
        rectPaint.setStyle(Paint.Style.STROKE);//描边
        RectF rectF = new RectF(100, 50, 200, 100);
        canvas.drawRect(rectF, rectPaint);
        //画圆圈
        canvas.drawCircle(300, 300, 50, getDefaultPaint());
        //画椭圆
        canvas.drawOval(100, 500, 200, 650, getDefaultPaint());

        //画扇形

        //虚线绘制

        Paint dashPain = getDefaultPaint();
        dashPain.setStyle(Paint.Style.STROKE);
        PathEffect pathEffect = new DashPathEffect(new float[]{10, 5}, 10);
        dashPain.setPathEffect(pathEffect);
        canvas.drawCircle(400, 400, 100, dashPain);


    }

    private Paint getDefaultPaint() {
        Paint paint = new Paint();
        paint.setAntiAlias(true);//抗锯齿开启
        paint.setStrokeWidth(3);
        paint.setColor(Color.parseColor(DEFAULT_COLOR));
        return paint;
    }

    public DrawView(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {

    }

    public DrawView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public DrawView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }
}
