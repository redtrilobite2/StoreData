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
/**
 * This class allows users to input data for time and distance based sports. It also allows users to transition to either
 * the ViewData interface or SportHome
 */
public class Storedata extends AppCompatActivity {
    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storedata);
        TextView sportName = (TextView) findViewById(R.id.SportName);
        Bundle bundle = getIntent().getExtras();
        name = bundle.getString("sportName");
        sportName.setText(name);
    }
    /**
     * This method pulls the data that the user inputs into the edit text boxes and transitions to ViewData if
     * the distance, time, and date edit texts are filled in. It also calls the saveData method.
     * @param view builds the user interface and widgets in the app
     */
    public void toViewData(View view) {
        EditText distancePull = (EditText) findViewById(R.id.distance);
        EditText timePull = (EditText) findViewById(R.id.time);
        EditText datePull = (EditText) findViewById(R.id.date);

        String distanceStr = distancePull.getText().toString();
        String timeStr = timePull.getText().toString();
        String dateStr = datePull.getText().toString();

        if (!distanceStr.isEmpty() && !timeStr.isEmpty() && !dateStr.isEmpty()) {
            Intent intent = new Intent(Storedata.this, ViewData.class);
            intent.putExtra("sportName", name);
            startActivity(intent);
        }
        saveData(view, 2);
    }
    /**
     * This method allows the user to transition to Sport Home. It also puts the sport name as an extra in the intent and calls
     * the saveData method.
     * @param view builds the user interface and widgets in the app
     */
    public void toSportHome(View view) {
        Intent intent = new Intent(Storedata.this, SportHome.class);
        intent.putExtra("sportName", name);
        startActivity(intent);
        saveData(view, 1);
    }
    /**
     * This method saves the user's inputted data. However, if the user does not input the distance, time, or date, the method
     * creates a toast that asks the user to input the missing information.
     * @param view builds the user interface and widgets in the app
     */
    public void saveData(View view, int delin) {
        Controller aController = (Controller) getApplicationContext();
        Log.i("Ellie", "Entered into newEvent");
        TextView sportName = (TextView) findViewById(R.id.SportName);
        EditText distancePull = (EditText) findViewById(R.id.distance);
        EditText timePull = (EditText) findViewById(R.id.time);
        EditText datePull = (EditText) findViewById(R.id.date);
        EditText commentPull = (EditText) findViewById(R.id.commentStoreData);

        String distanceStr = distancePull.getText().toString();
        String timeStr = timePull.getText().toString();
        String dateStr = datePull.getText().toString();
        String commentStr = commentPull.getText().toString();
if(delin == 1 && commentStr.isEmpty() && distanceStr.isEmpty() && timeStr.isEmpty() && dateStr.isEmpty()){
    Intent intent = new Intent(Storedata.this, SportHome.class);
    intent.putExtra("sportName", name);
    startActivity(intent);
}
        boolean print = true;
        if (commentStr.isEmpty()) {
            commentStr = " ";
        }
        if (distanceStr.isEmpty()) {
            Toast.makeText(getBaseContext(), "Please enter a distance", Toast.LENGTH_LONG).show();
            print = false;
        }
        if (timeStr.isEmpty()) {
            Toast.makeText(getBaseContext(), "Please enter a time", Toast.LENGTH_LONG).show();
            print = false;
        }
        if (dateStr.isEmpty()) {
            Toast.makeText(getBaseContext(), "Please enter a date", Toast.LENGTH_LONG).show();
            print = false;
        }


        if (print) {
            double distance = parseDouble(distanceStr);
            double time = parseDouble(timeStr);

            Event event = new Event(time, distance, dateStr, commentStr);
            aController.getSport(sportName.getText().toString()).addEvent(event);
            Log.i("EllieSaveSport", aController.getSport(sportName.getText().toString()).getEvents().toString());
            Log.i("Ellie", Integer.toString(aController.getSport(sportName.getText().toString()).getEvents().size()));
        }


    }
    /**
     * This method is called when the app is closed. It prints the inputted data into a text file so that when the app is closed,
     * the data will persist.
     */
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


