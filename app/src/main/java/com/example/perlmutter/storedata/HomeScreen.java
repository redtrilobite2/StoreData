package com.example.perlmutter.storedata;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class HomeScreen extends Activity implements AdapterView.OnItemSelectedListener {
    public Button makeNewSport;

    Spinner spin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homescreen);

        spin = (Spinner) findViewById(R.id.spinner);
        String sports[] = {"Select a sport","Track", "Soccer", "Basketball", "Swimming"};
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, sports);
        spin.setAdapter(adapter);
        spin.setOnItemSelectedListener(this);
    }
    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
        pos=spin.getSelectedItemPosition();
        if (pos!=0) {
            Intent intent = new Intent(HomeScreen.this, SportHome.class);
            startActivity(intent);
        }
    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }
    public void toSportStyle(View view) {
        Intent intent = new Intent(HomeScreen.this, SportStyle.class);
        startActivity(intent);
    }

    public String getSportName() {
        return "Swimming";
    }


}
