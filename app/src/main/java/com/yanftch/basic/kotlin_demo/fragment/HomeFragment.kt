package com.yanftch.basic.kotlin_demo.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.yanftch.applibrary.entity.HomeListBean
import com.yanftch.applibrary.net.HttpManager
import com.yanftch.applibrary.net.ICallBack
import com.yanftch.applibrary.net.RetrofitManager
import com.yanftch.basic.R
import com.yanftch.basic.kotlin_demo.adapter.HomeAdapter
import com.yanftch.basic.kotlin_demo.util.ToastUtils

class HomeFragment : Fragment() {
    private val TAG = "debug_HomeFragment"
    private var mParam1: String? = null
    private var mParam2: String? = null
    lateinit var mRecyclerView: RecyclerView
    private lateinit var mHomeAdapter: HomeAdapter
    private lateinit var datas: ArrayList<HomeListBean.DatasBean>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            mParam1 = arguments.getString(ARG_PARAM1)
            mParam2 = arguments.getString(ARG_PARAM2)
        }
        http_getData()
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.kt_main_home_fragment, container, false).apply { tag=TAG }
        initView(view)
        return view
    }

    private fun initView(view: View) {
        mRecyclerView = view.findViewById(R.id.homeRecyclerView) as RecyclerView
        datas = ArrayList()
        var linearLayoutManager: RecyclerView.LayoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        mRecyclerView.layoutManager = linearLayoutManager
        mHomeAdapter = HomeAdapter(context,datas)
        mRecyclerView.adapter = mHomeAdapter
        mHomeAdapter.setOnItemClickListener(object : HomeAdapter.OnItemClickListener{
            override fun click(position: Int) {
                ToastUtils.showShort(context,datas[position].author)
            }
        })
    }

    private fun http_getData() {
        HttpManager
                .getInstance()
                .with(activity)
                .setObservable(RetrofitManager.getService().getWanAndroidHomeList(1))
                .setCallBack(true, object : ICallBack<HomeListBean> {
                    override fun onSuccess(t: HomeListBean?) {
                        if (t != null) {
                            notifyDataSetChanged(t, true)
                        }
                    }

                    override fun onError(message: String?) {
                        Log.e(TAG, ": " + message);
                    }
                })
    }

    /**
     *
     */
    private fun notifyDataSetChanged(bean: HomeListBean, pullDown: Boolean) {
        if (pullDown) {
            datas.clear()
            datas.addAll(bean!!.datas)
        } else {
            datas.addAll(bean!!.datas)
        }
        mHomeAdapter.notifyDataSetChanged()
    }

    companion object {
        private val ARG_PARAM1 = "param1"
        private val ARG_PARAM2 = "param2"
        fun newInstance(param1: String, param2: String): HomeFragment {
            val fragment = HomeFragment()
            val args = Bundle()
            args.putString(ARG_PARAM1, param1)
            args.putString(ARG_PARAM2, param2)
            fragment.arguments = args
            return fragment
        }
    }
}
