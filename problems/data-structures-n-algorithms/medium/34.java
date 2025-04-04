// 34. Find First and Last Position of Element in Sorted Array
// Search for a Range
// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

import java.util.Arrays;

class S34 {
	public static void main (String[] args) {
		// int[] nums = new int[]{5, 7, 7, 8, 8, 10};
		// int target = 8;
		// int[] nums = new int[]{5, 7, 7, 8, 8, 10};
		// int target = 6;
		int[] nums = new int[]{};
		int target = 0;
		int[] res = searchRange(nums, target);
		Arrays.stream(res).forEach(o -> System.out.println(o));
	}

	public static int[] searchRange (int[] nums, int target) {
		int low = 0;
		int high = nums.length - 1;
		int[] res = new int[]{-1, -1};

		if (high == -1) {
			return res;
		}

		while (low < high) {
			int mid = (low + high) / 2;
			if (target > nums[mid]) {
				low = mid + 1;
			} else {
				high = mid;
			}
		}
		if (nums[low] == target) {
			res[0] = low;
		}

		low = 0;
		high = nums.length - 1;

		while (low < high) {
			int mid = (low + high) / 2 + 1;
			if (target < nums[mid]) {
				high = mid - 1;
			} else {
				low = mid;
			}
		}
		if (nums[low] == target) {
			res[1] = low;
		}

		return res;
	}
}