package com.cedar.app;

import java.util.*;

public class ShortestPath {
	private final List<MapNode> nodes;
	private final List<MapEdge> MapEdges;
	private Set<MapNode> settledNodes;
	private Set<MapNode> unSettledNodes;
	private Map<MapNode, MapNode> predecessors;
	private Map<MapNode, Integer> distance;

	public ShortestPath(Graph graph) {
		// Create a copy of the array so that we can operate on this array
		this.nodes = new ArrayList<MapNode>(graph.getNodes());
		this.MapEdges = new ArrayList<MapEdge>(graph.getEdges());
	}

	public void execute(MapNode source) {
		settledNodes = new HashSet<MapNode>();
		unSettledNodes = new HashSet<MapNode>();
		distance = new HashMap<MapNode, Integer>();
		predecessors = new HashMap<MapNode, MapNode>();
		distance.put(source, 0);
		unSettledNodes.add(source);
		while (unSettledNodes.size() > 0) {
			MapNode node = getMinimum(unSettledNodes);
			settledNodes.add(node);
			unSettledNodes.remove(node);
			findMinimalDistances(node);
		}
	}

	private void findMinimalDistances(MapNode node) {
		List<MapNode> adjacentNodes = getNeighbors(node);
		for (MapNode target : adjacentNodes) {
			if (getShortestDistance(target) > getShortestDistance(node)
					+ getDistance(node, target)) {
				distance.put(target, (int) (getShortestDistance(node)
						+ getDistance(node, target)));
				predecessors.put(target, node);
				unSettledNodes.add(target);
			}
		}

	}

	private double getDistance(MapNode node, MapNode target) {
		for (MapEdge MapEdge : MapEdges) {
			if (MapEdge.node1.equals(node)
					&& MapEdge.node2.equals(target)) 
			{
				return Math.sqrt((MapEdge.node1.x - MapEdge.node2.x)*(MapEdge.node1.x - MapEdge.node2.x) + (MapEdge.node1.y - MapEdge.node2.y))*(MapEdge.node1.y - MapEdge.node2.y);
			}
		}
		throw new RuntimeException("Should not happen");
	}

	private List<MapNode> getNeighbors(MapNode node) {
		List<MapNode> neighbors = new ArrayList<MapNode>();
		for (MapEdge MapEdge : MapEdges) {
			if (MapEdge.node1.equals(node)
					&& !isSettled(MapEdge.node1)) {
				neighbors.add(MapEdge.node2);
			}
		}
		return neighbors;
	}

	private MapNode getMinimum(Set<MapNode> MapNodees) {
		MapNode minimum = null;
		for (MapNode MapNode : MapNodees) {
			if (minimum == null) {
				minimum = MapNode;
			} else {
				if (getShortestDistance(MapNode) < getShortestDistance(minimum)) {
					minimum = MapNode;
				}
			}
		}
		return minimum;
	}

	private boolean isSettled(MapNode MapNode) {
		return settledNodes.contains(MapNode);
	}

	private int getShortestDistance(MapNode destination) {
		Integer d = distance.get(destination);
		if (d == null) {
			return Integer.MAX_VALUE;
		} else {
			return d;
		}
	}

	/*
	 * This method returns the path from the source to the selected target and
	 * NULL if no path exists
	 */
	public LinkedList<MapNode> getPath(MapNode target) {
		LinkedList<MapNode> path = new LinkedList<MapNode>();
		MapNode step = target;
		// Check if a path exists
		if (predecessors.get(step) == null) {
			return null;
		}
		path.add(step);
		while (predecessors.get(step) != null) {
			step = predecessors.get(step);
			path.add(step);
		}
		// Put it into the correct order
		Collections.reverse(path);
		return path;
	}
}
