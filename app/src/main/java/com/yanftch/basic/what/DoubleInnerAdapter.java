package com.yanftch.basic.what;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.yanftch.basic.R;
import com.yanftch.basic.constant.CommonTestBean;

import java.util.List;

/**
 * Author : yanftch
 * Date : 2018/4/15
 * Time : 23:35
 * Desc :
 */

public class DoubleInnerAdapter extends RecyclerView.Adapter<DoubleInnerAdapter.InnerViewHolder> {
    private List<CommonTestBean> mList;
    private static final String TAG = "dah_DoubleInnerAdapter";

    public DoubleInnerAdapter(List<CommonTestBean> list) {
        mList = list;
    }

    @Override
    public InnerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.double_rv_item_inner_view, parent, false);
        return new InnerViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(InnerViewHolder holder, int position) {
        CommonTestBean bean = mList.get(position);
        Log.e(TAG, "onBindViewHolder: ");
        if (bean != null) {
            holder.innerTextView.setText(bean.getTitle());
            ImageView imageView = holder.mImageView;
            if (bean.getImgUrl().endsWith(".gif")) {
                Glide.with(holder.mImageView.getContext()).load(bean.getImgUrl()).error(R.drawable.ic_test_0).placeholder(R.drawable.ic_test_1).into(imageView);
            } else {
                Glide.with(holder.mImageView.getContext()).load(bean.getImgUrl()).error(R.drawable.ic_test_0).placeholder(R.drawable.ic_test_1).into(imageView);
            }
        }
    }

    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }

    class InnerViewHolder extends RecyclerView.ViewHolder {
        private TextView innerTextView;
        private ImageView mImageView;


        public InnerViewHolder(View itemView) {
            super(itemView);
            innerTextView = (TextView) itemView.findViewById(R.id.innerTextView);
            mImageView = (ImageView) itemView.findViewById(R.id.image);
        }
    }

    public interface onItemClickListener {
        void onItemClick(int position);
    }

    public DoubleOutAdapter.onItemClickListener mOnItemClickListener;

    public void setOnItemClickListener(DoubleOutAdapter.onItemClickListener itemClickListener) {
        this.mOnItemClickListener = itemClickListener;
    }
}
