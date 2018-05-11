package com.yanftch.basic.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.yanftch.basic.entity.ColumnBean;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Author : yanftch
 * Date : 2018/5/9
 * Time : 08:59
 * Desc : 自定义柱状图View
 */

/**
 * 绘制思路：
 * 第一步：先绘制最外层的边框
 */
public class ColumnView extends View {
    private final boolean DEBUG = true;


    private static final String TAG = "debug_ColumnView";
    private ArrayList<ColumnBean> list = new ArrayList<>();//数据集合
    private Context mContext;
    //边界线的颜色(灰色)
    private static final String LINECOLOR = "#666666";
    //虚线颜色
    private static final String DASHLINECOLOR = "#66999999";
    //文本颜色
    private static final String TEXTCOLOR = "#66666666";
    //负数颜色
    private static final String GREENCOLOR = "#048e63";
    //正数颜色
    private static final String REDCOLOR = "#f80d0d";
    //底部日期的背景色
    private static final String BOTTOMTIMEBGCOLOR = "#aaE2EBF9";
    //默认边距
    private final int MARGINLEFT = 20;
    private final int MARGINRIGHT = 20;
    private final int MARGINTOP = 40;
    private final int MARGINBOTTOM = 40;
    //默认字体大小
    private int textSize = 14;//px
    private int textSize30 = 30;//px
    //默认画笔宽度
    private int stockWidth = 3;


    //柱形图的数量
    private int columnNo = 7;
    //柱状图横向之间的间距
    private final int HORIZONTALSPACE = 20;
    //柱状图竖向之间的间距
    private int VERTICALSPACE = 20;
    //View的宽高
    private int height, width;
    //每个柱状图的宽度，默认值15吧
    private float columnWidth = 15;
    private boolean hasData = true;


    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        width = w - MARGINLEFT - MARGINRIGHT;
        height = h - MARGINTOP - MARGINBOTTOM;
        Log.i(TAG, "onSizeChanged: width = " + width + "              height = " + height);
        //重新计算每个柱的宽度
//        columnWidth =

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        setMeasuredDimension(widthSize, heightSize);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawBorders(canvas);
        drawTitle(canvas);
        if (hasData) {
            drawLeftText(canvas);
        }

    }

    /**
     * 绘制左边的文案
     * @param canvas
     */
    private void drawLeftText(Canvas canvas) {

    }

    /**
     * 获取集合数据中的最大值
     *
     * @return
     */
    private double getMaxValueInList() {
        int max = -1;
        if (list==null || list.isEmpty()){
            Toast.makeText(mContext, "暂无数据~", Toast.LENGTH_SHORT).show();
            return -1;
        }
        int size = list.size();
        double abs = Math.abs(list.get(0).getValue());
        for (int i = 0; i < size; i++) {
            double temp = Math.abs(list.get(i).getValue());
            if (temp > abs){
                abs = temp;
            }
        }
        return abs;
    }

    /**
     * 绘制标题
     * 最顶端绘制
     *
     * @param canvas
     */
    private void drawTitle(Canvas canvas) {
        Paint paint = getDefaultPaint();
        paint.setColor(Color.RED);
        paint.setDither(true);
        paint.setTextSize(20);
        paint.setStyle(Paint.Style.FILL);
        String title = "我是标题";
        canvas.drawText(title, (MARGINLEFT + width / 2 - (paint.measureText(title) / 2)), MARGINTOP - 10, paint);
    }

    /**
     * 绘制外边框
     *
     * @param canvas
     */
    private void drawBorders(Canvas canvas) {
        Paint defaultPaint = getDefaultPaint();
        Path path = new Path();
        //移动到左上角点
        path.moveTo(MARGINLEFT, MARGINTOP);
        //绘制上边框线
        path.lineTo(MARGINLEFT + width, MARGINTOP);
        //绘制右边线
        path.lineTo(MARGINLEFT + width, MARGINTOP + height);
        //绘制底边线
        path.lineTo(MARGINLEFT, MARGINTOP + height);
        //闭合
        path.close();
        canvas.drawPath(path, defaultPaint);
        //重置
        path.reset();
        defaultPaint.reset();
        //绘制虚线-DEBUG环境---等分
        if (DEBUG) {
            VERTICALSPACE = height / 6;//计算垂直间距。需求规定上边三，下边三
            for (int i = 0; i < 7; i++) {
                //计算出来横线起始点的Y坐标
                int dashStartEndLocation = MARGINTOP + VERTICALSPACE * i;
                canvas.drawLine(MARGINLEFT, dashStartEndLocation, MARGINLEFT + width, dashStartEndLocation, getDashLinePaint());
            }
        }
    }

    /**
     * 默认画笔
     *
     * @return Paint
     */
    private Paint getDefaultPaint() {
        Paint paint = new Paint();
        paint.setAntiAlias(true);//
        paint.setColor(Color.parseColor(LINECOLOR));
        paint.setStyle(Paint.Style.STROKE);//填充样式
        paint.setStrokeWidth(stockWidth);
        return paint;
    }

    /**
     * 虚线画笔
     *
     * @return Paint
     */
    private Paint getDashLinePaint() {
        Paint paint = getDefaultPaint();
        paint.setColor(Color.parseColor(DASHLINECOLOR));
        DashPathEffect effect = new DashPathEffect(new float[]{8, 8}, 1);//虚线
        paint.setPathEffect(effect);
        return paint;
    }


    public ColumnView(Context context) {
        this(context, null);
    }

    public ColumnView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, -1);
    }

    public ColumnView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
//        TypedArray a = context.obtainStyledAttributes();
//        if (a != null)
//            a.recycle();
        init();
    }

    private void init() {
        //不关闭，虚线可能画不出来
        setLayerType(View.LAYER_TYPE_SOFTWARE, null);//关闭硬件加速(三种方法，详见百度)

        list = getData();

    }

    /**---------------------------------对外方法-------------------------**/
    /**
     * 设置数据
     *
     * @param list List
     */
    public void setData(ArrayList<ColumnBean> list) {
        this.list = list;
        hasData = true;
//        mAnimator.animateY(mDuriation);
        postInvalidate();
    }

    public ArrayList<ColumnBean> getData() {
        ArrayList<ColumnBean> list = new ArrayList<ColumnBean>();
        for (int i = 0; i < 10; i++) {
            ColumnBean columnBean = new ColumnBean();
            double value = (10000 - ((Math.random() * 20000)));
            value = getDecimal(value);
            columnBean.setValue(value);
            if (i + 1 < 10) {
                columnBean.setDate("2011-11-0" + (i + 1));
            } else {
                columnBean.setDate("2011-11-" + (i + 1));
            }
            list.add(columnBean);
        }
        return list;
    }

    private double getDecimal(double value) {
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        return Double.parseDouble(decimalFormat.format(value));
    }
}
