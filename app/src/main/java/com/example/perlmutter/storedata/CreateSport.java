package com.example.perlmutter.storedata;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class CreateSport extends AppCompatActivity {
    //static final int READ_BLOCK_SIZE = 200;
    //private ArrayList<Sport> sports = new ArrayList<Sport>();
    //private PrintData printSports = new PrintData();
   // private ArrayList<Event> events = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createsport);

        //EditText sportName = (EditText) findViewById(R.id.sportname);
    }

    public void toHomeScreen(View view) throws IOException {
        Intent intent = new Intent(CreateSport.this, HomeScreen.class);
        startActivity(intent);
        newSport();
    }

    public void toStoreData(View view) throws IOException {
        newSport();
        Intent intent = new Intent(CreateSport.this, SportHome.class);
        EditText namePull = (EditText) findViewById(R.id.sportname);
        String nameStr = namePull.getText().toString();
        intent.putExtra("sportName", nameStr);
        startActivity(intent);
    }


    public void newSport() throws IOException {
        //get Global Controller Class object (see application tag in AndroidManifest.xml)
        Controller aController = (Controller) getApplicationContext();
        EditText namePull = (EditText) findViewById(R.id.sportname);
        EditText commentPull = (EditText) findViewById(R.id.commentCreateSport);

        String nameStr = namePull.getText().toString();
        String commentStr = commentPull.getText().toString();

        Sport sport = new Sport(nameStr,commentStr);

        aController.addSport(sport);

        String check1 = sport.getComment();
        String check2 = sport.getName();

        Log.i("Ellie", check1 + check2);
    }
@Override
public void onDestroy() {
    Log.i("Ellie", "In onDestroy");
    // super.onDestroy();
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




