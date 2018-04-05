package com.yanftch.applibrary.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.RelativeLayout;

import com.yanftch.applibrary.R;
import com.yanftch.applibrary.base.titlebar.BaseTitleBarView;
import com.yanftch.applibrary.util.CommonUtils;

import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * User : yanftch
 * Date : 2017/6/2
 * Time : 08:35
 * Desc :
 */

public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener, BaseTitleBarView.TitleBarClick {
    private static String TAG = "";
    protected Context mContext;
    private ViewGroup mWindowRootLayout;
    protected BaseTitleBarView mBaseTitleBarView;
    private Unbinder mUnbinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);// 取消标题
        mContext = this;
        TAG = "tag_" + mContext.getClass().getSimpleName();
        Log.e(TAG, "onCreate.activityName = " + getClass().getSimpleName());
        int resId = setLayout();
        View view = View.inflate(this, resId, null);
        setContentView(resId);
        mUnbinder = ButterKnife.bind(this);
        initTitle();
        setTitle();
        initWidget();
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(R.layout.base_layout);
        mWindowRootLayout = (ViewGroup) findViewById(R.id.window_root_layout);

        mBaseTitleBarView = (BaseTitleBarView) findViewById(R.id.base_title_bar);

        View contentView = LayoutInflater.from(this).inflate(layoutResID, null);
        mWindowRootLayout.addView(contentView, new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

        if (null != mBaseTitleBarView) {
            mBaseTitleBarView.setTitleBarClick(this);
            mBaseTitleBarView.setLeftContainerVisible();
        }
    }


    protected <T extends View> T findView(int resId) {
        return (T) (findViewById(resId));
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mUnbinder != null) {
            mUnbinder.unbind();
            mUnbinder = null;
        }
    }

    private void initTitle() {
    }


    @Override
    public void onClick(View v) {
        widgetClick(v);
    }

    /**
     * 布局ID
     *
     * @return
     */
    public abstract int setLayout();

    /**
     * 设置标题显示的内容
     */
    public abstract void setTitle();

    /**
     * 初始化控件
     */
    public abstract void initWidget();

    /**
     * 添加事件
     */
    public abstract void widgetClick(View v);


    @Override
    public void onTitlePressed() {

    }

    @Override
    public void onTitleLeftPressed() {

    }

    @Override
    public void onTitleRightTextPressed() {

    }


    //region软键盘的处理

    /**
     * 清除editText的焦点
     *
     * @param v   焦点所在View
     * @param ids 输入框
     */
    public void clearViewFocus(View v, int... ids) {
        if (null != v && null != ids && ids.length > 0) {
            for (int id : ids) {
                if (v.getId() == id) {
                    v.clearFocus();
                    break;
                }
            }
        }


    }

    /**
     * 隐藏键盘
     *
     * @param v   焦点所在View
     * @param ids 输入框
     * @return true代表焦点在edit上
     */
    public boolean isFocusEditText(View v, int... ids) {
        if (v instanceof EditText) {
            EditText tmp_et = (EditText) v;
            for (int id : ids) {
                if (tmp_et.getId() == id) {
                    return true;
                }
            }
        }
        return false;
    }

    //是否触摸在指定view上面,对某个控件过滤
    public boolean isTouchView(View[] views, MotionEvent ev) {
        if (views == null || views.length == 0) return false;
        int[] location = new int[2];
        for (View view : views) {
            view.getLocationOnScreen(location);
            int x = location[0];
            int y = location[1];
            if (ev.getX() > x && ev.getX() < (x + view.getWidth())
                    && ev.getY() > y && ev.getY() < (y + view.getHeight())) {
                return true;
            }
        }
        return false;
    }
    //endregion

    //region 右滑返回上级


    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            if (isTouchView(filterViewByIds(), ev)) return super.dispatchTouchEvent(ev);
            if (hideSoftByEditViewIds() == null || hideSoftByEditViewIds().length == 0)
                return super.dispatchTouchEvent(ev);
            View v = getCurrentFocus();
            if (isFocusEditText(v, hideSoftByEditViewIds())) {
                //隐藏键盘
                CommonUtils.hideInputForce(this);
                clearViewFocus(v, hideSoftByEditViewIds());
            }
        }
        return super.dispatchTouchEvent(ev);

    }

    /**
     * 传入EditText的Id
     * 没有传入的EditText不做处理
     *
     * @return id 数组
     */
    public int[] hideSoftByEditViewIds() {
        return null;
    }

    /**
     * 传入要过滤的View
     * 过滤之后点击将不会有隐藏软键盘的操作
     *
     * @return id 数组
     */
    public View[] filterViewByIds() {
        return null;
    }


}
