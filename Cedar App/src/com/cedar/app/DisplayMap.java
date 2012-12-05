package com.cedar.app;

import java.io.IOException;
import java.util.ArrayList;

import android.os.Bundle;
import android.os.Parcelable;
import android.app.Activity;
import android.content.*;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.*;
import android.graphics.*;
import android.support.v4.app.NavUtils;

public class DisplayMap extends Activity {
	
	private ScrollView scroller;
	private RelativeLayout layout;
	public ArrayList<MapNode> nodes;
	private ArrayList<Ride> ridesList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

		try {
			Bitmap b = BitmapFactory.decodeStream(getAssets().open("cedarpointmap.png"));
			setContentView(new MapCanvas(this, b));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		

        for (Ride r : ListofRides.ridesList)
        {
        	System.out.println(r.name);
        }
       

    }
    
    //create options menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_display_map, menu);
        return true;
    }

    //when items are selected
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    
    public void CreateMap() throws IOException
    {
    	Bitmap b = BitmapFactory.decodeStream(getAssets().open("cedarpointmap.bmp"));

    	
    }

}
