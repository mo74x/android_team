package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Foods extends AppCompatActivity {
    public static ListView listView;
    public static ArrayAdapter<String> arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foods);
        listView = (ListView) findViewById(R.id.lv2);
        String names[]={"a7a","a8a"};
        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, names);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getBaseContext(),Update_or_delete_food.class);
                startActivity(intent);
            }
        });
    }
    public void Onclick(View view){
        Intent intent = new Intent(getBaseContext(),Add_food.class);
        startActivity(intent);
    }
    }
