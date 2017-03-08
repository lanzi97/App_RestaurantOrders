package com.laprogramming.restaurantorders;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

import static java.lang.System.out;

public class LoginActivity extends AppCompatActivity {

    private static final int SERVER_SOCKET = 4444;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Equivalent
        //EditText userEditText=(EditText) findViewById(R.id.login_user);
        //String username=userEditText.getText().toString();

        //final String username=((EditText) findViewById(R.id.login_user)).getText().toString();
        //final String password=((EditText) findViewById(R.id.login_password)).getText().toString();

        //Handle floatingActionButton click
        FloatingActionButton floatButton=(FloatingActionButton) findViewById(R.id.login_float_button);
        floatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username=((EditText) findViewById(R.id.login_user)).getText().toString();
                String password=((EditText) findViewById(R.id.login_password)).getText().toString();
                userCheck(username,password);
            }
        });
    }

    /*
    Check user credentials and open up new activity
     */
    public void userCheck(String username, String password) {

        String line;
        int access;

        Toast.makeText(this, "Username = "+ username + "\nPassword = "+ password, Toast.LENGTH_LONG).show();

        try {
            Socket socket = new Socket("127.0.0.1", SERVER_SOCKET); //Connessione al socket prestabilito
            //TODO connessione non si avvia
            
            DataOutputStream writer = new DataOutputStream(socket.getOutputStream());
            DataInputStream reader = new DataInputStream(socket.getInputStream());

            //line = "login " + username + " " + password;//Creazione comando login
            writer.write(1);//Invia comando di login al server
            access = reader.read();//Controlla accesso

            if (access == 1) {
                Intent verified = new Intent(this, TablesActivity.class);
                startActivity(verified);
            } else {
                Toast.makeText(this, "Credenziali errate", Toast.LENGTH_SHORT).show();
            }
        }
        catch(IOException e){};
    }
}
