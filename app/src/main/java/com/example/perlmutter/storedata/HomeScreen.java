package com.example.perlmutter.storedata;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class HomeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homeScreen);
    }
    public void toSportStyle(View view) {
        Intent intent=new Intent(HomeScreen.this, SportStyle.class);
        startActivity(intent);
    }
}
