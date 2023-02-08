/**
 *  Description
 * 
 *  @author Georg Hasebe
 */
package com.ghasebe.algorithms.graphs;

import java.util.LinkedList;
import java.util.List;

public class DepthFirstSearchIterative {

	public static void deptFirstSearchIterative(List<List<Integer>> G, int s, int n, int m) {
		boolean[] V = new boolean[n];
		LinkedList<Integer> S = new LinkedList<>();
		S.addLast(s);
		
		while (!S.isEmpty()) {
			int u = S.pollLast();

			if (!V[u]) {
				V[u] = true;
				
				for (Integer v : G.get(u)) {
					if (!V[v]) {
						S.addLast(v);
					}
				}
			}
		}
	}
}
