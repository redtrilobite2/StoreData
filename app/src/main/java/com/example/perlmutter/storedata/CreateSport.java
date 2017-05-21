package com.example.perlmutter.storedata;

import android.app.Activity;
import android.content.Intent;
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

/**
 * This class creates a sport that is either time based, distance based, time-distance based, accuracy based, or point based.
 */
public class CreateSport extends Activity implements AdapterView.OnItemSelectedListener {
    private int pos;
    Spinner spin;
    int sportStyle;
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
    }

    /**
     * Gets the position of the selected item
     * @param parent the view of the adapter
     * @param view builds the interface and the widgets
     * @param pos the position of the selected item
     * @param id the id of the selected item
     */

    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {

        pos = spin.getSelectedItemPosition();
        setPos(pos);
    }

    /**
     * Sets pos to the position of the selected item
     * @param pos position of selected item
     */
    public void setPos(int pos) {
        this.pos = pos;
    }

    /**
     * Gets the position of the selected item
     * @return
     */
    public int getPos() {
        return pos;
    }

    /**
     * Does nothing when the spinner is called
     * @param parent view of the adapter
     */
    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }

    /**
     * Creates new intent and goes to the Home Screen
     * @param view builds the interface and widgets
     * @throws IOException
     */
    public void toHomeScreen(View view) throws IOException {
        Intent intent = new Intent(CreateSport.this, HomeScreen.class);
        startActivity(intent);
    }

    /**
     * Creates new intent and goes to Sport Home
     * @param view builds the interface and widgets
     * @throws IOException
     */
    public void toSportHome(View view) throws IOException {
        Boolean add = true;
        Controller aController = (Controller) getApplicationContext();
        EditText name = (EditText) findViewById(R.id.sportname);
        String namestr = name.getText().toString();
        sportStyle = getPos();
        for (int i = 0; i < aController.getSports().size(); i++) {
            if (aController.getSports().get(i).getClass().getName().equalsIgnoreCase(namestr)) {
                Log.i("EllieRepeat", namestr + " " + aController.getSports().get(i).getClass().getName());
                add = false;
            }
        }
        Log.i("ElliePos", Integer.toString(sportStyle));
        if (!name.getText().toString().isEmpty() && sportStyle != 0 && add) {
            newSport(sportStyle);
            Intent intent = new Intent(CreateSport.this, SportHome.class);
            String nameStr = name.getText().toString();
            intent.putExtra("sportName", nameStr);
            startActivity(intent);
        } else if (name.getText().toString().isEmpty()) {
            Toast.makeText(getBaseContext(), "Please enter your sport name", Toast.LENGTH_SHORT).show();
        } else if (sportStyle == 0) {
            Toast.makeText(getBaseContext(), "Please choose a sport style", Toast.LENGTH_SHORT).show();
        } else if (!add) {
            Toast.makeText(getBaseContext(), "There is already a sport with this name", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Adds a new sport to the ArrayList of sports. The name and comment of the sport are gotten from the user's inputs in the
     * edit text boxes and the style of the sport is from the spinner
     * @param style position of the selected style in the spinner
     * @throws IOException
     */

    public void newSport(int style) throws IOException {
        //get Global Controller Class object (see application tag in AndroidManifest.xml)
        Controller aController = (Controller) getApplicationContext();
        EditText namePull = (EditText) findViewById(R.id.sportname);
        EditText commentPull = (EditText) findViewById(R.id.commentCreateSport);
        Log.i("EllieStyle", Integer.toString(style));
        String nameStr = namePull.getText().toString();
        String commentStr = commentPull.getText().toString();
        if (!namePull.getText().toString().isEmpty()) {
            Sport sport = new Sport(nameStr, commentStr, style);

            aController.addSport(sport);

            String check1 = sport.getComment();
            String check2 = sport.getName();
            int check3 = sport.getStyle();

            Log.i("Ellie", check1 + check2 + check3);
        }
    }

    /**
     * This method is called when the app is closed. It prints the inputted data into a text file so that when the app is closed,
     * the data will persist.
     */
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
            Log.i("EllieCheck", Integer.toString(aController.getSport("mySport").getEvents().size()) + " " + Integer.toString(sports.size()));
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




