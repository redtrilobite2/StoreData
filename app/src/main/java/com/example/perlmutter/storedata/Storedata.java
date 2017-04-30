package com.example.perlmutter.storedata;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import static java.lang.Double.parseDouble;

public class Storedata extends AppCompatActivity {

    private CreateSport sports = new CreateSport();
    private HomeScreen name = new HomeScreen();
    private EditText sportName;
    static final int READ_BLOCK_SIZE = 200;
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

    public void saveData() {
        Controller aController = (Controller) getApplicationContext();
        Log.i("stop", "Entered into newEvent");
        thisSport = new Sport();

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
            Log.i("EllieSaveSport", event.toString());
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        try {
            ArrayList<String> print = new ArrayList<>();
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

        // EditText test = (EditText) findViewById(R.id.sportname);
        // ReadBtn(test);

    }

    public void ReadBtn(View v) throws IOException {
        //reading text from file
        try {
            FileInputStream fIn = openFileInput("NewSport.txt");
            InputStreamReader inRead = new InputStreamReader(fIn);


            char[] inputBuffer = new char[READ_BLOCK_SIZE];
            String s = "";
            int charRead;

            while ((charRead = inRead.read(inputBuffer)) > 0) {
                // char to string conversion
                String readString = String.copyValueOf(inputBuffer, 0, charRead);
                s += readString;
            }
            inRead.close();
            sportName.setText(s);
            Toast.makeText(getBaseContext(), s, Toast.LENGTH_SHORT).show();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


