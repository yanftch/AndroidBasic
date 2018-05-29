package com.yanftch.basic.kotlin_demo.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.yanftch.applibrary.entity.HomeListBean
import com.yanftch.applibrary.net.HttpManager
import com.yanftch.applibrary.net.ICallBack
import com.yanftch.applibrary.net.RetrofitManager
import com.yanftch.basic.R

/**
 *
 * Author : yanftch
 * Date : 2018/5/29
 * Time : 15:58
 * Desc :
 */
class Fragment2 : Fragment() {
    val TAG="debug_Fragment2"

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var inflate = inflater!!.inflate(R.layout.fragment_fragment2, container, false)
        return inflate
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      HttpManager.getInstance().with(activity)
              .setObservable(RetrofitManager.getService().getWanAndroidHomeList(1))
              .setCallBack(true,object : ICallBack<HomeListBean>{
                  override fun onSuccess(t: HomeListBean?) {
                      var datas = t!!.datas
                      Log.e(TAG, ": "+datas.size);
                  }

                  override fun onError(message: String?) {
                      Log.e(TAG, ": "+message);
                  }

              })
    }
}