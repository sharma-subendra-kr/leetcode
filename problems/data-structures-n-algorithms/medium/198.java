// 198. House Robber
// https://leetcode.com/problems/house-robber/

class S198 {
	public static void main (String args[]) {
		int[] nums = new int[]{1, 2, 3, 1};
		// int[] nums = new int[]{2, 7, 9, 3, 1};
		// int[] nums = new int[]{2, 1, 1, 2};
		int res = rob(nums);
		System.out.println(res);
	}

	public static int rob (int[] nums) {
		int len = nums.length;
		int[] dp = new int[len];
		if (len == 1) {
			return nums[0];
		} else if (len == 2) {
			return Math.max(nums[0], nums[1]);
		}
		dp[0] = nums[0];
		dp[1] = Math.max(nums[0], nums[1]);

		for (int i = 2; i < len; i++) {
			dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
		}

		return dp[len - 1];
	}
}