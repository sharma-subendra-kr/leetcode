import java.util.Arrays;

class S80 {

	public static void main (String[] args) {
		int[] nums = new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3};
		// int[] nums = new int[]{1, 1, 1};
		// int[] nums = new int[]{1, 1};
		int res = removeDuplicates(nums);
		System.out.println(res);
		System.out.println(Arrays.toString(nums));
	}

	public static int removeDuplicates (int[] nums) {
		int len = nums.length;
		int left = 0;
		int right = 1;
		int temp;
		int count = 0;
		int prev = nums[0];
		int prevIdx = 0;
		for (int i = 1; i < len; i++) {
			if (nums[i] == prev && i - prevIdx > 1) {
				nums[i] = Integer.MIN_VALUE;
				count++;
			} else if (nums[i] != prev) {
				prev = nums[i];
				prevIdx = i;
			}
		}

		while (right < len && left < len - 1) {
			if (nums[left] != Integer.MIN_VALUE) {
				left++;
			} else {
				right = left + 1;
				while (right < len && nums[right] == Integer.MIN_VALUE) {
					right++;
				}
				if (right < len) {
					temp = nums[left];
					nums[left] = nums[right];
					nums[right] = temp;
				}
				left++;
				right++;
			}
		}

		return len - count;
	}
}