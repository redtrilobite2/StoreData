package com.example.perlmutter.storedata;

/**
 * Created by Ellie DeSota on 4/12/2017.
 */


public class Event {
    // Data
    //String eventName;
    //String sportName;
    String date;
    double time;
    double distance;
    String comment;

    // Constructor
    public Event(double time, double distance, String date, String comment) {
        //	eventName = this.eventName;
        this.date = date;
        this.time = time;
        this.distance = distance;
        this.comment = comment;
    }

    // Method
    /*public String getEventName() {
		return eventName;
	}*/

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString(){
        return date + " " + time + " " + distance + " " + comment;
    }
}
