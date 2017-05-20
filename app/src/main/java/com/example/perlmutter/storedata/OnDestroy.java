package com.example.perlmutter.storedata;

import android.view.View;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by Ellie DeSota on 5/20/2017.
 */

public class OnDestroy {
    /*public void Destroy(View view) {
        try {
            ArrayList<String> print;
            FileOutputStream fOut = openFileOutput("NewSport.txt", MODE_PRIVATE);
            OutputStreamWriter outputWriter = new OutputStreamWriter(fOut);
            final Controller aController = (Controller) getApplicationContext();
            ArrayList sports = aController.getSports();
            PrintData printData = new PrintData(sports);

            for (int i = 0; i < sports.size(); i++) {
                print = printData.print();
                outputWriter.write(print.get(i));

            }
            outputWriter.close();
            //display file

        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/
}
