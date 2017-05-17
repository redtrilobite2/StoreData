package com.example.perlmutter.storedata;

/*
 * Created by Ellie DeSota on 4/12/2017.
 * The Sport class constructs a Sport with name, comment, and ArrayLIst of the Event class.
 */

import android.util.Log;

import java.util.ArrayList;

/**
 * A sport class contains an ArrayList of events, the name of the sportname, the comment for the sport, and the style of the sport.
 * This class can get the name, comment, and style of the sport. It can set the name of the sport and can also add an event to the ArrayList of events.
 */
 class Sport {
    // Data
    private ArrayList<Event> events;
    private String name;
    private String comment;
    private int style;

    // Constructor

    /**
     * Constructs a sport with a given name, comment, and style
     * @param name the name of the sport
     * @param comment the user's comment for the sport
     * @param style the style of the sport
     */
    Sport(String name, String comment, int style) {
        Log.i("EllieStyle", Integer.toString(style));
        this.name = name;
        this.comment = comment;
        this.style = style;
        this.events = new ArrayList<>();
    }

    // Methods

    /**
     * Returns the name of the sport
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the comment
     * @return comment
     */

   String getComment() {
        return comment;
    }

    /**
     * Returns the event
     * @return events
     */

    public ArrayList getEvent() {
        return events;
    }

    /**
     * Returns the style
     * @return style
     */

    public int getStyle(){
        Log.i("EllieEnteredStyle", Integer.toString(style));
        return style;
    }

    /**
     * Sets the name of the sport to a new name
     * @param newName the new name of the sport
     */
    public void setName(String newName) { this.name = newName; }

    /**
     * Adds an event to the ArrayList of events
     * @param event an event within a sport
     */
    void addEvent(Event event) {
        Log.i("Ellie", "Entered Event");
        events.add(event);
    }

    public void setStyle(int style) {
        this.style = style;
    }


    /**
     * Returns the name of the sport and comment as one string
     * @return name and comment
     */
    @Override
    public String toString(){
        return name + " " + comment;
    }

}
