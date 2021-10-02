// 410. Split Array Largest Sum
// https://leetcode.com/problems/split-array-largest-sum/

class S410 {
	public static void main (String[] args) {
		int[] nums;
		int m;

		// nums = new int[]{7, 2, 5, 10, 8};
		// m = 2;
		nums = new int[]{1, 2, 3, 4, 5};
		m = 2;
		nums = new int[]{1, 4, 4};
		m = 3;
		nums = new int[]{2, 3, 1, 1, 1, 1, 1};
		m = 5;

		int res = splitArray(nums, m);

		System.out.println(res);
	}

	public static int splitArray (int[] nums, int m) {
		int left = 0;
		int right = 0;

		for (int i = 0; i < nums.length; i++) {
			left = Math.max(left, nums[i]);
			right += nums[i];
		}

		int minSum = Integer.MAX_VALUE;
		while (left <= right) {
			int mid = (left + right) / 2;

			int i = 0;
			int count = 0;
			int max = 0;
			while (i < nums.length) {
				int sum = 0;
				while (i < nums.length && sum + nums[i] <= mid) {
					sum += nums[i];
					i++;
				}
				if (sum > max) {
					max = sum;
				}
				count++;
			}

			if (count < m) {
				right = mid - 1;
			} else if (count > m) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
			if (minSum > max && count <= m) {
				minSum = max;
			}
		}
		return minSum;
	}
}
