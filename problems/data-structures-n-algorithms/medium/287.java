// 287. Find the Duplicate Number
// https://leetcode.com/problems/find-the-duplicate-number/description/

class S287 {
	public static void main (String[] args) {
		int[] nums = new int[]{1, 3, 4, 2, 2};
		int res = findDuplicate(nums);
		System.out.println(res);
	}

	public static int findDuplicate (int[] nums) {
		int slow = 0;
		int fast = 0;
		do {
			slow = nums[slow];
			fast = nums[nums[fast]];
		} while (nums[slow] != nums[fast]);

		slow = 0;
		while (nums[slow] != nums[fast]) {
			slow = nums[slow];
			fast = nums[fast];
		}

		return nums[slow];
	}
}