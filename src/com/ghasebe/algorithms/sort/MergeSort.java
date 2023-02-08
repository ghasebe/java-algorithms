/**
 *  Description
 * 
 *  @author Georg Hasebe
 */
package com.ghasebe.algorithms.sort;

public class MergeSort {

	public static void mergeSort(int[] A, int l, int r) {
		if (l < r) {
			int m = l + (r - l) / 2;
			
			mergeSort(A, l, m);
			mergeSort(A, m + 1, r);
			merge(A, l, m, r);
		}
	}
	
	public static void merge(int[] A, int l, int m, int r) {
		int[] B = new int[r - l + 1];
		
		int i = l;
		int j = m + 1;
		int k = 0;
		
		while (i <= m && j <= r) {
			if (A[i] < A[j]) {
				B[k++] = A[i++];
			} else {
				B[k++] = A[j++];
			}
		}
		
		while (i <= m) {
			B[k++] = A[i++];
		}

		while (j <= r) {
			B[k++] = A[j++];
		}
		
		for (int p = l; p <= r; ++p) {
			A[p] = B[p - l];
		}
	}
}
