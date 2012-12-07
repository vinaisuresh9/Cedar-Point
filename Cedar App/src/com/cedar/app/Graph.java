package com.cedar.app;

import java.util.List;

public class Graph {
	private final List<MapNode> nodes;
	private final List<MapEdge> edges;

	public Graph(List<MapNode> nodes, List<MapEdge> edges) {
		this.nodes = nodes;
		this.edges = edges;
	}

	public List<MapNode> getNodes() {
		return nodes;
	}

	public List<MapEdge> getEdges() {
		return edges;
	}


}
