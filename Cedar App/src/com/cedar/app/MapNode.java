package com.cedar.app;

import java.util.LinkedList;

/**
 * @author Vinai Suresh
 * MapNode class
 *
 */
public abstract class MapNode {
	public float x;
	public float y;
	
	public LinkedList<Ride> accessibleRides;
}
