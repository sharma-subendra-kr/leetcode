// 75. Sort Colors
// https://leetcode.com/problems/sort-colors/

import java.util.Arrays;
import java.util.Collections;

class S75 {
	public static void main (String args[]) {
		int[] nums = new int[]{2, 0, 2, 1, 1, 0};
		sortColors(nums);
		Arrays.stream(nums).boxed().forEach(o -> System.out.println(o));
	}

	public static void sortColors (int[] nums) {
		int zeros = 0;
		int ones = 0;
		int twos = 0;

		int len = nums.length;
		for (int i = 0; i < len; i++) {
			if (nums[i] == 0) {
				zeros++;
			} else if (nums[i] == 1) {
				ones++;
			} else if (nums[i] == 2) {
				twos++;
			}
		}
		int i = 0;
		while (i < len) {
			if (zeros > 0) {
				nums[i] = 0;
				zeros--;
			} else if (ones > 0) {
				nums[i] = 1;
				ones--;
			} else if (twos > 0) {
				nums[i] = 2;
				twos--;
			}
			i++;
		}
	}
}

