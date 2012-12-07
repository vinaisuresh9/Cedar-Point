package com.cedar.app;

import java.util.LinkedList;

/**
 * @author Eric Mellino
 * IntermediateMapNode is a subclass of MapNode and creates Path Nodes for routing. Each Node has a list of accessibleRides from that Node
 */
public class IntermediateMapNode extends MapNode {
	
	/**
	 * @param x
	 * @param y
	 * @param rides
	 */
	public IntermediateMapNode(float x, float y, Ride... rides)
	{
		this.x = x/1941; //Give a percentage of full map location since height is 1941 pixels
		this.y = y/2793; //Give a percentage of full map location since height is 2793 pixels
		
		accessibleRides = new LinkedList<Ride>();
		for (Ride r : rides)
		{
			accessibleRides.add(r);
		}
	}
	
}
