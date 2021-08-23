// 747. Largest Number At Least Twice of Others
// https://leetcode.com/problems/largest-number-at-least-twice-of-others/

class S747 {
	public static void main (String[] args) {
		int[] nums;

		nums = new int[]{3, 6, 1, 0};
		// nums = new int[]{1, 2, 3, 4};
		// nums = new int[]{1};

		int res = dominantIndex(nums);

		System.out.println(res);
	}

	public static int dominantIndex (int[] nums) {
		int max = 0;
		int maxIndex = 0;
		int secMax = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > max) {
				secMax = max;
				max = nums[i];
				maxIndex = i;
			} else if (nums[i] > secMax) {
				secMax = nums[i];
			}
		}

		if (secMax * 2 <= max) {
			return maxIndex;
		}
		return -1;
	}
}