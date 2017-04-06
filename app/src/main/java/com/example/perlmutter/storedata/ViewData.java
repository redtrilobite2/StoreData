package com.example.perlmutter.storedata;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ViewData extends AppCompatActivity{

    @Override
    public void startActivity(Intent intent) {
        Intent viewdata = new Intent(this, ViewData.class);
        startActivity(viewdata);
    }

    public void nextScreen(View view) {
        Intent intent=new Intent(ViewData.this, Storedata.class);
        startActivity(intent);
    }
}


