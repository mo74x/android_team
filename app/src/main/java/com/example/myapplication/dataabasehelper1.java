package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class dataabasehelper1 extends SQLiteOpenHelper {
    public static final String DB_NAME = "resturant.db";
    public static final int DB_VERSION = 1;
    public dataabasehelper1(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE foods(id INTEGER PRIMARY KEY AUTOINCREMENT,category TEXT,food TEXT,price INTEGER)");
        sqLiteDatabase.execSQL("CREATE TABLE restaurants(id INTEGER PRIMARY KEY AUTOINCREMENT,restaurant TEXT)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }
    public boolean insert_res(data restaurant){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("restaurant", restaurant.getRestaurant());
        long result = db.insert("restaurants", null, values);
        return result != -1;
    }
}
