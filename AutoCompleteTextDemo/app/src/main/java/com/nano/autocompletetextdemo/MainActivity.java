package com.nano.autocompletetextdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_SHORT;

public class MainActivity extends AppCompatActivity {

    private AutoCompleteTextView autoCompleteTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );

        getSupportActionBar ().setDisplayHomeAsUpEnabled ( true );
        getSupportActionBar ().setDisplayShowHomeEnabled ( true );


        autoCompleteTextView = (AutoCompleteTextView) findViewById ( R.id.autocompleteId );

        String[] countryNames = getResources ().getStringArray ( R.array.country_names );

        ArrayAdapter<String> adapter = new ArrayAdapter<String> ( this,android.R.layout.simple_list_item_1,countryNames );
        autoCompleteTextView.setThreshold ( 1 );
        autoCompleteTextView.setAdapter ( adapter );

        autoCompleteTextView.setOnItemClickListener ( new AdapterView.OnItemClickListener () {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                String value = autoCompleteTextView.getText ().toString ();

               Toast.makeText ( getApplicationContext (),value,Toast.LENGTH_SHORT ).show ();

            }
        } );

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if ((item.getItemId () == android.R.id.home))
        {
            this.finish ();
        }

        return super.onOptionsItemSelected ( item );
    }
}
