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
        // Construct the Scanner and PrinterWriter objects for reading and
        // writing
        File inputFile = new File("C:\\Users\\shalo\\D\\AppsForGood\\Sports.txt");
        Scanner in = new Scanner(inputFile);
        PrintWriter out = new PrintWriter("C:\\Users\\shalo\\D\\AppsForGood\\Sports.txt");

        CreateSport arrayList = new CreateSport();
        ArrayList sports = arrayList.getSports();

        // Read write the output


        for (int i = 0; i < sports.size(); i++) {
            Sport thisSport = (Sport) sports.get(i);
            ArrayList events = thisSport.getEvent();
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
