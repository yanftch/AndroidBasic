package com.yanftch.basic.glide;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;

import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;

/**
 * Author : yanftch
 * Date : 2018/4/23
 * Time : 09:25
 * Desc :
 */

public class CircleCrop extends BitmapTransformation {
    public CircleCrop(Context context) {
        super(context);
    }

    public CircleCrop(BitmapPool bitmapPool) {
        super(bitmapPool);
    }

    @Override
    protected Bitmap transform(BitmapPool pool, Bitmap toTransform, int outWidth, int outHeight) {
        //计算出宽高中的最小值，让最小值作为圆形的直径
        int diameter = Math.min(toTransform.getWidth(), toTransform.getHeight());
        //从Bitmap缓存池中尝试获取一个Bitmap对象来进行重用,如果没有，就手动自己创建一个
        Bitmap toReuse = pool.get(outWidth, outHeight, Bitmap.Config.ARGB_8888);
        Bitmap result;
        if (null != toReuse) {
            result = toReuse;
        } else {
            result = Bitmap.createBitmap(diameter, diameter, Bitmap.Config.ARGB_8888);
        }
        //
        int dx = (toTransform.getWidth() - diameter) / 2;
        int dy = (toTransform.getHeight() - diameter) / 2;
        Canvas canvas = new Canvas(result);
        Paint paint = new Paint();
        BitmapShader shader = new BitmapShader(toTransform, BitmapShader.TileMode.CLAMP,
                BitmapShader.TileMode.CLAMP);
        if (dx != 0 || dy != 0) {
            Matrix matrix = new Matrix();
            matrix.setTranslate(-dx, -dy);
            shader.setLocalMatrix(matrix);
        }
        paint.setShader(shader);
        paint.setAntiAlias(true);
        float radius = diameter / 2f;
        canvas.drawCircle(radius, radius, radius, paint);

        if (toReuse != null && !pool.put(toReuse)) {
            toReuse.recycle();
        }
        return result;
    }

    @Override
    public String getId() {
        return "com.yanftch.basic.glide.CircleCrop";
    }
}
