package com.yanftch.basic.diy_view;

import android.support.annotation.LayoutRes;
import android.support.annotation.StringRes;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.yanftch.applibrary.base.BaseActivity;
import com.yanftch.basic.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Author : yanftch
 * Date   : 2018/4/8
 * Time   : 21:25
 * Desc   : 自定义view练习
 */

public class DiyViewActivity extends BaseActivity {
    private static final String TAG = "dah_DiyViewActivity";
    @BindView(R.id.tabViewLayout)
    TabLayout mTabViewLayout;
    @BindView(R.id.divViewPager)
    ViewPager mDivViewPager;
    List<PageModel> pageModels = new ArrayList<>();

    {
        pageModels.add(new PageModel(R.string.title_draw_color, R.layout.practice_color));
        pageModels.add(new PageModel(R.string.title_draw_circle, R.layout.practice_circle));
        pageModels.add(new PageModel(R.string.title_draw_rect, R.layout.practice_shunxu));
    }


    @Override
    public int setLayout() {
        return R.layout.activity_diy_view;
    }

    @Override
    public void setTitle() {
        mBaseTitleBarView.setTitleText("自定义view练习");
    }

    @Override
    public void initWidget() {
        mDivViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {

            @Override
            public Fragment getItem(int position) {
                PageModel pageModel = pageModels.get(position);
                return PageFragment.newInstance(pageModel.practiceLayoutRes);
            }

            @Override
            public int getCount() {
                return pageModels.size();
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return getString(pageModels.get(position).titleRes);
            }
        });

        mTabViewLayout.setupWithViewPager(mDivViewPager);
    }

    @Override
    public void widgetClick(View v) {

    }

    private class PageModel {
        @StringRes
        int titleRes;
        @LayoutRes
        int practiceLayoutRes;

        PageModel(@StringRes int titleRes, @LayoutRes int practiceLayoutRes) {
            this.titleRes = titleRes;
            this.practiceLayoutRes = practiceLayoutRes;
        }
    }
}
