package com.example.perlmutter.storedata;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeScreen extends AppCompatActivity {
    public Button makeNewSport;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homescreen);
    }

    public void init(){
        makeNewSport = (Button)findViewById(R.id.makeNewSport);
        makeNewSport.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                Intent toy = new Intent(HomeScreen.this, SportStyle.class);
                startActivity(toy);
            }

        });

    }
    public void toSportStyle(View view) {
        Intent intent=new Intent(HomeScreen.this, SportStyle.class);
        startActivity(intent);
        init();
    }
}
