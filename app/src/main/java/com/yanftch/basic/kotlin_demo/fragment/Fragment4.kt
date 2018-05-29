package com.yanftch.basic.kotlin_demo.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.yanftch.basic.R

/**
 *
 * Author : yanftch
 * Date : 2018/5/29
 * Time : 15:58
 * Desc :
 */
class Fragment4 : Fragment() {
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var inflate = inflater!!.inflate(R.layout.fragment_fragment4, container, false)
        return inflate
    }

}