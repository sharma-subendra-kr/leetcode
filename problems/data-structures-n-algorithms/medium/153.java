// 153. Find Minimum in Rotated Sorted Array
// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/

class S153 {
	public static void main (String[] args) {
		int[] nums = new int[]{3, 4, 5, 1, 2};
		int res = findMin(nums);
		System.out.println(res);
	}

	public static int findMin (int[] nums) {
		int len = nums.length;
		int low = 0;
		int high = len - 1;
		int mid;
		while (low < high) {
			mid = (low + high) / 2;
			if (nums[mid] > nums[high]) {
				low = mid + 1;
			} else {
				high = mid;
			}
		}
		return nums[low];
	}
}