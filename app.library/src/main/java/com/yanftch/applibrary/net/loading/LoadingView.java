package com.yanftch.applibrary.net.loading;

import android.app.Dialog;
import android.app.Service;
import android.content.Context;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;

import com.yanftch.applibrary.R;

/**
 * Author : yanftch
 * Date : 2018/2/9
 * Time : 16:47
 * Desc :
 */

public class LoadingView {
    private static final String TAG = "dah_LoadingView";

    private Dialog mDialog;
    private Context mContext;

    public static LoadingView getInstance(Context context) {
        return new LoadingView().build(context);
    }

    private LoadingView build(Context context) {
        mContext = context;
        mDialog = new Dialog(context, R.style.dialog_background_dimEnabled);
        mDialog.setContentView(R.layout.layout_loading);
        mDialog.setCanceledOnTouchOutside(false);
        /**
         * Service中要处理Dialog，需要加上下边的Type代码！！！！
         */
        if (mContext instanceof Service) {
            Log.e(TAG, "build: mContext ==== Service");
            mDialog.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);
        } else {
            Log.e(TAG, "build: mContext !!!!==== Service");
        }
//        mDialog.setOnKeyListener(new DialogInterface.OnKeyListener() {
//            @Override
//            public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
//                return true;
//            }
//        });
        resetDialogSize();
        return this;
    }

    /**
     * 显示一定要调用的方法
     */
    public void show() {
        if (mDialog != null && !mDialog.isShowing()) {
            mDialog.show();
        }
    }

    public boolean isShowing() {
        if (mDialog == null || !mDialog.isShowing()) {
            return false;
        }
        return true;
    }

    public void disMiss() {
        if (mDialog != null && mDialog.isShowing()) {
            mDialog.dismiss();
        }
    }

    private void resetDialogSize() {
        Window dialogWindow = mDialog.getWindow();
        dialogWindow.setGravity(Gravity.CENTER);
        WindowManager m = dialogWindow.getWindowManager();
        Display d = m.getDefaultDisplay(); // 获取屏幕宽、高用
        WindowManager.LayoutParams p = dialogWindow.getAttributes(); // 获取对话框当前的参数值
        // p.height = (int) (d.getHeight() * 0.6); // 高度设置为屏幕的0.6
        p.width = (int) (d.getWidth() * 0.8); // 宽度设置为屏幕的0.8
        p.height = WindowManager.LayoutParams.WRAP_CONTENT;
        dialogWindow.setAttributes(p);
    }
}
