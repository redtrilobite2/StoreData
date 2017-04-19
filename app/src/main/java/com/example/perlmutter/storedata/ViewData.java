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

import java.util.ArrayList;

public class ViewData extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ArrayList<Integer> Sportarray = new ArrayList<Integer>();
        Sportarray.add(0);
        Sportarray.add(5);
        Sportarray.add(1);
        Sportarray.add(8);
        Sportarray.add(2);
        Sportarray.add(3);
        Sportarray.add(3);
        Sportarray.add(5);
        Sportarray.add(4);
        Sportarray.add(5);
        super.onCreate(savedInstanceState);
        Log.i("Kent", "On create, ready to set view");
        setContentView(R.layout.activity_viewdata);
        Log.i("Kent", "Finish setting view");
        GraphView line_graph = (GraphView) findViewById(R.id.graph);
        DataPoint[] data = new DataPoint[Sportarray.size()];
        Log.i("Kent", "Finish creating data point array");
        int counter = 0;
        for(int i = 0; i<(Sportarray.size()/2); i++){
            data[i] = new DataPoint (Sportarray.get(i+counter), Sportarray.get(i+1+counter));
            counter ++;}
        Log.i("Kent", "Completed population of datapoint array");
        for(int j =0; j<data.length; j++ ){
            DataPoint datap = data[j];
            if(datap != null){Log.i("Kent", "Good");}
            if(datap == null){
                Log.i("Kent", "datap is null");
            }
            datap.getX();
            datap.getY();
        }
        LineGraphSeries<DataPoint> line_series =

               new LineGraphSeries<DataPoint>(data);
        Log.i("Kent", "Created line graph series");
        if(line_graph!=null)
        {        Log.i("Kent", "linegraph is null");}
        if(line_series !=null){    Log.i("Kent", "line series is null");}
        line_graph.addSeries(line_series);
        Log.i("Kent", "Add line series");
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
}
//String tolkenizer

