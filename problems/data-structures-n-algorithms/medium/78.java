// 78. Subsets
// https://leetcode.com/problems/subsets/

import java.util.ArrayList;
import java.util.List;

class S78 {
	public static void main (String args[]) {
		int[] nums = new int[]{1, 2, 3};
		List<List<Integer>> res = subsets(nums);
		System.out.println(res);
	}

	public static List<List<Integer>> subsets (int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		int len = nums.length;
		res.add(new ArrayList<>());
		recursion(0, len, nums, res, new ArrayList<>());
		return res;
	}

	public static void recursion (int start, int len, int[] nums, List<List<Integer>> res, List<Integer> curr) {
		for (int i = start; i < len; i++) {
			List<Integer> temp = new ArrayList<>(curr);
			temp.add(nums[i]);
			res.add(temp);
			recursion(i + 1, len, nums, res, temp);
		}
	}
}