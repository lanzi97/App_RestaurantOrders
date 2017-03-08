package com.laprogramming.restaurantorders;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Equivalent
        //EditText userEditText=(EditText) findViewById(R.id.login_user);
        //String username=userEditText.getText().toString();
        final String username=((EditText) findViewById(R.id.login_user)).getText().toString();
        final String password=((EditText) findViewById(R.id.login_password)).getText().toString();

        //Handle floatingActionButton click
        FloatingActionButton floatButton=(FloatingActionButton) findViewById(R.id.login_float_button);
        floatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userCheck(username,password);
            }
        });
    }

    /*
    Check user credentials and open up new activity
     */
    public void userCheck(String username, String password){
        boolean access=true;    //TODO remove true

        Toast.makeText(this, "Username = "+ username + "\nPassword = "+ password, Toast.LENGTH_LONG).show();

        if(access == true){
            Intent verified = new Intent(this, TablesActivity.class);
            startActivity(verified);
        }
    }
}
