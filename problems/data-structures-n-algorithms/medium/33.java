// 33. Search in Rotated Sorted Array
// https://leetcode.com/problems/search-in-rotated-sorted-array/

class S33 {
	public static void main (String args[]) {
		// int[] nums = new int[]{4, 5, 6, 7, 0, 1, 2};
		// int target = 0;
		int[] nums = new int[]{1, 3};
		int target = 3;
		// int[] nums = new int[]{5, 1, 3};
		// int target = 5;
		int res = search(nums, target);
		System.out.println(res);
	}

	public static int search (int[] nums, int target) {
		int len = nums.length;
		int low = 0;
		int high = len - 1;
		int mid;

		while (low < high) {
			mid = (low + high) / 2;
			if (nums[mid] > nums[len - 1]) {
				low = mid + 1;
			} else {
				high = mid;
			}
		}

		int pivot = low;
		if (target >= nums[pivot] && target <= nums[len - 1]) {
			low = pivot;
			high = len - 1;
		} else {
			low = 0;
			high = pivot - 1;
		}

		while (low < high) {
			mid = (low + high) / 2;
			if (target > nums[mid]) {
				low = mid + 1;
			} else {
				high = mid;
			}
		}

		return nums[low] == target ? low : -1;
	}
}