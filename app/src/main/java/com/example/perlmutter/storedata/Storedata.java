package com.example.perlmutter.storedata;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

import static java.lang.Double.parseDouble;

public class Storedata extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storedata);
    }
    /*public void SaveData(View view){
        EditText number1 = (EditText) findViewById(R.id.data1);
        EditText number2 = (EditText) findViewById(R.id.data2);


        String num1str =  number1.getText().toString();
        String num2str =  number2.getText().toString();
        Double num1 = parseDouble(num1str);
        Double num2 = parseDouble(num2str);

        ArrayList<Double> num1s = new ArrayList<Double>();
        ArrayList<Double> num2s = new ArrayList<Double>();

        num1s.add(num1);
        num2s.add(num2);

    }
    public void ViewData(View view){

    }*/

    public void toHomeScreen(View view) {
        Intent intent = new Intent(Storedata.this, HomeScreen.class);
        startActivity(intent);
    }

    public void toSportHome(View view) {
        Intent intent = new Intent(Storedata.this, SportHome.class);
        startActivity(intent);
    }

    public void addEvent() {
        Sport sport = new Sport("Distance/time", "This is a comment");
        EditText distancePull = (EditText) findViewById(R.id.distance);
        EditText timePull = (EditText) findViewById(R.id.time);
        EditText datePull = (EditText) findViewById(R.id.date);
        EditText commentPull = (EditText) findViewById(R.id.comment);


        String distanceStr = distancePull.getText().toString();
        String timeStr = timePull.getText().toString();
        String dateStr = datePull.getText().toString();
        String commentStr = commentPull.getText().toString();
        Double distance = parseDouble(distanceStr);
        Double time = parseDouble(timeStr);
        Event event = new Event(time, distance, dateStr, commentStr);
        sport.addEvent(event);
    }
}
