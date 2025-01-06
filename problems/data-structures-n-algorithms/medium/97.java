// 97. Interleaving String
// https://leetcode.com/problems/interleaving-string/description/

import java.util.Arrays;

class S97 {
	public static void main(String[] args) {
		String s1 = "aabcc";
		String s2 = "dbbca";
		String s3 = "aadbbcbcac";
//		String s1 = "aabcc";
//		String s2 = "dbbca";
//		String s3 = "aadbbbaccc";
//		String s1 = "";
//		String s2 = "";
//		String s3 = "";
//		String s1 = "";
//		String s2 = "";
//		String s3 = "a";
//		String s1 = "a";
//		String s2 = "";
//		String s3 = "c";
//		String s1 = "a";
//		String s2 = "b";
//		String s3 = "a";
//		String s1 = "a";
//		String s2 = "b";
//		String s3 = "ab";
//		String s1 = "a";
//		String s2 = "";
//		String s3 = "a";
		boolean res = isInterleave(s1, s2, s3);
		System.out.println(res);
	}

	public static boolean isInterleave(String s1, String s2, String s3) {
		int s1Len = s1.length();
		int s2Len = s2.length();
		int s3Len = s3.length();

		if (s3Len != s1Len + s2Len) {
			return false;
		}

		boolean[][] dp = new boolean[s1Len + 1][s2Len + 1];
		for (int i = 0; i < s1Len + 1; i++) {
			Arrays.fill(dp[i], false);
		}
		dp[0][0] = true;

		for (int i = 1; i < s2Len + 1 && i <= s3Len; i++) {
			if (s2.charAt(i - 1) == s3.charAt(i - 1)) {
				dp[0][i] = true;
			} else {
				break;
			}
		}

		for (int i = 1; i < s1Len + 1 && i <= s3Len; i++) {
			if (s1.charAt(i - 1) == s3.charAt(i - 1)) {
				dp[i][0] = true;
			} else {
				break;
			}
		}

		int idx = 0;
		for (int i = 1; i <= s1Len; i++) {
			for (int j = 1; j <= s2Len; j++) {
				idx = i + j - 1;
				if (((s2.charAt(j - 1) == s3.charAt(idx) && dp[i][j - 1]) || (s1.charAt(i - 1) == s3.charAt(idx) && dp[i - 1][j]))) {
					dp[i][j] = true;
				}
			}
		}

		return dp[s1Len][s2Len];
	}
}

//		if ((s1Len == 0 && s2.equals(s3)) || (s2Len == 0 && s1.equals(s3))) {
//			return true;
//		} else if (s1Len + s2Len != s3Len) {
//			return false;
//		}
//
//		if (s2.length() > 0 && s2.charAt(0) == s3.charAt(0)) {
//			String temp = s1;
//			s1 = s2;
//			s2 = temp;
//
//			int tempLen = s1Len;
//			s1Len = s2Len;
//			s2Len = s1Len;
//		}