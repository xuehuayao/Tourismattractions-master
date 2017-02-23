package com.example.yaoxuehua.tourismattractionsapp.parent.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.yaoxuehua.tourismattractionsapp.R;

/**
 * Created by yaoxuehua on 16-10-19.
 */

public class BaseTopBarActivity extends BaseActivity {
    @Override
    protected int getLayoutResId() {
        return 0;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initListener() {
        super.initListener();
        //多个页面很可能都会拥有的功能，封装进父类，进行封装复用，减少代码冗余，
        //回退操作
        ImageButton leftImageButton = (ImageButton) findViewById(R.id.back_btn);

        if (leftImageButton != null)
            leftImageButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
    }

    @Override
    protected void initData(Bundle savedInstanceState) {

    }
    /**
     * 动态设置各个页面标题
     * */
    protected void setTitle(String titleName){

        TextView title = (TextView) findViewById(R.id.title);
        if (title != null)
            title.setText(titleName);
    }
}
