// 238. Product of Array Except Self
// https://leetcode.com/problems/product-of-array-except-self/

import java.util.Arrays;

class S238 {
	public static void main (String[] args) {
		// int[] nums = new int[]{1, 2, 3, 4};
		// int[] nums = new int[]{-1, 1, 0, -3, 3};
		int[] nums = new int[]{2, 3, 5, 0};
		int[] res = productExceptSelf(nums);
		Arrays.stream(res).forEach(o -> System.out.println(o));
	}

	public static int[] productExceptSelf (int[] nums) {
		int len = nums.length;
		int[] res = new int[len];

		res[0] = nums[0];
		for (int i = 1; i < len - 1; i++) {
			res[i] = nums[i] * res[i - 1];
		}

		res[len - 1] = res[len - 2];
		int rightSideProd = nums[len - 1];

		for (int i = len - 2; i > 0; i--) {
			res[i] = rightSideProd * res[i - 1];
			rightSideProd *= nums[i];
		}
		res[0] = rightSideProd;

		return res;
	}
}