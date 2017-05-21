package com.example.perlmutter.storedata;

import android.app.Activity;
import android.content.Intent;
import android.nfc.NfcAdapter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class HomeScreen extends Activity implements AdapterView.OnItemSelectedListener {

    Spinner spin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homescreen);
        //populates the spinner with the sports in the ArrayList of sports
        Controller aController = (Controller) getApplicationContext();
        ArrayList<String> sports = aController.allNames();
        Log.i("Ellie", Integer.toString(sports.size()));
        sports.add(0, "Select a sport");
        spin = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, sports);
        spin.setAdapter(adapter);
        spin.setOnItemSelectedListener(this);
    }
    //Creates a new intent and goes to the sport home screen when an item from the spinner is selected
    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
        final Controller aController = (Controller) getApplicationContext();
        pos = spin.getSelectedItemPosition();

        if (pos != 0) {
            Intent intent = new Intent(HomeScreen.this, SportHome.class);
            intent.putExtra("sportName", spin.getSelectedItem().toString());
            startActivity(intent);
            aController.setInti(pos);

        }
    }
    //does nothing when no item from the spinner is selected
    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }
    //creates a new intent and goes to the create sport screen
    public void toCreateSport(View view) {
        Intent intent = new Intent(HomeScreen.this, CreateSport.class);
        startActivity(intent);
    }
    //when the app is closed this method prints the sport data into a file
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
            Log.i("EllieCheck", sports.toString());
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

}