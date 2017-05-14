package com.example.perlmutter.storedata;

/**
 * Created by Ellie DeSota on 4/12/2017.
 * This class Event constructs an instance of an Event with the parameters time, distance, date, and comment.
 */


public class Event {
    // Data
    //String eventName;
    //String sportName;
    private String date;
    private double time;
    private double distance;
    private String comment;

    /**
     * Constructs an event with a given time, distance, date and comment
     * @param time time inputted
     * @param distance distance inputted
     * @param date date of event
     * @param comment comment of event
     */
    // Constructor
    public Event(double time, double distance, String date, String comment) {
        //	eventName = this.eventName;
        this.date = date;
        this.time = time;
        this.distance = distance;
        this.comment = comment;
    }

    /**
     * Constructs an event with a given distance, date, and comment
     * @param distance distance inputted
     * @param date date of event
     * @param comment comment of event
     */
    public Event(double distance, String date, String comment) {
        //	eventName = this.eventName;
        this.date = date;
        this.distance = distance;
        this.comment = comment;
    }

    /*public Event(double points, String date, String comment) {
        //	eventName = this.eventName;
        this.date = date;
        this.points = points;
        this.comment = comment;
    }
    public Event(double successfulAttempts, double totalAttempts, String date, String comment) {
        //	eventName = this.eventName;
        this.date = date;
        this.successfulAttempts = successfulAttempts;
        this.totalAttempts = totalAttempts;
        this.comment = comment;
    }*/

    /**
     * Returns the date of the event
     * @return
     */

    public String getDate() {
        return date;
    }

    /**
     * Returns the time inputted
     * @return
     */

    public double getTime() {
        return time;
    }

    /**
     * Returns the distance inputted
     * @return
     */

    public double getDistance() {
        return distance;
    }

    /**
     * Returns the comment of the event
     * @return
     */

    public String getComment() {
        return comment;
    }

    /**
     * Returns the date, time, distance, and comment of the event as one string
     * @return
     */
    @Override
    public String toString(){
        return date + " " + time + " " + distance + " " + comment;
    }
}
