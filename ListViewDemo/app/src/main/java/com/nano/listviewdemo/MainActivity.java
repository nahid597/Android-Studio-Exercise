package com.nano.listviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );

        listView = (ListView ) findViewById ( R.id.listViewId );


        final String [] country = getResources ().getStringArray ( R.array.country_names );

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String> ( MainActivity.this,R.layout.simple_view,R.id.textViewId,country);

        listView.setAdapter ( arrayAdapter );

        listView.setOnItemClickListener ( new AdapterView.OnItemClickListener () {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                String vlue = country[i];

                Toast.makeText ( MainActivity.this,"["+i+"]" + vlue,Toast.LENGTH_SHORT ).show ();


            }
        } );


    }
}
