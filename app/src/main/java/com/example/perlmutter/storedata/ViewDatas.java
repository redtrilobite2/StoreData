package com.example.perlmutter.storedata;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ViewDatas extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_datas);
    }

    //Button addData = (Button) findViewById(R.id.Add);

   // addData.setOnClickListener(new View.OnClickListener() {

        //@Override
        public void nextScreen(View view) {
            Intent intent=new Intent(ViewDatas.this, Storedata.class);
            startActivity(intent);
        }
}
   // });

