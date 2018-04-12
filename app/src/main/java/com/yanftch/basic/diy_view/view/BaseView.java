package com.yanftch.basic.diy_view.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Author : yanftch
 * Date : 2018/4/12
 * Time : 15:58
 * Desc :
 */

public class BaseView extends View {
    private static final String TAG = "dah_BaseView";
    Bitmap bitmap;
    int width;
    int height;

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        width = w;
        height = h;
    }

    protected Paint getDefaultPaint() {
        Paint paint = new Paint();
        paint.setAntiAlias(true);//抗锯齿开启
        paint.setStrokeWidth(3);
        paint.setColor(Color.parseColor("#FF0000"));
        return paint;
    }
    public BaseView(Context context) {
        super(context);
    }

    public BaseView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public BaseView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
