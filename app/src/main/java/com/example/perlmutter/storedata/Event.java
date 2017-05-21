package com.example.perlmutter.storedata;

/**
 * Created by Ellie DeSota on 4/12/2017.
 * This class Event constructs an instance of an Event with the parameters time, distance, date, and comment.
 */


public class Event {
    //Data
    private String date;
    private double time;
    private double distance;
    private String comment;
    private double successfulAttempts;
    private double totalAttempts;
    private int delin;
    private double points;
    private String delinStr;

    /**
     * Contructs an event with a time, distance, date, and comment
     * @param time time the user inputs
     * @param distance distance the user inputs
     * @param date date the user inputs
     * @param comment comment for the event that the user inputs
     */
    public Event(double time, double distance, String date, String comment) {
        //	eventName = this.eventName;
        this.date = date;
        this.time = time;
        this.distance = distance;
        this.comment = comment;
    }

    /**
     * Constructs an event with a distance, date, and comment
     * @param distance distance that the user inputs
     * @param date date of event that the user inputs
     * @param comment comment for the event that the user inputs
     */
    public Event(double distance, String date, String comment) {
        //	eventName = this.eventName;
        this.date = date;
        this.distance = distance;
        this.comment = comment;
    }

    /**
     * Constructs an event with a time, date, comment, and delin
     * @param time time the user inputs
     * @param date date of event that user inputs
     * @param comment comment for the event that user inputs
     * @param delin delineates the constructor
     */
   Event(double time, String date, String comment, int delin){
        this.time = time;
        this.date =date;
        this.comment = comment;
        this.delin = delin;
    }

    /**
     * Constructs an event with points, date, comment, and a delinStr
     * @param points number of points that the user inputs
     * @param date date of the event that the user inputs
     * @param comment comment for event that the user inputs
     * @param delinStr delineates the constructor
     */
    public Event(double points, String date, String comment, String delinStr) {
        //	eventName = this.eventName;
        this.date = date;
        this.points = points;
        this.comment = comment;
        this.delinStr = delinStr;
    }

    /**
     * Constructs an event with successful attempts, total attempts, date, comment, and a delinStr
     * @param successfulAttempts the number of successful attempts that the user inputs
     * @param totalAttempts the number of total attempts that the user inputs
     * @param date date of the event that the user inputs
     * @param comment comment for event that the user inputs
     * @param delin delineates the constructor
     */
    public Event(double successfulAttempts, double totalAttempts, String date, String comment, int delin) {
        //	eventName = this.eventName;
        this.date = date;
        this.successfulAttempts = successfulAttempts;
        this.totalAttempts = totalAttempts;
        this.comment = comment;
    }

    /**
     * Returns the number of succesful attempts
     * @return
     */
    public double getSuccessfulAttempts(){
        return successfulAttempts;
    }

    /**
     * Returns the number of total attempts
     * @return
     */
    public double getTotalAttempts(){
        return totalAttempts;
    }
    /**
     * Returns the date of the event
     * @return date
     */
  String getDate() {
        return date;
    }

    /**
     * Returns the time inputted
     * @return time
     */

    public double getTime() {
        return time;
    }

    /**
     * Returns the distance inputted
     * @return distance
     */

   double getDistance() {
        return distance;
    }

    /**
     * Returns the comment of the event
     * @return comment
     */

   String getComment() {
        return comment;
    }

    /**
     * Returns the points input
     * @return points
     */
    public double getPoints(){
        return points;
    }

    /**
     * Returns the date, time, distance, and comment of the event as one string
     * @return date, time, disance, and comment
     */
    @Override
    public String toString(){
        return date + " " + time + " " + distance + " " + comment;
    }
}
