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
    }




