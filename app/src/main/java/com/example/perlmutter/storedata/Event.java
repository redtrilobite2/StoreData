package com.example.perlmutter.storedata;

/**
 * Created by Ellie DeSota on 4/12/2017.
 * This class Event constructs an instance of an Event with the paramaters time, distance, date, and comment.
 */


public class Event {
    // Data
    //String eventName;
    //String sportName;
    private String date;
    private double time;
    private double distance;
    private String comment;

    // Constructor
    public Event(double time, double distance, String date, String comment) {
        //	eventName = this.eventName;
        this.date = date;
        this.time = time;
        this.distance = distance;
        this.comment = comment;
    }


    public String getDate() {
        return date;
    }

    public double getTime() {
        return time;
    }

    public double getDistance() {
        return distance;
    }

    public String getComment() {
        return comment;
    }

    @Override
    public String toString(){
        return date + " " + time + " " + distance + " " + comment;
    }
}
