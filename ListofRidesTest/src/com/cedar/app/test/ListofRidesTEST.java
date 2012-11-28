package com.cedar.app.test;


import com.cedar.app.ListofRides;
import com.cedar.app.R;

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
		setActivityInitialTouchMode(false);
		
		LOR = getActivity();

	}
	
	public void testAddtoList()
	{
		check = (CheckBox) LOR.findViewById(R.id.blue_streak_button);
		TouchUtils.clickView(this, check);
		assertEquals(check.isChecked(), true);
		
	}
	
	public void testRideDescriptionViews()
	{
		TouchUtils.clickView(this, LOR.findViewById(R.id.blue_streak));
	
		wait (2000);
		
		sendKeys(KeyEvent.KEYCODE_BACK);
		
		TouchUtils.clickView(this, LOR.findViewById(R.id.dodgem));
		
		wait (2000);
		
		sendKeys(KeyEvent.KEYCODE_BACK);
		
	}
	
	
	public void testScrolling()
	{
		CheckBox[] checks = new CheckBox[2];
		checks[0] = (CheckBox) LOR.findViewById(R.id.dodgem_button);
		checks[1] = (CheckBox) LOR.findViewById(R.id.calypso_button);
		
		for (CheckBox c : checks)
		{
			TouchUtils.clickView(this, c);	
		}
		
		assertTrue(LOR.ridesList.contains(LOR.getString(R.string.dodgem)));
		assertTrue(LOR.ridesList.contains(LOR.getString(R.string.calypso)));
		
		TouchUtils.dragQuarterScreenUp(this, getActivity());
		TouchUtils.dragQuarterScreenUp(this, getActivity());
		TouchUtils.dragQuarterScreenUp(this, getActivity());

		
		checks[0] = (CheckBox) LOR.findViewById(R.id.witches_wheel_button);
		checks[1] = (CheckBox) LOR.findViewById(R.id.woodstock_express_button);

		for (CheckBox c : checks)
		{
			TouchUtils.clickView(this, c);	
		}
		
		TouchUtils.dragQuarterScreenDown(this, getActivity());
		TouchUtils.dragQuarterScreenDown(this, getActivity());
		TouchUtils.dragQuarterScreenDown(this, getActivity());


		checks[0] = (CheckBox) LOR.findViewById(R.id.dodgem_button);
		checks[1] = (CheckBox) LOR.findViewById(R.id.calypso_button);
		
		for (CheckBox c : checks)
		{
			TouchUtils.clickView(this, c);	
		}
		
		assertTrue(LOR.ridesList.contains(LOR.getString(R.string.witches_wheel)));
		assertTrue(LOR.ridesList.contains(LOR.getString(R.string.woodstock_express)));	
		
		assertFalse(LOR.ridesList.contains(LOR.getString(R.string.dodgem)));
		assertFalse(LOR.ridesList.contains(LOR.getString(R.string.calypso)));	
		
		assertFalse(((CheckBox) LOR.findViewById(R.id.dodgem_button)).isChecked());
		assertFalse(((CheckBox) LOR.findViewById(R.id.calypso_button)).isChecked());

		assertTrue(((CheckBox) LOR.findViewById(R.id.witches_wheel_button)).isChecked());
		assertTrue(((CheckBox) LOR.findViewById(R.id.woodstock_express_button)).isChecked());
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

	
	
	
	
	public static void wait (int n){
        
        long t0, t1;

        t0 =  System.currentTimeMillis();

        do{
            t1 = System.currentTimeMillis();
        }
        while (t1 - t0 < n);
    }
}
