package com.example.perlmutter.storedata;

import android.app.Application;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.example.perlmutter.storedata.R;

import java.util.ArrayList;

/**
 * This class gets the graph data.
 */

public class MyData
{
    public ArrayList GraphData;

    /**
     * Contructs a MyData object with a graphdata ArrayList
     * @param graphdata data from the graph
     */
    public MyData(ArrayList graphdata)
    {
        this.GraphData = graphdata;
    }

    /**
     * Returns the graph data
     * @return
     */
    public ArrayList getGraphData() {

        return GraphData;
    }


}



