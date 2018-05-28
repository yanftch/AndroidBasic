package com.yanftch.basic.test

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.yanftch.basic.R
//todo 自定义view生命周期

public class TestViewActivity : AppCompatActivity() {

    private val TAG = "dah_TestViewActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test3)
    }


    override fun onResume() {
        super.onResume()
        Log.e(TAG, "onResume---Activity")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e(TAG, "onDestroy---Activity")
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        Log.e(TAG, "onDetachedFromWindow---Activity")
    }
}
