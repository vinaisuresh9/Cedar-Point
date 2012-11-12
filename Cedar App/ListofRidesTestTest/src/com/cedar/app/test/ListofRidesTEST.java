package com.cedar.app.test;

import java.util.*;

import com.cedar.app.ListofRides;

import android.test.ActivityInstrumentationTestCase2;

public class ListofRidesTEST extends
		ActivityInstrumentationTestCase2<ListofRides> {
	public List<String> ridesList;

	public ListofRidesTEST(String name) {
		super(ListofRides.class);
	}

	protected void setUp() throws Exception {
		super.setUp();
		ListofRides LOR = getActivity();
		ridesList = new LinkedList<String>();
	}
	
	public void testAddtoList()
	{
		
		
	}

}
