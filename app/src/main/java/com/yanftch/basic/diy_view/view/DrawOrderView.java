package com.yanftch.basic.diy_view.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

/**
 * Author : yanftch
 * Date : 2018/4/12
 * Time : 15:57
 * Desc : 绘制顺序
 */

public class DrawOrderView extends BaseView {
    private static final String TAG = "dah_DrawOrderView";

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint defaultPaint = getDefaultPaint();
        RectF rectF = new RectF(100, 100, 500, 500);
//        canvas.drawRect(rectF, defaultPaint);
        defaultPaint.setColor(Color.parseColor("#00ff00"));
        canvas.drawCircle(300, 300,200, defaultPaint);

    }

    public DrawOrderView(Context context) {
        super(context);
    }

    public DrawOrderView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawOrderView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
