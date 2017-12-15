package com.nano.optionsmenudemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater ();
        menuInflater.inflate ( R.menu.menu_layout,menu );
        return  super.onCreateOptionsMenu ( menu );
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId () == R.id.SettingId)
        {
            Toast.makeText ( MainActivity.this,"setting is selected",Toast.LENGTH_SHORT ).show ();
        }

       else if(item.getItemId () == R.id.ShareId)
        {
            Toast.makeText ( MainActivity.this,"share is selected",Toast.LENGTH_SHORT ).show ();
        }

       else if(item.getItemId () == R.id.FeedBackId)
        {
            Toast.makeText ( MainActivity.this,"Feed back is selected",Toast.LENGTH_SHORT ).show ();
        }

        else if(item.getItemId () == R.id.ShareUpId)
        {
            Toast.makeText ( MainActivity.this,"Share up is selected",Toast.LENGTH_SHORT ).show ();
        }



        return super.onOptionsItemSelected ( item );
    }
}
