package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Update_or_delete_restaurant extends AppCompatActivity {
    private static Intent intent;
    private static EditText restaurant;
    private MyDatabase myDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_or_delete_restaurant);
        myDatabase = new MyDatabase(this);
        intent = getIntent();
        restaurant = findViewById(R.id.et1);
        restaurant.setText(intent.getStringExtra("restaurantName"));
    }

    public void onclick1(View view) {
        myDatabase.updateRestaurant(intent.getStringExtra("restaurantName"), restaurant.getText().toString());
        Intent returned = new Intent();
        returned.putExtra("restaurantName", restaurant.getText().toString());
        setResult(1, returned);
        finish();
    }

    public void onclick2(View view) {
        myDatabase.deleteRestaurant(intent.getStringExtra("restaurantName"));
        finish();
    }
}