package com.example.yaoxuehua.tourismattractionsapp.user;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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
    private SQLiteDatabase db;


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

                String name = phoneNumber.getText().toString();
                String password = phoneNumber.getText().toString();
                Cursor cursor = db.rawQuery("SELECT * FROM user WHERE name = ?",new String[]{name});
                int length = cursor.getColumnCount();
                if (length == 0){
                    Toast.makeText(this,"没有这个数据",Toast.LENGTH_SHORT).show();
                    return;
                }
                while (cursor.moveToNext()){

                    int userPassword = cursor.getInt(cursor.getColumnIndex("password"));
                    if (userPassword == Integer.parseInt(password)){

                        intent = new Intent(this, MainActivity.class);
                        startActivity(intent);
                        db.close();
                    }
                }

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


        //打开或者创建数据库
        db = openOrCreateDatabase("db_user_table", Context.MODE_PRIVATE,null);

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
