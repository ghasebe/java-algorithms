/**
 *  The Bellman–Ford algorithm is an algorithm that computes shortest paths from
 *  a single source vertex to all of the other vertices in a weighted graph. 
 * 
 *  @author Georg Hasebe
 */
package com.ghasebe.algorithms.graphs;

import java.util.ArrayList;

public class BellmanFord {
	
	public static class Edge {
		int from, to, weight;
		
		public Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
	}

	public static int[] bellmanFord(ArrayList<Edge> E, int n, int m, int s) {
		int[] P = new int[n]; // store predecessors of nodes
		int[] D = new int[n]; // store distance from start to nodes
		
		for (int i = 0; i < n; ++i) D[i] = Integer.MAX_VALUE;
		D[s] = 0;
		
		for (int i = 1; i < n; ++i) {
			for (Edge e : E) {
				if (D[e.from] != Integer.MAX_VALUE && D[e.to] > D[e.from] + e.weight) {
					D[e.to] = D[e.from] + e.weight;
					P[e.to] = e.from;
				}
			}
		}
		
		for (Edge e : E) {
			if (D[e.from] != Integer.MAX_VALUE && D[e.to] > D[e.from] + e.weight) {
				System.out.println("negative cycle detected.");
				return null;
			}
		}

		return D;
	}
}
