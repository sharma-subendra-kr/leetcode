// 76. Minimum Window Substring
// https://leetcode.com/problems/minimum-window-substring/

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class S76 {
	public static void main (String[] args) {
		String s = "ADOBECODEBANC";
		String t = "ABC";
		// String s = "a";
		// String t = "a";
		// String s = "ab";
		// String t = "b";
		// String s = "aaaaaaaaaaaabbbbbcdd";
		// String t = "abcdd";
		String res = minWindow(s, t);
		System.out.println(res);
	}

	public static String minWindow (String s, String t) {
		int sLen = s.length();
		int tLen = t.length();
		int[] map = new int[128];
		int begin = 0;
		int end = 0;
		int count = tLen;
		int start = 0;
		int min = Integer.MAX_VALUE;

		for (int i = 0; i < tLen; i++) {
			map[t.charAt(i)]++;
		}

		while (end < sLen) {
			if (map[s.charAt(end)] > 0) {
				count--;
			}
			map[s.charAt(end)]--;
			end++;

			while (count == 0) {
				if (end - begin < min) {
					min = end - begin;
					start = begin;
				}

				if (map[s.charAt(begin)] == 0) {
					count++;
				}
				map[s.charAt(begin)]++;
				begin++;
			}
		}
		return min == Integer.MAX_VALUE ? "" : s.substring(start, start + min);
	}
}