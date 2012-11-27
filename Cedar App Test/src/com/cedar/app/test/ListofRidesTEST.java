package com.cedar.app.test;

import java.util.*;

import com.cedar.app.ListofRides;
import com.cedar.app.R;

import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.view.KeyEvent;
import android.widget.*;

public class ListofRidesTEST extends
		ActivityInstrumentationTestCase2<ListofRides> {
	ListofRides LOR;
	CheckBox check;

	public ListofRidesTEST() {
		super(ListofRides.class);
	}

	protected void setUp() throws Exception {
		super.setUp();
		//setActivityInitialTouchMode(false);
		
		LOR = getActivity();

	}
	
	public void testAddtoList()
	{
		check = (CheckBox) LOR.findViewById(R.id.blue_streak_button);
		TouchUtils.clickView(this, check);
		assertEquals(check.isChecked(), true);
		
	}
	
	
	
	//Checks to see if List remains even if new Activity is started
	public void testListRemains()

	{
		CheckBox[] checks = new CheckBox[5];
		checks[0] = (CheckBox) LOR.findViewById(R.id.cedar_downs_button);
		checks[1] = (CheckBox) LOR.findViewById(R.id.dodgem_button);
		checks[2] = (CheckBox) LOR.findViewById(R.id.calypso_button);
		checks[3] = (CheckBox) LOR.findViewById(R.id.corkscrew_button);
		checks[4] = (CheckBox) LOR.findViewById(R.id.gemini_button);
		
		
		
		for (CheckBox c : checks)
		{
			TouchUtils.clickView(this, c);
			
		}
		
		//Checks to see if rides were added to the list of rides
		assertTrue(LOR.ridesList.contains(LOR.getString(R.string.cedar_downs)));
		assertTrue(LOR.ridesList.contains(LOR.getString(R.string.dodgem)));
		assertTrue(LOR.ridesList.contains(LOR.getString(R.string.calypso)));
		assertTrue(LOR.ridesList.contains(LOR.getString(R.string.corkscrew)));
		assertTrue(LOR.ridesList.contains(LOR.getString(R.string.gemini)));
		
		//Move to next Activity, which is a Description of Calypso
		TouchUtils.clickView(this, LOR.findViewById(R.id.calypso));
		
		this.sendKeys(KeyEvent.KEYCODE_BACK);
		
		//Checks to see if rides remain in list after a new Activity has been started
		assertTrue(LOR.ridesList.contains(LOR.getString(R.string.cedar_downs)));
		assertTrue(LOR.ridesList.contains(LOR.getString(R.string.dodgem)));
		assertTrue(LOR.ridesList.contains(LOR.getString(R.string.calypso)));
		assertTrue(LOR.ridesList.contains(LOR.getString(R.string.corkscrew)));
		assertTrue(LOR.ridesList.contains(LOR.getString(R.string.gemini)));
		

		
		
		
	}

	public void testRideDescriptionViews()
	{
		TouchUtils.clickView(this, LOR.findViewById(R.id.blue_streak));
		
        
		
		
		
	}
}
