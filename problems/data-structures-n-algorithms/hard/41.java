// 41. First Missing Positive
// https://leetcode.com/problems/first-missing-positive/description/

class S41 {
	public static void main (String[] args) {
		int[] nums = new int[]{1, 2, 0};
		int res = firstMissingPositive(nums);
		System.out.println(res);
	}

	public static int firstMissingPositive (int[] nums) {
		int len = nums.length;

		for (int i = 0; i < len; i++) {
			if (nums[i] <= 0 || nums[i] > len) {
				nums[i] = len + 1;
			}
		}

		for (int i = 0; i < len; i++) {
			int num = Math.abs(nums[i]);
			if (num > len) {
				continue;
			}
			num--;
			if (nums[num] > 0) {
				nums[num] = -nums[num];
			}
		}

		for (int i = 0; i < len; i++) {
			if (nums[i] > 0) {
				return i + 1;
			}
		}
		return len + 1;
	}
}