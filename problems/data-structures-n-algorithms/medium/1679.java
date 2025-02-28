// 1679. Max Number of K-Sum Pairs
// https://leetcode.com/problems/max-number-of-k-sum-pairs/

import java.util.Arrays;

class S1679 {
	public static void main (String args[]) {
		// int[] nums = new int[]{1, 2, 3, 4};
		// int k = 5;
		int[] nums = new int[]{3, 1, 3, 4, 3};
		int k = 6;
		int res = maxOperations(nums, k);
		System.out.println(res);
	}

	public static int maxOperations (int[] nums, int k) {
		Arrays.sort(nums);

		int len = nums.length;
		int res = 0;
		int left = 0;
		int right = len - 1;
		while (left < right) {
			if (nums[left] + nums[right] > k) {
				right--;
			} else if (nums[left] + nums[right] < k) {
				left++;
			} else {
				right--;
				left++;
				res++;
			}
		}
		return res;
	}
}