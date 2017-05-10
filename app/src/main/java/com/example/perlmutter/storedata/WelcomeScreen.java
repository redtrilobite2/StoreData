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

        try {
            FileInputStream fIn = openFileInput("NewSport.txt");
            InputStreamReader inRead = new InputStreamReader(fIn);
            Scanner scan = new Scanner(inRead);
            Controller aController = (Controller) getApplicationContext();
            ArrayList<Sport> sports = aController.getSports();

            while (scan.hasNextLine()) {
                Log.i("EllieInWhile", "In while loop");
                String lineString = scan.nextLine();
                StringTokenizer help = new StringTokenizer(lineString, ";;");
                String sportName = help.nextToken();
                sports.add(new Sport(sportName, help.nextToken()));

                aController.getSport(sportName).addEvent(new Event(Double.parseDouble(help.nextToken()), Double.parseDouble(help.nextToken()), help.nextToken(), help.nextToken()));

                aController.allNames();
                Log.i("EllieHelp", aController.allNames().get(0));
            }
            inRead.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void toHomeScreen(View view) {
        Intent intent = new Intent(WelcomeScreen.this, HomeScreen.class);
        startActivity(intent);
    }


}