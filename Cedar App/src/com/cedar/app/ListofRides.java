package com.cedar.app;

import java.io.IOException;
import java.util.*;

import android.app.Activity;
import android.os.Bundle;
import android.view.*;
import android.widget.*;
import android.content.*;
import android.graphics.Color;


/**
 * @author Vinai Suresh
 * ListofRides is the main screen that provides the user a list of rides that they can select from using checkboxes. The user can also click on each ride and see its ride description.
 * There is a Clear all rides button and a view map button. The former clears all checkboxes and rides from the list and the latter allows the user to see the map, or see a route if they have
 * selected rides.
 */

public class ListofRides extends Activity  {
	
	private RelativeLayout layout; //layout of screen
	private ScrollView scroller; //Layout of scrollview
	public static ArrayList<Ride> ridesList; //List of rides that the user has selected
	public static ArrayList<Ride> fullListofRides; //Full list of rides loaded from xml documents
	public final static String RIDE = "com.cedar.app.ride"; //static variables used for passing of variables from one activity to another
	public final static String LISTOFRIDES = "com.cedar.app.list";
	
	public LinkedList<EnhancedCheckBox> allChecks = new LinkedList<EnhancedCheckBox>(); //Linked list of all checkboxes
	
	private static ListofRides instance; //Instance of this class created for getting Context in other classes
	
	int screenwidth;
	int screenheight;

    /* (non-Javadoc)
     * @see android.app.Activity#onCreate(android.os.Bundle)
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        //Screen height and width
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
        
        //Generate full list of rides by deserializing from the XML documents contained in the assests folder
        try {
        	for (int i = 1; i < 31; i ++)
        	{
        		fullListofRides.add(Ride.DeserializeFromXML(getAssets().open("Rides/Ride" + i)));
        	}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

        //Create clear rides button
        CreateClearButton();
        //Create list of rides in the screen
        CreateScreen();
        //Create map button
        CreateMapButton();
        
        
        //Add the layouts to the view
        scroller.addView(layout);
        setContentView(scroller);

        
    }

    /**
     * @author Aaron Noviski
     * @param None
     * @return None
     * Creates the clear all rides button at the top of the screen
     *
     */
    private void CreateClearButton() {
    	//Create button
    	Button b = new Button(this);
    	RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
    	//Align button at top of screen
    	lp.addRule(RelativeLayout.ALIGN_PARENT_TOP);
    	
    	//Set ID
    	b.setId(62);
    	b.setText("Clear all rides");
    	b.setTextSize(25);
    	//Set positioning with padding from other views
    	b.setPadding(0, 20, 0, 20);
    	b.setBackgroundColor(Color.BLACK);
    	b.setTextColor(Color.WHITE);
    	b.setLayoutParams(lp);

    	//Create a method for when this view is clicked. It clears all checkboxes and resets the ridesList
    	b.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
		    	if (!allChecks.isEmpty())
		    	{
		    		for (EnhancedCheckBox e : allChecks)
		    		{
		    			e.setChecked(false);
		    		}
		    	}
		    	ridesList = new ArrayList<Ride>();

			}
		});
    	
    	// add button to layout
    	layout.addView(b);
		
	}

	/* (non-Javadoc)
	 * @see android.app.Activity#onCreateOptionsMenu(android.view.Menu)
	 */
	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_listof_rides, menu);
        return true;
    }
    
    /**
     * @author Vinai Suresh
     *  Create Map button at the bottom of the view 
     */
    public void CreateMapButton()
    {
    	
    	Button b = new Button(this);
    	RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
    	
    	b.setId(61);
    	b.setText("View Map");
    	b.setTextSize(25);
    	b.setTextColor(getResources().getColor(R.color.white));
    	b.setBackgroundColor(Color.BLACK);
    	lp.addRule(RelativeLayout.BELOW, 60);
    	b.setLayoutParams(lp);
    	
    	//Method for creating DisplayMap Activity when clicked
    	b.setOnClickListener(new View.OnClickListener() {
			
			/* (non-Javadoc)
			 * @see android.view.View.OnClickListener#onClick(android.view.View)
			 */
			public void onClick(View v) {
		    	Intent intent = new Intent(getApplicationContext(), DisplayMap.class);
		    	
		    	startActivity(intent);
			}
		});
    	
    	layout.addView(b);
    
    	
    }
    
    /**
     * @return Context
     * Return this applications context
     */
    public static Context getContext()
    {
    	return instance;
    }
    
    /**
     * @author Aaron Noviski
     * Method creates the screen with all textviews and all checkboxes
     */
    public void CreateScreen()
    {
        int lastid = 1;

        //Creates each textview and button for each ride
        for (Ride r : fullListofRides)
        {
        	EnhancedTextView tv = CreateTextView(r, lastid);

       		 //Handle Ride Details Clicking
       		 tv.setOnClickListener(new View.OnClickListener() {
				
				/* (non-Javadoc)
				 * @see android.view.View.OnClickListener#onClick(android.view.View)
				 */
				public void onClick(View v) {
					EnhancedTextView etv = (EnhancedTextView) v;
					Intent intent = new Intent(getApplicationContext(), RideDetails.class);
					//Send properties of ride object to RideDetails
					String[] array = {etv.ride.name, etv.ride.ridetype, etv.ride.duration, etv.ride.heightreq,
							etv.ride.speed, etv.ride.description, etv.ride.video};
					
			   		intent.putExtra(RIDE, array);

			   		startActivity(intent);
					
				}
			}); 
       		 layout.addView(tv);
       		 
       		 EnhancedCheckBox e = CreateCheckBox(r, lastid + 30);
         	allChecks.add(e);
       		 
       		 e.setOnClickListener(new View.OnClickListener() {
				
				/* (non-Javadoc)
				 * @see android.view.View.OnClickListener#onClick(android.view.View)
				 */
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
    
    
    /**
     * @param Ride r
     * @param int id
     * @return TextView tv
     * CreateTextView creates a textview for each Ride. The rides are created in alphabetical order and set in the layout below each other.
     * Takes in a ride and an id for each textview. Returns the Textview created
     */
    public EnhancedTextView CreateTextView(Ride r, int id)
    {
    	EnhancedTextView tv = new EnhancedTextView(this, r);
		RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
		lp.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
		//If this is not BlueStreak, then set it below the last view made
		if (id != 1)
		{
			lp.addRule(RelativeLayout.BELOW, id - 1);
		}
		else
		{
			//If this is blue streak then set it below the clear all rides button
			lp.addRule(RelativeLayout.BELOW, 62);
		}
		tv.setLayoutParams(lp);
		tv.setTextColor(Color.WHITE);
		tv.setText(r.name);
		tv.setId(id);
		tv.setTextSize(25);
		tv.setPadding(0, 0, 0, 25);
		
		
		
		return tv;
    }
    
    
    /**
     * @param Ride r
     * @param int id
     * @return EnhancedCheckBox e
     * Creates CheckBox associated with a ride. Takes in a Ride and an id so that the checkboxes will be associated with the right ids and in the right order.
     */
    public EnhancedCheckBox CreateCheckBox(Ride r, int id)
    {
    	EnhancedCheckBox e = new EnhancedCheckBox(this, r);
    	RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
    	lp.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
    	//If not Blue streak then set below previous checkbox
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

	/**
	 * @param String string
	 * @return null
	 * For each ride in the fullListofRides will return what ride you want by name
	 */
	public static Ride getRide(String string) {
		for (Ride r : fullListofRides)
		{
			if (r.name.equals(string))
				return r;
		}
		return null;
		
	}
    
 



}
