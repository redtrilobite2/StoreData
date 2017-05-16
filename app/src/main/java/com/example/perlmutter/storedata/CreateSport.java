package com.example.perlmutter.storedata;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class CreateSport extends Activity implements AdapterView.OnItemSelectedListener {
    private int pos;
    Spinner spin;
    String sportStyle;
    ArrayList<String> styles = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //populates a spinner with the different styles of sports
        setContentView(R.layout.activity_createsport);
        styles.add("Select a Sport Type");
        styles.add("Time-Distance Based");
        styles.add("Time Based");
        styles.add("Distance Based");
        styles.add("Accuracy Based");
        styles.add("Point Based");
        Log.i("Ellie", Integer.toString(styles.size()));
        spin = (Spinner) findViewById(R.id.sportStyleSpinner);
        ArrayAdapter<CharSequence> adapter = new ArrayAdapter(CreateSport.this, android.R.layout.simple_spinner_item, styles);
        spin.setAdapter(adapter);
        spin.setOnItemSelectedListener(this);
        //EditText sportName = (EditText) findViewById(R.id.sportname);
    }

    //when an item from the spinner is called, this method gets the position of that item and assigns it
    //to a style of sport
    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {

        pos = spin.getSelectedItemPosition();

        if (pos == 1) {
            sportStyle = "time_distance";
        } else if (pos == 2) {
            sportStyle = "time";
        } else if (pos == 3) {
            sportStyle = "distance";
        } else if (pos == 4) {
            sportStyle = "accuracy";
        } else if (pos == 5) {
            sportStyle = "point";
        }
    }

    //doees nothing when no item from the spinner is called
    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }

    //creates new intent and goes to the home screen
    public void toHomeScreen(View view) throws IOException {
        Intent intent = new Intent(CreateSport.this, HomeScreen.class);
        startActivity(intent);
    }

    //creates new intent and goes to the sport home screen
    public void toSportHome(View view) throws IOException {
        Boolean add = true;
        Controller aController = (Controller) getApplicationContext();
        EditText name = (EditText) findViewById(R.id.sportname);
        String namestr = name.getText().toString();
        for (int i = 0; i < aController.getSports().size(); i++) {
            if (aController.getSports().get(i).getClass().getName().equalsIgnoreCase(namestr)) {
                Log.i("EllieRepeat", namestr + " " + aController.getSports().get(i).getClass().getName());
                add = false;
            }
        }
        if (!name.getText().toString().isEmpty() && !sportStyle.equals("Select a Sport Type") && add) {
            newSport(sportStyle);
            Intent intent = new Intent(CreateSport.this, SportHome.class);
            String nameStr = name.getText().toString();
            intent.putExtra("sportName", nameStr);
            startActivity(intent);
        } else if (name.getText().toString().isEmpty()) {
            Toast.makeText(getBaseContext(), "Please enter your sport name", Toast.LENGTH_SHORT).show();
        } else if (sportStyle.equals("Select a Sport Type")) {
            Toast.makeText(getBaseContext(), "Please choose a sport style", Toast.LENGTH_SHORT).show();
        } else if (!add) {
            Toast.makeText(getBaseContext(), "There is already a sport with this name", Toast.LENGTH_SHORT).show();
        }
    }

    //Adds a new sport to the arraylist of sports
    //The name of the sport and the comment that is added is gotten from the user's input in the edit text boxes on the screen
    public void newSport(String style) throws IOException {
        //get Global Controller Class object (see application tag in AndroidManifest.xml)
        Controller aController = (Controller) getApplicationContext();
        EditText namePull = (EditText) findViewById(R.id.sportname);
        EditText commentPull = (EditText) findViewById(R.id.commentCreateSport);
        Log.i("EllieStyle", style);
        String nameStr = namePull.getText().toString();
        String commentStr = commentPull.getText().toString();
        if (!namePull.getText().toString().isEmpty()) {
            Sport sport = new Sport(nameStr, commentStr, style);

            aController.addSport(sport);

            String check1 = sport.getComment();
            String check2 = sport.getName();
            String check3 = sport.getStyle();

            Log.i("Ellie", check1 + check2 + check3);
        }
    }

    //when the app is closed this method saves the data from the ArrayLists of sports and events to a text file
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
            Log.i("EllieCheck", Integer.toString(aController.getSport("mySport").getEvent().size()) + " " + Integer.toString(sports.size()));
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




