// 300. Longest Increasing Subsequence
// https://leetcode.com/problems/longest-increasing-subsequence/

class S300 {
	public static void main (String args[]) {
		int[] nums = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
		int res = lengthOfLIS(nums);
		System.out.println(res);
	}

	public static int binarySearch (int[] arr, int start, int end, int val) {
		int low = start;
		int high = end;
		int mid = 0;

		while (low < high) {
			mid = (low + high) / 2;
			if (val > arr[mid]) {
				low = mid + 1;
			} else {
				high = mid;
			}
		}

		// high also works because low will be equal to high
		// since mid+1 will be equal to high
		return low;
	}

	public static int lengthOfLIS (int[] nums) {
		int len = nums.length;
		int[] dp = new int[len];
		int dpLen = 0;
		for (int i = 0; i < len; i++) {
			int idx = binarySearch(dp, 0, dpLen, nums[i]);
			dp[idx] = nums[i];
			if (idx == dpLen) {
				dpLen++;
			}
		}
		return dpLen;
	}
}