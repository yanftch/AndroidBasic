package com.yanftch.basic.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
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
        tabLayout.setupWithViewPager(viewPager);
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
