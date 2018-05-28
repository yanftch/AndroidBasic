package com.yanftch.basic.kotlin_demo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.yanftch.applibrary.util.BottomNavigationViewHelper
import com.yanftch.basic.R
import kotlinx.android.synthetic.main.activity_kotlin_main.*

class KotlinMainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin_main)
        //解决位移问题
        BottomNavigationViewHelper.disableShiftMode(bottom_navigation_view);
    }
}
