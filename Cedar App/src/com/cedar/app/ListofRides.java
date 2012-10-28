package com.cedar.app;

import java.util.*;

import android.os.Bundle;
import android.app.Activity;
import android.view.*;
import android.widget.*;

public class ListofRides extends Activity {
	
	public List<String> ridesList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listof_rides);
        ridesList = new LinkedList<String>();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_listof_rides, menu);
        return true;
    }
    
    /*
     * Function to toggle Ride booleans for route information
     * 
     */
    public void AddtoList (View view)
    {
    	final CheckBox check = (CheckBox)view;
    	 switch (check.getId())
    	 {
    	 case R.id.blue_streak_button:
    		 if (check.isChecked())
    		 {
    			 ridesList.add(this.getString(R.string.blue_streak));
    		 }
    		 else
    		 {
    			 ridesList.remove(this.getString(R.string.blue_streak));
    		 }
    		 if (ridesList.size() > 0)
    		 {
    			 System.out.println(ridesList.get(0));
    		 }
    	 
    	 }
    }
    
}
