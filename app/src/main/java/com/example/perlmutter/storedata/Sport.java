package com.example.perlmutter.storedata;

/**
 * Created by Ellie DeSota on 4/12/2017.
 */

import android.util.Log;

import java.util.ArrayList;

public class Sport {
    // Data
    ArrayList<Event> events;
    String name;
    String comment;

    // Constructor
    public Sport(String name, String comment, ArrayList events) {
        this.name = name;
        this.comment = comment;
        this.events = events;
    }
    public Sport(){
        this.name = "";
        this.comment = "";
        events = new ArrayList<Event>();
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
        events.add(event);
    }

    @Override
    public String toString(){
        return name + " " + comment;
    }
}
