/**
 *  Description
 * 
 *  @author Georg Hasebe
 */
package com.ghasebe.algorithms.dp;

public class Knapsack {

	public static int knapsack(int[] WI, int[] VI, int W, int n) {
		int[][] dp = new int[n + 1][W + 1];

		for (int i = 1; i <= n; ++i) {
			for (int j = 1; j <= W; ++j) {
				if (j >= WI[i - 1]) {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - WI[i - 1]] + VI[i - 1]);
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}

		return dp[n][W];
	}
}
