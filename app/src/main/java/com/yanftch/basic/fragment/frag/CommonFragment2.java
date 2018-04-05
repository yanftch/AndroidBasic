package com.yanftch.basic.fragment.frag;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yanftch.basic.R;

/**
 * Author : yanftch
 * Date : 2018/4/4
 * Time : 22:52
 * Desc :
 */

public class CommonFragment2 extends Fragment {
    private static final String TAG = "dah_CommonFragment";
    private TextView commonTextView;
    private int index;
    public static String index_type = "_index_index_";

    public static CommonFragment2 newInstance(int type) {
        Bundle args = new Bundle();
        args.putInt(index_type, type);
        CommonFragment2 fragment = new CommonFragment2();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.e(TAG, "onAttach: " + index);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Log.e(TAG, "onCreate: " + index);
        Bundle arguments = getArguments();
        if (arguments != null) {
            index = arguments.getInt(index_type, 0);
        }
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.e(TAG, "onViewCreated: " + index);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.e(TAG, "onCreateView: " + index);
        View view = inflater.inflate(R.layout.common_fragment_layout, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        commonTextView = (TextView) view.findViewById(R.id.commonTextView);
        commonTextView.setText("index===---" + index + "");
        commonTextView.setTextColor(getResources().getColor(R.color.colorAccent));
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.e(TAG, "onResume: " + index);
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.e(TAG, "onPause: " + index);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy: " + index);
    }
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        Log.e(TAG, "setUserVisibleHint: "+index+"   "+isVisibleToUser);
    }
    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        Log.e(TAG, "onHiddenChanged: "+index+"   "+hidden);
    }
}
