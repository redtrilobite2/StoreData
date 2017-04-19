package com.example.perlmutter.storedata;

/**
 * Created by Ellie DeSota on 4/12/2017.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class PrintData {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Sport> sports = new ArrayList<Sport>();
        Sport sport = new Sport("Running", "This is my comment");
        sports.add(sport);
        Event test = new Event(55, 33, "mm/dd/yy", "This is a comment");
        Event test2 = new Event(55, 22, "mm/dd/yy", "This is a comment");

        sport.addEvent(test);
        sport.addEvent(test2);
        // Construct the Scanner and PrinterWriter objects for reading and
        // writing
        File inputFile = new File("C:\\Users\\shalo\\D\\AppsForGood\\Sports.txt");
        Scanner in = new Scanner(inputFile);
        PrintWriter out = new PrintWriter("C:\\Users\\shalo\\D\\AppsForGood\\Sports.txt");

        // Read write the output
        ArrayList events = sport.getEvent();

        for (int i = 0; i < sports.size(); i++) {
            Sport thisSport = sports.get(i);
            out.println(thisSport.getName() + " ;; " + thisSport.getComment() + " !;");
            for (int m = 0; m < events.size(); m++) {
                Event event = (Event) events.get(m);
                out.println(event.getTime() + " ;;  " + event.getDistance() + " ;; " + event.getDate() + " ;; "
                        + event.getComment());
            }
        }
        out.close();
    }
}
