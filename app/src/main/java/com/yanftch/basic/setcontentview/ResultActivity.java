package com.yanftch.basic.setcontentview;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.yanftch.basic.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ResultActivity extends AppCompatActivity {

    @BindView(R.id.tvHsow)
    TextView mTextView;
    private int type;
    private String info;


    public static void start(Context context, int type,String info) {
        Intent intent = new Intent(context, ResultActivity.class);
        intent.putExtra("type", type);
        intent.putExtra("info", info);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        ButterKnife.bind(this);
        type = getIntent().getIntExtra("type", 0);
        info=getIntent().getStringExtra("info");
        if (type == 1) {
            mTextView.setText("成功了"+ info);
        }
    }
}
