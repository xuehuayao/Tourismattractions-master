package com.example.yaoxuehua.tourismattractionsapp.homepage.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.yaoxuehua.tourismattractionsapp.R;
import com.example.yaoxuehua.tourismattractionsapp.parent.activity.BaseActivity;
import com.example.yaoxuehua.tourismattractionsapp.parent.fragment.BaseFragment;
import com.example.yaoxuehua.tourismattractionsapp.utils.AnimationUtils;
import com.example.yaoxuehua.tourismattractionsapp.utils.RadomCountUtils;
import com.example.yaoxuehua.tourismattractionsapp.view.MyCircleMenu;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by yaoxuehua on 16-11-15.
 */

public class TourismRecommendFragment extends BaseFragment implements View.OnClickListener {


    private ImageView switchPictureTwo;

    private Timer timer;
    private Handler handler;
    private MyCircleMenu circle_menu;
    //图片数组
    private int[] imageViewPicture = new int[]{R.mipmap.one, R.mipmap.two, R.mipmap.three, R.mipmap.four, R.mipmap.five, R.mipmap.six, R.mipmap.seven, R.mipmap.eight
            , R.mipmap.nine, R.mipmap.ten, R.mipmap.eleven, R.mipmap.twelve, R.mipmap.thirteen, R.mipmap.fourteen, R.mipmap.fiveteen, R.mipmap.sixteen, R.mipmap.seventeen, R.mipmap.eighteen
            , R.mipmap.nineteen, R.mipmap.twenty, R.mipmap.twentyone, R.mipmap.twentytwo, R.mipmap.twentythree};
    private int arrLocation = 0;//图片数组位置

    @Override
    public void onClick(View v) {

    }

    @Override
    protected int getLayoutResId() {
        return R.layout.tourism_recommend_fragment;
    }

    @Override
    protected void initView() {

        switchPictureTwo = (ImageView) rootView.findViewById(R.id.switch_picture_two);
        circle_menu = (MyCircleMenu) rootView.findViewById(R.id.circle_menu);
        switchPictureTwo.setBackgroundResource(R.mipmap.one);

    }

    @Override
    protected void initData() {

        handler = new Handler() {

            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                switch (msg.what) {

                    case 0:

                        if (arrLocation < 22) {

                            arrLocation++;
                        } else {
                            arrLocation = 0;
                        }
                        switchAnamition(switchPictureTwo, imageViewPicture[arrLocation]);

                        break;
                }
            }
        };
        controlAnimation();

        circle_menu.setListener(new MyCircleMenu.CircleMenuListener() {
            @Override
            public void circleMenuButtonListener(MyCircleMenu.StatusSave statusSave) {
                Toast.makeText(getActivity(),statusSave.getWatchCount()+"",Toast.LENGTH_SHORT).show();
            }
        });

    }

    /**
     * 切换动画时间。连续性
     */
    public void controlAnimation() {

        final TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {

                Message message = handler.obtainMessage();
                message.what = 0;
                handler.sendMessage(message);
            }
        };
        if (timer == null) {
            timer = new Timer();
            timer.schedule(timerTask, 10000, 13000);
        }
    }

    /**
     * 切换动画
     */
    public void switchAnamition(final ImageView view, int picture) {

        AnimationUtils.setAnimations(view, picture);
    }

}
