package com.yanftch.applibrary.base.titlebar;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.yanftch.applibrary.R;

import java.util.List;


/**
 * Author : yanftch
 * Date : 2018/1/11
 * Time : 13:24
 * Desc :
 */

public class BaseTitleBarView extends RelativeLayout {
    private static final String TAG = "dah_BaseTitleBarView";
    private Context mContext;
    //左边按钮+文本  容器----返回的点击事件，要加载这个容器上边
    private FrameLayout title_left;
    //返回箭头图标
    private ImageView title_img_back;
    //左边文本
    private TextView title_left_text;
    //右边  容器
    private FrameLayout title_right;
    //右边  文本
    private TextView title_right_text;
    //右边图标  容器
    private LinearLayout title_buttons_container;

    //标题
    private TextView title_title;
    private static float density;

    public BaseTitleBarView(Context context) {
        super(context);
        mContext = context;
        init();
    }


    public BaseTitleBarView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        init();
    }

    public BaseTitleBarView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(getLayoutResId(), this);//添加自定义Layout
        title_left = (FrameLayout) findViewById(R.id.title_left);
        title_img_back = (ImageView) findViewById(R.id.title_img_back);
        title_left_text = (TextView) findViewById(R.id.title_left_text);
        title_right = (FrameLayout) findViewById(R.id.title_right);
        title_right_text = (TextView) findViewById(R.id.title_right_text);
        title_buttons_container = (LinearLayout) findViewById(R.id.title_buttons_container);
        title_title = (TextView) findViewById(R.id.title_title);
        DisplayMetrics dm = mContext.getApplicationContext().getResources().getDisplayMetrics();
        density = dm.density;
    }

    /**
     * 隐藏TitleBar
     */
    public void setBaseTitleBarViewGone() {
        this.setVisibility(GONE);
    }

    /**
     * 默认设置左边返回显示
     */
    public void setLeftContainerVisible() {
        title_left.setVisibility(VISIBLE);
    }

    /**
     * 使用BaseTitleBarOptions来设置样式内容
     */
    /*-------------------------------右边处理-----begin-------------------------------*/

    //处理右边的，比较复杂喽

    /**
     * 设置右边图片Button    点击事件
     * 只有图片Button，不显示文本的
     */
    public void setRightButtons(List<BaseTitleBarOptions.OptionsButton> buttons) {
        title_right.setVisibility(VISIBLE);
        title_right_text.setVisibility(GONE);
        title_buttons_container.setVisibility(VISIBLE);
        if (null != buttons && !buttons.isEmpty()) {
            int size = buttons.size();
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            for (final BaseTitleBarOptions.OptionsButton button : buttons) {
                ImageView imageView = new ImageView(mContext);
                imageView.setImageResource(button.iconId);
                //imageView.setBackgroundResource(R.drawable.title_bar_button_selector);//可以给设置选择器
                imageView.setPadding(dip2px(5), 0, dip2px(5), 0);
                imageView.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        button.onClick(mContext, v);
                    }
                });
                title_buttons_container.addView(imageView, params);
            }
        }
    }

    /**
     * 设置右边文本
     */
    public void setRightTitleText(String rightTitleText) {
        title_right_text.setText(rightTitleText);
        title_right_text.setVisibility(VISIBLE);
        title_right.setVisibility(VISIBLE);
        title_right.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mTitleBarClick) {
                    mTitleBarClick.onTitleRightTextPressed();
                }
            }
        });
        visible();
    }

    /**
     * 设置右边文本的字体颜色
     */
    public void setRightTitleTextColor(int color) {
        title_right_text.setVisibility(VISIBLE);
        title_right_text.setTextColor(color);
        title_right.setVisibility(VISIBLE);
        visible();
    }

    /**
     * 隐藏右边的文本
     */
    public void setRightTitleGone() {
        title_right_text.setVisibility(GONE);
        visible();
    }

    /**
     * 隐藏整个右边
     */
    public void setRightGone() {
        title_right.setVisibility(GONE);
        visible();
    }

    /**
     * 只显示右边的文本
     */
    public void setOnlyRightTitleVisible() {
        title_right.setVisibility(VISIBLE);
        title_right_text.setVisibility(VISIBLE);
        title_buttons_container.setVisibility(GONE);
        visible();
    }

    /*-------------------------------右边处理-----end-------------------------------*/

    /*-------------------------------左边处理-----begin-------------------------------*/
    public void setLeftGone() {
        title_left.setVisibility(INVISIBLE);
        visible();
    }

    /**
     * 设置左边文本
     */
    public void setLeftTitleText(String leftTitleText) {
        title_left_text.setText(leftTitleText);
        title_left.setVisibility(VISIBLE);
        title_left_text.setVisibility(VISIBLE);
        title_left.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mTitleBarClick) {
                    mTitleBarClick.onTitleLeftPressed();
                }
            }
        });
        visible();
    }

    /**
     * 设置左边文本字体颜色
     */
    public void setLeftTitleTextColor(int color) {
        title_left_text.setTextColor(color);
        title_left_text.setVisibility(VISIBLE);
        visible();
    }

    /**
     * 只显示左边的返回箭头，不显示文本
     */
    public void setLeftTitleGone() {
        title_left_text.setVisibility(GONE);
        title_left.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mTitleBarClick) {
                    mTitleBarClick.onTitleLeftPressed();
                }
            }
        });
        visible();
    }

    /**
     * 只显示左边的文本
     */
    public void setLeftIconGone() {
        title_img_back.setVisibility(GONE);
        title_left_text.setVisibility(VISIBLE);
        title_left.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mTitleBarClick) {
                    mTitleBarClick.onTitleLeftPressed();
                }
            }
        });
        visible();
    }

    /**
     * 设置左边的点击事件
     */
    public void addOnLeftTitleClickListener(OnClickListener onClickListener) {
        title_left.setVisibility(VISIBLE);
        title_left.setOnClickListener(onClickListener);
        visible();
    }

    public void setLeftDrawable(int drawable) {
        if (drawable != -1) {
            title_img_back.setBackgroundResource(drawable);
            title_left_text.setText("");
        }
        title_left.setVisibility(View.VISIBLE);
        title_left.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mTitleBarClick != null) {
                    mTitleBarClick.onTitleLeftPressed();
                }
            }
        });
        this.setVisibility(View.VISIBLE);
    }
    /*-------------------------------左边处理-----end-------------------------------*/

    /*-------------------------------Title处理-----begin-------------------------------*/

    /**
     * 设置居中标题Title
     */
    public void setTitleText(String title) {
        title_title.setText(title);
        title_title.setVisibility(VISIBLE);
        title_title.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mTitleBarClick) {
                    mTitleBarClick.onTitlePressed();
                }
            }
        });
        visible();
    }

    /**
     * 设置标题字体颜色
     */
    public void setTitleTextColor(int color) {
        title_title.setVisibility(VISIBLE);
        title_title.setTextColor(color);
        visible();
    }

    /**
     * Title点击监听
     */
    public void addOnTitleClickListener(OnClickListener clickListener) {
        title_title.setOnClickListener(clickListener);
    }

    /**
     * 设置TitleBar标题、右边文本
     *
     * @param titleText 标题文本
     * @param rightText 右边文本
     */
    public void setBaseTitleBar(String titleText, String rightText) {
        title_left.setVisibility(VISIBLE);
        title_img_back.setVisibility(VISIBLE);
        title_left_text.setVisibility(VISIBLE);
        title_title.setText(titleText);
        title_title.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mTitleBarClick) {
                    mTitleBarClick.onTitlePressed();
                }
            }
        });
        title_right_text.setText(rightText);
        title_right_text.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mTitleBarClick) {
                    mTitleBarClick.onTitleRightTextPressed();
                }
            }
        });
        title_left.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mTitleBarClick) {
                    mTitleBarClick.onTitleLeftPressed();
                }
            }
        });
    }
    /*-------------------------------Title处理-----end-------------------------------*/


    protected int getLayoutResId() {
        return R.layout.base_common_title_bar_layout;
    }


    /**
     * 点击监听
     */
    public interface TitleBarClick {
        /**
         * Title 点击
         */
        void onTitlePressed();

        /**
         * 左边点击(返回键的容器)
         */
        void onTitleLeftPressed();

        /**
         * 右边文本点击
         */
        void onTitleRightTextPressed();
    }

    private TitleBarClick mTitleBarClick;

    public void setTitleBarClick(TitleBarClick titleBarClick) {
        mTitleBarClick = titleBarClick;
    }

    private void visible() {
        this.setVisibility(VISIBLE);
    }

    private void gone() {
        this.setVisibility(GONE);
    }

    private void invisible() {
        this.setVisibility(INVISIBLE);
    }

    public static int dip2px(float dipValue) {
        return (int) (dipValue * density + 0.5f);
    }
}
