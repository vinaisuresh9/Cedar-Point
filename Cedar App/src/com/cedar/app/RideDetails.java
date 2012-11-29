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
	String duration;
	String heightreq;
	String speed;
	String description;
	
	Ride ride;
	
	//Text View 
	TextView textView;
	ImageView imageView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        duration = "";
        heightreq = "";
        speed = "";
        description = "";
        
        //Creating the Layout dynamically
        layout = new RelativeLayout(this);
        RelativeLayout.LayoutParams rlp = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.MATCH_PARENT);
        layout.setLayoutParams(rlp);
        layout.setBackgroundColor(getResources().getColor(R.color.black));
        setContentView(layout);
        
        this.DetailsforRide();
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
    
    
    
    public void DetailsforRide()
    {
    	Intent intent = getIntent();
    	String[] ride = intent.getStringArrayExtra(ListofRides.RIDE);
    	
    	RideType r;
    	
    	if (ride[1].equals("Roller Coaster"))
    		r = RideType.RollerCoaster;
    	else
    		r = RideType.ThrillRide;
    	
    	
    	switch(r)
    	{
    	case RollerCoaster:
    		textView = this.CreateTextView(ride[0], ride[2], ride[3], ride[4], ride[5]);
    		layout.addView(textView);
    		
    		imageView = CreateImageView(R.drawable.bluestreak_thumb);
    		layout.addView(imageView);
    		break;
    	
	    case ThrillRide:
			textView = this.CreateTextView(ride[0], ride[3], ride[5]);
			layout.addView(textView);
			
			imageView = CreateImageView(R.drawable.calypso_thumb);
			layout.addView(imageView);
			break;
			
    	}
    }
    
    //TextView creation for roller coasters which have duration and speed statistics
    public TextView CreateTextView(String name, String duration, String heightreq, String speed, String description)

    {
    	TextView tv = new TextView(this);
		RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
		lp.addRule(RelativeLayout.CENTER_IN_PARENT);
		lp.addRule(RelativeLayout.CENTER_HORIZONTAL);
		tv.setLayoutParams(lp);
		tv.setTextColor(getResources().getColor(R.color.white));
		tv.setText("Name:	" + name + "\nDuration: 	" + duration +
				"\nHeight Requirement:	" + heightreq +
				"\nSpeed:		" + speed + "\n" +
					description);
		return tv;
    }
    
    
    //TextView creation for thrillrides, which do not have duration and speed statistics
    public TextView CreateTextView(String name, String heightreq, String description)
    {
    	TextView tv = new TextView(this);
		RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
		lp.addRule(RelativeLayout.CENTER_IN_PARENT);
		lp.addRule(RelativeLayout.CENTER_HORIZONTAL);
		tv.setLayoutParams(lp);
		tv.setTextColor(getResources().getColor(R.color.white));
		tv.setText("Name:	" + name + "\nHeight Requirement:	" + heightreq + "\n" +
					description);
		return tv;
    }
    
    public ImageView CreateImageView (int imageResource)
    {
    	ImageView image = new ImageView(this);
		RelativeLayout.LayoutParams l = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
		l.addRule(RelativeLayout.CENTER_HORIZONTAL);
		image.setLayoutParams(l);
		image.setImageResource(imageResource);
		return image;
    }
    
    public enum RideType
    {
    	RollerCoaster,ThrillRide
    }
    
    

}
