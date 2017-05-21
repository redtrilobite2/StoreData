package com.example.perlmutter.storedata;


import android.support.design.widget.AppBarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.widget.LinearLayoutCompat;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * Created by Ellie DeSota on 5/17/2017.
 * The class ViewComment extends the application activity activity_view_comment.
 * This class pulls the comments and the dates from the event class and displays them for the user
 * to scan through
 */

public class ViewComment extends AppCompatActivity{
    String name;
    @Override
public void onCreate(Bundle savedInstanceState){
    //loop based on classes needed
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_view_comment);
        Controller aController = (Controller) getApplicationContext();
        Bundle bundle = getIntent().getExtras();
        name = bundle.getString("sportName");

        ArrayList<String> comments = aController.getSport(name).getEventComments();
/*for(int i = 0; i<comments.size(); i++){
    EditText myEditText = new EditText(getApplicationContext()); //Pass it an Activity or Context
    myEditText.setLayoutParams(new LinearLayoutCompat.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, AppBarLayout.LayoutParams.WRAP_CONTENT)); // Pass two args; must be LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT, or an integer pixel value.
   getApplication().addView(myEditText);*/
}}



