package com.yanftch.basic.event;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ListView;
import android.widget.ScrollView;

/**
 * Author : yanftch
 * Date : 2018/4/24
 * Time : 11:17
 * Desc :
 */

public class MyListView extends ListView {
    private ScrollView mParent;

    private float mDownY;

    public void setParent(ScrollView view) {
        mParent = view;
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {

        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mParent.requestDisallowInterceptTouchEvent(true);
                mDownY = ev.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                if (isListViewReachTop() && ev.getY() - mDownY > 0) {
                    setParentScrollAble(true);
                } else if (isListViewReachBottom() && ev.getY() - mDownY < 0) {
                    setParentScrollAble(true);
                }
                break;

        }
        return super.onTouchEvent(ev);

    }

    /**
     * @param flag
     */
    private void setParentScrollAble(boolean flag) {
        mParent.requestDisallowInterceptTouchEvent(!flag);
    }


    public boolean isListViewReachTop() {
        boolean result = false;
        if (getFirstVisiblePosition() == 0) {
            View topChildView = getChildAt(0);
            if (topChildView != null) {
                result = topChildView.getTop() == 0;
            }
        }
        return result;
    }

    public boolean isListViewReachBottom() {
        boolean result = false;
        if (getLastVisiblePosition() == (getCount() - 1)) {
            View bottomChildView = getChildAt(getLastVisiblePosition() - getFirstVisiblePosition());
            if (bottomChildView != null) {
                result = (getHeight() >= bottomChildView.getBottom());
            }
        }
        return result;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //解决显示不全的问题
//        heightMeasureSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    public MyListView(Context context) {
        super(context);
    }

    public MyListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public MyListView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
}
