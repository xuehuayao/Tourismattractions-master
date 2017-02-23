package com.example.yaoxuehua.tourismattractionsapp.utils;

import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;

/**
 * Created by yaoxuehua on 16-12-2.
 */

public class AnimationUtils {

    public static void setAnimations(final View view, final int picture){

        float x = RadomCountUtils.getRadomCount();
        float y = RadomCountUtils.getRadomCount();

        AnimationSet animationSet = new AnimationSet(true);
        AlphaAnimation alphaAnimation = new AlphaAnimation(1, 0);
        alphaAnimation.setDuration(3000);

        ScaleAnimation scaleAnimation = new ScaleAnimation(1,0.0f,1,0.0f,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        scaleAnimation.setDuration(3000);

        TranslateAnimation translateAnimation = new TranslateAnimation(Animation.RELATIVE_TO_SELF,0f,Animation.RELATIVE_TO_SELF,x,Animation.RELATIVE_TO_SELF,0f,Animation.RELATIVE_TO_SELF,y);
        translateAnimation.setDuration(3000);

        RotateAnimation rotateAnimation = new RotateAnimation(0,1440,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        rotateAnimation.setDuration(3000);
//        animationSet.

        animationSet.addAnimation(alphaAnimation);
        animationSet.addAnimation(scaleAnimation);
        animationSet.addAnimation(rotateAnimation);
        animationSet.addAnimation(translateAnimation);
        animationSet.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {


                view.setBackgroundResource(picture);
                AnimationSet animationSet1 = new AnimationSet(true);
                RotateAnimation rotateAnimation1 = new RotateAnimation(0,1440,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
                rotateAnimation1.setDuration(3000);
                ScaleAnimation scaleAnimation1 = new ScaleAnimation(0,1f,0,1f,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
                scaleAnimation1.setDuration(3000);
                AlphaAnimation alphaAnimation1 = new AlphaAnimation(0, 1);
                alphaAnimation1.setDuration(3000);
                animationSet1.addAnimation(alphaAnimation1);
                animationSet1.addAnimation(scaleAnimation1);
                animationSet1.addAnimation(rotateAnimation1);
                view.startAnimation(animationSet1);

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });


        view.startAnimation(animationSet);
    }
}
