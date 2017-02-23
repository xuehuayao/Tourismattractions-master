package com.example.yaoxuehua.tourismattractionsapp.user;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.yaoxuehua.tourismattractionsapp.R;
import com.example.yaoxuehua.tourismattractionsapp.homepage.MainActivity;
import com.example.yaoxuehua.tourismattractionsapp.parent.activity.BaseLoginOrRegisterActivity;

/**
 * Created by yaoxuehua on 16-10-17.
 */

public class LoginActivity extends BaseLoginOrRegisterActivity {


    private EditText phoneNumber, password;
    private TextView register_now_textView, Retrieve_password_textView;
    private Button login_Button;


    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            //找回密码
            case R.id.Retrieve_password_textView:

                break;
            //立即注册
            case R.id.register_now_textView:

                intent = new Intent(this,RegisterActivity.class);
                startActivity(intent);
                break;
            //登陆
            case R.id.login_Button:

                intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;

        }

    }


    @Override
    protected int getLayoutResId() {
        return R.layout.login_activity;
    }

    @Override
    protected void initView() {

        setTitle("旅游旅行出行");
        phoneNumber = (EditText) findViewById(R.id.phone_editText);
        password = (EditText) findViewById(R.id.password_editText);
        register_now_textView = (TextView) findViewById(R.id.register_now_textView);
        Retrieve_password_textView = (TextView) findViewById(R.id.Retrieve_password_textView);
        login_Button = (Button) findViewById(R.id.login_Button);


    }

    @Override
    protected void initListener() {
        super.initListener();
        changeStatus(phoneNumber, "phone");
        changeStatus(password, "password");
        register_now_textView.setOnClickListener(this);
        Retrieve_password_textView.setOnClickListener(this);
        login_Button.setOnClickListener(this);

    }

    @Override
    protected void initData(Bundle savedInstanceState) {



    }

    /**
     * 改变登陆按钮颜色
     */
    public void changeButtonColor() {

        if (passwordJust && phoneJust) {

            login_Button.setBackgroundResource(R.drawable.content_bg_green);
        } else {

            login_Button.setBackgroundResource(R.drawable.content_bg_cyan);
        }
    }


}
