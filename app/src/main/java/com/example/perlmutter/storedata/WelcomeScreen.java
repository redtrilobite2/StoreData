package com.example.perlmutter.storedata;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class WelcomeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcomeScreen);
    }
    public void toHomeScreen(View view) {
        Intent intent=new Intent(WelcomeScreen.this, HomeScreen.class);
        startActivity(intent);
    }
}
