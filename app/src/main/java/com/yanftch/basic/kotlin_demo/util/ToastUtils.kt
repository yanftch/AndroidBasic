package com.yanftch.basic.kotlin_demo.util

import android.content.Context
import android.widget.Toast

/**
 *
 * Author : yanftch
 * Date : 2018/5/28
 * Time : 15:42
 * Desc :
 */
class ToastUtils {

    companion object {
        fun showShort(context: Context, string: String): Unit {
            Toast.makeText(context, string, Toast.LENGTH_SHORT).show()
        }
    }
}