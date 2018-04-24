package com.yanftch.basic.kotlin

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.yanftch.basic.R


/**
 *
 * Author : yanftch
 * Date : 2018/4/20
 * Time : 14:51
 * Desc :
 */
class Kotlin1Activity : Activity() {
    val TAG: String = "dah_Kotlin1Activity";
    var view : View? = null
    private var tvKt1: TextView? = null;
    var imageView: ImageView? = null;
    var user: User? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin_kotlin1)
        if (savedInstanceState == null) {
            user = User("小明", 22);
        }
        tvKt1 = findViewById(R.id.tvKt1) as TextView?
        imageView = findViewById(R.id.ivKotline1) as ImageView?
        Log.e(TAG, "imageView.scaleType===" + imageView!!.scaleType);

        tvKt1!!.text = "11111"
        tvKt1!!.textSize = 50F;


        tvKt1!!.setOnClickListener {
            Log.e("dah", "121212")
            toast(this, "ceshi12345678")
            loadImage();
        }
    }

    /**
     * 过滤
     */

    /**
     * for循环
     */
    fun forDiy(list: List<String>) {
        for (s in list) {
            log(s)
        }
        for (index in list.indices) {
            log("2-" + list.get(index) + "      --" + list[index])
        }
    }

    fun isString(o: Any): Int? {
        if (o is String) {
            return o.length;
        }
        return 100000;
    }

    fun loadImage() {
        val url = "https://www.baidu.com/img/bd_logo1.png"
        Glide.with(this)
                .load(url)
                .dontTransform()//不要对图片进行转换处理
                .into(imageView);
    }

    fun toast(context: Context, string: String) {
        Toast.makeText(this, string, Toast.LENGTH_LONG).show()
    }

    fun log(string: String) {
        Log.e(TAG, string);
    }

    /**
     * 加法运算
     */
    fun add(a: Int, b: Int): Int {
        return a + b
    }

    class User {
        var name: String = ""
        var age: Int = 0;

        constructor(name: String, age: Int) {
            this.name = name
            this.age = age
        }
    }


}