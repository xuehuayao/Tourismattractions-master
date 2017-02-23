package com.example.yaoxuehua.tourismattractionsapp.view;

import android.content.Context;
import android.content.pm.ProviderInfo;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Message;
import android.provider.OpenableColumns;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.yaoxuehua.tourismattractionsapp.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import static java.lang.Math.sin;

/**
 * Created by yaoxuehua on 16-12-9.
 */

public class MyCircleMenu extends View {

    private int viewWidth = 0;//该控件宽
    private int viewHeight = 0;//该控件高
    private int child_radius = 0;
    private int circleMenu_big_radius = 0;//模拟大圆
    private int need_child_radius = 0;
    private int need_circleMenu_big_radius = 0;
    private String open = "open";
    private String close = "close";
    private String[] stringArr = new String[]{"出行", "门票", "农家院", "酒店", "路程规划"};
    private int[] circleColor = new int[]{Color.rgb(70, 0, 130), Color.rgb(34, 139, 34), Color.rgb(30, 144, 255), Color.RED, Color.rgb(255, 182, 193)};
    private List<StatusSave> statusSaveList = new ArrayList<>();
    private int CIRCLEMENU_OPEN_STATUS = 0;//打开的状态
    private int CIRCLEMENU_CLOSE_STATUS = 1;//关闭的哦状态
    private int CIRCLEMENU_CURRENT_STATUS = 1;//当前所处状态
    private int CIRCLEMENU_MOVE_STATUS = 2;//按钮移动状态
    private Timer timer;
    private int countChange = 8;
    private int distanceTime = 400;
    private int distanceEveryTime = 60;
    //中心按钮画笔
    private Paint circleCenterPaint;
    //文字颜色画笔
    private Paint circleCenterPaintText;


    private CircleMenuListener circleMenuListener;//按钮回调

    private Handler handler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {


                case 2:
                    need_child_radius = need_child_radius - child_radius * 2;
                    need_circleMenu_big_radius = need_circleMenu_big_radius - circleMenu_big_radius * 2;
                    invalidate();
                    break;
                case 3:
                    need_circleMenu_big_radius = 0;
                    need_child_radius = 0;
                    CIRCLEMENU_CURRENT_STATUS = CIRCLEMENU_CLOSE_STATUS;
                    invalidate();
                    break;
            }
        }
    };

    public MyCircleMenu(Context context) {
        super(context);
        child_radius = getResources().getDimensionPixelSize(R.dimen.circleMenu_child_radius);
    }

    public MyCircleMenu(Context context, AttributeSet attrs) {
        super(context, attrs);


        child_radius = getResources().getDimensionPixelSize(R.dimen.circleMenu_child_radius);
        circleMenu_big_radius = getResources().getDimensionPixelSize(R.dimen.circleMenu_big_radius);
//        controlAnimation();

    }

    //点击事件监听
    @Override
    public boolean onTouchEvent(MotionEvent event) {

        int currentX = (int) event.getX();
        int currentY = (int) event.getY();
        switch (event.getAction()) {

            //手指点击的坐标

            case MotionEvent.ACTION_DOWN:

                break;
            case MotionEvent.ACTION_MOVE:

                break;
            case MotionEvent.ACTION_UP:

                //关闭时
                if (CIRCLEMENU_CURRENT_STATUS == CIRCLEMENU_CLOSE_STATUS) {

                    //d当前圆面积
                    int currentAra = (int) (Math.pow((double) (currentX) - (viewWidth / 2), 2d) + Math.pow((double) (currentY) - (viewWidth / 2), 2d));
                    //判断圆
                    int centerCircleAra = (int) Math.pow((child_radius * 8), 2d);
                    if (centerCircleAra > Math.abs(currentAra)) {

//                        controlAnimation();
                        CIRCLEMENU_CURRENT_STATUS = CIRCLEMENU_OPEN_STATUS;
                        need_child_radius = 9 * child_radius;

                        need_circleMenu_big_radius = 9 * circleMenu_big_radius;
                        invalidate();
                    }
                } else {//打开时

                    //d当前圆面积
                    int currentAra = (int) (Math.pow((double) (currentX) - (viewWidth / 2), 2d) + Math.pow((double) (currentY) - (viewWidth / 2), 2d));
                    //判断圆
                    int centerCircleAra = (int) Math.pow((need_child_radius), 2d);
                    if (centerCircleAra > Math.abs(currentAra)) {

                        controlAnimation();
                    }
                    //按钮圆形面积与点击对比
                    StatusSave statusSave;
                    for (int i = 0; i < statusSaveList.size(); i++) {

                        statusSave = statusSaveList.get(i);
                        double btnWidth = statusSave.getWidthX();
                        double btnHeight = statusSave.getHeightY();
                        int currentBtnAra = (int) (Math.pow((double) (currentX) - (btnWidth), 2d) + Math.pow((double) (currentY) - (btnHeight), 2d));
                        if (centerCircleAra > currentBtnAra){
                            circleMenuListener.circleMenuButtonListener(statusSave);
                            break;
                        }

                    }


                }
                break;
        }


        return true;
//        return super.onTouchEvent(event);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        circleCenterPaint = new Paint();
        circleCenterPaintText = new Paint();
        circleCenterPaintText.setTextSize(25);
        circleCenterPaintText.setAntiAlias(true);
        if (CIRCLEMENU_CURRENT_STATUS == CIRCLEMENU_OPEN_STATUS) {

            openDrawCircleButton(canvas);
        } else {

            closeDrawCircleButton(canvas);
        }
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        viewHeight = h;
        viewWidth = w;
    }

    /**
     * 关闭中心按钮
     */
    public void closeDrawCircleButton(Canvas canvas) {

        circleCenterPaint.setColor(Color.GRAY);
        canvas.drawCircle(viewWidth / 2, viewHeight / 2, child_radius * 8, circleCenterPaint);
        //文字宽度
        int textWidth = getTextWidth(circleCenterPaintText, open);
        canvas.drawText(open, viewWidth / 2 - textWidth / 2, viewHeight / 2, circleCenterPaintText);

    }

    /**
     * 打开中心按钮
     */
    public void openDrawCircleButton(Canvas canvas) {


        Paint bigCircleCenterPaint = new Paint();

        circleCenterPaintText.setColor(Color.WHITE);
        bigCircleCenterPaint.setStyle(Paint.Style.STROKE);
        circleCenterPaint.setColor(Color.BLUE);
        //大型圆圈
        canvas.drawCircle(viewWidth / 2, viewHeight / 2, need_circleMenu_big_radius, bigCircleCenterPaint);
        double offsetDegree = 72;//72;144;216;288;360;
        statusSaveList.clear();
        StatusSave statusSave = new StatusSave();
        statusSave.setWidthX((float) (viewWidth / 2));
        statusSave.setHeightY((float) (viewHeight / 2));
        statusSaveList.add(statusSave);
        for (int i = 1; i < 6; i++) {
            double offsetWidth = Math.sin(offsetDegree * i * Math.PI / 180) * need_circleMenu_big_radius;
            double offsetHeight = Math.cos(offsetDegree * i * Math.PI / 180) * need_circleMenu_big_radius;

            circleCenterPaint.setColor(circleColor[i - 1]);
            circleCenterPaint.setAntiAlias(true);
            canvas.drawCircle((float) (viewWidth / 2 + offsetWidth), (float) (viewHeight / 2 - offsetHeight), need_child_radius, circleCenterPaint);
            //保存位置坐标
            StatusSave statusSaveChild = new StatusSave();
            statusSaveChild.setWidthX((float) (viewWidth / 2 + offsetWidth));
            statusSaveChild.setHeightY((float) (viewHeight / 2 - offsetHeight));
            statusSaveChild.setWatchCount(i);
            statusSaveList.add(statusSaveChild);


            //文字宽度
            int textWidthChild = getTextWidth(circleCenterPaintText, stringArr[i - 1]);
            circleCenterPaintText.setColor(Color.WHITE);
            canvas.drawText(stringArr[i - 1], (float) (viewWidth / 2 + offsetWidth) - textWidthChild / 2, (float) (viewHeight / 2 - offsetHeight), circleCenterPaintText);

        }


        circleCenterPaint.setColor(Color.GRAY);
        canvas.drawCircle(viewWidth / 2, viewHeight / 2, need_child_radius, circleCenterPaint);
        //文字宽度
        int textWidth = getTextWidth(circleCenterPaintText, close);
        canvas.drawText(close, viewWidth / 2 - textWidth / 2, viewHeight / 2, circleCenterPaintText);

    }


    /**
     * 精确测量文字的宽度
     */
    public int getTextWidth(Paint paint, String str) {
        int iRet = 0;
        if (str != null && str.length() > 0) {
            int len = str.length();
            float[] widths = new float[len];
            paint.getTextWidths(str, widths);
            for (int j = 0; j < len; j++) {
                iRet += (int) Math.ceil(widths[j]);
            }
        }
        return iRet;
    }

    /**
     * 渐变的时间效果
     */
    public void controlAnimation() {

        final TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {

                Message message = handler.obtainMessage();

                if (distanceEveryTime < distanceTime) {
                    distanceEveryTime = distanceEveryTime + 100;
                    message.what = 2;
                } else {
                    timer.cancel();
                    timer = null;
                    message.what = 3;
                    distanceEveryTime = 100;
                }
                handler.sendMessage(message);
            }
        };
        if (timer == null) {
            timer = new Timer();
        }

        timer.schedule(timerTask, 100, distanceEveryTime);
    }

    public void setListener(CircleMenuListener circleMenuListener) {

        this.circleMenuListener = circleMenuListener;
    }

    public interface CircleMenuListener {

        void circleMenuButtonListener(StatusSave statusSave);
    }

    public class StatusSave {

        float widthX;
        float heightY;
        int watchCount;//按钮编号

        public float getWidthX() {
            return widthX;
        }

        public void setWidthX(float widthX) {
            this.widthX = widthX;
        }

        public float getHeightY() {
            return heightY;
        }

        public void setHeightY(float heightY) {
            this.heightY = heightY;
        }

        public int getWatchCount() {
            return watchCount;
        }

        public void setWatchCount(int watchCount) {
            this.watchCount = watchCount;
        }
    }
}
