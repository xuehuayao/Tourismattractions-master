package com.example.yaoxuehua.tourismattractionsapp.parent.activity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.yaoxuehua.tourismattractionsapp.R;

/**
 * Created by yaoxuehua on 16-10-19.
 * <p>
 * 注册登陆页面的父类activity，封装该模块都会用到的功能，实现代码复用；
 * 如果以后模块扩展，更可以加入更多复用。提升性能,减少代码冗余,
 */

public class BaseLoginOrRegisterActivity extends BaseTopBarActivity implements View.OnClickListener {

    public boolean phoneJust, passwordJust;


    @Override
    public void onClick(View v) {

    }


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

    }

    @Override
    protected void initData(Bundle savedInstanceState) {

    }


    /**     相同代码，功能，抽取代码进入父类,实现复用,优化结构,使 子类 结构 更加 清晰      */


    /**
     * 增加双监听
     * viewNumber 控件名
     * tag 区分两个不同控件
     */
    public void changeStatus(EditText viewNumber, final String tag) {

        viewNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                justStatus(s, tag);

            }
        });

    }

    /**
     * 判断控件改变，确定是否可点击登陆
     */
    public void justStatus(Editable s, String tag) {

        if (tag.equals("phone")) {

            if (s.length() > 0) {

                phoneJust = true;
            } else {

                phoneJust = false;
            }

        } else if (tag.equals("password")) {

            if (s.length() > 0) {

                passwordJust = true;
            } else {
                passwordJust = false;
            }

        }

        changeButtonColor();

    }

    /**
     * 子类调用，实现不同子类的自个操作；（差异化）
     */
    public void changeButtonColor() {

    }

}