package com.laprogramming.restaurantorders;

import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

public class TablesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tables);

        initToolbar();

        //Handle floatingActionButton click
        FloatingActionButton floatButton=(FloatingActionButton) findViewById(R.id.tables_float_button);
        floatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmTables();
            }
        });
    }


    /*
    Open un new activity after button click
     */
    private void confirmTables(){
        //TODO manage more than one table (public method that return int array?)
        int tableNumber=10;

        Intent confirmed=new Intent(this, MainActivity.class);
        confirmed.putExtra("tableNumber", tableNumber);
        startActivity(confirmed);
    }


    /*
    Initialize toolbar with back button and title
     */
    private void initToolbar(){
        //TODO put string constant in /res/strings.xml file
        Toolbar toolbar=(Toolbar) findViewById(R.id.tables_toolbar);
        toolbar.setTitle("Tables");
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);

        toolbar.setNavigationIcon(R.drawable.ic_toolbar_arrow_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }
}
