/**
 *  Description
 * 
 *  @author Georg Hasebe
 */
package com.ghasebe.algorithms.sort;

public class QuickSort {

	public static void quickSort(int[] A, int l, int r) {
		if (l < r) {
			int k = partition(A, l, r);

			quickSort(A, l, k - 1);
			quickSort(A, k + 1, r);
		}
	}

	public static int partition(int[] A, int l, int r) {
		int p = A[r];
		int i = l - 1;

		for (int j = l; j <= r - 1; ++j) {
			if (A[j] < p) {
				i++;
				if (i != j) {
					int tmp = A[i];
					A[i] = A[j];
					A[j] = tmp;
				}
			}
		}

		i++;
		int tmp = A[i];
		A[i] = A[r];
		A[r] = tmp;

		return i;
	}
}
