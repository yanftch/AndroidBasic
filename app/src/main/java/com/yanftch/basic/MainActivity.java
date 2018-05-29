package com.yanftch.basic;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.yanftch.applibrary.base.BaseActivity;
import com.yanftch.applibrary.lv_adapter.CommonAdapter;
import com.yanftch.applibrary.lv_adapter.ViewHolder;
import com.yanftch.basic.animation.Animation2Activity;
import com.yanftch.basic.animation.AnimationActivity;
import com.yanftch.basic.diy_view.DiyViewActivity;
import com.yanftch.basic.entity.Item;
import com.yanftch.basic.entity.User;
import com.yanftch.basic.event.EventActivity;
import com.yanftch.basic.fragment.FragmentChangeMainActivity;
import com.yanftch.basic.glide.GlideDemoActivity;
import com.yanftch.basic.handler.HandlerActivity;
import com.yanftch.basic.kotlin.Kotlin1Activity;
import com.yanftch.basic.kotlin_demo.KotlinMainActivity;
import com.yanftch.basic.md.FloatButtonActivity;
import com.yanftch.basic.mvp.MVPTestActivity;
import com.yanftch.basic.recyclerview.RecyclerViewHeadFootActivity;
import com.yanftch.basic.rxjava.RxJavaMainActivity;
import com.yanftch.basic.service.ServiceActivity;
import com.yanftch.basic.setcontentview.SetContentViewActivity;
import com.yanftch.basic.sliding_conflict.SlidingConflictActivity;
import com.yanftch.basic.test.TestActivity;
import com.yanftch.basic.test.TestViewActivity;
import com.yanftch.basic.what.DoubleRecyclerViewActivity;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends BaseActivity {
    private static final String TAG = "dah_MainActivity";
    private ListView mListView;
    private List<Item> datas;
    private CommonAdapter mCommonAdapter;

    @Override
    public int setLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void setTitle() {

        anni2(R.string.app_name);
        // TODO: 2018/5/5 练习反射
        try {
            Class c = Class.forName("java.lang.String");
            Field[] declaredFields = c.getDeclaredFields();
            Method[] declaredMethods = c.getDeclaredMethods();

            for (int i = 0; i < declaredFields.length; i++) {
                Log.e(TAG, "setTitle: " + declaredFields[i].getName());
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        datas = new ArrayList<>();
        datas.add(new Item("MD", 15, FloatButtonActivity.class));
        datas.add(new Item("测试自定义view-纯view", 14, TestViewActivity.class));
        datas.add(new Item("MVPTest", 13, MVPTestActivity.class));

        datas.add(new Item("kotlin", 16, Kotlin1Activity.class));
        datas.add(new Item("kotlinDemo-Main", 17, KotlinMainActivity.class));
        datas.add(new Item("setContentView", 15, SetContentViewActivity.class));
        datas.add(new Item("DoubleRv", 14, DoubleRecyclerViewActivity.class));

        datas.add(new Item("Handler", 0, HandlerActivity.class));
        datas.add(new Item("RxJava", 1, RxJavaMainActivity.class));
        datas.add(new Item("Service", 2, ServiceActivity.class));
        datas.add(new Item("Glide", 3, GlideDemoActivity.class));
        datas.add(new Item("滑动冲突", 4, SlidingConflictActivity.class));
        datas.add(new Item("RecyclerView Header Footer", 5, RecyclerViewHeadFootActivity.class));
        datas.add(new Item("共享动画", 6, AnimationActivity.class));
        datas.add(new Item("事件分发机制", 8, EventActivity.class));
        datas.add(new Item("Fragment切换", 9, FragmentChangeMainActivity.class));
        datas.add(new Item("动画", 10, Animation2Activity.class));
        datas.add(new Item("自定义View", 11, DiyViewActivity.class));
        datas.add(new Item("Test", 12, TestActivity.class));
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
                    startActivity(new Intent(MainActivity.this.mContext, clazz));
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
        for (Integer value : values) {
            Log.e(TAG, "map: map.values()====value = " + value);
        }
    }

    @Override
    public void widgetClick(View v) {
//        Glide.with(this).load("1").transform().diskCacheStrategy(DiskCacheStrategy.NONE).skipMemoryCache(true).into(new ImageView(this));
    }

    // TODO: 2018/4/25
    private void okhttpMethod() throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request;
        Request.Builder builder = new Request.Builder();
        request = builder.url("url").build();
        Response execute = client.newCall(request).execute();
        //移步
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                anni("1");
                anni2(R.string.app_name);
            }
        });


    }

    private void anni(@NonNull String string) {
        Toast.makeText(this, string, Toast.LENGTH_SHORT).show();
    }

    private void anni2(@StringRes int resId) {
        Log.e(TAG, "anni2: " + resId);
        try {
            Class<?> aClass = Class.forName("com.yanftch.basic.entity.User");

            //获取类名和包名
            String 包名 = aClass.getPackage().getName();
            String 类名 = aClass.getName();
            //通过反射，用Class创建对象
            Class<?> tClass = null;
            tClass = Class.forName("com.yanftch.basic.entity.User");
            User user = (User) tClass.newInstance();
            user.setName("反射设置的Name");
            user.setAge(999);
            //通过反射机制，获得一个类的构造函数，并实现带参实例对象
            User user1;
            User user2;
            Class<?> cClass = Class.forName("com.yanftch.basic.entity.User");
            Constructor<?>[] constructors = cClass.getConstructors();
            user1 = (User) constructors[0].newInstance();
            user1.setName("user1-name");
            user1.setAge(111111);
            user2 = (User) constructors[1].newInstance("user2-name", 222222);
            Log.e(TAG, "anni2: " + user1.toString() + "     " + user2.toString());

            //通过反射机制，调用类方法
            Class<?> dClass = Class.forName("com.yanftch.basic.entity.User");
            User user3 = (User) dClass.newInstance();
            Log.e(TAG, "anni2: user3.toString()===" + user3.toString());
            Method method = dClass.getMethod("setAge", int.class);
            method.invoke(dClass.newInstance(), 123);

            Log.e(TAG, "anni2: user3.toString()==333==" + user3.toString());

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }


    }

    /**
     * 静态内部类的单例模式
     */
    static class SingleTon {
        //私有构造
        private SingleTon() {
        }

        //静态内部类
        private static class SingletonHolder {
            private static final SingleTon instance = new SingleTon();
        }

        //获取方法
        public SingleTon getInstance() {
            return SingletonHolder.instance;
        }
    }

}
