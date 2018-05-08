package com.yanftch.applibrary.util;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.text.TextUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Author : yanftch
 * Date : 2018/5/7
 * Time : 13:55
 * Desc : Bitmap常用工具类
 */

public class BitmapUtils {
    /**
     * 将bitmap保存到本地
     *
     * @param bitmap
     * @param filePath
     */
    public static void saveBitmap2Local(Bitmap bitmap, String filePath, String fileName) {
        try {
            //复制Bitmap  因为png可以为透明，jpg不支持透明，把透明底明变成白色
            //主要是先创建一张白色图片，然后把原来的绘制至上去
            Bitmap outB = bitmap.copy(Bitmap.Config.ARGB_8888, true);
            Canvas canvas = new Canvas(outB);
            canvas.drawColor(Color.WHITE);
            canvas.drawBitmap(bitmap, 0, 0, null);
            if (!TextUtils.isEmpty(filePath)) {
                File foder = new File(filePath);
                if (!foder.exists()) {
                    foder.mkdirs();
                }
                File file = new File(filePath, fileName);
                if (file.exists())
                    file.delete();
                file.createNewFile();
                FileOutputStream out = new FileOutputStream(file);
                outB.compress(Bitmap.CompressFormat.JPEG, 100, out);
                out.flush();
                out.close();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
