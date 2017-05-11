package com.example.perlmutter.storedata;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

/**
 * Created by Ellie DeSota on 4/6/2017.
 * Will add comments
 */

public class SportHome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sporthome);

        //final Controller aController = (Controller) getApplicationContext();
       // String name=aController.allNames().get(aController.getInti());
        TextView sportName=(TextView) findViewById(R.id.SportName);
        Bundle bundle=getIntent().getExtras();
        String name=bundle.getString("sportName");
        sportName.setText(name);

    }

    //button controls
    public void toStoreData(View view) {
        TextView sportName=(TextView) findViewById(R.id.SportName);
        Intent intent = new Intent(SportHome.this, Storedata.class);
        intent.putExtra("sportName", sportName.getText().toString());
        startActivity(intent);
    }

    public void toViewData(View view) {
        Intent intent = new Intent(SportHome.this, ViewData.class);
        startActivity(intent);
    }

    public void toHomeScreen(View view) {
        Intent intent = new Intent(SportHome.this, HomeScreen.class);
        startActivity(intent);

    }

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

    /*public void setTextView (View view){
        TextView sportName=(TextView) findViewById(R.id.SportName);
        Spinner spin = (Spinner) findViewById(R.id.spinner);
        String text=spin.getSelectedItem().toString();
        sportName.setText(text);
    }*/

   /* @Override
    public void onStop() {
        super.onStop();
        try {
            ArrayList<String> print;
            FileOutputStream fOut = openFileOutput("NewSport.txt", MODE_PRIVATE);
            OutputStreamWriter outputWriter = new OutputStreamWriter(fOut);
            final Controller aController = (Controller) getApplicationContext();
            ArrayList sports = aController.getSports();
            PrintData printData = new PrintData();
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
