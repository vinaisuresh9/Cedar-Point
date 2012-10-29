package com.cedar.app;

import android.app.Activity;
import android.content.*;
import android.widget.*;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;

public class RideDetails extends Activity {
	RelativeLayout layout;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        
        //Creating the Layout dynamically
        layout = new RelativeLayout(this);
        RelativeLayout.LayoutParams rlp = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.MATCH_PARENT);
        layout.setLayoutParams(rlp);
        layout.setBackgroundColor(getResources().getColor(R.color.black));
        setContentView(layout);
        
        
        
        Intent intent = getIntent();
        int message = intent.getIntExtra(ListofRides.RIDE, 0);
        DetailsforRide(message);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_ride_details, menu);
        return true;
    }

    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    
    public void DetailsforRide(int ride)
    {
    	switch(ride)
    	{
    	case R.string.blue_streak:
    		TextView tv = new TextView(this);
    		RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.WRAP_CONTENT,
                    RelativeLayout.LayoutParams.WRAP_CONTENT);
    		lp.addRule(RelativeLayout.CENTER_IN_PARENT);
    		lp.addRule(RelativeLayout.CENTER_HORIZONTAL);
    		tv.setLayoutParams(lp);
    		tv.setTextColor(getResources().getColor(R.color.white));
    		tv.setText("Duration: 	1 min, 45 sec\n" +
    				"Height Requirement:	48\"\n" +
    				"Speed:		40 mph\n" +
    				"Cedar Point's classic wooden roller coaster!");
    		layout.addView(tv);
    		
    		ImageView image = new ImageView(this);
    		RelativeLayout.LayoutParams l = new RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.WRAP_CONTENT,
                    RelativeLayout.LayoutParams.WRAP_CONTENT);
    		l.addRule(RelativeLayout.CENTER_HORIZONTAL);
    		image.setLayoutParams(l);
    		image.setImageResource(R.drawable.bluestreak_thumb);
    		//layout.setBackgroundResource(R.drawable.bluestreak_thumb);
    		layout.addView(image);
    		
    		break;
    	}
    }

}
