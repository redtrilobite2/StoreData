package com.example.perlmutter.storedata;

import android.app.Application;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Ellie DeSota on 4/25/2017.
 * The class Controller saves all the data for the app while the app is running.
 */


public class Controller extends Application {
    Boolean add = true;
    private ArrayList<Sport> allSports = new ArrayList<>();
    private int i;
    public Sport getNewSport() {
        return allSports.get(0);
    }

    public ArrayList getSports(){
        return allSports;
    }

     public void addSport(Sport sport) {
        for(int i = 0; i < allSports.size(); i++){
            if(allSports.get(i).getName().equalsIgnoreCase(sport.getName()) || sport.getName().equalsIgnoreCase("")){
                add = false;
            }
        }
         if(add){
            allSports.add(sport);
         }
    }
    public Boolean sportIsAdded(){
        return add;
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
        ArrayList<String> allNames=new ArrayList<>();
        for (int i=0; i<allSports.size(); i++){
            String name=allSports.get(i).getName();
            allNames.add(name);
        }
        return allNames;
    }
    public void setInti(int i){
        this.i=i;
    }

    public int getInti(){
        return i;
    }
    }




