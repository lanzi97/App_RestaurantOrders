package com.laprogramming.restaurantorders;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        //Handle floatingActionButton click
        FloatingActionButton floatButton=(FloatingActionButton) findViewById(R.id.login_float_button);
        floatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmLogin();
            }
        });

        //Handle keyboard done click after imput password
        EditText passwordEditText=(EditText) findViewById(R.id.login_password);
        passwordEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId==EditorInfo.IME_ACTION_DONE){
                    confirmLogin();
                    return true;
                }
                return false;
            }
        });
    }

    /*
    Verify credentials after clicked a button
     */
    private void confirmLogin(){
        String username=((EditText) findViewById(R.id.login_username)).getText().toString();
        String password=((EditText) findViewById(R.id.login_password)).getText().toString();

        userCheck(username, password);
    }

    /*
    Check user credentials and open up new activity
     */
    private void userCheck(String username, String password){
        boolean access=true;    //TODO remove true

        Toast.makeText(this, "Username = "+ username + "\nPassword = "+ password, Toast.LENGTH_LONG).show();

        if(access == true){
            Intent verified = new Intent(this, TablesActivity.class);
            startActivity(verified);
        }
    }
}
