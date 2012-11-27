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
		System.out.println(check.isChecked());
		this.assertEquals(check.isChecked(), true);
		
	}

}
