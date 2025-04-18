// 128. Longest Consecutive Sequence
// https://leetcode.com/problems/longest-consecutive-sequence/

import java.util.HashMap;

class S128 {
	public static void main (String[] args) {
		// int[] nums = new int[]{100, 4, 200, 1, 3, 2};
		int[] nums = new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
		int res = longestConsecutive(nums);
		System.out.println(res);
	}

	public static int longestConsecutive (int[] nums) {
		int len = nums.length;
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < len; i++) {
			map.put(nums[i], i);
		}

		int max = 0;
		for (int i = 0; i < len; i++) {
			if (map.get(nums[i]) >= 0) {
				int count = 0;
				Integer curr = nums[i];
				Integer idx = map.get(curr);
				while (idx != null && idx > -1) {
					map.put(curr, -1);
					curr++;
					idx = map.get(curr);
					count++;
				}
				curr = nums[i] - 1;
				idx = map.get(curr);
				while (idx != null && idx > -1) {
					map.put(curr, -1);
					curr--;
					idx = map.get(curr);
					count++;
				}
				if (count > max) {
					max = count;
				}
			}
		}
		return max;
	}

	// Daren Chen's solution
	// public static int longestConsecutive (int[] nums) {
	// 	int len = nums.length;
	// 	HashMap<Integer, Integer> map = new HashMap<>();
	// 	int res = 0;
	// 	for (int i = 0; i < len; i++) {
	// 		if (!map.containsKey(nums[i])) {
	// 			int left = map.containsKey(nums[i] - 1) ? map.get(nums[i] - 1) : 0;
	// 			int right = map.containsKey(nums[i] + 1) ? map.get(nums[i] + 1) : 0;
	// 			int sum = left + right + 1;
	// 			map.put(nums[i], sum);
	// 			res = Math.max(res, sum);
	//
	// 			map.put(nums[i] - left, sum);
	// 			map.put(nums[i] + right, sum);
	// 		}
	// 	}
	// 	return res;
	// }
}