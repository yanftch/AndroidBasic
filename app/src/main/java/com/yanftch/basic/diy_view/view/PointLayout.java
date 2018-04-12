package com.yanftch.basic.diy_view.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/**
 * Author : yanftch
 * Date : 2018/4/12
 * Time : 16:30
 * Desc :
 */

public class PointLayout extends LinearLayout {
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        canvas.drawCircle(100, 100, 50, getDefaultPaint());
        canvas.drawCircle(300, 200, 50, getDefaultPaint());
        canvas.drawCircle(500, 500, 50, getDefaultPaint());
    }

    protected Paint getDefaultPaint() {
        Paint paint = new Paint();
        paint.setAntiAlias(true);//抗锯齿开启
        paint.setStrokeWidth(3);
        paint.setColor(Color.parseColor("#FF0000"));
        return paint;
    }

    public PointLayout(Context context) {
        super(context);
    }

    public PointLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public PointLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
