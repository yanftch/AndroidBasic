package com.yanftch.basic.diy_view.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.yanftch.basic.R;

/**
 * Author : yanftch
 * Date : 2018/4/12
 * Time : 15:31
 * Desc : Canvas辅助
 */

public class CanvasAidView extends View {
    private static final String TAG = "dah_CanvasAidView";
    private Bitmap bitmap;
    private int width;
    private int height;


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        width = w;
        height = h;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(getResources().getColor(R.color.color_999999));

        canvas.save();
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.icon_launcher);
        canvas.clipRect(100, 100, 300, 400);
        canvas.drawBitmap(bitmap, 100, 100, getDefaultPaint());
        canvas.restore();
        canvas.save();
        canvas.rotate(270, width/2, height / 2);
        canvas.drawBitmap(bitmap, 400, 400, getDefaultPaint());
        canvas.restore();

        //

    }

    private Paint getDefaultPaint() {
        Paint paint = new Paint();
        paint.setAntiAlias(true);//抗锯齿开启
        paint.setStrokeWidth(3);
        paint.setColor(Color.parseColor("#FF0000"));
        return paint;
    }

    public CanvasAidView(Context context) {
        super(context);
    }

    public CanvasAidView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CanvasAidView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
