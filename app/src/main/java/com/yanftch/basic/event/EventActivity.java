package com.yanftch.basic.event;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.Toast;

import com.yanftch.applibrary.lv_adapter.CommonAdapter;
import com.yanftch.applibrary.lv_adapter.ViewHolder;
import com.yanftch.basic.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Author : yanftch
 * Date   : 2018/3/22
 * Time   : 16:50
 * Desc   : 事件分发
 */

public class EventActivity extends AppCompatActivity {
    private static final String TAG = "debug_EventActivity";
    @BindView(R.id.myView)
    MyView mMyView;
    @BindView(R.id.myViewGroup)
    MyViewGroup mMyViewGroup;
    @BindView(R.id.listview)
    MyListView mListview;
    @BindView(R.id.scrollView)
    ScrollView mScrollView;
    private CommonAdapter<String> mCommonAdapter;
    private List<String> datas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        ButterKnife.bind(this);
        datas = new ArrayList<>();
        for (int i = 0; i < 40; i++) {
            datas.add("item" + i);
        }
        mCommonAdapter = new CommonAdapter<String>(this, datas, R.layout.item_test) {
            @Override
            public void convert(ViewHolder holder, String item) {
                holder.setText(R.id.tv_name, item);
            }
        };
        mListview.setAdapter(mCommonAdapter);
        mListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(EventActivity.this, "position===" + position, Toast.LENGTH_SHORT).show();
            }
        });
        mListview.setParent(mScrollView);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.e(TAG, "dispatchTouchEvent: " + ev);
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e(TAG, "onTouchEvent: " + event);
        return super.onTouchEvent(event);
    }

    static class setHeightUtils {
        public static void setHeight(ListView listView) {
            //获取适配器
            ListAdapter adapter = listView.getAdapter();
            if (null == adapter) return;
            int size = adapter.getCount();
            int totleHeight = 0;//总的高度
            for (int i = 0; i < size; i++) {
                View adapterView = adapter.getView(i, null, listView);
                adapterView.measure(0, 0);
                totleHeight += adapterView.getMeasuredHeight();
            }
            ViewGroup.LayoutParams layoutParams = listView.getLayoutParams();
            layoutParams.height = totleHeight + (listView.getDividerHeight() * (adapter.getCount() - 1));
            Log.e(TAG, "setHeight: "+ layoutParams.height);
            listView.setLayoutParams(layoutParams);
        }
    }
}
