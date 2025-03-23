// 55. Jump Game
// https://leetcode.com/problems/jump-game/

class S55 {
	public static void main (String args[]) {
		// int[] nums = new int[]{2, 3, 1, 1, 4};
		int[] nums = new int[]{3, 2, 1, 0, 4};
		boolean res = canJump(nums);
		System.out.println(res);
	}

	public static boolean canJump (int[] nums) {
		int len = nums.length;

		int max = 0;
		for (int i = 0; i < len; i++) {
			if (nums[i] + i > max) {
				max = i + nums[i];
			}
			if (max == i && i != len - 1) {
				return false;
			}
		}
		return true;
	}
}