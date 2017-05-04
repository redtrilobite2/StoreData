import android.app.Application;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.example.perlmutter.storedata.R;

import java.util.ArrayList;

/**
 * Created by Perlmutter on 4/25/2017.
 */

public class MyData
{
    public ArrayList GraphData;

    public MyData(ArrayList graphdata)
    {
        this.GraphData = graphdata;
    }

    public ArrayList getGraphData() {

        return GraphData;
    }


}



