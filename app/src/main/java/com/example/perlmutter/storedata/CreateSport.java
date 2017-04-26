package com.example.perlmutter.storedata;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.io.IOException;
import java.util.ArrayList;

public class CreateSport extends AppCompatActivity {
    ArrayList<Sport> sports = new ArrayList<Sport>();
    PrintData printSports = new PrintData();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createsport);
    }

    public void toHomeScreen(View view) {
        Intent intent = new Intent(CreateSport.this, HomeScreen.class);
        startActivity(intent);
    }

    public void toStoreData(View view) throws IOException{
        //newSport();

        Intent intent = new Intent(CreateSport.this, SportHome.class);
        startActivity(intent);
    }


  public void newSport() throws IOException {
       //get Global Controller Class object (see application tag in AndroidManifest.xml)
       final Controller aController =(Controller) getApplicationContext();
       EditText namePull = (EditText) findViewById(R.id.sportname);
       EditText commentPull = (EditText) findViewById(R.id.commentCreateSport);

       String nameStr = namePull.getText().toString();
       String commentStr = commentPull.getText().toString();
      aController.getNewSport().setName(nameStr);
      aController.getNewSport().setComment(commentStr);

       Sport sport = new Sport(nameStr, commentStr);

       sports.add(sport);
       PrintData printSports = new PrintData();
       printSports.printMyStuff();
   }

    public ArrayList getSports() {
        return sports;
    }


    }

