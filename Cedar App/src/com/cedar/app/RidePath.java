package com.cedar.app;

import java.util.ArrayList;
import java.util.LinkedList;


/**
 * @author Eric Mellino
 * Create a RidePath from the listofRides that the user wishes to visit
 *
 */
public class RidePath 
{	
	
	private ArrayList<Ride> selectedRides;		//rides that the user has selected to ride
	public LinkedList<IntermediateMapNode> rideNodesInOrder;  //nodes that will be returned to be visited for optimal route
	public ArrayList<Ride> allRides; //all rides
	public static ArrayList<IntermediateMapNode> needToVisit = new ArrayList<IntermediateMapNode>(); //nodes that the user needs to visit
	//Rides split into different sections
	static String[] rightSubsection = { "MaXair", "Wicked Twister", "Woodstock Express", "WindSeeker", "Calypso" };
	static String[] leftFork = { "Iron Dragon", "Millenium Force", "Mantis", "Cedar Creek Mine Ride", "Skyhawk", "Wave Swinger", "Maverick" };
	static String[] rightFork = { "Power Tower", "Top Thrill Dragster", "Matterhorn", "Magnum XL-200", "Monster", "Jr. Gemini", "Scrambler", "Super Himalaya", "Gemini", "Mean Streak" };
	static String[] firstSection = {"Troika", "Dodgem", "Corkscrew" };
	
	/**
	 * @author Eric Mellino
	 * @param ArrayList<Ride> selectedRides
	 * @param ArrayList<IntermediateMapNode>pathNodes
	 * Populate rideNodesinOrder so that the MapCanvas will know how to draw the optimal route
	 */
	public RidePath(ArrayList<Ride> selectedRides, ArrayList<IntermediateMapNode> pathNodes)
	{
		allRides = ListofRides.fullListofRides;
		rideNodesInOrder =  new LinkedList<IntermediateMapNode>();
		this.selectedRides = selectedRides;
		needToVisit = new ArrayList<IntermediateMapNode>();

		//Check rides and populate needs to visit nodes
		for (Ride ride : selectedRides)
		{
			for (IntermediateMapNode node : pathNodes)
			{
				if (node.accessibleRides.contains(ride))
				{
					if (!needToVisit.contains(node))
					{
						needToVisit.add(node);
					}
				}
			}
		}
		//if list size is 0 return
		if (needToVisit.size() == 0) return;
		//always visit first two nodes
		rideNodesInOrder.add(pathNodes.get(0));
		rideNodesInOrder.add(pathNodes.get(1));
		
		//Check to see if user needs to go to the far end of the park
		if (needsToVisit(leftFork) || needsToVisit(rightFork))
		{
			//Check to see if user needs to go to right area of park
			if (needsToVisit(rightSubsection))
			{
				rideNodesInOrder.add(pathNodes.get(18));
				rideNodesInOrder.add(pathNodes.get(17));
				rideNodesInOrder.add(pathNodes.get(16));
				rideNodesInOrder.add(pathNodes.get(15));
				rideNodesInOrder.add(pathNodes.get(3));
				if (needsToVisit("Troika"))
				{
					rideNodesInOrder.add(pathNodes.get(2));
					rideNodesInOrder.add(pathNodes.get(3));
				}
			}
			else
			{
				rideNodesInOrder.add(pathNodes.get(2));
				rideNodesInOrder.add(pathNodes.get(3));
			}
			
			//Check to see if user needs to go to right fork on the far end of the park
			if (needsToVisit(rightFork))
			{
				if (needsToVisit(pathNodes.get(9)))
				{
					rideNodesInOrder.add(pathNodes.get(14));
					rideNodesInOrder.add(pathNodes.get(13));
					rideNodesInOrder.add(pathNodes.get(12));
					rideNodesInOrder.add(pathNodes.get(11));
					rideNodesInOrder.add(pathNodes.get(10));
					rideNodesInOrder.add(pathNodes.get(9));
				}
				else if (needsToVisit(pathNodes.get(10)))
				{
					rideNodesInOrder.add(pathNodes.get(14));
					rideNodesInOrder.add(pathNodes.get(13));
					rideNodesInOrder.add(pathNodes.get(12));
					rideNodesInOrder.add(pathNodes.get(11));
					rideNodesInOrder.add(pathNodes.get(10));
					
				}
				else if (needsToVisit(pathNodes.get(11)))
				{
					rideNodesInOrder.add(pathNodes.get(14));
					rideNodesInOrder.add(pathNodes.get(13));
					rideNodesInOrder.add(pathNodes.get(12));
					rideNodesInOrder.add(pathNodes.get(11));
					
				}
				else if (needsToVisit(pathNodes.get(12)))
				{
					rideNodesInOrder.add(pathNodes.get(14));
					rideNodesInOrder.add(pathNodes.get(13));
					rideNodesInOrder.add(pathNodes.get(12));
					
				}
				else if (needsToVisit(pathNodes.get(13)))
				{
					rideNodesInOrder.add(pathNodes.get(14));
					rideNodesInOrder.add(pathNodes.get(13));
					
				}
				else if (needsToVisit(pathNodes.get(14)))
				{
					rideNodesInOrder.add(pathNodes.get(14));					
				}

				//Check to see if user needs to go to left fork on the far end of the park after visiting right fork
				if (needsToVisit(leftFork))
				{
					if (rideNodesInOrder.getLast() == pathNodes.get(9) || rideNodesInOrder.getLast() == pathNodes.get(10))
					{
						if (rideNodesInOrder.getLast() == pathNodes.get(10))
							rideNodesInOrder.add(pathNodes.get(9));
						
						if (needsToVisit(pathNodes.get(4)))
						{
							rideNodesInOrder.add(pathNodes.get(8));
							rideNodesInOrder.add(pathNodes.get(7));
							rideNodesInOrder.add(pathNodes.get(6));
							rideNodesInOrder.add(pathNodes.get(5));
							rideNodesInOrder.add(pathNodes.get(4));
						}				
						else if (needsToVisit(pathNodes.get(5)))
						{
							rideNodesInOrder.add(pathNodes.get(8));
							rideNodesInOrder.add(pathNodes.get(7));
							rideNodesInOrder.add(pathNodes.get(6));
							rideNodesInOrder.add(pathNodes.get(5));
						}
						else if (needsToVisit(pathNodes.get(6)))
						{
							rideNodesInOrder.add(pathNodes.get(8));
							rideNodesInOrder.add(pathNodes.get(7));
							rideNodesInOrder.add(pathNodes.get(6));
						}
						else if (needsToVisit(pathNodes.get(7)))
						{
							rideNodesInOrder.add(pathNodes.get(8));
							rideNodesInOrder.add(pathNodes.get(7));
						}
						else if (needsToVisit(pathNodes.get(8)))
						{
							rideNodesInOrder.add(pathNodes.get(8));
						}
						return;
					}
					//Check to see if user needs to around circle or go back to a closer ride from right to left fork
					else
					{
						if (rideNodesInOrder.getLast() == pathNodes.get(11))
						{
							rideNodesInOrder.add(pathNodes.get(12));
							rideNodesInOrder.add(pathNodes.get(13));
							rideNodesInOrder.add(pathNodes.get(14));
							rideNodesInOrder.add(pathNodes.get(3));
						}
						else if (rideNodesInOrder.getLast() == pathNodes.get(12))
						{
							rideNodesInOrder.add(pathNodes.get(13));
							rideNodesInOrder.add(pathNodes.get(14));
							rideNodesInOrder.add(pathNodes.get(3));
						}
						else if (rideNodesInOrder.getLast() == pathNodes.get(13))
						{
							rideNodesInOrder.add(pathNodes.get(14));
							rideNodesInOrder.add(pathNodes.get(3));
						}
						else if (rideNodesInOrder.getLast() == pathNodes.get(14))
						{
							rideNodesInOrder.add(pathNodes.get(3));
						}
						
						if (needsToVisit(pathNodes.get(8)))
						{
							rideNodesInOrder.add(pathNodes.get(4));
							rideNodesInOrder.add(pathNodes.get(5));
							rideNodesInOrder.add(pathNodes.get(6));
							rideNodesInOrder.add(pathNodes.get(7));
							rideNodesInOrder.add(pathNodes.get(8));
						}				
						else if (needsToVisit(pathNodes.get(7)))
						{
							rideNodesInOrder.add(pathNodes.get(4));
							rideNodesInOrder.add(pathNodes.get(5));
							rideNodesInOrder.add(pathNodes.get(6));
							rideNodesInOrder.add(pathNodes.get(7));
						}
						else if (needsToVisit(pathNodes.get(6)))
						{
							rideNodesInOrder.add(pathNodes.get(4));
							rideNodesInOrder.add(pathNodes.get(5));
							rideNodesInOrder.add(pathNodes.get(6));
						}
						else if (needsToVisit(pathNodes.get(5)))
						{
							rideNodesInOrder.add(pathNodes.get(4));
							rideNodesInOrder.add(pathNodes.get(5));
						}
						else if (needsToVisit(pathNodes.get(4)))
						{
							rideNodesInOrder.add(pathNodes.get(4));
						}
						return;
					}
				}
				
			}
			//Check to see which nodes user needs to visit on left fork
			else
			{
				if (needsToVisit(pathNodes.get(8)))
				{
					rideNodesInOrder.add(pathNodes.get(4));
					rideNodesInOrder.add(pathNodes.get(5));
					rideNodesInOrder.add(pathNodes.get(6));
					rideNodesInOrder.add(pathNodes.get(7));
					rideNodesInOrder.add(pathNodes.get(8));
				}				
				else if (needsToVisit(pathNodes.get(7)))
				{
					rideNodesInOrder.add(pathNodes.get(4));
					rideNodesInOrder.add(pathNodes.get(5));
					rideNodesInOrder.add(pathNodes.get(6));
					rideNodesInOrder.add(pathNodes.get(7));
				}
				else if (needsToVisit(pathNodes.get(6)))
				{
					rideNodesInOrder.add(pathNodes.get(4));
					rideNodesInOrder.add(pathNodes.get(5));
					rideNodesInOrder.add(pathNodes.get(6));
				}
				else if (needsToVisit(pathNodes.get(5)))
				{
					rideNodesInOrder.add(pathNodes.get(4));
					rideNodesInOrder.add(pathNodes.get(5));
				}
				else if (needsToVisit(pathNodes.get(4)))
				{
					rideNodesInOrder.add(pathNodes.get(4));
				}
				return;
			}
		}
		
		//If user only needs to visit right subsection
		else if (needsToVisit(rightSubsection))
		{
			//if needs to visit rides in the center of the park
			if (needsToVisit(firstSection))
			{
				rideNodesInOrder.add(pathNodes.get(2));
				rideNodesInOrder.add(pathNodes.get(3));
				
				if (needsToVisit(pathNodes.get(18)))
				{
					rideNodesInOrder.add(pathNodes.get(15));
					rideNodesInOrder.add(pathNodes.get(16));
					rideNodesInOrder.add(pathNodes.get(17));
					rideNodesInOrder.add(pathNodes.get(18));
				}
				else if (needsToVisit(pathNodes.get(17)))
				{
					rideNodesInOrder.add(pathNodes.get(15));
					rideNodesInOrder.add(pathNodes.get(16));
					rideNodesInOrder.add(pathNodes.get(17));
				}
				else if (needsToVisit(pathNodes.get(16)))
				{
					rideNodesInOrder.add(pathNodes.get(15));
					rideNodesInOrder.add(pathNodes.get(16));
				}
				else if (needsToVisit(pathNodes.get(15)))
				{
					rideNodesInOrder.add(pathNodes.get(15));
				}
			}
			else // Need to visit right subsection but not the center part of it.
			{
				if (needsToVisit(pathNodes.get(15)))
				{
					rideNodesInOrder.add(pathNodes.get(18));
					rideNodesInOrder.add(pathNodes.get(17));
					rideNodesInOrder.add(pathNodes.get(16));
					rideNodesInOrder.add(pathNodes.get(15));
				}
				else if (needsToVisit(pathNodes.get(16)))
				{
					rideNodesInOrder.add(pathNodes.get(18));
					rideNodesInOrder.add(pathNodes.get(17));
					rideNodesInOrder.add(pathNodes.get(16));
				}
				else if (needsToVisit(pathNodes.get(17)))
				{
					rideNodesInOrder.add(pathNodes.get(18));
					rideNodesInOrder.add(pathNodes.get(17));
	
				}
				else if (needsToVisit(pathNodes.get(18)))
				{
					rideNodesInOrder.add(pathNodes.get(18));
				}
				
				
			}
			return;
		}
		else if (needsToVisit(pathNodes.get(3)))
		{
			rideNodesInOrder.add(pathNodes.get(2));
			rideNodesInOrder.add(pathNodes.get(3));
		}
		else if (needsToVisit(pathNodes.get(2)))
			rideNodesInOrder.add(pathNodes.get(2));
		
		return;
	}
	
	/**
	 * @param IntermediateMapNode intermediateMapNode 
	 * @return boolean
	 * Checks to see if this node needs to be visited depending on rides in selectedrides
	 */
	private boolean needsToVisit(IntermediateMapNode intermediateMapNode) {
		for (Ride r : intermediateMapNode.accessibleRides)
		{
			if (selectedRides.contains(r)) return true;
		}
		return false;		
	}

	/**
	 * @param String s
	 * @return Ride
	 * Returns the ride object by its name
	 */
	private Ride getRide(String s)
	{
		return ListofRides.getRide(s);
	}
	
	/**
	 * @param rideName
	 * @return boolean
	 * Checks to see if ride needs to be visited
	 * 
	 */
	private boolean needsToVisit(String rideName)
	{
		return selectedRides.contains(getRide(rideName));
	}
	
	/**
	 * @param rideNames
	 * @return boolean
	 * Checks to see if rides needs to be visited
	 * 
	 */
	private boolean needsToVisit(String... rideNames)
	{
		for (String s : rideNames)
		{
			if (needsToVisit(s)) return true;			
		}
		return false;
	}
	
	
	/**
	 * @param ArrayList<Ride>rides
	 * @param ArrayList<IntermediateMapNode>pathNodes
	 * @return LinkedList<IntermediateMapNode>
	 * Returns optimal ride nodes in order for routing
	 */
	public static LinkedList<IntermediateMapNode> GetOptimalPathNodes(ArrayList<Ride> rides, ArrayList<IntermediateMapNode> pathNodes)
	{
		return new RidePath(rides, pathNodes).rideNodesInOrder;
	}
}
