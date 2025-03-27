// 18. 4Sum
// https://leetcode.com/problems/4sum/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class S18 {
	public static void main (String args[]) {
		// int[] nums = new int[]{1, 0, -1, 0, -2, 2};
		// int target = 0;
		// int[] nums = new int[]{2, 2, 2, 2};
		// int target = 8;
		int[] nums = new int[]{1000000000, 1000000000, 1000000000, 1000000000};
		System.out.println(Long.MAX_VALUE);
		int target = -294967296;

		List<List<Integer>> res = fourSum(nums, target);
		System.out.println(res);
	}

	public static List<List<Integer>> fourSum (int[] nums, int target) {
		Arrays.sort(nums);
		int len = nums.length;
		List<List<Integer>> res = new ArrayList<>();

		for (int i = 0; i < len; i++) {
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			for (int j = i + 1; j < len; j++) {
				if (j > i + 1 && nums[j] == nums[j - 1]) {
					continue;
				}
				int left = j + 1;
				int right = len - 1;
				while (left < right) {
					long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
					if (sum > target) {
						right--;
					} else if (sum < target) {
						left++;
					} else {
						res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
						left++;
						while (left < len && nums[left] == nums[left - 1]) {
							left++;
						}
					}
				}
			}
		}
		return res;
	}
}