package com.example.perlmutter.storedata;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

/**
 * Created by Ellie DeSota on 5/14/2017.
 */

public class DistanceGraph extends AppCompatActivity{
    private String sportName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Bundle bundle=getIntent().getExtras();
        sportName=bundle.getString("sportName");

        final Controller control = (Controller) getApplicationContext();
        ArrayList<Double> Sportarray = new ArrayList<>();
        ArrayList<Event> sportsArray = control.getSport(sportName).getEvents();
        Log.i("ElliePoint", Double.toString(sportsArray.get(0).getDistance()));
        double counterdt = 0;
        double rate = 1;
        for (int q = 0; q < sportsArray.size(); q++) {
            if (sportsArray.get(q).getDistance() != 0) {
                counterdt++;
                rate = sportsArray.get(q).getDistance();
                if (q == 0) {
                    Sportarray.add(0.0);
                    Sportarray.add(0.0);
                }
                Sportarray.add(counterdt);
                Sportarray.add(rate);
            }
        }

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_distance_graph);

        GraphView line_graph = (GraphView) findViewById(R.id.graph);
        DataPoint[] data = new DataPoint[Sportarray.size() / 2];

        int counter = 0;
        for (int i = 0; i < (Sportarray.size() / 2); i++) {
            data[i] = new DataPoint(Sportarray.get(i + counter), Sportarray.get(i + 1 + counter));
            counter++;
        }

        for (int j = 0; j < Sportarray.size() / 2; j++) {
            DataPoint datap = data[j];

            System.out.println(datap.getX());

            System.out.println(datap.getY());
        }
        LineGraphSeries<DataPoint> line_series =

                new LineGraphSeries<>(data);


        line_graph.addSeries(line_series);
        line_series.setDrawDataPoints(true);
        line_series.setDataPointsRadius(10); // set the radius of data point
        line_series.setOnDataPointTapListener(new OnDataPointTapListener() {
            @Override
            public void onTap(Series series, DataPointInterface dataPoint) {
                Toast.makeText(DistanceGraph.this, "Series: On Data Point clicked:" + dataPoint, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void toStoreData(View view) {
        Intent intent=new Intent(DistanceGraph.this, DistanceGraph.class);
        intent.putExtra("sportName", sportName);
        startActivity(intent);
    }

    public void toSportHome(View view) {
        Intent intent=new Intent(DistanceGraph.this, SportHome.class);
        intent.putExtra("sportName", sportName);
        startActivity(intent);
    }

    @Override
    public void onDestroy() {
        Log.i("Ellie", "In onDestroy");
        super.onDestroy();
        try {
            ArrayList<String> print;
            FileOutputStream fOut = openFileOutput("NewSport.txt", MODE_PRIVATE);
            OutputStreamWriter outputWriter = new OutputStreamWriter(fOut);
            final Controller aController = (Controller) getApplicationContext();
            ArrayList sports = aController.getSports();
            PrintData printData = new PrintData(sports);
            Log.i("EllieCheck", sports.toString());
            for (int i = 0; i < sports.size(); i++) {
                print = printData.print();
                outputWriter.write(print.get(i));

            }
            outputWriter.close();
            //display file
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
