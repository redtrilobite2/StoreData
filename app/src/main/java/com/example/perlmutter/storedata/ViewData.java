package com.example.perlmutter.storedata;

import android.content.Intent;
import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.DataPointInterface;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.jjoe64.graphview.series.OnDataPointTapListener;
import com.jjoe64.graphview.series.Series;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class ViewData extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final Controller control = (Controller)getApplicationContext();
        ArrayList<Double> Sportarray = new ArrayList<Double>();
       ArrayList<Event> sportsarray = control.getSport(control.allNames().get(control.getInti())).getEvent();
       double counterdt = 0;
        double dt = 1;
        for(int q=0; q<sportsarray.size(); q++) {

            if(sportsarray.get(q).getTime()!=0) {
                counterdt++;
                dt = sportsarray.get(q).getDistance() / sportsarray.get(q).getTime();
                if (q == 0) {
                    Sportarray.add(0.0);
                    Sportarray.add(0.0);

                    // Sportarray.add(sportsarray.get(q).getTime());
                    //  Sportarray.add(sportsarray.get(q).getDistance());
                }

                Sportarray.add(counterdt);
                Sportarray.add(dt);
            }
           // Sportarray.add(sportsarray.get(q).getTime());
            //Sportarray.add(sportsarray.get(q).getDistance());



        }

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_viewdata);

        GraphView line_graph = (GraphView) findViewById(R.id.graph);
        DataPoint[] data = new DataPoint[Sportarray.size()/2];

        int counter = 0;
        for(int i = 0; i<(Sportarray.size()/2); i++){
            data[i] = new DataPoint (Sportarray.get(i+counter), Sportarray.get(i+1+counter));
            counter ++;}

        for(int j =0; j<Sportarray.size()/2; j++ ){
            DataPoint datap = data[j];
            if(datap != null){Log.i("Kent", "Good");}
            if(datap == null){

            }
            System.out.println(datap.getX());

            System.out.println(datap.getY());
        }
        LineGraphSeries<DataPoint> line_series =

                new LineGraphSeries<DataPoint>(data);


        line_graph.addSeries(line_series);
        line_series.setDrawDataPoints(true);
        line_series.setDataPointsRadius(10); // set the radius of data point
        line_series.setOnDataPointTapListener(new OnDataPointTapListener() {
            @Override
            public void onTap(Series series, DataPointInterface dataPoint) {
                Toast.makeText(ViewData.this, "Series: On Data Point clicked:"  + dataPoint, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void toStoreData(View view) {
        Intent intent=new Intent(ViewData.this, Storedata.class);
        startActivity(intent);
    }
    public void toSportHome(View view) {
        Intent intent=new Intent(ViewData.this, SportHome.class);
        startActivity(intent);
    }

    @Override
    public void onDestroy() {
        Log.i("Ellie", "In onDestroy");
       // super.onDestroy();
        try {
            ArrayList<String> print;
            FileOutputStream fOut = openFileOutput("NewSport.txt", MODE_PRIVATE);
            OutputStreamWriter outputWriter = new OutputStreamWriter(fOut);
            final Controller aController = (Controller) getApplicationContext();
            ArrayList sports = aController.getSports();
            PrintData printData = new PrintData(sports);
            Log.i("EllieCheck",Integer.toString(aController.getSport("mySport").getEvent().size())+" "+ Integer.toString(sports.size()));
            for (int i = 0; i < sports.size(); i++) {
                print = printData.print();
                outputWriter.write(print.get(i));
                Log.i("EllieWrite", print.get(i));
            }
            outputWriter.close();
            //display file
            Toast.makeText(getBaseContext(), (String) printData.print().get(1), Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

        // EditText test = (EditText) findViewById(R.id.sportname);
        // ReadBtn(test);


}
//String tolkenizer

