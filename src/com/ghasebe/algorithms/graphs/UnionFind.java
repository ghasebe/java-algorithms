/**
 *  Description
 * 
 *  @author Georg Hasebe
 */
package com.ghasebe.algorithms.graphs;

public class UnionFind {

	private int[] parent;
	private int[] rank;
	
	public UnionFind(int n) {
		parent = new int[n];
		rank = new int[n];
		for (int i = 0; i < n; ++i) {
			parent[i] = i;
		}
	}

	// find using path halving (see wikipedia disjoint set datastructure)
	public int find(int x) {
		while (parent[x] != x) {
			parent[x] = parent[parent[x]];
			x = parent[x];
		}
		return parent[x];
	}

	public void union(int x, int y) {
		int xr = find(x);
		int yr = find(y);
		if (xr == yr) return;

		if (rank[yr] < rank[xr]) {
			parent[yr] = xr;
		} else if (rank[xr] < rank[yr]) {
			parent[xr] = yr;
		} else {
			parent[yr] = xr;
			rank[xr]++;
		}
	}
	
	public boolean connected(int x, int y) {
		return find(x) == find(y);
	}
}
