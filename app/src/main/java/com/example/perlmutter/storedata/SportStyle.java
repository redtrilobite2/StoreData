package com.example.perlmutter.storedata;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class SportStyle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sportstyle);
    }

    public void toCreateSport(View view) {
        Intent intent = new Intent(SportStyle.this, CreateSport.class);
        startActivity(intent);
    }

   /* @Override
    public void onStop() {
        super.onStop();
        try {
            ArrayList<String> print;
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
    }*/
}
