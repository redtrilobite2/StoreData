package com.example.perlmutter.storedata;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class HomeScreen extends AppCompatActivity {
    public Button makeNewSport;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homescreen);
    }

    public void toSportStyle(View view) {
        Log.i("El", "In toSportStyle");
        Intent intent=new Intent(HomeScreen.this, SportStyle.class);
        startActivity(intent);
    }
}
