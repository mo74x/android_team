package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Update_or_delete_food extends AppCompatActivity {
    private static TextView restaurant, name, description,price;
    private static Food curFood;
    private MyDatabase myDatabase;
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_or_delete_food);
        myDatabase=new MyDatabase(this);
        intent=getIntent();
        curFood=myDatabase.getFood(intent.getStringExtra("foodName"));
        restaurant=(TextView)findViewById(R.id.et1);
        restaurant.setText(curFood.getRestaurant());
        name=(TextView) findViewById(R.id.et2);
        name.setText(curFood.getName());
        description=(TextView) findViewById(R.id.et3);
        description.setText(curFood.getDescription());
        price=(TextView) findViewById(R.id.et4);
        price.setText(Integer.toString(curFood.getPrice()));
    }

    public void onclick1(View view) {
        myDatabase.updateFood(curFood,new Food(Integer.parseInt(price.getText().toString()),restaurant.getText().toString(),description.getText().toString(),name.getText().toString()));

    finish();
    }

    public void onclick2(View view) {
        myDatabase.deleteFood(curFood.getName());
    finish();
    }
}
