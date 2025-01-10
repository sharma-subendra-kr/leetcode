// 72. Edit Distance
// https://leetcode.com/problems/edit-distance/

import java.util.Arrays;

class S72 {
	public static void main(String[] args) {
//		String word1 = "horse";
//		String word2 = "ros";
//		String word1 = "intention";
//		String word2 = "execution";
		String word1 = "";
		String word2 = "a";

		int res = minDistance(word1, word2);
		System.out.println(res);
	}

	public static int minDistance(String word1, String word2) {
		int len1 = word1.length();
		int len2 = word2.length();

		int[][] dp = new int[2][len2 + 1];
		dp[0][0] = 0;
		for (int i = 1; i <= len2; i++) {
			dp[0][i] = i;
		}

		for (int i = 1; i <= len1; i++) {
			dp[1][0] = dp[0][0] + 1;
			for (int j = 1; j <= len2; j++) {
				if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
					dp[1][j] = dp[0][j - 1];
				} else {
					dp[1][j] = Math.min(Math.min(dp[1][j - 1], dp[0][j - 1]), dp[0][j]) + 1;
				}
			}
			for (int k = 0; k <= len2; k++) {
				dp[0][k] = dp[1][k];
			}
			Arrays.fill(dp[1], 0);
		}
		return dp[0][len2];
	}
}