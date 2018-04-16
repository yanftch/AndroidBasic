package com.yanftch.basic.what;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.yanftch.basic.R;
import com.yanftch.basic.constant.CommonDataUtils;
import com.yanftch.basic.constant.CommonTestBean;

import java.util.List;

/**
 * Author : yanftch
 * Date : 2018/4/15
 * Time : 22:32
 * Desc :
 */

public class DoubleOutAdapter extends RecyclerView.Adapter<DoubleOutAdapter.OutViewHolder> {
    private List<CommonTestBean> mList;
    private static final String TAG = "dah_DoubleOutAdapter";

    private DoubleInnerAdapter mDoubleInnerAdapter;
    //RecyclerView 视图池
    private RecyclerView.RecycledViewPool mRecycledViewPool;


    public DoubleOutAdapter(List<CommonTestBean> list) {
        mList = list;
        mRecycledViewPool = new RecyclerView.RecycledViewPool();
    }

    @Override
    public OutViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.double_rv_item_view, parent, false);
        OutViewHolder holder = new OutViewHolder(inflate);
        holder.innerRecyclerView.setRecycledViewPool(mRecycledViewPool);
        return holder;
    }

    @Override
    public void onBindViewHolder(OutViewHolder holder, final int position) {
        CommonTestBean bean = mList.get(position);
        Log.e(TAG, "onBindViewHolder: ");

        if (bean != null) {
            holder.textView.setText(bean.getTitle());
        }
        holder.container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnItemClickListener != null) {
                    mOnItemClickListener.onItemClick(position);
                }
            }
        });
        //配置内部RV
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(holder.container.getContext(), LinearLayoutManager.HORIZONTAL, false);

        RecyclerView innerRecyclerView = holder.innerRecyclerView;
        innerRecyclerView.setLayoutManager(linearLayoutManager);
        mDoubleInnerAdapter = new DoubleInnerAdapter(CommonDataUtils.getCommonTestDataList());
        innerRecyclerView.setAdapter(mDoubleInnerAdapter);
    }

    @Override
    public int getItemCount() {
        return null == mList ? 0 : mList.size();
    }

    class OutViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;
        private LinearLayout container;
        private RecyclerView innerRecyclerView;


        public OutViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.textView);
            container = (LinearLayout) itemView.findViewById(R.id.container);
            innerRecyclerView = (RecyclerView) itemView.findViewById(R.id.innerRecyclerView);

        }
    }

    public interface onItemClickListener {
        void onItemClick(int position);
    }

    public onItemClickListener mOnItemClickListener;

    public void setOnItemClickListener(onItemClickListener itemClickListener) {
        this.mOnItemClickListener = itemClickListener;
    }
}
