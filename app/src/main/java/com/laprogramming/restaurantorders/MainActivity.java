package com.laprogramming.restaurantorders;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Retreive data from last activity  TODO with more than one table
        Intent receive=getIntent();
        int tableNumber=receive.getIntExtra("tableNumber",-1);

        initToolbar(tableNumber);
    }


    /*
    Initialize toolbar with back button and title
     */
    private void initToolbar(int tableNumber){
        //TODO put string constant in /res/strings.xml file
        Toolbar toolbar=(Toolbar) findViewById(R.id.main_toolbar);
        toolbar.setTitle("Table "+tableNumber); //TODO with more than one table
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);

        toolbar.setNavigationIcon(R.drawable.ic_toolbar_arrow_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO verify while opening category, also hw back button
                onBackPressed();
            }
        });

    }
}
