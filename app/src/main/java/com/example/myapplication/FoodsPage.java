package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class FoodsPage extends menu {
    public static ListView listView;
    public static ArrayAdapter<String> arrayAdapter;
    public static ArrayList<String> foods;
    public static MyDatabase myDatabase;
    public static Intent intent;
    public static String restaurantName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foods);
        intent = getIntent();
        restaurantName=intent.getStringExtra("restaurantName");
        listView = (ListView) findViewById(R.id.lv2);
        myDatabase = new MyDatabase(this);
        foods = myDatabase.getAllFoods(restaurantName);
        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, foods);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getBaseContext(), Update_or_delete_food.class);
                intent.putExtra("foodName", foods.get(i));
                startActivity(intent);
            }
        });
    }

    public void Onclick1(View view) {
        Intent addFoodIntent = new Intent(getBaseContext(), Add_food.class);
        addFoodIntent.putExtra("restaurantName",restaurantName);
        startActivity(addFoodIntent);
    }
    public void Onclick2(View view) {
        Intent addFoodIntent = new Intent(getBaseContext(), Update_or_delete_restaurant.class);
        addFoodIntent.putExtra("restaurantName",restaurantName);
        startActivityForResult(addFoodIntent,1);
    }
    public void onResume() {
        super.onResume();
        foods = myDatabase.getAllFoods(restaurantName);
        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, foods);
        listView.setAdapter(arrayAdapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        restaurantName=data.getStringExtra("restaurantName");
    }
}
