// 162. Find Peak Element
// https://leetcode.com/problems/find-peak-element/

class S162 {
	public static void main (String args[]) {
		int[] nums = new int[]{1, 2, 3, 1};
		// int[] nums = new int[]{1, 2, 1, 3, 5, 6, 4};
		// int[] nums = new int[]{1, 2};
		// int[] nums = new int[]{2, 1};
		// int[] nums = new int[]{1, 3, 2, 1};
		int res = findPeakElement(nums);
		System.out.println(res);
	}

	public static int findPeakElement (int[] nums) {
		int mid = 0;
		int low = 0;
		int high = nums.length - 1;

		while (low < high) {
			mid = (low + high) / 2;
			mid = (high - low + 1) % 2 == 0 ? mid + 1 : mid;
			if (nums[mid] > nums[low]) {
				low = mid;
			} else {
				low = 0;
				high = mid - 1;
			}
		}
		return low;
	}
}