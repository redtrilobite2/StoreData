package com.example.perlmutter.storedata;


/**
 * Created by Ellie DeSota on 4/12/2017.
 */
import android.app.Activity;
import java.util.ArrayList;


public class PrintData extends Activity {
    //Data
    Controller aController = (Controller) getApplicationContext();
    Sport sport = new Sport();
    ArrayList<Event> events = new ArrayList<>();
    ArrayList<Sport> sports = new ArrayList<>();

    //Constructor
    public PrintData(ArrayList sports) {
        this.sports = sports;
        this.events = sport.getEvent();
    }

    //Methods

    public String printEvent() {
        String output = new String();
        for (int i = 0; i < sports.size(); i++) {
            Sport thisSport = sports.get(i);
            for (int m = 0; m < events.size(); m++) {
                Event event = (Event) events.get(m);
               output = (thisSport.getName() + " ;; " + thisSport.getComment() + " ;; " + event.getTime() + " ;; "
                        + event.getDistance() + " ;; " + event.getDate() + " ;; " + event.getComment());
            }


        }
        return output;
    }
}





