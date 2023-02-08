/**
 *  Description
 * 
 *  @author Georg Hasebe
 */
package com.ghasebe.algorithms.graphs;

import java.util.List;

public class DepthFirstSearchRecursive {

	public static void depthFirstSearchRecursive(List<List<Integer>> G, boolean[] V, int u) {
		V[u] = true;
		
		for (Integer v : G.get(u)) {
			if (!V[v]) {
				depthFirstSearchRecursive(G,V,v);
			}
		}
	}
}
