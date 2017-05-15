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

    /**
     * Returns the newest sport added to the ArrayList of sports
     * @return
     */
    public Sport getNewSport() {
        return allSports.get(0);
    }

    /**
     * Returns the ArrayList of sports
     * @return
     */
    public ArrayList getSports(){
        return allSports;
    }

    /**
     * Adds a sport to the ArrayList of sports
     * @param sport the sport inputted by the user
     */
     public void addSport(Sport sport) {
        for(int i = 0; i < allSports.size(); i++){
            if(allSports.get(i).getName().equalsIgnoreCase(sport.getName())){
                add = false;
            }
        }
         if(add == true){
            allSports.add(sport);
         }
    }

    /**
     * Checks if a sport has been added. Returns true if sport has been added
     * @return
     */
    public Boolean sportIsAdded(){
        return add;
    }

    /**
     * Gets the name of the sport and checks if another sport in the ArrayList has the same name.
     * Returns the sport name is already in the ArrayList of sports. Returns null if the sport is
     * not in the ArrayList
     * @param name name of the sport
     * @return
     */
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

    /**
     * Returns the names of the sports in the ArrayList of sports
     * @return
     */
    public ArrayList<String> allNames(){
        Log.i("Please",Integer.toString(allSports.size()));
        ArrayList<String> allNames=new ArrayList<>();
        for (int i=0; i<allSports.size(); i++){
            String name=allSports.get(i).getName();
            allNames.add(name);
        }
        return allNames;
    }

    /**
     * Sets i to a integer
     * @param i postion of the spinner
     */
    public void setInti(int i){
        this.i=i;
    }

    /**
     * Returns the value of i
     * @return
     */
    public int getInti(){
        return i;
    }
    }




