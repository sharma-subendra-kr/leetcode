// 209. Minimum Size Subarray Sum
// https://leetcode.com/problems/minimum-size-subarray-sum/

class S209 {
	public static void main (String[] args) {
		int target = 7;
		int[] nums = {2, 3, 1, 2, 4, 3};
		// int target = 4;
		// int[] nums = {1, 4, 4};
		// int target = 11;
		// int[] nums = {1, 2, 3, 4, 5};
		// int target = 80;
		// int[] nums = {10, 5, 13, 4, 8, 4, 5, 11, 14, 9, 16, 10, 20, 8};

		int res = minSubArrayLen(target, nums);
		System.out.println(res);
	}

	public static int minSubArrayLen (int target, int[] nums) {
		int len = nums.length;
		int front = 0;
		int back = 0;
		int min = Integer.MAX_VALUE;
		int sum = 0;
		while (front <= back && front < len) {
			if (back < len && sum < target) {
				sum += nums[back++];
			} else if (sum >= target) {
				if (back - front < min) {
					min = back - front;
				}
				sum -= nums[front++];
			} else if (front < back) {
				sum -= nums[front++];
			}
		}

		if (min != Integer.MAX_VALUE) {
			return min;
		}

		return 0;
	}
}