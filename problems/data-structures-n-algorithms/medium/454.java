// 454. 4Sum II
// https://leetcode.com/problems/4sum-ii/

import java.util.HashMap;
import java.util.HashSet;

class S454 {
	public static void main (String[] args) {
		// int[] nums1 = new int[]{1, 2};
		// int[] nums2 = new int[]{-2, -1};
		// int[] nums3 = new int[]{-1, 2};
		// int[] nums4 = new int[]{0, 2};

		int[] nums1 = new int[]{-1, -1};
		int[] nums2 = new int[]{-1, 1};
		int[] nums3 = new int[]{-1, 1};
		int[] nums4 = new int[]{1, -1};

		int res = fourSumCount(nums1, nums2, nums3, nums4);
		System.out.println(res);
	}

	public static int fourSumCount (int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
		int len = nums1.length;
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				int sum = nums1[i] + nums2[j];
				int val = map.getOrDefault(sum, 0);
				map.put(sum, val + 1);
			}
		}
		int res = 0;
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				int diff = 0 - (nums3[i] + nums4[j]);
				res += map.getOrDefault(diff, 0);
			}
		}

		return res;
	}
}