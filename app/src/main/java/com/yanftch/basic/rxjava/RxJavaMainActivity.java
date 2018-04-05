package com.yanftch.basic.rxjava;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.yanftch.applibrary.base.BaseActivity;
import com.yanftch.applibrary.lv_adapter.CommonAdapter;
import com.yanftch.applibrary.lv_adapter.ViewHolder;
import com.yanftch.applibrary.widget.DialogUtils;
import com.yanftch.basic.R;
import com.yanftch.basic.entity.Item;
import com.yanftch.basic.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;

/**
 * Author : yanftch
 * Date   : 2018/3/15
 * Time   : 17:05
 * Desc   : RxJava操作符
 * https://www.jianshu.com/p/b39afa92807e
 * 实际操作：https://www.jianshu.com/p/2caa581425a3
 */

public class RxJavaMainActivity extends BaseActivity {
    private static final String TAG = "dah_RxJavaOpertate";
    private ListView mListView;
    private List<Item> datas;
    private CommonAdapter mCommonAdapter;
    private StringBuilder mStringBuilder;

    @Override
    public int setLayout() {
        return R.layout.activity_rx_java_main;
    }

    @Override
    public void setTitle() {
        mBaseTitleBarView.setTitleText("RxJava操作符");
        mListView = (ListView) findViewById(R.id.rxJavaListView);
        datas = new ArrayList<>();
        datas.add(new Item("RxJava使用三步曲", 0));
        datas.add(new Item("RxJava-线程切换", 1));
        datas.add(new Item("RxJava-map", 2));
        datas.add(new Item("RxJava-Filter", 3));


        datas.add(new Item("distinct", 4));
        datas.add(new Item("zip", 5));
        datas.add(new Item("FlatMap", 6));
        datas.add(new Item("buffer", 7));
        datas.add(new Item("map2", 8));

        mListView.setAdapter(mCommonAdapter = new CommonAdapter<Item>(mContext, datas, R.layout.item_rxjava_main) {
            @Override
            public void convert(ViewHolder holder, Item item) {
                holder.setText(R.id.tvListViewItemName, item.getName());
            }
        });
    }

    @Override
    public void initWidget() {
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mStringBuilder = new StringBuilder();
                switch (position) {
                    case 0:
                        createRxJava();
                        break;
                    case 1:
                        ThreadChangeRxJava();
                        break;
                    case 2:
                        RxJava_map();
                        break;
                    case 3:
                        RxJava_filter();
                        break;
                    case 4:
                        RxJava_distinct();
                        break;
                    case 5:
                        RxJava_zip();
                        break;
                    case 6:
                        RxJava_FlatMap();
                        break;
                    case 7:
                        RxJava_buffer();
                        break;
                    case 8:
                        RxJava_map2();
                        break;
                }
            }
        });
    }

    private void RxJava_map2() {
        List<User> list = new ArrayList<>();
        List<String> names = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            list.add(new User("name" + i, i));
        }
        Observable.fromArray(list)
                .map(new Function<List<User>, List<String>>() {
                    @Override
                    public List<String> apply(List<User> users) throws Exception {
                        List list1 = new ArrayList();
                        list1.add("1234");
                        return list1;
                    }
                }).subscribe(new Consumer<List<String>>() {
            @Override
            public void accept(List<String> strings) throws Exception {
                for (int i = 0; i < strings.size(); i++) {
                    Log.e(TAG, "accept: " + strings.get(i).toString());
                }
            }
        });
    }

    /**
     * buffer
     * buffer 操作符接受两个参数，buffer(count,skip)，
     * 作用是将 Observable 中的数据按 skip (步长) 分成最大不超过 count 的 buffer ，
     * 然后生成一个  Observable
     */
    private void RxJava_buffer() {
        Observable.just(1, 2, 3, 4, 5)
                .buffer(3, 2)
                .subscribe(new Consumer<List<Integer>>() {
                    @Override
                    public void accept(List<Integer> integers) throws Exception {
                        Log.e(TAG, "buffer size : " + integers.size() + "\n");
                        Log.e(TAG, "buffer value : ");
                        for (Integer i : integers) {
                            Log.e(TAG, i + "");
                        }
                        Log.e(TAG, "\n");

                    }
                });
    }

    /**
     * FlatMap
     * FlatMap 是一个很有趣的东西，我坚信你在实际开发中会经常用到。它可以把一个发射器 Observable 通过某种方法转换为多个 Observables，
     * 然后再把这些分散的 Observables装进一个单一的发射器 Observable。但有个需要注意的是，flatMap 并不能保证事件的顺序
     */
    private void RxJava_FlatMap() {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                e.onNext(1);
                e.onNext(2);
                e.onNext(3);
            }
        }).flatMap(new Function<Integer, ObservableSource<String>>() {
            @Override
            public ObservableSource<String> apply(Integer integer) throws Exception {
                List<String> list = new ArrayList<>();
                for (int i = 0; i < 3; i++) {
                    list.add("I am value " + integer);
                }
                int delayTime = (int) (1 + Math.random() * 10);

                return Observable.fromIterable(list).delay(delayTime, TimeUnit.MILLISECONDS);
            }
        })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        Log.e(TAG, "flatMap : accept : " + s + "\n");
                    }
                });
    }

    /**
     * zip
     * 专用于合并事件，该合并不是连接（连接操作符后面会说），而是两两配对，也就意味着，最终配对出的 Observable 发射事件数目只和少的那个相同
     */
    private void RxJava_zip() {
        Observable.zip(getStringObservable(), getIntegerObservable(), new BiFunction<String, Integer, String>() {
            @Override
            public String apply(String s, Integer integer) throws Exception {
                return s + integer;
            }
        }).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                Log.e(TAG, "zip : accept : " + s + "\n");
            }
        });
    }


    /**
     * distinct
     * 去重操作
     */
    private void RxJava_distinct() {
        Observable.just(1, 2, 1, 2, 3, 4, 5, 1, 6, 7).distinct()
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        Log.e(TAG, "distinct : " + integer + "\n");
                    }
                });
    }

    /**
     * Filter
     * 过滤功能
     * 可以接受一个参数，让其过滤掉不符合我们条件的值
     */
    private void RxJava_filter() {
        Observable.just(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .filter(new Predicate<Integer>() {
                    @Override
                    public boolean test(Integer integer) throws Exception {
                        return integer > 5;
                    }
                }).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Integer integer) {
                Log.e(TAG, "filter : " + integer + "\n");
                mStringBuilder.append("filter : " + integer + "\n");
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

                showDialogInfo(mStringBuilder.toString());
            }
        });
    }

    /**
     * Map操作符
     * 对发射时间发送的每一个事件应用一个函数，是的每一个事件都按照指定的函数去变化
     * map 基本作用就是将一个 Observable 通过某种函数关系，转换为另一种 Observable
     */
    private void RxJava_map() {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                e.onNext(1);
                e.onNext(2);
                e.onNext(3);
            }
        }).map(new Function<Integer, String>() {
            @Override
            public String apply(Integer integer) throws Exception {
                return "This is String Value === " + String.valueOf(integer);
            }
        }).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                Log.e(TAG, "accept : " + s + "\n");
                mStringBuilder.append("accept : " + s + "\n");
                showDialogInfo(mStringBuilder.toString());
            }
        });
    }

    /**
     * 线程切换
     * subscribeOn 用于指定 subscribe() 时所发生的线程
     * observeOn 方法用于指定下游 Observer 回调发生的线程。
     * 简单地说，subscribeOn() 指定的就是发射事件的线程，observerOn 指定的就是订阅者接收事件的线程。
     * 多次指定发射事件的线程只有第一次指定的有效，也就是说多次调用 subscribeOn() 只有第一次的有效，其余的会被忽略。
     * 但多次指定订阅者接收线程是可以的，也就是说每调用一次 observerOn()，下游的线程就会切换一次。
     */
    private void ThreadChangeRxJava() {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Integer> e) throws Exception {
                Log.e(TAG, "Observable thread is : " + Thread.currentThread().getName());
                e.onNext(1);
                e.onComplete();
            }
        }).subscribeOn(Schedulers.newThread())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext(new Consumer<Integer>() {
                    @Override
                    public void accept(@NonNull Integer integer) throws Exception {
                        Log.e(TAG, "After observeOn(mainThread)，Current thread is " + Thread.currentThread().getName());
                    }
                })
                .observeOn(Schedulers.io())
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(@NonNull Integer integer) throws Exception {
                        Log.e(TAG, "After observeOn(io)，Current thread is " + Thread.currentThread().getName());
                    }
                });

    }

    /**
     * 基本使用RxJava的三步曲
     * 第一步：初始化 Observable
     * 第二步：初始化 Observer
     * 第三步：建立订阅关系
     */
    private void /*z*/createRxJava() {
        Observable.create(new ObservableOnSubscribe<Integer>() {// 第一步：初始化Observable
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                Log.e(TAG, "Observable emit 1" + "\n");
                e.onNext(1);
                Log.e(TAG, "Observable emit 2" + "\n");
                e.onNext(2);
                Log.e(TAG, "Observable emit 3" + "\n");
                e.onNext(3);
                Log.e(TAG, "Observable emit 4" + "\n");
                e.onNext(4);
            }
        }).subscribe(new Observer<Integer>() { // 第三步：订阅
            // 第二步：初始化Observer
            Disposable mDisposable;
            int index;

            @Override
            public void onSubscribe(Disposable d) {
                mDisposable = d;
            }

            @Override
            public void onNext(Integer integer) {
                Log.e(TAG, "onNext: integer===" + integer);
                index++;
                if (index == 2) {
                    // 在RxJava 2.x 中，新增的Disposable可以做到切断的操作，让Observer观察者不再接收上游事件
                    mDisposable.dispose();
                }

            }

            @Override
            public void onError(Throwable e) {
                Log.e(TAG, "onError : value : " + e.getMessage() + "\n");
            }

            @Override
            public void onComplete() {
                Log.e(TAG, "onComplete" + "\n");
            }
        });
    }

    @Override
    public void widgetClick(View v) {

    }

    private Observable<String> getStringObservable() {
        return Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<String> e) throws Exception {
                if (!e.isDisposed()) {
                    e.onNext("A");
                    Log.e(TAG, "String emit : A \n");
                    e.onNext("B");
                    Log.e(TAG, "String emit : B \n");
                    e.onNext("C");
                    Log.e(TAG, "String emit : C \n");
                }
            }
        });
    }

    private Observable<Integer> getIntegerObservable() {
        return Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Integer> e) throws Exception {
                if (!e.isDisposed()) {
                    e.onNext(1);
                    Log.e(TAG, "Integer emit : 1 \n");
                    e.onNext(2);
                    Log.e(TAG, "Integer emit : 2 \n");
                    e.onNext(3);
                    Log.e(TAG, "Integer emit : 3 \n");
                    e.onNext(4);
                    Log.e(TAG, "Integer emit : 4 \n");
                    e.onNext(5);
                    Log.e(TAG, "Integer emit : 5 \n");
                }
            }
        });
    }

    private void showDialogInfo(String text) {
        DialogUtils.getInstance(mContext).setTitle("******")
                .setContent(text)
                .singleButton(true)
                .setSingleButtonText("OK")
                .setSingleButtonListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mStringBuilder = null;
                    }
                }).show();
    }

}
