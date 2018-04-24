package com.yanftch.basic.setcontentview;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.yanftch.basic.R;

import butterknife.ButterKnife;

/**
 * Author : yanftch
 * Date   : 2018/4/16
 * Time   : 16:23
 * Desc   : 研究setContentView的流程
 * </p>
 * https://blog.csdn.net/nugongahou110/article/details/49662211
 */

public class SetContentViewActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "dah_SetContentViewActivity";
    EditText mEtAccount;
    EditText mEtPassword;
    Button mBtnSubmit;

    TextView mTvAccount;
    TextView mTvPassword;
    Button mBtnReset;
    Button mBtnSubmit2;
    /**
     * 表示两种布局标识
     */
    private static final int LAYOUT_FILL = 0;
    private static final int LAYOUT_REFILL = 1;
    private int currentLayout;
    private LayoutInflater mInflater;
    private View fillView;
    private View confirmView;

    private String account;
    private String password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        //初始布局
        int activity_set_content_view_fill = R.layout.activity_set_content_view_fill;
        //重填的布局
        int activity_set_content_view_refill = R.layout.activity_set_content_view_refill;
        initView();
        initListener();
        //初始化当前布局为填写表单布局
        currentLayout = LAYOUT_FILL;
    }

    private void initListener() {
        mBtnSubmit.setOnClickListener(this);
        mBtnReset.setOnClickListener(this);
        mBtnSubmit2.setOnClickListener(this);
    }

    private void initView() {
        //初始化布局加载器
        mInflater = LayoutInflater.from(this);
        //加载填写表单页面
        fillView = mInflater.inflate(R.layout.activity_set_content_view_fill, null);
        //加载确认表单页面
        confirmView = mInflater.inflate(R.layout.activity_set_content_view_refill, null);


        mEtAccount = (EditText) fillView.findViewById(R.id.etAccount);
        mEtPassword = (EditText) fillView.findViewById(R.id.etPassword);
        mBtnSubmit = (Button) fillView.findViewById(R.id.btnSubmit);

        mTvAccount = (TextView) confirmView.findViewById(R.id.tvAccount);
        mTvPassword = (TextView) confirmView.findViewById(R.id.tvPassword);
        mBtnReset = (Button) confirmView.findViewById(R.id.btnReset);
        mBtnSubmit2 = (Button) confirmView.findViewById(R.id.btnSubmit2);
        //调用setContentView(View view)方法，传入一个View
        setContentView(fillView);
    }

    @Override
    public void onClick(View v) {
        if (currentLayout == LAYOUT_FILL) {
            switch (v.getId()) {
                case R.id.btnSubmit:
                    if (TextUtils.isEmpty(mEtAccount.getText().toString())) {
                        Toast.makeText(this, "账号不能为空", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    if (TextUtils.isEmpty(mEtPassword.getText().toString())) {
                        Toast.makeText(this, "密码不能为空", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    //将EditText内容保存到变量中
                    account = mEtAccount.getText().toString();
                    password = mEtPassword.getText().toString();
                    //将当前页面改为确认表单页面
                    currentLayout = LAYOUT_REFILL;
                    //调用setContentView(View view)，显示确认表单页面
                    setContentView(confirmView);
                    break;
            }
        } else if (currentLayout == LAYOUT_REFILL) {
            switch (v.getId()) {
                case R.id.btnReset:
                    //重填
                    Animation animation = new AlphaAnimation(0f, 1f);
                    fillView.setAnimation(animation);
                    setContentView(fillView);
                    //将当前页面改为填写表单页面
                    currentLayout = LAYOUT_FILL;
                    break;
                case R.id.btnSubmit2:
                    String info = account + "---" + password;
                    ResultActivity.start(SetContentViewActivity.this, 1, info);
                    break;
            }
        }
    }

    /**
     * 调用了setContentView后会回调此方法
     */
    @SuppressLint("LongLogTag")
    @Override
    public void onContentChanged() {
        super.onContentChanged();
        Log.e(TAG, "onContentChanged: ");
        //当前是确认页面
        if (currentLayout == LAYOUT_REFILL) {
            if (!TextUtils.isEmpty(account)) {
                mTvAccount.setText(account);
            }
            if (!TextUtils.isEmpty(password)) {
                mTvPassword.setText(password);
            }
        } else if (currentLayout == LAYOUT_FILL) {
            if (!TextUtils.isEmpty(account)) {
                mEtAccount.setText(account);
            }
            if (!TextUtils.isEmpty(password)) {
                mEtPassword.setText(password);
            }
        }
    }
}
