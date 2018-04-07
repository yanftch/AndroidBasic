package com.yanftch.basic.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;

import com.yanftch.applibrary.base.BaseActivity;
import com.yanftch.basic.R;
import com.yanftch.basic.fragment.frag.CommonFragment;
import com.yanftch.basic.fragment.frag.CommonFragment2;
import com.yanftch.basic.fragment.frag.CommonFragment3;

import java.util.ArrayList;
import java.util.List;

/**
 * Author : yanftch
 * Date   : 2018/4/4
 * Time   : 22:52
 * Desc   : Tablayout+ViewPager+Fragment
 */

public class TabLayoutViewPagerFragmentActivity extends BaseActivity {
    //测试一次提交
    private static final String TAG = "dah_TabLayoutViewPagerFragm";
    private ViewPager viewPager;

    private TabLayout tabLayout;
    private List<Fragment> mFragments;
    private MyAdapter mMyAdapter;
    private List<String> titles;

    @Override
    public int setLayout() {
        return R.layout.activity_tab_layout_view_pager_fragment;
    }

    @Override
    public void setTitle() {
        mBaseTitleBarView.setVisibility(View.GONE);
    }

    @Override
    public void initWidget() {
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        mFragments = new ArrayList<>();
        titles = new ArrayList<>();
//        for (int i = 0; i < 4; i++) {
//            CommonFragment commonFragment = CommonFragment.newInstance(i);
//            mFragments.add(commonFragment);
//            titles.add("Title:" + i+"-"+i);
//        }
        mFragments.add(CommonFragment.newInstance(0));
        mFragments.add(CommonFragment2.newInstance(1));
        mFragments.add(CommonFragment3.newInstance(2));
        titles.add("0");
        titles.add("1");
        titles.add("2");
        mMyAdapter = new MyAdapter(getSupportFragmentManager());

//        mAdapter = new ViewPagerAdapter();
        viewPager.setAdapter(mMyAdapter);
        viewPager.setOffscreenPageLimit(1);
        viewPager.setPageTransformer(true, new DepthTransform());

        tabLayout.setupWithViewPager(viewPager);
    }

    /**
     *
     */
    class DepthTransform implements ViewPager.PageTransformer {
        private static final float MIN_SCALE = 0.75f;

        @Override
        public void transformPage(View view, float position) {
            int width = view.getWidth();
            if (position < -1) {
                view.setAlpha(1);
            } else if (position < 0) {
                view.setTranslationX(0);
                view.setAlpha(1);
                view.setScaleX(1);
                view.setScaleY(1);
            } else if (position < 1) {
                view.setAlpha(1 - position);

                view.setTranslationX(width * -position);

                float scaleFactor = MIN_SCALE
                        + (1 - MIN_SCALE) * (1 - Math.abs(position));
                view.setScaleX(scaleFactor);
                view.setScaleY(scaleFactor);
            }
        }
    }

    /**
     * 放大形式进入的ViewPager
     */
    class ZoomInTransform implements ViewPager.PageTransformer {
        private static final String TAG = "dah_ZoomInTransform";

        @Override
        public void transformPage(View page, float position) {
            int width = page.getWidth();
            int height = page.getHeight();
            //這裏只對右邊的view做了操作
            if (position > 0 && position <= 1) {
                //position是1.0->0,但是沒有等於0
                Log.e(TAG, "right----position====" + position);
                //設置該view的X軸不動
                page.setTranslationX(-width * position);
                //設置縮放中心點在該view的正中心
                page.setPivotX(width / 2);
                page.setPivotY(height / 2);
                //設置縮放比例（0.0，1.0]
                page.setScaleX(1 - position);
                page.setScaleY(1 - position);

            } else if (position >= -1 && position < 0) {//left scrolling

            } else {//center

            }
        }
    }

    class MyAdapter extends FragmentPagerAdapter {

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles.get(position);
        }
    }

    @Override
    public void widgetClick(View v) {

    }
}
