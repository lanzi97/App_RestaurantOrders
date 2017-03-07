package com.laprogramming.restaurantorders;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    /*
    Check user credentials and open up new activity
     */
    public void userCheck(String username, String password){
        boolean access=true;    //TODO remove true

        if(access == true){
            //Intent verified = new Intent(this, HomeActivity.class);   //TODO CREATE HOME ACTIVITY
            //startActivity(verified);
        }
    }
}
