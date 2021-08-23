// 724. Find Pivot Index
// https://leetcode.com/problems/find-pivot-index/

class S724 {

	public static void main (String[] args) {
		int[] nums;

		nums = new int[]{1, 2, 3};
		// nums = new int[]{1, 7, 3, 6, 5, 6};
		// nums = new int[]{2, 1, -1};

		int res = pivotIndex(nums);

		System.out.println(res);
	}

	public static int pivotIndex (int[] nums) {
		int pivot = nums.length / 2;
		int leftSum = nums[0];
		int rightSum = 0;

		for (int i = 0; i < nums.length; i++) {
			rightSum += nums[i];
		}

		for (int i = 0; i < nums.length; i++) {
			int left = leftSum - nums[i];
			int right = rightSum - nums[i];

			if (left == right) {
				return i;
			}

			rightSum -= nums[i];
			if (i < nums.length - 1) {
				leftSum += nums[i + 1];
			}
		}
		return -1;
	}
}