package com.yanftch.basic.sliding_conflict;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

/**
 * Author : yanftch
 * Date : 2018/3/30
 * Time : 17:38
 * Desc :
 */

public class ChildViewPager extends ViewPager {
    private static final String TAG = "dah_ChildViewPager";

    public ChildViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ChildViewPager(Context context) {
        super(context);
    }

    // 滑动距离及坐标 归还父控件焦点
    private float xDistance, yDistance, xLast, yLast, mLeft;
    //记录x,y点值
    private int downX;
    private int downY;

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                //阻止父View的onInterceptTouchEvent()事件：让父控件不拦截~
                //附 源码解释
                /**
                 * Called when a child does not want this parent and its ancestors to
                 * intercept touch events with
                 * {@link ViewGroup#onInterceptTouchEvent(MotionEvent)}.
                 *
                 * <p>This parent should pass this call onto its parents. This parent must obey
                 * this request for the duration of the touch (that is, only clear the flag
                 * after this parent has received an up or a cancel.</p>
                 *
                 * @param disallowIntercept True if the child does not want the parent to
                 *            intercept touch events.
                 */
                getParent().requestDisallowInterceptTouchEvent(true);
                //记录x,y
                downX = (int) ev.getX();
                downY = (int) ev.getY();
                Log.e(TAG, "dispatchTouchEvent: downX==" + downX + "        downY==" + downY);
                break;

            case MotionEvent.ACTION_MOVE:
                int moveX = (int) ev.getX();
                int moveY = (int) ev.getY();
                Log.e(TAG, "dispatchTouchEvent: moveX==" + moveX + "        moveY==" + moveY);

                int diffX = downX - moveX;
                int diffY = downY - moveY;
                //横向滑动的时候
                if (Math.abs(diffX) > Math.abs(diffY)) {
                    if (getCurrentItem() == 0 && diffX < 0) {
                        // 当前页面等于第一个页面, 并且是从左向右滑动, 可以拦截
                        getParent().requestDisallowInterceptTouchEvent(false);
                    } else if (getCurrentItem() == (getAdapter().getCount() - 1)
                            && diffX > 0) {
                        // 当前页面等于最后一个, 并且是从右向左滑动, 可以拦截
                        getParent().requestDisallowInterceptTouchEvent(false);
                    } else {
                        // 自己处理
                        getParent().requestDisallowInterceptTouchEvent(true);
                    }
                }

                //竖向滑动的时候
                else {
                    // 竖着滑动, 可以拦截
                    getParent().requestDisallowInterceptTouchEvent(false);
                }
                break;
            default:
                break;
        }
//        getParent().requestDisallowInterceptTouchEvent(true);
//        switch (ev.getAction()) {
//            case MotionEvent.ACTION_DOWN:
//                xDistance = yDistance = 0f;
//                xLast = ev.getX();
//                yLast = ev.getY();
//                mLeft = ev.getX();
//                break;
//            case MotionEvent.ACTION_MOVE:
//                final float curX = ev.getX();
//                final float curY = ev.getY();
//
//                xDistance += Math.abs(curX - xLast);
//                yDistance += Math.abs(curY - yLast);
//                xLast = curX;
//                yLast = curY;
//                if (mLeft < 100 || xDistance < yDistance) {
//                    //x轴的距离小于y轴的距离  那么就直接交由父处理
//                    Log.e(TAG, "dispatchTouchEvent: xDistance < yDistance::" + (xDistance < yDistance));
//                    getParent().requestDisallowInterceptTouchEvent(false);
//                } else {
//                    getParent().requestDisallowInterceptTouchEvent(true);
//                }
//                break;
//            case MotionEvent.ACTION_UP:
//            case MotionEvent.ACTION_CANCEL:
//                break;
//        }
        return super.dispatchTouchEvent(ev);
    }
}
