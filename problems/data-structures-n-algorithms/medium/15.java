// 15. 3Sum
// https://leetcode.com/problems/3sum/

import java.util.*;

class S3Sum {
	public static void main (String args[]) {
		int[] num = new int[]{-1, 0, 1, 2, -1, -4};
		List<List<Integer>> res = threeSum(num);

		System.out.println(res);
		// res.forEach(o -> {
		// 	o.forEach(i -> System.out.print(i + ", "));
		// 	System.out.println();
		// });
	}

	public static List<List<Integer>> threeSum (int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		int len = nums.length;
		int target = 0;

		Arrays.sort(nums);

		for (int i = 0; i < len; i++) {
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			int left = i + 1;
			int right = len - 1;
			while (left < right) {
				int csum = nums[i] + nums[left] + nums[right];
				if (csum > target) {
					right--;
				} else if (csum < target) {
					left++;
				} else if (csum == target) {
					res.add(Arrays.asList(nums[i], nums[left], nums[right]));
					left++;
					while (nums[left] == nums[left - 1] && left < right) {
						left++;
					}
				}
			}
		}
		return res;
	}
}