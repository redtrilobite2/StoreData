package com.example.perlmutter.storedata;

import android.app.Activity;
import android.content.Intent;
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
        Controller aController = (Controller) getApplicationContext();
        ArrayList<String> sports = aController.allNames();
        Log.i("Ellie", Integer.toString(sports.size()));
        sports.add(0, "Select a sport");
        spin = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, sports);
        spin.setAdapter(adapter);
        spin.setOnItemSelectedListener(this);
    }

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

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }

    public void toSportStyle(View view) {
        Intent intent = new Intent(HomeScreen.this, CreateSport.class);
        startActivity(intent);
    }

    @Override
    public void onDestroy() {
        Log.i("Ellie", "In onDestroy");
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

}