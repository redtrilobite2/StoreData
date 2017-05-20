package com.example.perlmutter.storedata;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.UUID;

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
                Integer sportStyle = Integer.parseInt(help.nextToken());
                sports.add(new Sport(sportName, sportComment, sportStyle));
                Log.i("EllieNextStyle", Integer.toString(sportStyle));


                aController.getSport(sportName).addEvent(new Event(Double.parseDouble(help.nextToken()), Double.parseDouble(help.nextToken()), help.nextToken(), help.nextToken()));

                // aController.allNames();
            }
            inRead.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

   /* public void setupUser(){
        Context context = this;
        SharedPreferences sharedPref = context.getSharedPreferences(
                getString(R.string.user_preferences_id), Context.MODE_PRIVATE);
int userID = sharedPref.getInt(fetStringR.string.user_id, null);
    }
*/
    //Creates a new intent and directs app to the home screen
    public void toHomeScreen(View view) {
        Intent intent = new Intent(WelcomeScreen.this, HomeScreen.class);
        startActivity(intent);
    }


}