package com.example.perlmutter.storedata;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class WelcomeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("EllieInOnCreate", "InOnCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcomescreen);
        //gets all of the saved data from the file and repopulates the sport and event ArrayLists with the data
        try {
            FileInputStream fIn = openFileInput("NewSport.txt");
            InputStreamReader inRead = new InputStreamReader(fIn);
            Scanner scan = new Scanner(inRead);
            final Controller aController = (Controller) getApplicationContext();
            Log.i("ellie", "PastController");
            ArrayList<Sport> sports = aController.getSports();

            while (scan.hasNextLine()) {
                Log.i("EllieInWhile", "In while loop");
                String lineString = scan.nextLine();
                StringTokenizer help = new StringTokenizer(lineString, ";;");
                String sportName = help.nextToken();
                String sportComment = help.nextToken();
                String sportStyle = help.nextToken();
                sports.add(new Sport(sportName, sportComment, sportStyle));
                Log.i("EllieNextStyle", sportStyle);

                aController.getSport(sportName).addEvent(new Event(Double.parseDouble(help.nextToken()), Double.parseDouble(help.nextToken()), help.nextToken(), help.nextToken()));

               // aController.allNames();
            }
            inRead.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //Creates a new intent and directs app to the home screen
    public void toHomeScreen(View view) {
        Intent intent = new Intent(WelcomeScreen.this, HomeScreen.class);
        startActivity(intent);
    }


}