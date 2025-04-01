// 46. Permutations
// https://leetcode.com/problems/permutations/

import java.util.ArrayList;
import java.util.List;

class S46 {
	public static void main (String args[]) {
		int[] nums = new int[]{1, 2, 3, 4};
		List<List<Integer>> res = permute(nums);
		System.out.println(res);
	}

	public static List<List<Integer>> permute (int[] nums) {
		int len = nums.length;
		List<List<Integer>> res = new ArrayList<>();
		boolean[] visited = new boolean[len];
		recursion(nums, 0, len, visited, new ArrayList<>(), res);
		return res;
	}

	public static void recursion (int[] nums, int cLen, int len, boolean[] visited, List<Integer> curr,
	                              List<List<Integer>> res) {
		if (cLen == len) {
			res.add(curr);
			return;
		}

		List<Integer> temp = new ArrayList<>(curr);
		for (int i = 0; i < len; i++) {
			if (visited[i] == true) {
				continue;
			}
			temp.add(nums[i]);
			visited[i] = true;
			cLen++;
			recursion(nums, cLen, len, visited, temp, res);
			if (cLen < len) {
				temp.remove(cLen - 1);
			}
			visited[i] = false;
			cLen--;
		}
	}
}