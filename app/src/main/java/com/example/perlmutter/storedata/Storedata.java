package com.example.perlmutter.storedata;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

import static java.lang.Double.parseDouble;

public class Storedata extends AppCompatActivity {

    CreateSport sports = new CreateSport();
    //ArrayList sport = sports.getSports();
    HomeScreen name = new HomeScreen();
    Sport thisSport;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storedata);
    }

    public void toViewData(View view) {
        Intent intent = new Intent(Storedata.this, ViewData.class);
        startActivity(intent);
        saveData();
    }

    public void toSportHome(View view) {
        Intent intent = new Intent(Storedata.this, SportHome.class);
        startActivity(intent);
        saveData();
    }

    public void saveData(){
        Controller aController = (Controller) getApplicationContext();
        Log.i("stop", "Entered into newEvent");
        thisSport = new Sport();

                EditText distancePull = (EditText) findViewById(R.id.distance);
                EditText timePull = (EditText) findViewById(R.id.time);
                EditText datePull = (EditText) findViewById(R.id.date);
                EditText commentPull = (EditText) findViewById(R.id.comment);

                String distanceStr = distancePull.getText().toString();
                String timeStr = timePull.getText().toString();
                String dateStr = datePull.getText().toString();
                String commentStr = commentPull.getText().toString();

                double distance = parseDouble(distanceStr);
                double time = parseDouble(timeStr);

                if (distance != 0 && time != 0 && !dateStr.equals("00/00/00")) {
                    Event event = new Event(time, distance, dateStr, commentStr);
                    aController.getSport("mySport").addEvent(event);
                    Log.i("Ellie", event.toString());
                }
//through spinner, bundle, intent
            }
        }


