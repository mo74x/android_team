package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Add_restaurant extends AppCompatActivity {
public static dataabasehelper1 mydb;
public  static TextView res_name;

    public static ArrayAdapter<String> arrayAdapter;
    public static ArrayList<String> names;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_restaurant);
        mydb=new dataabasehelper1(this);
        res_name=(TextView) findViewById(R.id.add_res);




    }
    public void onclick_res(View view){

    }
}