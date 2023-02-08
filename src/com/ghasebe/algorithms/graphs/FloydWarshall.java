/**
 *  Description
 * 
 *  @author Georg Hasebe
 */
package com.ghasebe.algorithms.graphs;

import java.util.ArrayList;

public class FloydWarshall {
	
	public static class Edge {
		int from, to, weight;
		
		public Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
	}

	public static int[][] floydWarshall(ArrayList<Edge> E, int n, int m) {
		int[][] DP = new int[n][n];
		
		for (int u = 0; u < n; ++u) {
			for (int v = 0; v < n; ++v) {
				DP[u][v] = Integer.MAX_VALUE;
			}
		}
		
		for (int u = 0; u < n; ++u) {
			DP[u][u] = 0;
		}
 		
		for (Edge e : E) {
			DP[e.from][e.to] = e.weight;
		}
		
		for (int i = 0; i < n; ++i) {
			for (int u = 0; u < n; ++u) {
				for (int v = 0; v < n; ++v) {
					if (DP[u][i] != Integer.MAX_VALUE 
							&& DP[i][v] != Integer.MAX_VALUE
							&& DP[u][v] > DP[u][i] + DP[i][v]) {
						DP[u][v] = DP[u][i] + DP[i][v];
					}
				}
			}
		}
		
		return DP;
	}
}
