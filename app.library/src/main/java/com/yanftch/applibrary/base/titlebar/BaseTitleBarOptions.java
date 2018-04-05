package com.yanftch.applibrary.base.titlebar;

import android.content.Context;
import android.view.View;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Author : yanftch
 * Date : 2018/1/11
 * Time : 12:45
 * Desc : 设置TitleBar样式的基类
 */

public class BaseTitleBarOptions {
    /**
     * Title文本
     */
    public String titleString;
    /**
     * 左侧文本
     */
    public String titleLeftString;

    /**
     * 右侧文本
     */
    public String titleRightString;

    /**
     * Titlebar的返回键资源id
     */
    public int navigateId;
    /**
     * Titlebar的返回按钮
     */
    public boolean isNeedNavigate;
    /**
     * Titlebar右侧可定制按钮。默认为空。
     */
    public ArrayList<OptionsButton> buttons;

    /**
     * Titlebar 右侧按钮，可定制icon和点击事件
     */
    public static abstract class OptionsButton implements Serializable {

        // 图标drawable id
        public int iconId;

        // 响应事件
        public abstract void onClick(Context context, View view);
    }
}
