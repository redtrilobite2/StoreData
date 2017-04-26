package com.example.perlmutter.storedata;

/**
 * Created by Ellie DeSota on 4/12/2017.
 */

import android.util.Log;

import java.util.ArrayList;

public class Sport {
    // Data
    ArrayList<Event> events = new ArrayList<Event>();
    String name;
    String comment;

    // Constructor
    public Sport(String name, String comment) {
        this.name = name;
        this.comment = comment;
        events = new ArrayList<Event>();
    }
    public Sport(){
        this.name = null;
        this.comment = null;
        events = null;
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

    public void setName(String newName){ this.name = newName; }

    public void setComment(String newComment){ this.name = newComment; }

    public void addEvent(Event event) {
        if(events == null){
            Log.i("Check", "Events is null");
        }else
            Log.i("Check", "Events is not null");
        events.add(event);

    }
}
