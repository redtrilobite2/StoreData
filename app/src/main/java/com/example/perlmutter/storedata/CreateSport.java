package com.example.perlmutter.storedata;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class CreateSport extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createSport);
    }
    public void toHomeScreen(View view) {
        Intent intent=new Intent(CreateSport.this, HomeScreen.class);
        startActivity(intent);
    }

    public void toStoreData(View view) {
        Intent intent=new Intent(CreateSport.this, SportHome.class);
        startActivity(intent);
    }
}
