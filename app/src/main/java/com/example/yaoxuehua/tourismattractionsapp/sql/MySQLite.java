package com.example.yaoxuehua.tourismattractionsapp.sql;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by yaoxuehua on 16-11-15.
 */

public class MySQLite extends SQLiteOpenHelper {

    private static final String DB_userTable = "db_user_table";
    private static final int DB_version = 1;
    private String Sqlite_tableName = "";

    public MySQLite(Context context, String DB_name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DB_userTable, factory, DB_version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

//        db.execSQL("CREATE TABLE IF NOT EXISTS person" +
//                "(_id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR, password INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("ALTER TABLE person ADD COLUMN other STRIN");
    }



    //ddddd
    //dddd
}
