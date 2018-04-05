package com.yanftch.applibrary.util;

import android.app.Activity;
import android.content.Context;
import android.text.method.NumberKeyListener;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import static android.content.Context.INPUT_METHOD_SERVICE;

/**
 * User : yanftch
 * Date : 2017/5/23
 * Time : 09:10
 * Desc : 公共工具类，大杂烩
 */

public class CommonUtils {
    public static char[] char_number = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    public static char[] char_l_word = {'a', 'b'};
    public static char[] char_u_word = {'A', 'B'};

    /**
     * EditText第一次调起数字键盘、后续可以随意切换任意键盘，但是输入的字符只能是：0-9、X、x(也就是只能输入身份证号)
     *
     * @param editText 要输入身份证号的EditText
     */
    public static void showIDKeyBoard(EditText editText) {
        editText.setKeyListener(new NumberKeyListener() {
            @Override
            protected char[] getAcceptedChars() {
                char[] chars = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'X', 'x'};
                return chars;
            }

            /**
             * 0：无键盘,键盘弹不出来
             * 1：英文键盘
             * 2：模拟键盘
             * 3：数字键盘
             *
             * @return
             */
            @Override
            public int getInputType() {
                return 3;
            }
        });
    }

    /**
     * 对EditText只能输入指定的字符
     *
     * @param editText 待操作的EditText
     * @param chars    允许输入的字符
     */
    public static void showKeyBoardAllowSpecialChar(EditText editText, final char[] chars) {
        editText.setKeyListener(new NumberKeyListener() {
            @Override
            protected char[] getAcceptedChars() {
                //若设置null，则默认只能输入数字
                char defaultChars[] = char_number;
                return null == chars ? defaultChars : chars;
            }

            /**
             * 0：无键盘,键盘弹不出来
             * 1：英文键盘
             * 2：模拟键盘
             * 3：数字键盘
             *
             * @return
             */
            @Override
            public int getInputType() {
                return 3;
            }
        });
    }



    /**
     * 打开软键盘
     * 魅族可能会有问题
     *
     * @param mEditText
     * @param mContext
     */
    public static void openKeybord(EditText mEditText, Context mContext) {
        InputMethodManager imm = (InputMethodManager) mContext
                .getSystemService(INPUT_METHOD_SERVICE);
        imm.showSoftInput(mEditText, InputMethodManager.RESULT_SHOWN);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED,
                InputMethodManager.HIDE_IMPLICIT_ONLY);
    }

    /**
     * 关闭软键盘
     *
     * @param mEditText
     * @param mContext
     */
    public static void closeKeybord(EditText mEditText, Context mContext) {
        InputMethodManager imm = (InputMethodManager) mContext.getSystemService(INPUT_METHOD_SERVICE);

        imm.hideSoftInputFromWindow(mEditText.getWindowToken(), 0);
    }


    /**
     * des:隐藏软键盘,这种方式参数为activity
     *
     * @param activity
     */
    public static void hideInputForce(Activity activity) {
        if (activity == null || activity.getCurrentFocus() == null)
            return;

        ((InputMethodManager) activity.getSystemService(INPUT_METHOD_SERVICE))
                .hideSoftInputFromWindow(activity.getCurrentFocus()
                        .getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
    }

    /**
     * 打开键盘
     **/
    public static void showInput(Context context, View view) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(INPUT_METHOD_SERVICE);
        if (imm != null) {
            view.requestFocus();
            imm.showSoftInput(view, 0);
        }
    }
}
