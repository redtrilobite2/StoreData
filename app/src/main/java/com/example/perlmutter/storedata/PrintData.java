package com.example.perlmutter.storedata;

/**
 * Created by Ellie DeSota on 4/12/2017.
 */

import android.content.Context;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import java.io.OutputStreamWriter;
import java.util.ArrayList;


import static android.content.Context.MODE_PRIVATE;


public class PrintData {
    public static void printMyStuff() throws IOException {
        // Construct the Scanner and PrinterWriter objects for reading and
        // writing\
        Context context = null;
        File file = new File(context.getFilesDir(), "NewSports.txt");
        FileOutputStream stream = new FileOutputStream(file);

        CreateSport arrayList = new CreateSport();
        ArrayList sports = arrayList.getSports();



        // Read write the output


     /*   for (int i = 0; i < sports.size(); i++) {
            Sport thisSport = (Sport) sports.get(i);
            ArrayList events = thisSport.getEvent();
            out.println(thisSport.getName() + " ;; " + thisSport.getComment() + " !;");
            for (int m = 0; m < events.size(); m++) {
                Event event = (Event) events.get(m);
                out.println(event.getTime() + " ;;  " + event.getDistance() + " ;; " + event.getDate() + " ;; "
                        + event.getComment());
            }
        }
        out.close();*/
    }

    /*AssetManager assetManager = getAssets();
    InputStream inputStream = null;
    AssetFileDescriptor descriptor = assetManager.openFd("NewSport.txt");*/



}

