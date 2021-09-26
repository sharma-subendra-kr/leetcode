// 132. Palindrome Partitioning II
// https://leetcode.com/problems/palindrome-partitioning-ii/

import java.util.concurrent.atomic.AtomicInteger;

class S132 {
	public static void main (String[] args) {
		String s;

		s = "aab";
		s = "a";
		s = "";
		s = "ab";
		s = "ababababababababababababcbabababababababababababa";

		int res = minCut(s);

		System.out.println(res);
	}

	public static int minCut (String s) {
		if (s.length() == 0) {
			return 0;
		}
		int dp[][] = new int[s.length()][s.length()];
		int cache[][] = new int[s.length()][s.length()];
		AtomicInteger MIN = new AtomicInteger(Integer.MAX_VALUE);

		return find(0, s, dp, cache, 0, MIN) - 1;
	}

	public static int find (int start, String s, int[][] dp, int cache[][], int nums, AtomicInteger MIN) {
		if (start < s.length() && cache[start][s.length() - 1] != 0) {
			return nums + cache[start][s.length() - 1];
		}
		if (start == s.length()) {
			if (nums < MIN.get()) {
				MIN.set(nums);
			}
			return nums;
		}

		int minPallindrome = Integer.MAX_VALUE;
		for (int end = start; end < s.length(); end++) {
			if (s.charAt(start) == s.charAt(end) && (end - start <= 2 || dp[start + 1][end - 1] == 1)) {
				dp[start][end] = 1;
				int pallindromes = find(end + 1, s, dp, cache, nums + 1, MIN) - nums;
				if (pallindromes < minPallindrome) {
					minPallindrome = pallindromes;
				}
			}
		}
		cache[start][s.length() - 1] = minPallindrome;
		return nums + minPallindrome;
	}
}