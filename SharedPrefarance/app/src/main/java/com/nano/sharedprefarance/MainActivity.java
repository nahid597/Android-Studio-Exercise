package com.nano.sharedprefarance;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText nameText, passwordText;
    private Button loadButton, saveButton;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );


        nameText = (EditText) findViewById ( R.id.userNameId );
        passwordText = (EditText) findViewById ( R.id.userPassId );
        loadButton = (Button) findViewById ( R.id.loadButtonId );
        saveButton = (Button) findViewById ( R.id.saveButtonId );
        textView = (TextView ) findViewById ( R.id.textId );

        loadButton.setOnClickListener ( this );
        saveButton.setOnClickListener ( this );


    }

    @Override
    public void onClick(View view) {

        String name = nameText.getText ().toString ();
        String pass = passwordText.getText ().toString ();

        if (view.getId () == R.id.saveButtonId)
        {

            if (name.equals ( "" ) && pass.equals ( "" ))
            {

                Toast.makeText ( getApplicationContext (),"Please enter user name and password first",Toast.LENGTH_SHORT ).show ();
            }

            else {

                //write data

                SharedPreferences sharedPreferences = getSharedPreferences ( "userDetails", Context.MODE_PRIVATE );
                SharedPreferences.Editor editor = sharedPreferences.edit ();

                editor.putString ( "userName",name );
                editor.putString ( "userPassword",pass );

                editor.commit ();

                nameText.setText ( "" );
                passwordText.setText ( "");

            }
        }

         else if(view.getId () == R.id.loadButtonId)
        {

            //read data

            SharedPreferences sharedPreferences = getSharedPreferences ( "userDetails", Context.MODE_PRIVATE );

            if (sharedPreferences.contains ( "userName" ) && sharedPreferences.contains ( "userPassword" ))
            {

                String userNam = sharedPreferences.getString ( "userName","Data not found" );
                String userpass = sharedPreferences.getString ( "userPassword","Data not found" );

                textView.setText ( "User name: " + userNam +"\n"+ "password: " + userpass );

            }

            else

                Toast.makeText ( getApplicationContext (),"No data store",Toast.LENGTH_SHORT ).show ();





        }

    }
}
