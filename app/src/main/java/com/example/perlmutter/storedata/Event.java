package com.example.perlmutter.storedata;

/**
 * Created by Ellie DeSota on 4/12/2017.
 */


public class Event {
    // Data
    String eventName;
    String date;
    int time;
    int distance;
    String comment;

    // Constructor
    public Event(double time, double distance,String date, String comment) {
        //eventName = this.eventName;
        date = this.date;
        time = this.time;
        distance = this.distance;
        comment = this.comment;
    }

    // Method
   /* public String getEventName() {
        return eventName;
    }*/

    public String getDate() {
        return date;
    }

    public int getTime() {
        return time;
    }

    public int getDistance() {
        return distance;
    }

    public String getComment() {
        return comment;
    }
}