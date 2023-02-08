/**
 *  Description
 * 
 *  @author Georg Hasebe
 */
package com.ghasebe.algorithms.search;

public class BinarySearchIterative {

	public static int binarySearch(int[] A, int l, int r, int key) {
		
		while (l < r) {
			int m = l + (r - l)/2;
			
			if (A[m] > key) {
				r = m - 1;
			} else {
				l = m;
			}
		}
		
		if (A[l] == key) {
			return l;
		}
		return -1;
	}
}
