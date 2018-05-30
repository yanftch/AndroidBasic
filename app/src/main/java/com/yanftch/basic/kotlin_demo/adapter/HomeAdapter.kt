package com.yanftch.basic.kotlin_demo.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.yanftch.applibrary.entity.HomeListBean
import com.yanftch.basic.R

/**
 *
 * Author : yanftch
 * Date : 2018/5/29
 * Time : 21:36
 * Desc :
 */
class HomeAdapter : RecyclerView.Adapter<HomeAdapter.HomeViewHolder> {
    private val TAG = "debug_HomeAdapter"

    private var context: Context? = null
    private var datas: ArrayList<HomeListBean.DatasBean>? = null
    private var mLayoutInflater: LayoutInflater

    //这是构造方法
    constructor(context: Context, newsList: ArrayList<HomeListBean.DatasBean>) : super() {
        this.context = context
        this.datas = newsList
        mLayoutInflater = LayoutInflater.from(context)
    }

    override fun onBindViewHolder(holder: HomeViewHolder?, position: Int) {
        holder!!.tvHomeTest.text = datas!![position].author
    }

    //TODO 三元运算符
    override fun getItemCount(): Int = datas!!.size

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): HomeViewHolder {
        var view = mLayoutInflater.inflate(R.layout.kt_home_layout_item, parent, false)
        return HomeViewHolder(view)
    }


    class HomeViewHolder : RecyclerView.ViewHolder {
        var tvHomeTest: TextView

        constructor(itemView: View) : super(itemView) {
            tvHomeTest = itemView!!.findViewById(R.id.tvHomeTest) as TextView
        }
    }
}

