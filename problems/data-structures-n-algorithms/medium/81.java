// 81. Search in Rotated Sorted Array II
// https://leetcode.com/problems/search-in-rotated-sorted-array-ii/

class S81 {
	public static void main (String args[]) {
		// int[] nums = new int[]{1, 0, 1, 1, 1};
		// int target = 0;
		int[] nums = new int[]{1};
		int target = 0;
		boolean res = search(nums, target);
		System.out.println(res);
	}

	public static boolean search (int[] nums, int target) {
		int len = nums.length;
		int low = 0;
		int high = len - 1;
		int mid;

		while (low < high && nums[low] == nums[high]) {
			low++;
		}
		int start = low;

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
			low = start;
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

		return nums[low] == target;
	}
}