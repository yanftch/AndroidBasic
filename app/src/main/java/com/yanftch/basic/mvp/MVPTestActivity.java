package com.yanftch.basic.mvp;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.yanftch.applibrary.net.MyTestBean;
import com.yanftch.basic.R;
import com.yanftch.basic.mvp.base.BaseMVPActivity;

/**
 * Author : yanftch
 * Date   : 2018/5/16
 * Time   : 10:55
 * Desc   :
 */

public class MVPTestActivity extends BaseMVPActivity<LoginContract.LoginView, LoginPresenter>
        implements LoginContract.LoginView {
    private static final String TAG = "dah_MVPTestActivity";
    Button mBtnGetHome;

    @Override
    protected void getData() {

    }

    @Override
    protected LoginPresenter createPresenter() {
        return new LoginPresenter();
    }

    @Override
    public int setLayout() {
        return R.layout.activity_mvptest;
    }

    @Override
    protected void initView() {
        mBtnGetHome = (Button) findViewById(R.id.btnGetHome);
        mBtnGetHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.checkInfo((MVPTestActivity) mContext,"n","1");
            }
        });
    }

    @Override
    public void checkPass() {
        Log.e(TAG, "checkPass: ");
    }

    @Override
    public void checkFail(String message) {
        Toast.makeText(this, "111:message===" + message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoginSuccess(MyTestBean myTestBean) {
        Toast.makeText(this, "" + myTestBean.getBannerList().get(0).getAdTitle().toString(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoginFailed(String failMsg) {
        Toast.makeText(this, "error===" + failMsg, Toast.LENGTH_SHORT).show();
    }
}
