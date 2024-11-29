import java.util.Arrays;

class S45 {

	public static void main (String[] args) {
		// int[] nums = new int[]{2, 3, 1, 1, 4};
		int[] nums = new int[]{2, 3, 0, 1, 4};
		System.out.println("Start!");
		int res = jump(nums);
		System.out.println(res);
	}

	public static int jump (int[] nums) {
		int len = nums.length;
		int[] memo = new int[len];
		Arrays.fill(memo, Integer.MIN_VALUE);
		return recursion(nums, 0, memo);
	}

	public static int recursion (int[] nums, int idx, int[] memo) {
		int len = nums.length;
		if (idx == len - 1) {
			return 0;
		} else if (memo[idx] != Integer.MIN_VALUE) {
			return memo[idx];
		}
		int curr = nums[idx];
		int min = Integer.MAX_VALUE;
		for (int i = idx + 1; i <= idx + curr; i++) {
			if (i >= len) {
				continue;
			}
			int res = Math.min(recursion(nums, i, memo), Integer.MAX_VALUE - 1) + 1;
			if (res < min) {
				min = res;
			}
		}
		memo[idx] = min;
		return min;
	}
}