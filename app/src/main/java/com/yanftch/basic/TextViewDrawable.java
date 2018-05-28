package com.yanftch.basic;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.util.Log;

/**
 * Author : yanftch
 * Date : 2018/5/25
 * Time : 11:29
 * Desc :
 */

public class TextViewDrawable extends AppCompatTextView {
    private static final String TAG = "debug_TextViewDrawable";
    Drawable drawableLeft;
    Drawable drawableTop;
    Drawable drawableRight;
    Drawable drawableBottom;
    private int mWidth;
    private int mHeight;
    // TODO: 2018/5/28 提取成style
    private boolean isAlignCenter = false;


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        Log.e(TAG, "onSizeChanged: getLineCount()===" + getLineCount());
        Log.e(TAG, "onSizeChanged: getLineHeight()===" + getLineHeight());
        Log.e(TAG, "onSizeChanged: getHeight()===" + getHeight());
        Log.e(TAG, "onSizeChanged: getMeasuredHeight()===" + getMeasuredHeight());
        Log.e(TAG, "onSizeChanged: mHeight()===" + mHeight);
        Log.e(TAG, "onSizeChanged: getLineSpacingExtra()===" + getLineSpacingExtra());
        Log.e(TAG, "onSizeChanged: getLineSpacingMultiplier()===" + getLineSpacingMultiplier());

        mWidth = w;
        mHeight = h;

        Drawable[] compoundDrawables = getCompoundDrawables();
        drawableLeft = compoundDrawables[0];//左边
        resetDrawable(drawableLeft, "left", 40, 40);
        this.setCompoundDrawables(drawableLeft, drawableTop, drawableRight, drawableBottom);
    }

    /**
     * 对于drawable重置
     */
    private void resetDrawable(Drawable drawable, String tag, int drawableWidth, int drawableHeight) {
        //获取drawable的宽高尺寸
        int width = drawableWidth == 0 ? drawable.getIntrinsicWidth() : drawableWidth;
        int height = drawableHeight == 0 ? drawable.getIntrinsicHeight() : drawableHeight;
        width =height= getLineHeight();
        int gravity = getGravity();

        int left = 0, top = 0, right = 0, bottom = 0;
        switch (tag) {
            case "left":
                left = 0;//
                top = -((getLineCount() * getLineHeight()) / 2) + getLineHeight()/2;
                right = width;
                bottom = top + height;
                break;
            default:
                break;
        }
        Rect bounds = drawable.getBounds();
        Log.e(TAG, "resetDrawable: " + bounds.left + "-" + bounds.top + "-" + bounds.right + "-" + bounds.bottom);
        drawable.setBounds(left, top, right, bottom);
    }

    @Override
    public void setText(CharSequence text, BufferType type) {
        super.setText("大家好大家好大家好大家好大家好大家好大家好大家好大家好大家好大家好大家好大家好大家好大家好大家好大家好大家好大家好大家好大家好大家好大家好大家好大家好大家好大家好大家好大家好大家好大家好大家好大家好大家好大家好大家好大家好大家好大家好大家好大家好大家好大家好大家好大家好大家好大家好大家好大家好大家好大家好大家好大家好大家好大家好大家好大家好大家好大家好大家好", type);
    }

    public TextViewDrawable(Context context) {
        this(context, null);
    }

    public TextViewDrawable(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TextViewDrawable(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
//        drawableLeft = context.getResources().getDrawable(R.drawable.about);
    }

    /**
     * 以apk签名作为秘钥
     */
    public static String getApkSignature(Context context) {
        String s = "";
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), PackageManager.GET_SIGNATURES);
            Signature signature = packageInfo.signatures[0];
            s = signature.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return s;
    }
}
