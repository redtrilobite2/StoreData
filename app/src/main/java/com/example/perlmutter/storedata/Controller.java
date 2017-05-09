package com.example.perlmutter.storedata;

import android.app.Application;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by Ellie DeSota on 4/25/2017.
 * The class Controller saves all the data for the app while the app is running.
 */

public class Controller extends Application {
    private ArrayList<Sport> allSports = new ArrayList<>();
    private int i;
    public Sport getNewSport() {
        return allSports.get(0);
    }

    public ArrayList getSports(){
        return allSports;
    }

     public void addSport(Sport sport) {
        allSports.add(sport);
    }

    public Sport getSport(String name) {
        for (int i = 0; i < allSports.size(); i++) {
            Sport thisSport = allSports.get(i);
            if (name.equalsIgnoreCase(thisSport.getName())) {
                Log.i("Ellie", "entered getSport");
                return thisSport;
            }
        }
        return null;
    }
    public ArrayList<String> allNames(){
        Log.i("Please",Integer.toString(allSports.size()));
        String name;
        ArrayList<String> allNames = new ArrayList<>();
        for (int i=0; i < allSports.size(); i++){
            name = allSports.get(i).getName();
            allNames.add(name);
        }
        Log.i("Ellie", Integer.toString(allNames.size()));
        return allNames;
    }
    public void setInti(int i){
        this.i=i;
    }

    public int getInti(){
        return i;
    }
    }




