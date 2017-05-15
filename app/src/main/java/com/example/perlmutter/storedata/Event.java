package com.example.perlmutter.storedata;

/**
 * Created by Ellie DeSota on 4/12/2017.
 * This class Event constructs an instance of an Event with the paramaters time, distance, date, and comment.
 */


public class Event {
    //Data
    private String date;
    private double time;
    private double distance;
    private String comment;
    private int successfulAttempts;
    private int totalAttempts;
    private int delin;
    private double points;
    private String delinStr;

    // Constructor
    public Event(double time, double distance, String date, String comment) {
        //	eventName = this.eventName;
        this.date = date;
        this.time = time;
        this.distance = distance;
        this.comment = comment;
    }

    public Event(double distance, String date, String comment) {
        //	eventName = this.eventName;
        this.date = date;
        this.distance = distance;
        this.comment = comment;
    }

    public Event(double time, String date, String comment, int delin){
        this.time = time;
        this.date =date;
        this.comment = comment;
        this.delin = delin;
    }
    public Event(double points, String date, String comment, String delinStr) {
        //	eventName = this.eventName;
        this.date = date;
        this.points = points;
        this.comment = comment;
        this.delinStr = delinStr;
    }
    public Event(int successfulAttempts, int totalAttempts, String date, String comment) {
        //	eventName = this.eventName;
        this.date = date;
        this.successfulAttempts = successfulAttempts;
        this.totalAttempts = totalAttempts;
        this.comment = comment;
    }

    public int getSuccessfulAttempts(){
        return successfulAttempts;
    }
    public int getTotalAttempts(){
        return totalAttempts;
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
    public double getPoints(){
        return points;
    }

    @Override
    public String toString(){
        return date + " " + time + " " + distance + " " + comment;
    }
}
