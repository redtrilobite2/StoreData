package com.example.perlmutter.storedata;

import android.content.Intent;
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
/**
 Constructs Graph for points vs time
 */
public class Pointsvstime extends AppCompatActivity {

    private String sportName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Bundle bundle = getIntent().getExtras();
        sportName = bundle.getString("sportName");
        /**
         * Gets the sport for which the graph will be constructed
         */
        final Controller control = (Controller) getApplicationContext();
        /**
         *Creates arraylist for the data points to be added
         */
        ArrayList<Double> Sportarray = new ArrayList<>();

        //imports array list of information from the sport
        ArrayList<Event> sportsarray = control.getSport(sportName).getEvents();
        //variable for the x-axis
        double counterdt = 0;

        double point;

        for (int q = 0; q < sportsarray.size(); q++) {

                counterdt++;
                point = sportsarray.get(q).getPoints();
                if (q == 0) {
                    Sportarray.add(0.0);
                    Sportarray.add(0.0);
                    //graph starts at (0,0)
                }
                Sportarray.add(counterdt);
                Sportarray.add(point);

        }

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_pointsvstime);

        GraphView line_graph = (GraphView) findViewById(R.id.graph);
        DataPoint[] data = new DataPoint[Sportarray.size() / 2];
//creates list of data points
        int counter = 0;
        //fills data point list with array list of accuracy vs time
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

//Creates graph
        line_graph.addSeries(line_series);
        line_series.setDrawDataPoints(true);
        line_series.setDataPointsRadius(10); // set the radius of data point
        line_series.setOnDataPointTapListener(new OnDataPointTapListener() {
            @Override
            public void onTap(Series series, DataPointInterface dataPoint) {
                Toast.makeText(Pointsvstime.this, "Series: On Data Point clicked:" + dataPoint, Toast.LENGTH_SHORT).show();
            }
        });
    }
    /**
     *Switches to entering data interface
     * @param view
     */
    public void toStoreData(View view) {
        Intent intent = new Intent(Pointsvstime.this, PointBased.class);
        intent.putExtra("sportName", sportName);
        startActivity(intent);
    }
    /**
     * Switches to sport home interface
     * @param view
     */
    public void toSportHome(View view) {
        Intent intent = new Intent(Pointsvstime.this, SportHome.class);
        intent.putExtra("sportName", sportName);
        startActivity(intent);
    }
    /**
     *Adds the data into an arraylist and then prints the arraylist into a text file.
     */
    @Override
    public void onDestroy() {
        super.onDestroy();
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
    }
}


