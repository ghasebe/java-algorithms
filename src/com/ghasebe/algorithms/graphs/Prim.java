/**
 *  Description
 * 
 *  @author Georg Hasebe
 */
package com.ghasebe.algorithms.graphs;

import java.util.List;
import java.util.PriorityQueue;

public class Prim {
	
	public static class Edge {
		int from, to, weight;
		
		public Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
	}
	
	public static class Node implements Comparable<Node> {
		int key, cost;
		
		public Node(int key, int cost) {
			this.key = key;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Node other) {
			return Integer.compare(this.cost, other.cost);
		}
	}

	public static int[] prim(List<List<Edge>> G, int n, int source) {
		int[] C = new int[n]; // store cheapest connection cost 
		int[] P = new int[n]; // store predecessors of nodes
		
		for (int i = 0; i < n; ++i) {
			C[i] = Integer.MAX_VALUE;
			P[i] = -1;
		}
		C[source] = 0;
		
		PriorityQueue<Node> PQ = new PriorityQueue<>();
		for (int i = 0; i < n; ++i) {
			PQ.add(new Node(i, Integer.MAX_VALUE));
		}
		PQ.add(new Node(source, C[source]));
		
		boolean[] inMST = new boolean[n]; // store if node is in MST
		
		while (!PQ.isEmpty()) {
			int u = PQ.poll().key;
			
			if (inMST[u]) continue;
			
			inMST[u] = true;
			
			for (Edge e : G.get(u)) {
				if (!inMST[e.from] && e.weight < C[e.to]) {
					C[e.from] = e.weight;
					P[e.to] = u;
					PQ.add(new Node(e.from, e.weight));
				}
			}
		}
		
		return P;
	}
}
