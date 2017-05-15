package com.example.perlmutter.storedata;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import static java.lang.Double.parseDouble;

public class DistanceBased extends AppCompatActivity {
    private String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_distance_based);
        TextView sportName=(TextView) findViewById(R.id.SportName);
        Bundle bundle=getIntent().getExtras();
        name=bundle.getString("sportName");
        sportName.setText(name);
    }
    public void toViewData(View view) {
        EditText distancePull = (EditText) findViewById(R.id.distance);
        EditText datePull = (EditText) findViewById(R.id.date);

        String distanceStr = distancePull.getText().toString();
        String dateStr = datePull.getText().toString();

        if(!distanceStr.isEmpty() && !dateStr.isEmpty()) {
            Intent intent = new Intent(DistanceBased.this, DistanceGraph.class);
            intent.putExtra("sportName", name);
            startActivity(intent);
        }
        saveData(view);
    }

    public void toSportHome(View view) {
        Intent intent = new Intent(DistanceBased.this, SportHome.class);
        intent.putExtra("sportName", name);
        startActivity(intent);
        saveData(view);
        //TextView sportName=(TextView) findViewById(R.id.SportName);

    }

    public void saveData(View view) {
        Controller aController = (Controller) getApplicationContext();
        Log.i("Ellie", "Entered into newEvent");
        TextView sportName=(TextView) findViewById(R.id.SportName);
        EditText distancePull = (EditText) findViewById(R.id.distance);
        EditText datePull = (EditText) findViewById(R.id.date);
        EditText commentPull = (EditText) findViewById(R.id.commentStoreData);

        String distanceStr = distancePull.getText().toString();
        String dateStr = datePull.getText().toString();
        String commentStr = commentPull.getText().toString();
        boolean print = true;
        if (commentStr.isEmpty()) {
            commentStr = " ";
        }
        if (distanceStr.isEmpty()) {
            Toast.makeText(getBaseContext(),"Please enter a distance", Toast.LENGTH_LONG).show();
            print = false;
        }
        if (dateStr.isEmpty()) {
            Toast.makeText(getBaseContext(),"Please enter a date", Toast.LENGTH_LONG).show();
            print = false;
        }


        if (print) {
            double distance = parseDouble(distanceStr);

            Event event = new Event(distance, dateStr, commentStr);
            aController.getSport(sportName.getText().toString()).addEvent(event);
            Log.i("EllieSaveSport", aController.getSport(sportName.getText().toString()).getEvent().toString());
            Log.i("Ellie", Integer.toString(aController.getSport(sportName.getText().toString()).getEvent().size()));
        }


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

