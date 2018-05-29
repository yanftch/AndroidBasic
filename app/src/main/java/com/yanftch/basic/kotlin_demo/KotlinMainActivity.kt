package com.yanftch.basic.kotlin_demo

import android.content.Context
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.Window
import android.widget.FrameLayout
import com.yanftch.applibrary.util.BottomNavigationViewHelper
import com.yanftch.basic.R
import com.yanftch.basic.kotlin_demo.fragment.Fragment1
import com.yanftch.basic.kotlin_demo.fragment.Fragment2
import com.yanftch.basic.kotlin_demo.fragment.Fragment3
import com.yanftch.basic.kotlin_demo.fragment.Fragment4
import com.yanftch.basic.kotlin_demo.util.ToastUtils

class KotlinMainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onClick(v: View?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    val TAG = "debug_KotlinMain";
    lateinit var mBottomNavigationView: BottomNavigationView
    lateinit var mFragmentContainer: FrameLayout
    lateinit var mFragmentList: ArrayList<Fragment>
    var mLastFragmentIndex: Int = 0 //记录上一次的索引值


    var context: Context = this;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //隐藏
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_kotlin_main)
        initView()
        initListener()
    }


    private fun initView() {
        mFragmentList = ArrayList()//初始化
        mFragmentList.add(Fragment1.newInstance("string-1", "string-1111"))
        mFragmentList.add(Fragment2())
        mFragmentList.add(Fragment3())
        mFragmentList.add(Fragment4())
        //默认选中第一个Fragment
        switchFragment(0)

        mBottomNavigationView = findViewById(R.id.bottom_navigation_view) as BottomNavigationView
        //解决位移问题
        BottomNavigationViewHelper.disableShiftMode(mBottomNavigationView);
        mFragmentContainer = findViewById(R.id.fragmentContainer) as FrameLayout
    }

    private fun initListener() {
        mBottomNavigationView.setOnNavigationItemSelectedListener { item ->
//            ToastUtils.showShort(context, item.title.toString())
            var itemId = item.itemId
            when (itemId) {
                R.id.tab_main_pager -> switchFragment(0)
                R.id.tab_knowledge_hierarchy -> switchFragment(1)
                R.id.tab_navigation -> switchFragment(2)
                R.id.tab_project -> switchFragment(3)
                else -> ToastUtils.showShort(context, "NULL")
            }
            true
        }
    }

    /**
     * 切换Fragment
     * 用add、hide、show来控制Fragment的显示隐藏，不重新走Fragment的生命周期
     *
     * @param index 要切换的索引值
     */
    fun switchFragment(index: Int) {
        if (index >= mFragmentList.size) return
        val transaction = supportFragmentManager.beginTransaction()
        val targetFragment = mFragmentList[index]//目标的视图
        val currentFragment = mFragmentList[mLastFragmentIndex]//当前的Fragment
        mLastFragmentIndex = index
        transaction.hide(currentFragment)
        if (!targetFragment.isAdded) {
            supportFragmentManager.beginTransaction().remove(targetFragment).commitAllowingStateLoss()
            transaction.add(R.id.fragmentContainer, targetFragment)
        }
        transaction.show(targetFragment)
        transaction.commitAllowingStateLoss()
    }
}
