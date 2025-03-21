// 322. Coin Change
// https://leetcode.com/problems/coin-change/

import java.util.*;

class S322 {
	public static void main (String[] args) {
		// int[] coins = new int[]{1, 2, 5};
		// int amount = 11;
		int[] coins = new int[]{2};
		int amount = 3;
		// int[] coins = new int[]{1};
		// int amount = 0;
		// int[] coins = new int[]{186, 419, 83, 408};
		// int amount = 6249; // 419,419,419,419,419,408,408,408,408,408,408,408,408,186,186,186,83,83,83,83
		// int[] coins = new int[]{4, 3, 2};
		// int amount = 17;
		// int[] coins = new int[]{3, 2};
		// int amount = 7;
		// int[] coins = new int[]{3, 7, 405, 436};
		// int amount = 8839;

		int res = coinChange(coins, amount);
		System.out.println(res);
	}

	public static int coinChange (int[] coins, int amount) {
		int len = coins.length;
		int[] dp = new int[amount + 1];
		Arrays.sort(coins);
		Arrays.fill(dp, amount + 1);
		dp[0] = 0;

		for (int i = 0; i < len; i++) {
			for (int j = coins[i]; j <= amount; j++) {
				dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
			}
		}
		return dp[amount] == amount + 1 ? -1 : dp[amount];
	}

	// public static int coinChange (int[] coins, int amount) {
	// 	Arrays.sort(coins);
	// 	int len = coins.length;
	// 	long[] dp = new long[amount + 1];
	// 	Arrays.fill(dp, Integer.MAX_VALUE);
	// 	dp[0] = 0;
	// 	for (int i = 0; i < len; i++) {
	// 		int num = 1;
	// 		int j = num * coins[i];
	// 		while (j <= amount) {
	// 			dp[j] = Math.min(num / coins[i] + dp[j - num], dp[j]);
	// 			num += coins[i];
	// 			num++;
	// 			j = num * coins[i];
	// 		}
	// 		// int q = j / coins[i];
	// 		// dp[j] = Math.min(q + dp[j - q * coins[i]], dp[j]);
	// 		// int diff = (amount - j);
	// 		// dp[amount] = Math.min(dp[amount], dp[j] + dp[diff]);
	//
	// 	}
	//
	// 	return dp[amount] == Integer.MAX_VALUE ? -1 : (int) dp[amount];
	// }

	// public static int coinChange (int[] coins, int amount) {
	// 	Arrays.sort(coins);
	// 	int len = coins.length;
	// 	long[] dp = new long[amount + 1];
	// 	Arrays.fill(dp, Integer.MAX_VALUE);
	// 	dp[0] = 0;
	// 	for (int i = 0; i < len; i++) {
	// 		for (int j = 1; j <= amount; j++) {
	// 			int num = coins[i];
	// 			while (num <= j) {
	// 				dp[j] = Math.min(num / coins[i] + dp[j - num], dp[j]);
	// 				num += coins[i];
	// 			}
	// 			// int q = j / coins[i];
	// 			// dp[j] = Math.min(q + dp[j - q * coins[i]], dp[j]);
	// 			// int diff = (amount - j);
	// 			// dp[amount] = Math.min(dp[amount], dp[j] + dp[diff]);
	// 		}
	// 	}
	//
	// 	return dp[amount] == Integer.MAX_VALUE ? -1 : (int) dp[amount];
	// }
}

// public static void reverse (int[] arr) {
// 	int len = arr.length;
// 	int left = 0;
// 	int right = len - 1;
// 	int temp;
// 	while (left < right) {
// 		temp = arr[left];
// 		arr[left] = arr[right];
// 		arr[right] = temp;
// 		left++;
// 		right--;
// 	}
// }