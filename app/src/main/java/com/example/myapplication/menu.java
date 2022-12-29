package com.example.myapplication;

import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;

public class menu extends AppCompatActivity {
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
          getMenuInflater().inflate(R.menu.nav_menu,menu);
          return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id =item.getItemId();
           if(id  == R.id.settings){
         Intent intent=new Intent(getApplicationContext(),settings.class);
         startActivity(intent);
           }
       return true;
    }
}
