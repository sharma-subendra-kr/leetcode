// https://leetcode.com/problems/two-sum/
// 1. Two Sum

import java.util.*;
import java.util.stream.Collectors;

class S1 {
	public static void main (String args[]) {
		// int[] nums = new int[]{2, 7, 11, 15};
		// int target = 9;
		// int[] nums = new int[]{3, 3};
		// int target = 6;
		int[] nums = new int[]{3, 2, 4};
		int target = 6;

		int[] res = twoSum(nums, target);

		Arrays.stream(res).boxed().collect(Collectors.toList()).forEach(o -> System.out.println(o));
	}

	public static int[] twoSum (int[] nums, int target) {
		int len = nums.length;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < len; i++) {
			map.put(nums[i], i);
		}
		int[] res = new int[2];
		for (int i = 0; i < len; i++) {
			int other = target - nums[i];
			if (map.containsKey(other)) {
				int oIndex = map.get(other);
				if (oIndex != i) {
					res[0] = i;
					res[1] = oIndex;
					return res;
				}
			}
		}
		return null;
	}

	// public static int[] twoSum (int[] nums, int target) {
	// 	// Here index is required so this approach doesn't work
	// 	int len = nums.length;
	// 	int[] res = new int[2];
	//
	// 	Arrays.sort(nums);
	//
	// 	int left = 0;
	// 	int right = len - 1;
	// 	while (left < right) {
	// 		int sum = nums[left] + nums[right];
	// 		if (sum > target) {
	// 			right--;
	// 		} else if (sum < target) {
	// 			left++;
	// 		} else {
	// 			res[0] = nums[left];
	// 			res[1] = nums[right];
	// 			return res;
	// 		}
	// 	}
	// 	return null;
	// }
}