package com.yanftch.basic.test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.SeekBar;

import com.yanftch.basic.R;
import com.yanftch.basic.diy_view.view.DiyView;
import com.yanftch.basic.diy_view.view.DiyViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TestActivity extends AppCompatActivity {
    private static final String TAG = "dah_TestActivity";
    @BindView(R.id.seekBar)
    SeekBar mSeekBar;
    @BindView(R.id.myView)
    DiyView mMyView;
    @BindView(R.id.myViewGroup)
    DiyViewGroup mMyViewGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        ButterKnife.bind(this);
        mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int size = progress * 7;
                Log.e(TAG, "onProgressChanged: progress===" + size);
                ViewGroup.LayoutParams layoutParams = mMyView.getLayoutParams();
                layoutParams.height = size;
                mMyView.setLayoutParams(layoutParams);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

}
