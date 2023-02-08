/**
 *  Description
 * 
 *  @author Georg Hasebe
 */
package com.ghasebe.algorithms.sort;

public class HeapSort {

	public static void heapSort(int[] A, int n) {
		for (int i = n / 2 - 1; i >= 0; --i) {
			heapify(A, i, n);
		}

		for (int i = n - 1; i >= 0; --i) {
			int tmp = A[i];
			A[i] = A[0];
			A[0] = tmp;

			heapify(A, 0, i);
		}
	}

	public static void heapify(int[] A, int i, int n) {
		while (2 * i + 1 < n) {
			int j = 2 * i + 1;

			if (j + 1 < n && A[j + 1] > A[j]) {
				j++;
			}

			if (A[i] > A[j]) {
				return;
			}
			
			int tmp = A[i];
			A[i] = A[j];
			A[j] = tmp;

			i = j;
		}
	}
}
