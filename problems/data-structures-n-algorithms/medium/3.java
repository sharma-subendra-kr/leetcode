// 3. Longest Substring Without Repeating Characters
// https://leetcode.com/problems/longest-substring-without-repeating-characters/

import java.util.Arrays;

class S3 {
	public static void main (String args[]) {
		// String s = "abcabcbb";
		// String s = "bbbbb";
		String s = "pwwkew";
		int res = lengthOfLongestSubstring(s);
		System.out.println(res);
	}

	public static int lengthOfLongestSubstring (String s) {
		int len = s.length();
		int[] map = new int[128];
		Arrays.fill(map, -1);

		int max = 0;
		int start = 0;
		for (int i = 0; i < len; i++) {
			if (map[s.charAt(i)] != -1) {
				while (s.charAt(start) != s.charAt(i)) {
					map[s.charAt(start)] = -1;
					start++;
				}
				start++;
			}
			map[s.charAt(i)] = i;
			if (i - start + 1 > max) {
				max = i - start + 1;
			}
		}
		return max;
	}
}