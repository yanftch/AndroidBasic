package com.yanftch.basic.md;

import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageButton;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.yanftch.applibrary.base.BaseActivity;
import com.yanftch.basic.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class FloatButtonActivity extends BaseActivity {
    private static final String TAG = "dah_FloatButtonActivity";
    private Adapter mAdapter;
    private List datas;

    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;
    @BindView(R.id.imageButton)
    ImageButton mImageButton;
    private static final int DISTANCE = 20;
    private static int distanceCount = 0;
    private boolean visible = true;


    @Override
    public int setLayout() {
        return R.layout.activity_float_button;
    }

    @Override
    public void setTitle() {

    }

    @Override
    public void initWidget() {
        datas = new ArrayList();
        for (int i = 0; i < 100; i++) {
            datas.add("name" + i);
        }
        mAdapter = new Adapter(R.layout.item_test, datas);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(mContext.getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Toast.makeText(FloatButtonActivity.this, ""+position, Toast.LENGTH_SHORT).show();
            }
        });
        mAdapter.setEnableLoadMore(true);
        mAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                mRecyclerView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0; i < 20; i++) {
                            datas.add("new ITEM"+i);
                        }
                        mAdapter.loadMoreComplete();
                    }
                },2000);
            }
        },mRecyclerView);
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
//                Log.e(TAG, "onScrolled: dx == " + dx + "      dy == " + dy);//x,y的增量
                Log.e(TAG, "onScrolled: distanceCount===" + distanceCount);
                if (distanceCount > 20 && visible) {
                    //隐藏
                    visible = false;
                    CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) mImageButton.getLayoutParams();
                    mImageButton.animate().translationY(mImageButton.getHeight() + layoutParams.bottomMargin).setInterpolator(new AccelerateInterpolator(8));
                    distanceCount = 0;
                } else if (distanceCount < -20 && !visible) {
                    //显示
                    visible = true;
                    mImageButton.animate().translationY(0).setInterpolator(new DecelerateInterpolator(4));
                    distanceCount = 0;
                }
                if (visible && dy > 0 || !visible && dy < 0) {
                    distanceCount += dy;
                }
            }
        });
    }

    @Override
    public void widgetClick(View v) {

    }

    /**
     * 适配器
     */
    static class Adapter extends BaseQuickAdapter<String, BaseViewHolder> {

        public Adapter(int layoutResId, @Nullable List<String> data) {
            super(layoutResId, data);
        }

        @Override
        protected void convert(BaseViewHolder helper, String item) {
            helper.setText(R.id.tv_name, item);
        }
    }
}
