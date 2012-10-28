package com.cedar.app;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.*;

public class ListofRides extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listof_rides);
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
    public void ToggleRideStates (View view)
    {
    	if (view.getId() == R.id.blue_streak_button)
    	{
    		System.out.println("cool");
    		
    	}
    }
    
}
