// 1456. Maximum Number of Vowels in a Substring of Given Length
// https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

class S1456 {
	public static void main (String args[]) {
		// String s = "abciiidef";
		// int k = 3;
		// String s = "aeiou";
		// int k = 2;
		String s = "leetcode";
		int k = 3;

		int res = maxVowels(s, k);
		System.out.println(res);
	}

	public static int maxVowels (String s, int k) {
		int len = s.length();
		int[] map = new int[]{
			1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0
		};

		int max = 0;
		for (int i = 0; i < k; i++) {
			if (map[s.charAt(i) - 97] == 1) {
				max++;
			}
		}
		int curr = max;
		for (int i = 1; i + k - 1 < len; i++) {
			if (map[s.charAt(i - 1) - 97] == 1) {
				curr--;
			}
			if (map[s.charAt(i + k - 1) - 97] == 1) {
				curr++;
			}
			if (curr > max) {
				max = curr;
			}
		}

		return max;
	}
}
