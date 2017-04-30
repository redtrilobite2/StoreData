package com.example.perlmutter.storedata;

import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * Created by Ellie DeSota on 4/30/2017.
 */

class PrintData {
    private ArrayList sports;
    private Sport sport;

    public PrintData(ArrayList sport) {
        this.sports = sport;
    }

    public ArrayList print() {
        ArrayList<String> data = new ArrayList<>();
        ArrayList<Event> events = new ArrayList<>();
        for (int i = 0; i < sports.size(); i++) {
            sport = (Sport) sports.get(i);
            for (int m = 0; m < events.size(); m++) {
                events = sport.getEvent();
                data.add(sport.getName() + " ;; " + sport.getComment() + " ;; " + events.get(m).getTime() + " ;; "
                        + events.get(m).getDistance() + " ;; " + events.get(m).getDate() + " ;; " + events.get(m).getComment());
            }
        }
        return data;
    }
}
