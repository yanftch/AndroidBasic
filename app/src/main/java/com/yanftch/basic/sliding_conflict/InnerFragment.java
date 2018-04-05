package com.yanftch.basic.sliding_conflict;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yanftch.basic.R;

/**
 * Author : yanftch
 * Date : 2018/3/30
 * Time : 08:53
 * Desc :
 */

public class InnerFragment extends Fragment {
    private static final String TAG = "dah_InnerFragment";
    public static String index_type = "_index_";
    private int resIds[] = new int[]{R.drawable.ic_test_0, R.drawable.ic_test_1, R.drawable.ic_test_2, R.drawable.ic_test_3,};

    private int index;
    private TextView mTextView;
    private ViewPagerAdapter mAdapter;
    private ChildViewPager mChildViewPager;


    public static InnerFragment newInstance(int type) {
        Bundle args = new Bundle();
        args.putInt(index_type, type);
        InnerFragment fragment = new InnerFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            index = arguments.getInt(index_type, 0);
            Log.e(TAG, "onCreate: index====" + index);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.innerfragment_layout_view, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        mTextView = (TextView) view.findViewById(R.id.textViewInnerFragment);
        mTextView.setText("index===" + index);
        mChildViewPager = (ChildViewPager) view.findViewById(R.id.innerViewPager);
        mAdapter = new ViewPagerAdapter();
        mChildViewPager.setAdapter(mAdapter);
    }

    class ViewPagerAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return resIds.length;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
//            super.destroyItem(container, position, object);
            container.removeView((View) object);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            TextView tv = new TextView(getContext().getApplicationContext());
            tv.setGravity(Gravity.CENTER);
            tv.setTextSize(20);
            tv.setTextColor(getResources().getColor(R.color.colorAccent));
            tv.setText("" + position + "号");
            container.addView(tv);
            return tv;

        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }
    }
}
