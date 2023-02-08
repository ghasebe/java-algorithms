/**
 *  Description
 * 
 *  @author Georg Hasebe
 */
package com.ghasebe.algorithms.sort;

public class SelectionSort {

	public static void selectionSort(int[] A, int n) {
		
		for (int i = 0; i < n; ++i) {
			int min = i;
			for (int j = i + 1; j < n; ++j) {
				if (A[j] < A[min]) {
					min = j;
				}
			}
			
			if (i != min) {
				int tmp = A[i];
				A[i] = A[min];
				A[min] = tmp;
			}
		}
	}
}
