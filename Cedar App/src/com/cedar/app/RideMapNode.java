package com.cedar.app;


/**
 * @author Eric Mellino
 * MapNode for rides
 */
public class RideMapNode extends MapNode {
	
	public Ride ride;
	
	public RideMapNode(Ride ride)
	{
		this.ride = ride;
		this.x = ride.mapX;
		this.y = ride.mapY;
	}

}
