package com.example.perlmutter.storedata;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class HomeScreen extends Activity implements AdapterView.OnItemSelectedListener {
    public Button makeNewSport;

    Spinner spin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homescreen);

        spin = (Spinner) findViewById(R.id.spinner);
        String sports[] = {"Select your sport","Track", "Soccer", "Basketball", "Swimming"};
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, sports);
        spin.setAdapter(adapter);
        spin.setOnItemSelectedListener(this);
    }
    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
        pos=spin.getSelectedItemPosition();
        if (pos!=0) {
            Intent intent = new Intent(HomeScreen.this, SportHome.class);
            startActivity(intent);

            TextView sportName=(TextView) findViewById(R.id.SportName);
            Spinner spin = (Spinner) findViewById(R.id.spinner);
            String text=spin.getSelectedItem().toString();
            sportName.setText(text);
        }
    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }
    public void toSportStyle(View view) {
        Intent intent = new Intent(HomeScreen.this, SportStyle.class);
        startActivity(intent);
    }

    public String getSportName() {
        return "Swimming";
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


}
