package com.example.yaoxuehua.tourismattractionsapp.sql;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.yaoxuehua.tourismattractionsapp.user.bean.UserBean;

/**
 * Created by Administrator on 2017/2/24.
 * 做增删该查操作
 * 向不同的表中插入数据
 */

public class SqliteManager {

    private SQLiteDatabase DB;

    public SqliteManager(SQLiteDatabase DB) {
        this.DB = DB;
    }

    //分表管理数据
    public void managerTableData(String table ,UserBean userBean){

        switch (table){
            case "user":
                insertdataforUser(table,userBean);
                break;
        }


    }

    //向用户表中插入数据
    public void insertdataforUser(String table ,UserBean userBean){
//        ContentValues values = new ContentValues();
//        values.put("name",userBean.getName());
//        values.put("password",userBean.getPassword());
//        DB.insert("user",null,values);
        DB.execSQL("insert into "+table+"(name, password) values("+userBean.getName()+","+userBean.getPassword()+")");
    }

}
