package com.yanftch.basic.sliding_conflict;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.yanftch.applibrary.base.BaseActivity;
import com.yanftch.basic.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Author : yanftch
 * Date   : 2018/3/30
 * Time   : 08:25
 * Desc   : 滑动冲突
 */

public class SlidingConflictActivity extends BaseActivity {
    private static final String TAG = "dah_SlidingConflictActivity";
private ViewPager viewPager;

    private TabLayout tabLayout;
    private List<Fragment> mFragments;
    private MyAdapter mMyAdapter;
    private List<String> titles;



    @Override
    public int setLayout() {
        return R.layout.activity_sliding_conflict;
    }

    @Override
    public void setTitle() {
        mBaseTitleBarView.setTitleText("A");
        mBaseTitleBarView.setVisibility(View.GONE);
    }

    @Override
    public void initWidget() {
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        mFragments = new ArrayList<>();
        titles = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            InnerFragment innerFragment = InnerFragment.newInstance(i);
            mFragments.add(innerFragment);
            titles.add("Title:"+i);
        }
        mMyAdapter = new MyAdapter(getSupportFragmentManager());

//        mAdapter = new ViewPagerAdapter();
        viewPager.setAdapter(mMyAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public void widgetClick(View v) {

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

}
