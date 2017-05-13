package com.example.perlmutter.storedata;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
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

public class Accuracyvstime extends AppCompatActivity {

    private String sportName;

    /* @Override
      protected void onCreate(Bundle savedInstanceState) {

        Bundle bundle=getIntent().getExtras();
        sportName=bundle.getString("sportName");

       final Controller control = (Controller) getApplicationContext();
        ArrayList<Double> Sportarray = new ArrayList<Double>();
        ArrayList<Event> sportsarray = control.getSport(sportName).getEvent();
        double counterdt = 0;
        double accuracy = 1;
        for (int q = 0; q < sportsarray.size(); q++) {

            if (sportsarray.get(q).getMissed() != 0) {
                counterdt++;
                accuracy = sportsarray.get(q).getScored() / sportsarray.get(q).getMissed();
                if (q == 0) {
                    Sportarray.add(0.0);
                    Sportarray.add(0.0);
                }
                Sportarray.add(counterdt);
                Sportarray.add(accuracy);
            }
        }

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_viewdata);

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
                Toast.makeText(Accuracyvstime.this, "Series: On Data Point clicked:" + dataPoint, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void toStoreData(View view) {
        Intent intent=new Intent(Accuracyvstime.this, Storedata.class);
        intent.putExtra("sportName", sportName);
        startActivity(intent);
    }

    public void toSportHome(View view) {
        Intent intent=new Intent(Accuracyvstime.this, SportHome.class);
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
                Log.i("EllieWrite", print.get(i));
            }
            outputWriter.close();
            //display file
            Toast.makeText(getBaseContext(), (String) printData.print().get(1), Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/
}


