package com.example.perlmutter.storedata;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import org.w3c.dom.Comment;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class CreateSport extends AppCompatActivity {
    ArrayList<Sport> sports = new ArrayList<Sport>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createsport);
    }

    public void toHomeScreen(View view) {
        Intent intent = new Intent(CreateSport.this, HomeScreen.class);
        startActivity(intent);
    }

    public void toStoreData(View view) {
        Intent intent = new Intent(CreateSport.this, SportHome.class);
        startActivity(intent);
    }

    public void onSubmit() {
        CreateSport sport = new CreateSport();
        sport.newSport();
    }

    public void newSport() {
        EditText namePull = (EditText) findViewById(R.id.sportname);
        EditText commentPull = (EditText) findViewById(R.id.comment);

        String nameStr = namePull.getText().toString();
        String commentStr = commentPull.getText().toString();

        Sport sport = new Sport(nameStr, commentStr);

        sports.add(sport);
    }

    public ArrayList getSports() {
        return sports;
    }
}
