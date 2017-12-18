package com.nano.fragmentdemo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentManagerNonConfig;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );


        String [] name = {"Nahid","Hasan","Milon","Rusho","Rakib"," Vog","Kumu"};

        listView = (ListView) findViewById ( R.id.listViewId );

        ArrayAdapter <String> adapter = new ArrayAdapter<String> ( this,android.R.layout.simple_list_item_1,name );

        listView.setAdapter ( adapter );
        listView.setOnItemClickListener ( this );

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


        android.app.Fragment fragment;

        if (i == 0)
        {
            fragment = new Nahid_Fragment ();
            android.app.FragmentManager fragmentManager = getFragmentManager ();
            android.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction ();
            android.app.FragmentTransaction replace = fragmentTransaction.replace ( R.id.fragmentId, fragment );
            fragmentTransaction.commit ();


        }

        if (i == 1)
        {
            fragment = new Milon_fragment ();
            android.app.FragmentManager fragmentManager = getFragmentManager ();
            android.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction ();
            fragmentTransaction.replace ( R.id.fragmentId, fragment );
            fragmentTransaction.commit ();

        }

    }
}