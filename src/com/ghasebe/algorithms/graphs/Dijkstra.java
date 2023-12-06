/**
 *  Dijkstra's algorithm for finding the shortest paths between nodes in a graph.
 *  The implementation uses an adjacency list to store the graph. 
 * 
 *  @author	Georg Hasebe
 */
package com.ghasebe.algorithms.graphs;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Dijkstra {
	
	public static class Edge {
		int from, to, weight;
		
		public Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
	}

	public static class Node implements Comparable<Node> {
		int key, dist;
		
		public Node(int key, int dist) {
			this.key = key;
			this.dist = dist;
		}
		
		@Override
		public int compareTo(Node other) {
			return Integer.compare(this.dist, other.dist);
		}
	}
	
	public int[] dijkstra(ArrayList<ArrayList<Edge>> G, int n, int start) {
		int[] P = new int[n]; // store predecessors of nodes
		int[] D = new int[n]; // store distance from start to nodes
		
		for (int i = 0; i < n; ++i) D[i] = Integer.MAX_VALUE;
		D[start] = 0;
		
		PriorityQueue<Node> PQ = new PriorityQueue<>();
		PQ.add(new Node(start, 0));
		
		while (!PQ.isEmpty()) {
			Node u = PQ.poll();
			
			if (D[u.key] < u.dist) continue; // already found shorter distance
			
			for (Edge edge : G.get(u.key)) {
				int v = edge.to;
				int d = D[u.key] + edge.weight;
				
				if (d < D[v]) {
					D[v] = d;
					P[v] = u.key;
					PQ.add(new Node(v, D[v]));
				}
			}
		}
		
		return D;
	}
}
