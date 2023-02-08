/**
 *  Description
 * 
 *  @author Georg Hasebe
 */
package com.ghasebe.algorithms.sort;

public class InsertionSort {

	public static void insertionSort(int[] A, int n) {
		int i = 1;
		
		while (i < n) {
			int ai = A[i];
			int j = i - 1;
			
			while (j >= 0 && A[j] > ai) {
				A[j + 1] = A[j];
				j--;
			}

			A[j + 1] = ai;
			i++;
		}

	}
}
