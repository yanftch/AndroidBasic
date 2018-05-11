package com.yanftch.basic.kotlin

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.bumptech.glide.Glide
import com.yanftch.applibrary.net.HttpManager
import com.yanftch.applibrary.net.ICallBack
import com.yanftch.applibrary.net.MyTestBean
import com.yanftch.applibrary.net.RetrofitManager
import com.yanftch.basic.R
import kotlinx.android.synthetic.main.activity_kotlin_kotlin1.*


/**
 *
 * Author : yanftch
 * Date : 2018/4/20
 * Time : 14:51
 * Desc :
 */
class Kotlin1Activity : Activity() {
    private var photoUrl: String? = null;

    lateinit var list: ArrayList<String>
    val TAG: String = "dah_Kotlin1Activity";
    var listView: ListView? = null
    lateinit var context: Context

    var view: View? = null
    lateinit var tv: TextView
    var tvKt1: TextView? = null;

    var imageView: ImageView? = null;
    var user: User? = null;
    /**
     * Intent 跳转
     */
    fun start(context: Context, bundle: Bundle) {
        var intent = Intent(context, Kotlin1Activity::class.java);
        intent.putExtra("bundle_key", bundle);
        context.startActivity(intent);
    }

    /**
     * 获取传递的值
     */
    fun getBundleData() {
        var bundle = intent.getBundleExtra("bundle_key")
        var string = bundle.getString("string_key")
        Log.e(TAG, string + "¬¬¬¬¬¬¬¬¬¬¬¬˚˚˚˚˚∆∆©©©©©©∂∂∂∂∂åå≈µ≤œ¥øπ¬˚∆©∂å≈µ≤≥")
    }

    /**
     * 有返回值的function
     */
    fun getString(string: String): String {
        return "123"
    }

    /**
     * 显示ListVIew
     */
    private fun setListView() {
        list = ArrayList();
        var i: Int = 0
        var end: Int = 40
        do {
            list.add("item$i")
//            list.add("你好" + "_" + "$i")
            i++;
        } while (i < end)

        ktListView.dividerHeight = 10;
        var adapter = MyAdapter(list, this);
        ktListView.adapter = adapter;
        ktListView.onItemClickListener =
                AdapterView.OnItemClickListener { parent, view, position, id -> toast(parent.context, "position==" + position) }

    }

    private fun http_getHome() {
        HttpManager.getInstance()
                .with(context)
                .setObservable(RetrofitManager.getService().fengHome)
                .setCallBack(true, object : ICallBack<MyTestBean> {
                    override fun onSuccess(normalBean: MyTestBean?) {
                        if (null != normalBean && normalBean.productIntr != null) {
                            Log.e(TAG, "onSuccess: " + normalBean.bannerList)
                            tvNoFbc.text = normalBean.productIntr.piTitle
                            for (i in 0 until normalBean.bannerList.size) {
                                Log.e(TAG, "onSuccess: " + normalBean.bannerList[i].adTitle)
                            }
                        } else {
                            Toast.makeText(context, "空数据", Toast.LENGTH_SHORT).show()
                        }
                    }

                    override fun onError(message: String) {
                        Log.e(TAG, "--------------------" + message)
                    }
                })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin_kotlin1)
        context = this
        setListView();
        http_getHome()

        photoUrl?.let { toast(context, it) }

        if (savedInstanceState == null) {
            user = User("小明", 22);
//            var  aa = A.getStr()

        }
        tvKt1 = findViewById(R.id.tvKt1) as TextView?;
        imageView = findViewById(R.id.ivKotline1) as ImageView?
        Log.e(TAG, "imageView.scaleType===" + imageView!!.scaleType);

        tvKt1!!.text = "11111"
        tvKt1!!.textSize = 50F;

        tvNoFbc.setOnClickListener {
            toast(this, "哈哈哈哈哈")
        }
        tvNoFbc.text = "不好啊"

        tvKt1!!.setOnClickListener {
            Log.e("dah", "121212")
            toast(this, "ceshi12345678")
            loadImage();
        }
    }


    /**
     * 枚举
     */
    enum class DIRECTION {
        NORTH, SOUTH, WEST, EAST

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

     open fun toast(context: Context, string: String) {
        Toast.makeText(context, string, Toast.LENGTH_LONG).show()
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

    /*
    适配器
     */
    class MyAdapter(var datas: ArrayList<String>, var context: Context) : BaseAdapter() {
        class ViewHolder(var itemView: View) {
            var textView: TextView = itemView.findViewById(R.id.tv_name) as TextView;
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            var viewHolder: ViewHolder? = null
            var view: View;
            if (convertView == null) {
                view = View.inflate(context, R.layout.item_test, null);
                viewHolder = ViewHolder(view)
                view.tag = viewHolder
            } else {
                view = convertView
                viewHolder = view.tag as ViewHolder;
            }
            val item = getItem(position)
            viewHolder.textView.text = item.toString();
            return view;
        }

        override fun getItem(position: Int): Any {
            return datas.get(position)
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            return datas.size
        }
    }


}