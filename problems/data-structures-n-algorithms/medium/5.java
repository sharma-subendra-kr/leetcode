// 5. Longest Palindromic Substring
// https://leetcode.com/problems/longest-palindromic-substring/

class S5 {
	public static void main (String args[]) {
		// String s = "babad";
		String s = "cbbd";
		String res = longestPalindrome(s);
		System.out.println(res);
	}

	public static String longestPalindrome (String s) {
		int len = s.length();
		int longest = 0;
		int start = 0;
		int end = 0;
		if (len == 0) {
			return s;
		}
		for (int i = 0; i < len; i++) {
			int right = i + 1;
			while (right < len && s.charAt(i) == s.charAt(right)) {
				right++;
			}
			int left = i - 1;
			while (left >= 0 && right < len && s.charAt(left) == s.charAt(right)) {
				left--;
				right++;
			}
			left++;
			right--;
			if (right - left + 1 > longest) {
				longest = right - left + 1;
				start = left;
				end = right;
			}
		}
		return s.substring(start, end + 1);
	}
}