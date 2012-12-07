package com.cedar.app;


/**
 * @author Eric Mellino
 * Create MapEdge between two MapNodes
 *
 */
public class MapEdge {
	public MapNode node1;
	public MapNode node2;
	public float distance;
	
	public MapEdge(MapNode node1, MapNode node2)
	{
		this.node1 = node1; 
		this.node2 = node2;
		this.distance = (float)Math.sqrt(node1.x*node1.x - node2.x*node2.x + node1.y*node1.y - node2.y*node2.y);
	}
	
}
