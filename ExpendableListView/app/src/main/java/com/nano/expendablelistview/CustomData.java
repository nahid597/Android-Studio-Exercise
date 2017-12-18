package com.nano.expendablelistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

/**
 * Created by nahid on 12/18/17.
 */

public class CustomData extends BaseExpandableListAdapter {

    Context context;
    List<String> headerListData;
    HashMap<String,List<String>> childMapData;


    public CustomData(Context context, List<String> headerListData, HashMap<String, List<String>> childMapData) {
        this.context = context;
        this.headerListData = headerListData;
        this.childMapData = childMapData;
    }


    @Override
    public int getGroupCount() {
        return headerListData.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return childMapData.get ( headerListData.get ( i ) ).size ();
    }

    @Override
    public Object getGroup(int i) {
        return headerListData.get ( i );
    }

    @Override
    public Object getChild(int i, int i1) {
        return childMapData.get ( headerListData.get ( i ) ).get ( i1 );
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {

        String headerText = (String ) getGroup ( i );

        if (view == null)
        {
            LayoutInflater inflater = ( LayoutInflater ) context.getSystemService ( Context.LAYOUT_INFLATER_SERVICE );

            view = inflater.inflate ( R.layout.group_layout,null );

        }

        TextView textView = view.findViewById ( R.id.groupTextId );
        textView.setText ( headerText );

        return view;
    }



    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {


        String childText = (String ) getChild ( i,i1 );

        if (view == null)
        {
            LayoutInflater inflater = ( LayoutInflater ) context.getSystemService ( Context.LAYOUT_INFLATER_SERVICE );

            view = inflater.inflate ( R.layout.chield_layout,null );

        }

        TextView textView = view.findViewById ( R.id.chieldtextId );
        textView.setText ( childText );

        return view;
    }



    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }
}
