/**
 *  Description
 * 
 *  @author Georg Hasebe
 */
package com.ghasebe.algorithms.dp;

public class LongestCommonSubsequence {

	public static int longestCommonSubsequence(String A, String B) {
		int n = A.length();
		int m = B.length();
		
		int[][] dp = new int[n + 1][m + 1];
		
		for (int i = 1; i <= n; ++i) {
			for (int j = 1; j <= m; ++j) {
				dp[i][j] = max(
						dp[i][j - 1],
						dp[i - 1][j],
						dp[i - 1][j - 1] + (A.charAt(i - 1) == B.charAt(j - 1) ? 1 : 0)
					);
			}
		}
		
		return dp[n][m];
	}
	
	public static int max(int a, int b, int c) {
		return Math.max(a, Math.max(b, c));
	}
}
