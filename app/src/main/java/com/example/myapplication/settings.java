package com.example.myapplication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class settings extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle save){
        super.onCreate(save);
        setContentView(R.layout.activity_settings);
        getSupportFragmentManager().beginTransaction().add(R.id.setframe,new settingsfreg()).commit();
    }

}
