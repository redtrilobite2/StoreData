package com.example.perlmutter.storedata;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SportStyle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sportStyle);
    }
    public void toCreateSport(View view) {
        Intent intent=new Intent(SportStyle.this, CreateSport.class);
        startActivity(intent);
    }
}
