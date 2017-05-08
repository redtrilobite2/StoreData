package com.example.perlmutter.storedata;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class CreateSport extends AppCompatActivity {
    //static final int READ_BLOCK_SIZE = 200;
    //private ArrayList<Sport> sports = new ArrayList<Sport>();
    //private PrintData printSports = new PrintData();
   // private ArrayList<Event> events = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createsport);

        //EditText sportName = (EditText) findViewById(R.id.sportname);
    }

    public void toHomeScreen(View view) throws IOException {
        Intent intent = new Intent(CreateSport.this, HomeScreen.class);
        startActivity(intent);
        newSport();
    }

    public void toStoreData(View view) throws IOException {
        newSport();
        Intent intent = new Intent(CreateSport.this, SportHome.class);
        EditText namePull = (EditText) findViewById(R.id.sportname);
        String nameStr = namePull.getText().toString();
        intent.putExtra("sportName", nameStr);
        startActivity(intent);
    }


    public void newSport() throws IOException {
        //get Global Controller Class object (see application tag in AndroidManifest.xml)
        Controller aController = (Controller) getApplicationContext();
        EditText namePull = (EditText) findViewById(R.id.sportname);
        EditText commentPull = (EditText) findViewById(R.id.commentCreateSport);

        String nameStr = namePull.getText().toString();
        String commentStr = commentPull.getText().toString();

        Sport sport = new Sport(nameStr,commentStr);

        aController.addSport(sport);

        String check1 = sport.getComment();
        String check2 = sport.getName();

        Log.i("Ellie", check1 + check2);
    }
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
   // @Override
   /* public void click() {
        //super.onDestroy();
        Log.i("Ellie", "I entered");
        try {
            ArrayList<String> print;
            FileOutputStream fOut = openFileOutput("NewSport.txt", MODE_PRIVATE);
            OutputStreamWriter outputWriter = new OutputStreamWriter(fOut);
            final Controller aController = (Controller) getApplicationContext();
            ArrayList sports = aController.getSports();
            PrintData printData = new PrintData();
            for (int i = 0; i < aController.getSports().size(); i++) {
                print = printData.print(sports);
                outputWriter.write(print.get(i));
                Log.i("Ellie", print.get(i));
            }
            outputWriter.close();
            //display file
            Toast.makeText(getBaseContext(), (String) printData.print(sports).get(1), Toast.LENGTH_LONG).show();
            Log.i("Ellie", (String) printData.print(sports).get(1));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
*/


/*    public void ReadBtn(View v) throws IOException {
        //reading text from file
        try {
            FileInputStream fIn = openFileInput("NewSport.txt");
            InputStreamReader inRead = new InputStreamReader(fIn);


            char[] inputBuffer = new char[READ_BLOCK_SIZE];
            String s = "";
            int charRead;

            while ((charRead = inRead.read(inputBuffer)) > 0) {
                // char to string conversion
                String readString = String.copyValueOf(inputBuffer, 0, charRead);
                s += readString;
            }
            inRead.close();
            sportName.setText(s);
            Toast.makeText(getBaseContext(), s, Toast.LENGTH_SHORT).show();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/
}




