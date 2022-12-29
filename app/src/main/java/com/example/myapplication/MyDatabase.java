package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class MyDatabase extends SQLiteOpenHelper {
    public static final String DS_NAME = "test_db";
    public static final int DB_VERSION = 1;

    public MyDatabase(Context context) {
        super(context, DS_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE foods(id INTEGER PRIMARY KEY AUTOINCREMENT,restaurant TEXT,description TEXT,name TEXT UNIQUE,price INTEGER)");
        sqLiteDatabase.execSQL("CREATE TABLE restaurants(id INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT UNIQUE)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public boolean insertFood(Food food) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", food.getName());
        values.put("price", food.getPrice());
        values.put("description", food.getDescription());
        values.put("restaurant", food.getRestaurant());
        long result = db.insert("foods", null, values);
        return result != -1;
    }

    public boolean insertRestaurant(Restaurant restaurant) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", restaurant.getName());
        long result = db.insert("restaurants", null, values);
        return result != -1;
    }

    ArrayList<String> getAllRestaurants() {
        ArrayList<String> restaurants = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM restaurants", null);
        while (cursor.moveToNext()) {
            String name = cursor.getString(1);
            restaurants.add(name);
        }
        return restaurants;
    }

    ArrayList<String> getAllFoods(String restaurant) {
        ArrayList<String> foods = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        String args[] = {restaurant};
        Cursor cursor = db.rawQuery("SELECT * FROM foods where restaurant=?", args);
        while (cursor.moveToNext()) {
            String name = cursor.getString(3);
            foods.add(name);
        }
        return foods;
    }

    Food getFood(String food) {
        SQLiteDatabase db = getReadableDatabase();
        String args[] = {food};
        Cursor cursor = db.rawQuery("SELECT * FROM foods where name=?", args);
        cursor.moveToNext();
        int id = cursor.getInt(0);
        String restaurant = cursor.getString(1);
        String description = cursor.getString(2);
        String name = cursor.getString(3);
        int price = cursor.getInt(4);
        return new Food(id, price, restaurant, description, name);
    }

    public boolean updateRestaurant(String Old, String New) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", New);
        String args[] = {Old};
        Cursor cursor = db.rawQuery("SELECT * FROM foods", null);
        while (cursor.moveToNext()) {
            System.out.println(cursor.getString(3) + " " + cursor.getString(1));
        }
        int result = db.update("restaurants", values, "name=?", args);
        String args1[] = {New, Old};
        db.execSQL("UPDATE foods SET restaurant=? WHERE restaurant=?", args1);
        return result != 0;
    }

    public boolean deleteRestaurant(String restaurant) {
        SQLiteDatabase db = getWritableDatabase();
        String args[] = {restaurant};
        int result = db.delete("restaurants", "name=?", args);
        db.delete("foods", "restaurant=?", args);

        return result != 0;
    }

    public boolean updateFood(Food Old, Food New) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", New.getName());
        values.put("price", New.getPrice());
        values.put("description", New.getDescription());
        values.put("restaurant", New.getRestaurant());
        String args[] = {Old.getName()};
        int result = db.update("foods", values, "name=?", args);
        return result != 0;
    }

    public boolean deleteFood(String food) {
        SQLiteDatabase db = getWritableDatabase();
        String args[] = {food};
        int result = db.delete("foods", "name=?", args);
        return result != 0;
    }
}
