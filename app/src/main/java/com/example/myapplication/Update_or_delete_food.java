package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Update_or_delete_food extends AppCompatActivity {
    public static TextView category,food,price;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_or_delete_food);
        Intent intent = getIntent();
        category=(TextView)findViewById(R.id.category_v);
        food=(TextView)findViewById(R.id.food_v);
        price=(TextView)findViewById(R.id.price_v);

        }
    public void  onclickup(View view){
    }
    }
