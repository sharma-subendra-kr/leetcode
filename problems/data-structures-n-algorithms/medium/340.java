// 340. Longest Substring with At Most K Distinct Characters
// https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/

import java.util.Arrays;

class S340 {

	public static void main (String[] args) {
		String s;
		int k;

		s = "eceba";
		k = 2;
		// s = "aa";
		// k = 1;
		// s = "abee";
		// k = 1;
		// s = "ab";
		// k = 0;
		s = "a@b$5!a8alskj234jasdf*()@$&%&#FJAvjjdaurNNMa8ASDF-0321jf?>{}L:fh";
		k = 10;

		int res = lengthOfLongestSubstringKDistinct(s, k);

		System.out.println(res);

	}

	public static int lengthOfLongestSubstringKDistinct (String s, int k) {
		if (s.length() == 0 || k == 0) {
			return 0;
		}

		int[] map = new int[128];
		Arrays.fill(map, -1);
		int MAX = Integer.MIN_VALUE;

		int uniqueChars = 0;
		int len = 0;
		int start = 0;
		for (int i = 0; i < s.length(); i++) {
			int index = s.charAt(i) - '\0';
			if (uniqueChars < k && map[index] == -1) {
				uniqueChars++;
			} else if (uniqueChars == k && map[index] == -1) {
				MAX = Math.max(MAX, len);
				int idx = erase(map);
				len = len - (idx - start + 1);
				start = idx + 1;
			}
			len++;
			map[index] = i;
		}

		return Math.max(len, MAX);
	}

	public static int erase (int[] map) {
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < 128; i++) {
			if (map[i] < min && map[i] != -1) {
				min = map[i];
			}
		}

		for (int i = 0; i < 128; i++) {
			if (map[i] <= min) {
				map[i] = -1;
			}
		}

		return min;
	}
}