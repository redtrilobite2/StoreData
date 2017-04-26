package com.example.perlmutter.storedata;

import android.app.Application;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Ellie DeSota on 4/25/2017.
 */

public class Controller extends Application{
    ArrayList<Event> ThisEvent = new ArrayList<>();
    private Sport newSport = new Sport("ThisSport", "ThisComment");
    public Sport getNewSport(){
        return newSport;
    }
}
