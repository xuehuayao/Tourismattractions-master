package com.example.yaoxuehua.tourismattractionsapp.user;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.yaoxuehua.tourismattractionsapp.R;
import com.example.yaoxuehua.tourismattractionsapp.parent.activity.BaseLoginOrRegisterActivity;
import com.example.yaoxuehua.tourismattractionsapp.sql.MySQLite;
import com.example.yaoxuehua.tourismattractionsapp.sql.SqliteManager;
import com.example.yaoxuehua.tourismattractionsapp.sql.SqliteTableManager;
import com.example.yaoxuehua.tourismattractionsapp.user.bean.UserBean;

/**
 * Created by yaoxuehua on 16-10-19.
 */

public class RegisterActivity extends BaseLoginOrRegisterActivity {


    private EditText phoneNumber, password;
    private Button register_Button;
    private SQLiteDatabase db;

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

                insertUserInformation(phoneNumber.getText().toString(),Integer.parseInt(password.getText().toString()));

            }
        });
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

            register_Button.setBackgroundResource(R.drawable.content_bg_green);
        } else {

            register_Button.setBackgroundResource(R.drawable.content_bg_cyan);
        }
    }
    //向数据库放入数据
    public void insertUserInformation(String name,int password){

        String tableName = "user";
        SqliteTableManager sqliteTableManager = new SqliteTableManager(tableName,db);
        sqliteTableManager.isCreateSqlite();
        SqliteManager sqliteManager = new SqliteManager(db);
        UserBean userBean = new UserBean();
        userBean.setName(name);
        userBean.setPassword(password);
        sqliteManager.managerTableData(tableName,userBean);
        db.close();
        finish();
    }
}
