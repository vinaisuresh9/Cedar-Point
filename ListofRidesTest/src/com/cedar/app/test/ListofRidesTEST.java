package com.cedar.app.test;

import java.util.*;

import com.cedar.app.ListofRides;
import com.cedar.app.R;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.*;

public class ListofRidesTEST extends
		ActivityInstrumentationTestCase2<ListofRides> {
	public List<String> ridesList;
	ListofRides LOR;
	CheckBox check;

	public ListofRidesTEST(String name) {
		super(ListofRides.class);
	}

	protected void setUp() throws Exception {
		super.setUp();
		LOR = getActivity();
		ridesList = new LinkedList<String>();
		ridesList = LOR.ridesList;
	}
	
	public void testAddtoList()
	{
		check = (CheckBox) LOR.findViewById(R.id.blue_streak_button);
		check.setChecked(true);
		
	}

}
