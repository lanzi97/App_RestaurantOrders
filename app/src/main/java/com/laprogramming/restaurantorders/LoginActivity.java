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

    public void userCheck(String username, String password){
        boolean access=true;//remove true
        //USER CHECK
        if(access == true){
            Intent verified = new Intent(this, HomeActivity.class);//CREATE HOME ACTIVITY
            startActivity(verified);
        }
    }
}
