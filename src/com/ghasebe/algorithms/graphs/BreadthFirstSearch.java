/**
 *  Description
 * 
 *  @author Georg Hasebe
 */
package com.ghasebe.algorithms.graphs;

import java.util.List;
import java.util.LinkedList;

public class BreadthFirstSearch {

	public static void breadthFirstSearch(List<List<Integer>> G, int source, int n, int m) {
		boolean[] V = new boolean[n];
		LinkedList<Integer> Q = new LinkedList<>();
		Q.addLast(source);
		
		while (!Q.isEmpty()) {
			int u = Q.pollFirst();
			
			if (!V[u]) {
				V[u] = true;
				
				for (Integer v : G.get(u)) {
					if (!V[v]) {
						Q.addLast(v);
					}
				}
			}
		}
	}
}
