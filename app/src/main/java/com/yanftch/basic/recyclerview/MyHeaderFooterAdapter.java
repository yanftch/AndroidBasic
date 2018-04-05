package com.yanftch.basic.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yanftch.basic.R;

import java.util.List;

/**
 * Author : yanftch
 * Date : 2018/3/29
 * Time : 21:47
 * Desc : 给Recyclerview添加Header&Footer
 */

public class MyHeaderFooterAdapter extends RecyclerView.Adapter<MyHeaderFooterAdapter.ViewHolder> {
    private static final String TAG = "dah_MyHeaderFooterAdapter";
    private LayoutInflater mLayoutInflater;
    private List<String> datas;
    private Context mContext;
    private static final int TYPE_HEADER = 0;
    private static final int TYPE_NORMAL = 1;
    private static final int TYPE_FOOTER = 2;
    private View mHeadView;
    private View mFootView;


    public void setHeadView(View headView) {
        mHeadView = headView;
        notifyItemInserted(0);//插入数据
    }

    public void setFootView(View footView) {
        mFootView = footView;
        notifyItemInserted(getItemCount() - 1);
    }

    public View getHeadView() {
        return mHeadView;
    }

    @Override
    public int getItemViewType(int position) {
        if (mHeadView == null) return TYPE_NORMAL;
        if (0 == position) return TYPE_HEADER;
        if (getItemCount() - 1 == position) return TYPE_FOOTER;
        return TYPE_NORMAL;

    }

    public MyHeaderFooterAdapter(Context context, List<String> datas) {
        mContext = context;
        this.datas = datas;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mHeadView != null && viewType == TYPE_HEADER) return new ViewHolder(mHeadView);
        if (mFootView != null && viewType == TYPE_FOOTER) return new ViewHolder(mFootView);
        ViewHolder viewHolder = new ViewHolder(mLayoutInflater.inflate(R.layout.item_test, parent, false));
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        if (getItemViewType(position) == TYPE_HEADER) return;
        if (getItemViewType(position) == TYPE_FOOTER) return;
        holder.name.setText(datas.get(position - 1));

    }

    @Override
    public int getItemCount() {
        if (mHeadView == null && mFootView == null) {
            return datas.size();
        } else if (mHeadView == null && mFootView != null) {
            return datas.size() + 1;
        } else if (mHeadView != null && mFootView == null) {
            return datas.size() + 1;
        } else {
            return datas.size() + 2;
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView name;

        public ViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.tv_name);
        }
    }
}
