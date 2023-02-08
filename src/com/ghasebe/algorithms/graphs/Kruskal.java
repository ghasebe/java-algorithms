/**
 *  Description
 * 
 *  @author Georg Hasebe
 */
package com.ghasebe.algorithms.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Kruskal {

	public static class Edge implements Comparable<Edge> {
		int from, to, weight;
		
		public Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Edge other) {
			return Integer.compare(this.weight, other.weight);
		}
	}
	
	public static List<Edge> kruskal(int[] source, int[] dest, int[] weight, int n, int m) {

		Edge[] E = new Edge[m];
		for (int i = 0; i < m; ++i) {
			E[i] = new Edge(source[i], dest[i], weight[i]);
		}

		Arrays.sort(E);

		UnionFind uf = new UnionFind(n);

		List<Edge> MST = new ArrayList<>(n - 1);
		for (Edge edge : E) {
			if (!uf.connected(edge.from, edge.to)) {
				MST.add(edge);
				uf.union(edge.from, edge.to);
			}
		}
		
		return MST;
	}
}
