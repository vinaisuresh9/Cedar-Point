package com.cedar.app;

import java.util.LinkedList;

public class IntermediateMapNode extends MapNode {
	
	public IntermediateMapNode(float x, float y, Ride... rides)
	{
		this.x = x/1941;
		this.y = y/2793;
		
		accessibleRides = new LinkedList<Ride>();
		for (Ride r : rides)
		{
			accessibleRides.add(r);
			System.out.println("This node can access "+r.name);
		}
	}
	
}
