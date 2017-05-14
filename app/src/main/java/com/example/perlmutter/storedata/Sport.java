package com.example.perlmutter.storedata;

/*
 * Created by Ellie DeSota on 4/12/2017.
 * The Sport class constructs a Sport with name, comment, and ArrayLIst of the Event class.
 */

import android.util.Log;

import java.util.ArrayList;

public class Sport {
    // Data
    private ArrayList<Event> events;
    private String name;
    private String comment;
    private String style;

    // Constructor
    public Sport(String name, String comment, String style) {
        Log.i("EllieStyle", style);
        this.name = name;
        this.comment = comment;
        this.style = style;
        this.events = new ArrayList<>();
    }
    public Sport(){
        this.name = "";
        this.comment = "";
        events = new ArrayList<>();
    }
    // Methods

    public String getName() {
        return name;
    }

    public String getComment() {
        return comment;
    }

    public ArrayList getEvent() {
        return events;
    }

    public String getStyle(){
        Log.i("EllieEnteredStyle", style);
        return style;
    }

    public void setName(String newName) { this.name = newName; }

    public void addEvent(Event event) {
        Log.i("Ellie", "Entered Event");
        events.add(event);
    }

    @Override
    public String toString(){
        return name + " " + comment;
    }
}
