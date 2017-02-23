package com.example.yaoxuehua.tourismattractionsapp.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by yaoxuehua on 16-11-18.
 * 该控件方便于是图片与文字可以共存，间距等可控
 */

public class MyTextView extends TextView {
    private Bitmap bitmapNeed;
    private String text;
    private int textViewWidth;
    private int textViewHeight;

    public MyTextView(Context context) {
        super(context);
    }

    public MyTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setBitmapAndSize(int drawble, String text) {

        this.text = text;
        Resources resources = getResources();
        Bitmap bitmap = BitmapFactory.decodeResource(resources, drawble);
        Matrix matrix = new Matrix();
        int pictureHeight = bitmap.getHeight();
        int pictureWidth = bitmap.getWidth();
        int newHeight = 20;
        int newWidth = 20;
        float scaleHeight = (float) newHeight / pictureHeight;
        float scaleWidth = (float) newWidth / pictureWidth;
        matrix.setScale(1f, 1f);
        this.bitmapNeed = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        setTextCanvas(canvas);
    }

    public void setTextCanvas(Canvas canvas){

        Paint paint = new Paint();
        paint.setTextAlign(Paint.Align.CENTER);
        String text = "全部";
        paint.setTextSize(25);

        int textWidth = getTextWidth(paint, text);
        int textHeight = getTextHeight(paint);
        canvas.drawText(text, textViewWidth / 2 - textWidth / 2, textViewHeight / 2, paint);
        setBitmapCanvas(canvas, textWidth, textHeight);
    }
    public void setBitmapCanvas(Canvas canvas, int textWidth, int textHeight) {

        textWidth = textWidth / 2;
        int bitmapWidth = bitmapNeed.getWidth();
        int bitmapHeight = bitmapNeed.getHeight();
        int left = textViewWidth / 2 - bitmapWidth / 2;
        int top = textViewHeight / 2 - bitmapHeight / 2;

        Paint paintBitmap = new Paint();
        Rect rectBitmap = new Rect(0, 0, bitmapWidth, bitmapHeight);
        Rect rectLocationForBitmap = new Rect(left + textWidth, top - textHeight / 4, left + bitmapWidth + textWidth, top + bitmapHeight- textHeight / 4);
        canvas.drawBitmap(bitmapNeed, rectBitmap, rectLocationForBitmap, paintBitmap);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        this.textViewWidth = w;
        this.textViewHeight = h;
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
     * 获取文字的高度
     */
    public int getTextHeight(Paint paint) {

        Paint.FontMetrics fm = paint.getFontMetrics();
        int textHeight = (int) (Math.ceil(fm.descent - fm.ascent) + 2);
        return textHeight;
    }

}
