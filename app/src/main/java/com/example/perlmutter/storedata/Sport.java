package com.example.perlmutter.storedata;

/**
 * Created by Ellie DeSota on 4/12/2017.
 */
import java.util.ArrayList;

public class Sport {
    //Data
    ArrayList<Event> events = new ArrayList<Event>();
    String name;
    String comment;

    //Constructor
    public Sport(String name, String comment){
        name = this.name;
        comment = this.comment;
        events = new ArrayList<Event>();
    }
//Methods

    public String getName(){
        return name;
    }
    public String getComment(){
        return comment;
    }
    public ArrayList getEvent(){
        return events;
    }
    public void addEvent(Event event){
        events.add(event);
    }
}
