package com.example.perlmutter.storedata;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ViewDatas extends AppCompatActivity {
public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_datas);
    }
    public void nextPage(View view){
        Intent intent = new Intent(this, Storedata.class);
        EditText editText = (EditText) findViewById(R.id.RandomString);
String display = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, display);
        startActivity(intent);
    }
}
