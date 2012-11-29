package com.cedar.app;

import java.io.IOException;
import java.util.*;
import android.os.Bundle;
import android.app.Activity;
import android.view.*;
import android.widget.*;
import android.content.*;

public class ListofRides extends Activity  {
	
	private RelativeLayout layout;
	private ScrollView scroller;
	public List<Ride> ridesList;
	public List<Ride> fullListofRides;
	public final static String RIDE = "com.cedar.app.ride";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        
        //Create Layout programmatically with textviews
        scroller = new ScrollView(this);
        layout = new RelativeLayout(this);
        RelativeLayout.LayoutParams rlp = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        layout.setLayoutParams(rlp);
        layout.setBackgroundColor(getResources().getColor(R.color.black));
        
        fullListofRides = new LinkedList<Ride>();
        ridesList = new LinkedList<Ride>();
        
        try {
        	for (int i = 1; i < 31; i ++)
        	{
        		fullListofRides.add(Ride.DeserializeFromXML(getAssets().open("Rides/Ride" + i)));
        	}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
        
        CreateScreen();
        
        CreateMapButton();
        
        scroller.addView(layout);
        setContentView(scroller);

        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_listof_rides, menu);
        return true;
    }
    
    public void CreateMapButton()
    {
    	
    	Button b = new Button(this);
    	RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
    	
    	b.setId(61);
    	b.setText("View Map");
    	b.setTextColor(getResources().getColor(R.color.white));
    	lp.addRule(RelativeLayout.BELOW, 60);
    	b.setLayoutParams(lp);
    	b.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
		    	Intent intent = new Intent(getApplicationContext(), DisplayMap.class);
		    	startActivity(intent);
			}
		});
    	
    	layout.addView(b);
    
    	
    }
    
    public void CreateScreen()
    {
        int lastid = 1;

        for (Ride r : fullListofRides)
        {
        	EnhancedTextView tv = CreateTextView(r, lastid);

       		 //Handle Ride Details Clicking
       		 tv.setOnClickListener(new View.OnClickListener() {
				
				public void onClick(View v) {
					EnhancedTextView etv = (EnhancedTextView) v;
					Intent intent = new Intent(getApplicationContext(), RideDetails.class);
					String[] array = {etv.ride.name, etv.ride.ridetype, etv.ride.duration, etv.ride.heightreq,
							etv.ride.speed, etv.ride.description};
					
			   		intent.putExtra(RIDE, array);

			   		startActivity(intent);
					
				}
			}); 
       		 layout.addView(tv);
       		 
       		 EnhancedCheckBox e = CreateCheckBox(r, lastid + 30);
       		 
       		 e.setOnClickListener(new View.OnClickListener() {
				
				public void onClick(View v) {
					if (((EnhancedCheckBox) v).isChecked())
					{
						ridesList.add(((EnhancedCheckBox) v).ride);
					}
					else
					{
						ridesList.remove((((EnhancedCheckBox) v).ride));
					}
					
					
				}
			});
       		 
       		 layout.addView(e);
       		lastid ++;
        }
    }
    
    
    public EnhancedTextView CreateTextView(Ride r, int id)
    {
    	EnhancedTextView tv = new EnhancedTextView(this, r);
		RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
		lp.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
		if (id != 1)
		{
			lp.addRule(RelativeLayout.BELOW, id - 1);
		}
		else
		{
			lp.addRule(RelativeLayout.ALIGN_PARENT_TOP);
		}
		tv.setLayoutParams(lp);
		tv.setTextColor(getResources().getColor(R.color.white));
		tv.setText(r.name);
		tv.setId(id);
		tv.setTextSize(25);
		
		
		
		return tv;
    }
    
    
    public EnhancedCheckBox CreateCheckBox(Ride r, int id)
    {
    	EnhancedCheckBox e = new EnhancedCheckBox(this, r);
    	RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
    	lp.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
    	if (id != 1)
    	{
    		lp.addRule(RelativeLayout.BELOW, id-1);
    	}
    	//Align with text
    	lp.addRule(RelativeLayout.ALIGN_TOP, id - 30);
    	lp.addRule(RelativeLayout.ALIGN_BOTTOM, id - 30);
    	e.setLayoutParams(lp);
    	e.setId(id);
    	
    	return e;

    }
    
    
    public void ViewMap(View view)
    {
    	Intent intent = new Intent(this, DisplayMap.class);
    	startActivity(intent);
    	
    }

    
    //Function to allow details for each ride to show up when clicked
    /*public void RideDetails(View view)
    {
    	Intent intent = new Intent(this, RideDetails.class);
    	
   	 switch (view.getId())
   	 {
   	 case R.id.blue_streak:
   		 intent.putExtra(RIDE, R.string.blue_streak);
   		 startActivity(intent);
   		 break;
   	case R.id.calypso:
  		 intent.putExtra(RIDE, R.string.calypso);
  		 startActivity(intent);
  		 break;
   	case R.id.cedar_downs:
  		 intent.putExtra(RIDE, R.string.cedar_downs);
  		 startActivity(intent);
  		 break;
   	case R.id.cedar_mine:
 		 intent.putExtra(RIDE, R.string.cedar_creek_mine);
 		 startActivity(intent);
 		 break;
   	case R.id.corkscrew:
 		 intent.putExtra(RIDE, R.string.corkscrew);
 		 startActivity(intent);
 		 break;
   	case R.id.dodgem:
 		 intent.putExtra(RIDE, R.string.dodgem);
 		 startActivity(intent);
 		 break;
   	case R.id.gemini:
		 intent.putExtra(RIDE, R.string.gemini);
		 startActivity(intent);
		 break;
   	case R.id.iron_dragon:
		 intent.putExtra(RIDE, R.string.iron_dragon);
		 startActivity(intent);
		 break;
   	case R.id.junior_gemini:
		 intent.putExtra(RIDE, R.string.junior_gemini);
		 startActivity(intent);
		 break;
   	case R.id.magnum_xl200:
		 intent.putExtra(RIDE, R.string.magnum_xl200);
		 startActivity(intent);
		 break;
  	case R.id.mantis:
		 intent.putExtra(RIDE, R.string.mantis);
		 startActivity(intent);
		 break;
  	case R.id.matterhorn:
		 intent.putExtra(RIDE, R.string.matterhorn);
		 startActivity(intent);
		 break;
  	case R.id.maverick:
		 intent.putExtra(RIDE, R.string.maverick);
		 startActivity(intent);
		 break;
  	case R.id.maxair:
		 intent.putExtra(RIDE, R.string.maxair);
		 startActivity(intent);
		 break;
  	case R.id.mean_streak:
		 intent.putExtra(RIDE, R.string.mean_streak);
		 startActivity(intent);
		 break;
 	case R.id.millenium_force:
		 intent.putExtra(RIDE, R.string.millenium_force);
		 startActivity(intent);
		 break;
 	case R.id.monster:
		 intent.putExtra(RIDE, R.string.monster);
		 startActivity(intent);
		 break;
 	case R.id.ocean_motion:
		 intent.putExtra(RIDE, R.string.ocean_motion);
		 startActivity(intent);
		 break;
	case R.id.power_tower:
		 intent.putExtra(RIDE, R.string.power_tower);
		 startActivity(intent);
		 break;
	case R.id.raptor:
		 intent.putExtra(RIDE, R.string.raptor);
		 startActivity(intent);
		 break;
	case R.id.scrambler:
		 intent.putExtra(RIDE, R.string.scrambler);
		 startActivity(intent);
		 break;
	case R.id.skyhawk:
		 intent.putExtra(RIDE, R.string.skyhawk);
		 startActivity(intent);
		 break;
	case R.id.super_himalaya:
		 intent.putExtra(RIDE, R.string.super_himalaya);
		 startActivity(intent);
		 break;
	case R.id.top_thrill:
		 intent.putExtra(RIDE, R.string.top_thrill);
		 startActivity(intent);
		 break;
	case R.id.troika:
		 intent.putExtra(RIDE, R.string.troika);
		 startActivity(intent);
		 break;
	case R.id.wave_swinger:
		 intent.putExtra(RIDE, R.string.wave_swinger);
		 startActivity(intent);
		 break;
	case R.id.wicked_twister:
		 intent.putExtra(RIDE, R.string.wicked_twister);
		 startActivity(intent);
		 break;
	case R.id.wind_seeker:
		 intent.putExtra(RIDE, R.string.wind_seeker);
		 startActivity(intent);
		 break;
	case R.id.witches_wheel:
		 intent.putExtra(RIDE, R.string.witches_wheel);
		 startActivity(intent);
		 break;
	case R.id.woodstock_express:
		 intent.putExtra(RIDE, R.string.woodstock_express);
		 startActivity(intent);
		 break;
		 
    	
   	 }
    }*/



}
