package com.laprogramming.restaurantorders;

import android.graphics.Color;
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
    }

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
                Toast.makeText(getApplicationContext(), "Pressed back!", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
