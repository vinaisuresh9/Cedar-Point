package com.cedar.app;

import java.util.ArrayList;
import java.util.LinkedList;

public class RidePath 
{	
	private ArrayList<Ride> selectedRides;	
	public LinkedList<IntermediateMapNode> rideNodesInOrder;
	public ArrayList<Ride> allRides;
	static String[] rightSubsection = { "MaXair", "Wicked Twister", "Woodstock Express", "WindSeeker", "Calypso" };
	static String[] leftFork = { "Iron Dragon", "Millenium Force", "Mantis", "Cedar Creek Mine Ride", "Skyhawk", "Wave Swinger", "Maverick" };
	static String[] rightFork = { "Power Tower", "Top Thrill Dragster", "Matterhorn", "Magnum XL-200", "Monster", "Jr. Gemini", "Scrambler", "Super Himalaya", "Gemini", "Mean Streak" };
	static String[] firstSection = {"Troika", "Dodgem", "Corkscrew" };
	
	public RidePath(ArrayList<Ride> selectedRides, ArrayList<IntermediateMapNode> pathNodes)
	{
		allRides = ListofRides.fullListofRides;
		rideNodesInOrder =  new LinkedList<IntermediateMapNode>();
		this.selectedRides = selectedRides;
		ArrayList<IntermediateMapNode> needToVisit = new ArrayList<IntermediateMapNode>();
		System.out.println("You have " + selectedRides.size() + " selected rides.");
		System.out.println("There are " +pathNodes.size() + " path nodes.");
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
		System.out.println("You need to visit "+needToVisit.size() + " nodes.");
		if (needToVisit.size() == 0) return;
		rideNodesInOrder.add(pathNodes.get(0));
		rideNodesInOrder.add(pathNodes.get(1));
		
		if (needsToVisit(leftFork) || needsToVisit(rightFork))
		{
			System.out.println("You need to visit the top area.");
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
			
			if (needsToVisit(rightSubsection))
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
		
		else if (needsToVisit(rightSubsection))
		{
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
	
	private boolean needsToVisit(IntermediateMapNode intermediateMapNode) {
		for (Ride r : intermediateMapNode.accessibleRides)
		{
			if (selectedRides.contains(r)) return true;
		}
		return false;		
	}

	private Ride getRide(String s)
	{
		return ListofRides.getRide(s);
	}
	
	private boolean needsToVisit(String rideName)
	{
		return selectedRides.contains(getRide(rideName));
	}
	
	private boolean needsToVisit(String... rideNames)
	{
		for (String s : rideNames)
		{
			if (needsToVisit(s)) return true;			
		}
		return false;
	}
	
	
	public static LinkedList<IntermediateMapNode> GetOptimalPathNodes(ArrayList<Ride> rides, ArrayList<IntermediateMapNode> pathNodes)
	{
		return new RidePath(rides, pathNodes).rideNodesInOrder;
	}
}
