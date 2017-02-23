package com.example.yaoxuehua.tourismattractionsapp.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by yaoxuehua on 16-12-1.
 * 禁止滑动的viewpager
 */

public class NoScrollViewPager extends ViewPager {

    private boolean noScroll;

    public NoScrollViewPager(Context context) {
        super(context);
    }

    public NoScrollViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setIfCanScorll(boolean scorll){
        this.noScroll = scorll;
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {

        if (noScroll){

            return false;
        }else {

            return super.onTouchEvent(ev);
        }
    }

    @Override
    public void scrollTo(int x, int y){
        if (noScroll){

            super.scrollTo(x, y);
        }
    }

    @Override
    public boolean onInterceptHoverEvent(MotionEvent event) {

        if (noScroll){

            return false;
        }else {

            return super.onInterceptHoverEvent(event);
        }
    }

    @Override
    protected boolean canScroll(View v, boolean checkV, int dx, int x, int y) {

        if(v.getClass().getName().equals("com.baidu.mapapi.map.TextureMapView")) {
            return true;
        }
        //if(v instanceof MapView){
        //    return true;
        //}
        return super.canScroll(v, checkV, dx, x, y);
    }
}
