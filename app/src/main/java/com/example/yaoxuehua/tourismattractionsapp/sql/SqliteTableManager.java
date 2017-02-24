package com.example.yaoxuehua.tourismattractionsapp.sql;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Administrator on 2017/2/24.
 * 管理多个表
 */

public class SqliteTableManager {

    private String tableName = "";
    private SQLiteDatabase db;
    private String paramater = "";//例如：,username VARCHAR, password SMALLINT
    //想要的表名
    public SqliteTableManager(String tableName,SQLiteDatabase db) {
        this.tableName = tableName;
        this.db = db;
    }
    //创建表的相关条件
    public void SqliteTableParameter(String paramater ){

        this.paramater = paramater;
    }

    //通过数据库建立表
    public void isCreateSqlite(){
        //打开或创建test.db数据库
        db.execSQL("DROP TABLE IF EXISTS "+tableName);
        //创建person表
        db.execSQL("CREATE TABLE "+tableName+" (_id INTEGER PRIMARY KEY AUTOINCREMENT, username VARCHAR, password SMALLINT"+paramater+")");
    }
    //通过数据库做该表的增删改查

    public void insertUserDataForSqlite(){


    }
}
