package com.example.perlmutter.storedata;

import android.util.Log;

import java.util.ArrayList;

/**
 * Created by Ellie DeSota on 4/30/2017.
 * The PrintData class takes an ArrayList of the Sport class and prints out all of the events in the given format.
 */

public class PrintData {
    ArrayList <Sport> sports;
    ArrayList<String> data = new ArrayList<>();
    ArrayList<Event> events = new ArrayList<>();

    public PrintData(ArrayList <Sport> sports) {
    this.sports = sports;
    }

    public ArrayList print() {
        Log.i("EllieWrite", "Inprint");
        Sport sport;
        for (int i = 0; i < sports.size(); i++) {
            sport = sports.get(i);
            events = sport.getEvent();
            for (int m = 0; m < events.size(); m++) {
                data.add(sport.getName() + " ;; " + sport.getComment() + " ;; " + sport.getStyle() + " ;; "+ events.get(m).getTime() + " ;; "
                        + events.get(m).getDistance() + " ;; " + events.get(m).getDate() + " ;; " + events.get(m).getComment());
            }
        }
        Log.i("EllieWrite", Integer.toString(data.size()));
        return data;
    }
}
