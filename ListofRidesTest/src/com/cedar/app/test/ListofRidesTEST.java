package com.cedar.app.test;

import java.util.*;

import com.cedar.app.ListofRides;
import com.cedar.app.R;

import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.widget.*;

public class ListofRidesTEST extends
		ActivityInstrumentationTestCase2<ListofRides> {
	public List<String> ridesList;
	ListofRides LOR;
	CheckBox check;

	public ListofRidesTEST() {
		super(ListofRides.class);
	}

	protected void setUp() throws Exception {
		super.setUp();
		//setActivityInitialTouchMode(false);
		
		LOR = getActivity();
		ridesList = new LinkedList<String>();
		ridesList = LOR.ridesList;
	}
	
	public void testAddtoList()
	{
		check = (CheckBox) LOR.findViewById(R.id.blue_streak_button);
		TouchUtils.clickView(this, check);
		assertEquals(check.isChecked(), true);
		
	}
	
	
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
		
		System.out.println(LOR.ridesList.size());
		
			
		
		/*assertTrue(LOR.ridesList.contains(LOR.getString(R.id.cedar_downs)));
		assertTrue(LOR.ridesList.contains(LOR.getString(R.id.dodgem)));
		assertTrue(LOR.ridesList.contains(LOR.getString(R.id.calypso)));
		assertTrue(LOR.ridesList.contains(LOR.getString(R.id.corkscrew)));
		assertTrue(LOR.ridesList.contains(LOR.getString(R.id.gemini)));*/
		
		
		
	}

}
