package com.example.perlmutter.storedata;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class HomeScreen extends AppCompatActivity {
    public Button makeNewSport;

    Spinner spin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homescreen);

        spin = (Spinner) findViewById(R.id.spinner);
        String sports[] = {"Track", "Soccer", "Basketball", "Swimming"};
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, sports);
        spin.setAdapter(adapter);
    }
    public void toSportStyle(View view) {
        Intent intent = new Intent(HomeScreen.this, SportStyle.class);
        startActivity(intent);
    }

    public String getSportName() {
        return "Swimming";
    }


}
