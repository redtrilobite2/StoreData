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
 */

public class SportHome extends AppCompatActivity {
    private String name  = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sporthome);
        TextView sportName=(TextView) findViewById(R.id.SportName);
        Bundle bundle = getIntent().getExtras();
        name=bundle.getString("sportName");
        sportName.setText(name);

    }

    //button controls
    public void toStoreData(View view) {
        final Controller aController = (Controller) getApplicationContext();
        TextView sportName=(TextView) findViewById(R.id.SportName);
        String name = sportName.getText().toString();
        Log.i("EllieNull", name);
        String sport = aController.getSport(name).getStyle();
        if(sport.equals("time_distance")){
            Intent intent = new Intent(SportHome.this, Storedata.class);
            intent.putExtra("sportName", sportName.getText());
            startActivity(intent);
        }else if(sport.equals("time")) {
            Intent intent = new Intent(SportHome.this, TimeBased.class);
            intent.putExtra("sportName", sportName.getText());
            startActivity(intent);
        }else if(sport.equals("distance")){
            Intent intent = new Intent(SportHome.this, DistanceBased.class);
            intent.putExtra("sportName", sportName.getText());
            startActivity(intent);
        }else if(sport.equals("accuracy")){
            Intent intent = new Intent(SportHome.this, AccuracyBased.class);
            intent.putExtra("sportName", sportName.getText());
            startActivity(intent);
        }
        }



    public void toViewData(View view) {
        Intent intent = new Intent(SportHome.this, ViewData.class);
        intent.putExtra("sportName", name);
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
            Log.i("EllieSportToString", sports.toString());
            for (int i = 0; i < sports.size(); i++) {
                print = printData.print();
                outputWriter.write(print.get(i));
                Log.i("EllieSport@i", print.get(i));
            }
            outputWriter.close();
            //display file
            Toast.makeText(getBaseContext(), (String) printData.print().get(1), Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
