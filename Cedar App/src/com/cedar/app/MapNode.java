package com.cedar.app;

import java.util.LinkedList;

public abstract class MapNode {
	public float x;
	public float y;
	
	public LinkedList<Ride> accessibleRides;
}
