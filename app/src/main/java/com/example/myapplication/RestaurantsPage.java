package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class RestaurantsPage extends menu  {
    public static ListView listView;
    public static ArrayAdapter<String> arrayAdapter;
    public static ArrayList<String> restaurants;
    public static MyDatabase myDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants);
        listView = (ListView) findViewById(R.id.lv1);
        myDatabase=new MyDatabase(this);
        restaurants=myDatabase.getAllRestaurants();
        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, restaurants);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getBaseContext(), FoodsPage.class);
                intent.putExtra("restaurantName", restaurants.get(i));
                startActivity(intent);
            }
        });
    }

    public void  Onclick(View view){
        Intent intent = new Intent(getBaseContext(), Add_restaurant.class);
        startActivity(intent);
    }
    public void onResume() {
        super.onResume();
        restaurants = myDatabase.getAllRestaurants();
        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, restaurants);
        listView.setAdapter(arrayAdapter);
    }
}