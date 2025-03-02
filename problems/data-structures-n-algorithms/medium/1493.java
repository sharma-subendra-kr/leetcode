// 1493. Longest Subarray of 1's After Deleting One Element
// https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/

class S1493 {
	public static void main (String args[]) {
		// int[] nums = new int[]{1, 1, 0, 1};
		// int[] nums = new int[]{0, 1, 1, 1, 0, 1, 1, 0, 1};
		// int[] nums = new int[]{1, 1, 1};
		int[] nums = new int[]{0, 0, 0};
		int res = longestSubarray(nums);
		System.out.println(res);
	}

	public static int longestSubarray (int[] nums) {
		int len = nums.length;

		int max = 0;
		int zeros = 0;
		int curr = 0;
		int left = 0;
		int right = 0;
		while (right < len) {
			curr++;
			if (nums[right] == 0) {
				zeros++;
			}
			if (zeros > 1) {
				while (left < right && nums[left] != 0) {
					left++;
				}
				left++;
				curr = right - left + 1;
				zeros = 1;
			}
			if (zeros == 1 && curr != 1) {
				max = Math.max(max, curr - 1);
			} else if (zeros == 0 && curr != len) {
				max = Math.max(max, curr);
			}
			right++;
		}
		return max;
	}
}