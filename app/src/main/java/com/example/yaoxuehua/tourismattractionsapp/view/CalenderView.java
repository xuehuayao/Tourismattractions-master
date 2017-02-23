package com.example.yaoxuehua.tourismattractionsapp.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by yaoxuehua on 16-11-17.
 */

public class CalenderView extends View {
    private String[] arr = new String[]{"1","2", "3" ,"4","5","6","7",
                                       "8","9", "10" ,"11","12","13","14",
                                       "15","16", "17" ,"18","19","20","21",
                                        "22","23", "24" ,"25","26","27","28","29","30"};
    private Activity activity;
    private int height;
    private int width;
    private int offset = 0;
    public CalenderView(Activity context) {
        super(context);
    }

    public CalenderView(Activity context, AttributeSet attrs) {
        super(context, attrs);
        height = context.getWindowManager().getDefaultDisplay().getHeight();
        width = context.getWindowManager().getDefaultDisplay().getWidth();
        offset = width / 7;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        setCalendarRectCount(canvas);
    }

    public void setCalendarRectCount(Canvas canvas){

        Paint paint = new Paint();
        Paint paintLine = new Paint();
        paint.setTextSize(14f);
        paint.setColor(Color.BLACK);
        paintLine.setColor(Color.BLACK);
        paint.setStrokeWidth(10);
        paintLine.setStrokeWidth(2);

        Paint paintCircle = new Paint();
        paintCircle.setColor(Color.GRAY);
        canvas.drawCircle(offset /2 ,20f,20f,paintCircle);
        for (int j= 0;j < arr.length;j++){

            for (int i = 0;i<7;i++){

                // 绘制一个矩形
                int offetNeed = offset * i;
                if (i == 0){

                    canvas.drawText("1",(float) (offset/2) ,20f,paint);
                }else {
                    canvas.drawText("1",(float) (offset/2)+offetNeed ,20f,paint);
                }
                canvas.drawLine(1,1,width,1f,paintLine);
                canvas.drawLine(1,40f,width,40f,paintLine);
                canvas.drawLine(1,0,1f,40f,paintLine);
            }
        }
        for (int i = 0;i<8;i++){
            canvas.drawLine(offset * i,0,offset * i,40f,paintLine);
        }
    }
}
