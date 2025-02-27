// 1004. Max Consecutive Ones III
// https://leetcode.com/problems/max-consecutive-ones-iii/

class S1004 {
	public static void main (String args[]) {
		// int[] nums = new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
		// int k = 2;
		// int[] nums = new int[]{0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1};
		// int k = 3;
		// int[] nums = new int[]{0, 0, 0, 0};
		// int k = 0;
		int[] nums = new int[]{0};
		int k = 1;
		int res = longestOnes(nums, k);
		System.out.println(res);
	}

	public static int longestOnes (int[] nums, int k) {
		int len = nums.length;
		int max = nums[0] == 1 || k > 0 ? 1 : 0;
		int zeros = nums[0] == 0 ? 1 : 0;
		int start = 0;
		int curr = 1;
		for (int i = 1; i < len; i++) {
			curr++;
			if (nums[i] == 0) {
				zeros++;
			}
			if (zeros > k) {
				while (nums[start] != 0) {
					start++;
				}
				start++;
				zeros--;
				curr = i - start + 1;
			}

			if (curr > max && zeros <= k) {
				max = curr;
			}
		}
		return max;
	}
}