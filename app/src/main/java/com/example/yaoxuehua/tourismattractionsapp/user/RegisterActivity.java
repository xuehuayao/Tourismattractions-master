package com.example.yaoxuehua.tourismattractionsapp.user;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.yaoxuehua.tourismattractionsapp.R;
import com.example.yaoxuehua.tourismattractionsapp.parent.activity.BaseLoginOrRegisterActivity;

/**
 * Created by yaoxuehua on 16-10-19.
 */

public class RegisterActivity extends BaseLoginOrRegisterActivity {


    private EditText phoneNumber, password;
    private Button register_Button;

    @Override
    public void onClick(View v) {
        super.onClick(v);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.register_activity;
    }

    @Override
    protected void initView() {

        phoneNumber = (EditText) findViewById(R.id.phone_editText);
        password = (EditText) findViewById(R.id.password_editText);
        register_Button = (Button) findViewById(R.id.register_Button);

    }

    @Override
    protected void initListener() {
        super.initListener();
        changeStatus(phoneNumber, "phone");
        changeStatus(password, "password");
        register_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    protected void initData(Bundle savedInstanceState) {

    }

    /**
     * 改变登陆按钮颜色
     */
    public void changeButtonColor() {

        if (passwordJust && phoneJust) {

            register_Button.setBackgroundResource(R.drawable.content_bg_green);
        } else {

            register_Button.setBackgroundResource(R.drawable.content_bg_cyan);
        }
    }
}
