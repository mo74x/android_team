package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Add_food extends AppCompatActivity {
    public static MyDatabase myDatabase;
    public static Intent intent;
    public static EditText name;
    public static EditText restaurant;
    public static EditText description;
    public static EditText price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_food);
        myDatabase = new MyDatabase(this);
        restaurant = findViewById(R.id.et1);
        name = findViewById(R.id.et2);
        description = findViewById(R.id.et3);
        price = findViewById(R.id.et4);
        intent = getIntent();
        restaurant.setText(intent.getStringExtra("restaurantName"));
    }

    public void onclick(View view) {
        myDatabase.insertFood(new Food(Integer.parseInt(price.getText().toString()), restaurant.getText().toString(), description.getText().toString(), name.getText().toString()));
        finish();
    }
}