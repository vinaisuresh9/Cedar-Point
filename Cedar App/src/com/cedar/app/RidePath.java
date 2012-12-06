package com.cedar.app;

import java.util.ArrayList;
import java.util.LinkedList;

public class RidePath 
{	
	private ArrayList<Ride> selectedRides;	
	public LinkedList<RideMapNode> rideNodesInOrder;
	
	public RidePath(ArrayList<Ride> selectedRides)
	{
		this.selectedRides = selectedRides;
		
	}
	
	
	public static LinkedList<RideMapNode> GetOptimalPathNodes(ArrayList<Ride> rides)
	{
		return new RidePath(rides).rideNodesInOrder;
	}
}
