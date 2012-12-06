package com.cedar.app;

import java.io.IOException;
import java.util.*;

import org.xmlpull.v1.XmlPullParserException;

import com.cedar.app.Ride.RideSize;

import android.os.Bundle;
import android.os.Parcelable;
import android.app.Activity;
import android.view.*;
import android.widget.*;
import android.content.*;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.Color;

public class ListofRides extends Activity  {
	
	private RelativeLayout layout;
	private ScrollView scroller;
	public static ArrayList<Ride> ridesList;
	public static ArrayList<Ride> fullListofRides;
	public final static String RIDE = "com.cedar.app.ride";
	public final static String LISTOFRIDES = "com.cedar.app.list";
	
	private static ListofRides instance;
	
	int screenwidth;
	int screenheight;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        Display display = getWindowManager().getDefaultDisplay();
        screenwidth = display.getWidth();
        screenheight = display.getHeight();
        
        instance = this;
        
        //Create Layout programmatically with textviews
        scroller = new ScrollView(this);
        layout = new RelativeLayout(this);
        RelativeLayout.LayoutParams rlp = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        layout.setLayoutParams(rlp);
        layout.setBackgroundColor(getResources().getColor(R.color.black));
       
        fullListofRides = new ArrayList<Ride>();
        ridesList = new ArrayList<Ride>();
        
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
    
    public static Context getContext()
    {
    	return instance;
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
							etv.ride.speed, etv.ride.description, etv.ride.video};
					
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
	  /* XmlResourceParser xpp=Resources.getSystem().getXml 
	    		(R.color.textfieldcolors); 
	   try {
		ColorStateList csl = ColorStateList.createFromXml(getResources(), xpp);
		   tv.setTextColor(csl);
	} catch (XmlPullParserException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 	*/	
		tv.setTextColor(Color.WHITE);
		tv.setText(r.name);
		tv.setId(id);
		tv.setTextSize(25);
		tv.setPadding(0, 0, 0, 25);
		
		
		
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

	public static Ride getRide(String string) {
		for (Ride r : fullListofRides)
		{
			if (r.name == string)
				return r;
		}
		return null;
		
	}
    
 



}
