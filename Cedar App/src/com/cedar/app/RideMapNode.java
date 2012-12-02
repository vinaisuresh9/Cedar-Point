package com.cedar.app;

public class RideMapNode extends MapNode {
	
	public Ride ride;
	
	public RideMapNode(Ride ride)
	{
		this.ride = ride;
		this.x = ride.mapX;
		this.y = ride.mapY;
	}

}
