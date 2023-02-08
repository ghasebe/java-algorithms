/**
 *  Description
 * 
 *  @author Georg Hasebe
 */
package com.ghasebe.algorithms.dp;

public class MatrixChainMultiplication {

	public static int[][] matrixChainMultiplication(int[] P, int n) {
		int[][] DP = new int[n][n];

		for (int L = 2; L < n; ++L) {
			for (int i = 1; i < n - L + 1; ++i) {
				int j = i + L - 1;

				DP[i][j] = Integer.MAX_VALUE;
				for (int k = i; k <= j - 1; ++k) {
					int q = DP[i][k] + DP[k + 1][j] + P[i - 1] * P[k] * P[j];
					if (q < DP[i][j]) {
						DP[i][j] = q;
					}
				}
			}
		}

		return DP;
	}
}
