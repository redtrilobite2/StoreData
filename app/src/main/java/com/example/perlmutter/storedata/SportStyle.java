package com.example.perlmutter.storedata;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class SportStyle extends AppCompatActivity {
    private String name  = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sportstyle);
        //Sets the textview at the top of the screen to the name of the sport selected by the user
        TextView sportName=(TextView) findViewById(R.id.sport);
        Bundle bundle = getIntent().getExtras();
        name=bundle.getString("sportName");
        sportName.setText(name);
    }
    //Creates a new intent and goes to sport home
    //puts the name of the sport in the intent
    public void toSportHome(View view) throws IOException {
        TextView name = (TextView) findViewById(R.id.sport);
        if (!name.getText().toString().isEmpty()){

            Intent intent = new Intent(SportStyle.this, SportHome.class);
            String nameStr = name.getText().toString();
            intent.putExtra("sportName", nameStr);
            startActivity(intent);
        }
    }
    //when the app is closed this method saves the data from the ArrayLists of sports and events to a text file
    @Override
    public void onDestroy() {
        super.onDestroy();
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
}
