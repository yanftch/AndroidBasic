package com.yanftch.basic;

import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.yanftch.applibrary.base.BaseActivity;
import com.yanftch.applibrary.lv_adapter.CommonAdapter;
import com.yanftch.applibrary.lv_adapter.ViewHolder;
import com.yanftch.basic.animation.AnimationActivity;
import com.yanftch.basic.entity.Item;
import com.yanftch.basic.event.EventActivity;
import com.yanftch.basic.fragment.FragmentChangeMainActivity;
import com.yanftch.basic.glide.GlideDemoActivity;
import com.yanftch.basic.handler.HandlerActivity;
import com.yanftch.basic.recyclerview.RecyclerViewHeadFootActivity;
import com.yanftch.basic.rxjava.RxJavaMainActivity;
import com.yanftch.basic.service.ServiceActivity;
import com.yanftch.basic.sliding_conflict.SlidingConflictActivity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MainActivity extends BaseActivity {
    private static final String TAG = "dah_MainActivity";
    private ListView mListView;
    private List<Item> datas;
    private CommonAdapter mCommonAdapter;
    private SharedPreferences mSharedPreferences;

    @Override
    public int setLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void setTitle() {
        datas = new ArrayList<>();
        datas.add(new Item("Handler", 0, HandlerActivity.class));
        datas.add(new Item("RxJava", 1, RxJavaMainActivity.class));
        datas.add(new Item("Service", 2, ServiceActivity.class));
        datas.add(new Item("Glide", 3, GlideDemoActivity.class));
        datas.add(new Item("滑动冲突", 4, SlidingConflictActivity.class));
        datas.add(new Item("RecyclerView Header Footer", 5, RecyclerViewHeadFootActivity.class));
        datas.add(new Item("共享动画", 6, AnimationActivity.class));
        datas.add(new Item("事件分发机制", 8, EventActivity.class));
        datas.add(new Item("Fragment切换", 9, FragmentChangeMainActivity.class));


        
    }

    @Override
    public void initWidget() {
        mListView = (ListView) findViewById(R.id.mainListView);
        mListView.setAdapter(mCommonAdapter = new CommonAdapter<Item>(mContext, datas, R.layout.item_rxjava_main) {
            @Override
            public void convert(ViewHolder holder, Item item) {
                holder.setText(R.id.tvListViewItemName, item.getName());
            }
        });

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Item item = datas.get(position);
                Class clazz = item.getClazz();
                if (null != clazz)
                    startActivity(new Intent(mContext, clazz));
            }
        });
        map();
    }

    /**
     * map操作
     */
    private void map() {
        final Map<String, Integer> map = new LinkedHashMap<>();
        map.put("key0", 10000);
        map.put("key1", 10001);
        map.put("key2", 10002);
        map.put("key3", 10003);
        map.put("key4", 10004);
        map.put("key5", 10005);
        map.put("key6", 10006);
        map.put(null, 100010);//

        Log.e(TAG, "map: map.toString()===" + map.toString());
        /**
         * 遍历方式一
         * keySet()
         */
        Set<String> strings = map.keySet();
        for (String keyString : strings) {
            Log.e(TAG, "map: keySet()== key= " + keyString + "   value = " + map.get(keyString));
        }
        Log.e(TAG, "map: ==================================================");
        /**
         * 遍历方式二
         * entrySet()
         * iterator
         */
        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> next = iterator.next();
            Log.e(TAG, "map: map.entrySet().iterator()===key = " + next.getKey() + "   value = " + next.getValue());
        }
        Log.e(TAG, "map: -----------------------------------");
        /**
         * 遍历方式三
         * 直接用entrySet
         * 数据量大，效率最高
         */
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        for (Map.Entry<String, Integer> m : entries) {
            Log.e(TAG, "map: map.entrySet()== key = " + m.getKey() + "  value = " + m.getValue());
        }
        Log.e(TAG, "map: ******************************************");
        /**
         * 遍历方式四
         * 只能获取到value值
         */
        Collection<Integer> values = map.values();
        for (Integer value : values){
            Log.e(TAG, "map: map.values()====value = "+value);
        }
    }

    @Override
    public void widgetClick(View v) {

    }
}
