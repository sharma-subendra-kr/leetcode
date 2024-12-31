// 918. Maximum Sum Circular Subarray
// https://leetcode.com/problems/maximum-sum-circular-subarray/

import java.util.HashMap;
import java.util.Hashtable;

class S918 {
	public static void main(String[] args) {
//		int nums[] = new int[]{1, -2, 3, -2};
//		int nums[] = new int[]{5, -3, 5};
		int nums[] = new int[]{-3, -2, -3};
//		int nums[] = new int[]{-7, -3, -9, 1, 9, -6, -9, 3, 7};

		int res = maxSubarraySumCircular(nums);
		System.out.println(res);
	}

	public static int maxSubarraySumCircular(int[] nums) {
		int len = nums.length;
		int maxSum = nums[0];
		int currMax = nums[0];
		int minSum = nums[0];
		int currMin = nums[0];
		int total = nums[0];
		for (int i = 1; i < len; i++) {
			currMax = Math.max(currMax + nums[i], nums[i]);
			maxSum = Math.max(maxSum, currMax);
			currMin = Math.min(currMin + nums[i], nums[i]);
			minSum = Math.min(minSum, currMin);
			total = total + nums[i];
		}
		return maxSum > 0 ? Math.max(total - minSum, maxSum) : maxSum;
	}

	public static int getNext(int i, int n) {
		return (i + 1) % n;
	}

	public static int getPrev(int i, int n) {
		return (i - 1 + n) % n;
	}
}