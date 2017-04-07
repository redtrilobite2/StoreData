package com.example.perlmutter.storedata;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by Ellie DeSota on 4/6/2017.
 */

public class SportHome extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sporthome);
    }
    //button controls
    public void toStoreData(View view) {
        Intent intent=new Intent(SportHome.this, Storedata.class);
        startActivity(intent);
    }

    public void toViewData (View view) {
        Intent intent=new Intent(SportHome.this, ViewData.class);
        startActivity(intent);
    }

    public void toHomeScreen(View view) {
        Intent intent=new Intent(SportHome.this, HomeScreen.class);
        startActivity(intent);
    }
}
