package com.example.perlmutter.storedata;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

import static java.lang.Double.parseDouble;

public class Storedata extends AppCompatActivity {

    /*private CreateSport sports = new CreateSport();
    private HomeScreen name = new HomeScreen();
    private EditText sportName;
    static final int READ_BLOCK_SIZE = 200;*/
    //Sport thisSport;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storedata);
      //  final Controller aController = (Controller) getApplicationContext();
        //String name=aController.allNames().get(aController.getInti());
        TextView sportName=(TextView) findViewById(R.id.SportName);
        Intent intent = getIntent();
        String name=intent.getStringExtra("sportName");
        sportName.setText(name);
    }

    public void toViewData(View view) {
        Intent intent = new Intent(Storedata.this, ViewData.class);
        startActivity(intent);
        saveData(view);
    }

    public void toSportHome(View view) {
        Intent intent = new Intent(Storedata.this, SportHome.class);
        startActivity(intent);
        saveData(view);
    }

    public void saveData(View view) {
        Controller aController = (Controller) getApplicationContext();
        Log.i("stop", "Entered into newEvent");

        EditText distancePull = (EditText) findViewById(R.id.distance);
        EditText timePull = (EditText) findViewById(R.id.time);
        EditText datePull = (EditText) findViewById(R.id.date);
        EditText commentPull = (EditText) findViewById(R.id.commentStoreData);

        String distanceStr = distancePull.getText().toString();
        String timeStr = timePull.getText().toString();
        String dateStr = datePull.getText().toString();
        String commentStr = commentPull.getText().toString();

        double distance = parseDouble(distanceStr);
        double time = parseDouble(timeStr);
        if (commentStr.equals("")) {
            commentStr = " ";
        }

        if (distance != 0 && time != 0 && !dateStr.equals("00/00/00")) {
            Event event = new Event(time, distance, dateStr, commentStr);
            aController.getSport("mySport").addEvent(event);
            Log.i("EllieSaveSport", aController.getSport("mySport").getEvent().toString());
            Log.i("Ellie", Integer.toString(aController.getSport("mySport").getEvent().size()));
        }


    }

    @Override
    public void onDestroy() {
        //super.onDestroy();
        try {
            ArrayList<String> print;
            FileOutputStream fOut = openFileOutput("NewSport.txt", MODE_PRIVATE);
            OutputStreamWriter outputWriter = new OutputStreamWriter(fOut);
            final Controller aController = (Controller) getApplicationContext();
            ArrayList sports = aController.getSports();
            PrintData printData = new PrintData(sports);
            Log.i("EllieCheck",Integer.toString(aController.getSport("mySport").getEvent().size())+" "+ Integer.toString(sports.size()));
            for (int i = 0; i < sports.size(); i++) {
                print = printData.print();
                outputWriter.write(print.get(i));
                Log.i("EllieWrite", print.get(i));
            }
            outputWriter.close();
            //display file
            Toast.makeText(getBaseContext(), (String) printData.print().get(1), Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

   /* @Override
    public void onStop() {
        super.onStop();
        try {
            ArrayList<String> print;
            FileOutputStream fOut = openFileOutput("NewSport.txt", MODE_PRIVATE);
            OutputStreamWriter outputWriter = new OutputStreamWriter(fOut);
            final Controller aController = (Controller) getApplicationContext();
            ArrayList sports = aController.getSports();
            PrintData printData = new PrintData(sports);
            for (int i = 0; i < aController.getSports().size(); i++) {
                print =  printData.print();
                outputWriter.write( print.get(i));
            }

            outputWriter.close();

            //display file
            Toast.makeText(getBaseContext(), (String) printData.print().get(1), Toast.LENGTH_LONG).show();
            Log.i("Ellie", (String) printData.print().get(1));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
*/
}


