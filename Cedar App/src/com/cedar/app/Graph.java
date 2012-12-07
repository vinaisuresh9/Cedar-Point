package com.cedar.app;

import java.util.List;



/**
 * @author Thomas Li
 * Graph class is used to connect nodes and edges together for use in Dijkstra's algorithm. However we decided to use our own custom algorithm because Dijkstra's 
 * does not provide an optimal route for our app.
 */

public class Graph {
	private final List<MapNode> nodes;
	private final List<MapEdge> edges;

	/**
	 * @param nodes
	 * @param edges
	 */
	public Graph(List<MapNode> nodes, List<MapEdge> edges) {
		this.nodes = nodes;
		this.edges = edges;
	}

	/**
	 * @author Thomas Li
	 *@return List<MapNode>
	 */
	public List<MapNode> getNodes() {
		return nodes;
	}

	/**
	 * @return List<MapEdge>
	 */
	public List<MapEdge> getEdges() {
		return edges;
	}


}
