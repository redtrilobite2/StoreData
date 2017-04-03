package com.example.perlmutter.storedata;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

import static java.lang.Double.parseDouble;

public class Storedata extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storedata);
    }
    public void SaveData(View view){
        EditText number1 = (EditText) findViewById(R.id.data1);
        EditText number2 = (EditText) findViewById(R.id.data2);


        String num1str =  number1.getText().toString();
        String num2str =  number2.getText().toString();
        Double num1 = parseDouble(num1str);
        Double num2 = parseDouble(num2str);

        ArrayList<Double> num1s = new ArrayList<Double>();
        ArrayList<Double> num2s = new ArrayList<Double>();

        num1s.add(num1);
        num2s.add(num2);

    }
    public void ViewData(View view){

    }

    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);
        Intent viewdata = new Intent(getApplicationContext(), ViewData.class);
        startActivity(viewdata);
    }
}
