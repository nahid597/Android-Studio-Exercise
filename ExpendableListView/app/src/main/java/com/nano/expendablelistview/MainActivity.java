package com.nano.expendablelistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ExpandableListView expandableListView;
    private CustomData customData;
    private int lastExpandableData = -1;

    List<String> headerListData;
    HashMap<String,List<String>> childMapData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );

        expandData();

        expandableListView = (ExpandableListView) findViewById ( R.id.expendableId );
        customData = new CustomData(this,headerListData,childMapData);
        expandableListView.setAdapter (customData );

        expandableListView.setOnGroupClickListener ( new ExpandableListView.OnGroupClickListener () {
            @Override
            public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long l) {

                String groupName = headerListData.get ( i );

                Toast.makeText ( getApplicationContext (),"group name: " + groupName,Toast.LENGTH_SHORT ).show ();


                return false;
            }
        } );

        expandableListView.setOnGroupCollapseListener ( new ExpandableListView.OnGroupCollapseListener () {
            @Override
            public void onGroupCollapse(int i) {

                String groupName = headerListData.get ( i );

                Toast.makeText ( getApplicationContext (),"collaps name: " + groupName,Toast.LENGTH_SHORT ).show ();

            }
        } );


        expandableListView.setOnChildClickListener ( new ExpandableListView.OnChildClickListener () {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i1, long l) {

                String childName = childMapData.get ( headerListData.get ( i ) ).get ( i1 );

                Toast.makeText ( getApplicationContext (),"child name: " + childName,Toast.LENGTH_SHORT ).show ();

                return false;
            }
        } );

        expandableListView.setOnGroupExpandListener ( new ExpandableListView.OnGroupExpandListener () {
            @Override
            public void onGroupExpand(int i) {

                if (lastExpandableData != -1 && lastExpandableData != i)
                {
                    expandableListView.collapseGroup ( lastExpandableData );

                }
                lastExpandableData = i;

            }
        } );


    }


    public void expandData()
    {
        String [] header = getResources ().getStringArray ( R.array.group_string );
        String [] child = getResources ().getStringArray ( R.array.child_string);

        headerListData = new ArrayList<> (  );
        childMapData = new HashMap<> (  );

        for (int i = 0; i < header.length; i ++)
        {

            headerListData.add ( header[i] );

            List<String> childdata = new ArrayList<> (  );
            childdata.add ( child[i] );

            childMapData.put ( headerListData.get ( i ),childdata );


        }


    }
}

