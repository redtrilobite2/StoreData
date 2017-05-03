package com.example.perlmutter.storedata;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.io.FileInputStream;
//import java.io.FileOutputStream;
import java.io.InputStreamReader;
//import java.io.OutputStreamWriter;
//import java.io.StringBufferInputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class WelcomeScreen extends AppCompatActivity {

    private static final int READ_BLOCK_SIZE = 200;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcomescreen);
    }

    public void toHomeScreen(View view) {
        Intent intent = new Intent(WelcomeScreen.this, HomeScreen.class);
        startActivity(intent);
    }

    /*@Override
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
                print = printData.print();
                outputWriter.write(print.get(i));
            }

            outputWriter.close();

            //display file
            Toast.makeText(getBaseContext(), (String) printData.print().get(1), Toast.LENGTH_LONG).show();
            Log.i("Ellie", (String) printData.print().get(1));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/

   /* @Override
    public void onStart() {
        super.onStart();
        //reading text from file
        try {
            FileInputStream fIn = openFileInput("NewSport.txt");
            InputStreamReader inRead = new InputStreamReader(fIn);
            Scanner scan = new Scanner(inRead);
            Controller aController = new Controller();
            ArrayList<Sport> sports = aController.getSports();

            while (scan.hasNextLine()) {
                String lineString = scan.nextLine();
                StringTokenizer help = new StringTokenizer(lineString, ";;");
                Log.i("EllieHelp", help.nextToken());


            }/*

                String sportName = scan.next();
                for (int i = 0; i < sports.size(); i++) {
                    if (!sportName.equalsIgnoreCase(sports.get(i).getName())) {
                        return;
                    } else {

                    }
                }
                while (scan.hasNext()) {
                    if (scan.next().equals(";;")) {

                    }
                }
            }
            inRead.close();
            Toast.makeText(getBaseContext(), aController.getSport("mysport").getEvent().toString(), Toast.LENGTH_SHORT).show();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/
}
