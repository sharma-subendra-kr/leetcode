// 62. Unique Paths
// https://leetcode.com/problems/unique-paths/

import java.util.Arrays;

class S62 {
	public static void main (String args[]) {
		int m = 3;
		int n = 7;

		int res = uniquePaths(m, n);
		System.out.println(res);
	}

	public static int uniquePaths (int m, int n) {
		int[] dp = new int[m + 1];
		Arrays.fill(dp, 1);
		dp[0] = 0;

		for (int i = 1; i < n; i++) {
			for (int j = 1; j <= m; j++) {
				dp[j] = dp[j] + dp[j - 1];
			}
		}

		return dp[m];
	}
}