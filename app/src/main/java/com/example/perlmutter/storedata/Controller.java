package com.example.perlmutter.storedata;

import android.app.Application;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Ellie DeSota on 4/25/2017.
 */

public class Controller extends Application {
    private ArrayList<Sport> allSports = new ArrayList<>();

    public Sport getNewSport() {

        return (Sport) allSports.get(0);


    }

    public void addSport(Sport sport){
        allSports.add(sport);
    }


}
