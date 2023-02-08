/**
 *  Description
 * 
 *  @author Georg Hasebe
 */
package com.ghasebe.algorithms.dp;

public class SubsetSum {

	public static boolean subsetSum(int[] A, int b, int n) {
		boolean[][] dp = new boolean[n + 1][b + 1];

		for (int i = 0; i < n + 1; ++i) {
			dp[i][0] = true;
		}

		for (int i = 1; i <= n; ++i) {
			for (int j = 1; j <= b; ++j) {
				if (A[i - 1] <= j) {
					dp[i][j] = dp[i - 1][j - A[i - 1]] || dp[i - 1][j];
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}

		return dp[n][n];
	}
}
