// 188. Best Time to Buy and Sell Stock IV
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/

class S188 {
	public static void main (String args[]) {
		// int[] prices = new int[]{2, 4, 1};
		// int k = 2;
		// int[] prices = new int[]{3, 2, 6, 5, 0, 3};
		// int k = 2;
		// int[] prices = new int[]{6, 1, 3, 2, 4, 7};
		// int k = 2;
		int[] prices = new int[]{1, 2, 3, 4, 5};
		int k = 2;
		int res = maxProfit(k, prices);
		System.out.println(res);
	}

	public static int maxProfit (int k, int[] prices) {
		int len = prices.length;
		int[][] dp = new int[k + 1][len];

		for (int i = 0; i < len; i++) {
			dp[0][i] = 0;
		}
		for (int i = 0; i <= k; i++) {
			dp[i][0] = 0;
		}

		for (int i = 1; i <= k; i++) {
			int expense = dp[i - 1][0] - prices[0];
			for (int j = 1; j < len; j++) {
				dp[i][j] = Math.max(dp[i][j - 1], prices[j] + expense);
				expense = Math.max(expense, dp[i - 1][j] - prices[j]);
			}
		}
		return dp[k][len - 1];
	}
}