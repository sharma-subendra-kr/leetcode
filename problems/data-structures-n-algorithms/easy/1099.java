// 1099. Two Sum Less Than K
// https://leetcode.com/problems/two-sum-less-than-k/

import java.util.Arrays;

class S1099 {
	public static void main (String[] args) {
		int[] nums;
		int k;

		nums = new int[]{34, 23, 1, 24, 75, 33, 54, 8};
		k = 60;

		nums = new int[]{10, 20, 30};
		k = 15;

		int res = twoSumLessThanK(nums, k);

		System.out.println(res);
	}

	public static int twoSumLessThanK (int[] nums, int k) {
		Arrays.sort(nums);

		int i = 0, j = nums.length - 1;
		int max = Integer.MIN_VALUE;

		while (i < j) {
			if (nums[i] + nums[j] < k && nums[i] + nums[j] > max) {
				max = nums[i] + nums[j];
			}
			if (nums[i] + nums[j] >= k) {
				j--;
			} else {
				i++;
			}
		}

		if (max < k && max != Integer.MIN_VALUE) {
			return max;
		}
		return -1;
	}
}