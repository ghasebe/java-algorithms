/**
 *  Description
 * 
 *  @author Georg Hasebe
 */
package com.ghasebe.algorithms.dp;

public class LevenshteinDistance {

	public static int levenshteinDistance(String A, String B) {
		int n = A.length();
		int m = B.length();
		
		int[][] dp = new int[n + 1][m + 1];
		
		for (int i = 1; i <= n; ++i) { dp[i][0] = i; }
		for (int i = 1; i <= n; ++i) { dp[0][i] = i; }
		
		for (int i = 1; i <= n; ++i) {
			for (int j = 1; j <= m; ++j) {
				dp[i][j] = min3(
						dp[i - 1][j] + 1,	// delete
						dp[i][j - 1] + 1,	// add
						dp[i - 1][j - 1] + (A.charAt(i - 1) == B.charAt(j - 1) ? 0 : 1) // substitute
					);
			}
		}
		
		return dp[n][m];
	}
	
	public static int min3(int delete, int add, int substitute) {
		return Math.min(delete, Math.min(add, substitute));
	}
}
