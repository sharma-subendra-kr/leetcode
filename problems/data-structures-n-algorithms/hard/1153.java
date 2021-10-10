// 1153. String Transforms Into Another String
// https://leetcode.com/problems/string-transforms-into-another-string/

import java.net.Inet4Address;
import java.util.Arrays;
import java.util.HashSet;

class S1153 {

	public static void main (String[] args) {
		String str1, str2;

		str1 = "aabcc";
		str2 = "ccdee";
		str1 = "leetcode";
		str2 = "codeleet";
		str1 = "aa";
		str2 = "ab";
		str1 = "abcdefghijklmnopqrstuvwxyz";
		str2 = "bcdefghijklmnopqrstuvwxyza";
		str1 = "ab";
		str2 = "ba";
		str1 = "abcdefghijklmnopqrstuvwxyz";
		str2 = "bcadefghijklmnopqrstuvwxzz";
		str1 = "abcdefghijklmnopqrstuvwxyz";
		str2 = "bcdefghijklmnopqrstuvwxyzq";

		boolean res = canConvert(str1, str2);
		System.out.println(res);
	}

	public static boolean canConvert (String str1, String str2) {
		if (str1.length() != str2.length()) {
			return false;
		}
		int[] map = new int[26];
		Arrays.fill(map, -1);
		HashSet<Integer> valuesCount = new HashSet<>();

		for (int i = 0; i < str1.length(); i++) {
			int c1 = str1.charAt(i) - 'a';
			int c2 = str2.charAt(i) - 'a';
			if (map[c1] == -1) {
				map[c1] = c2;
				valuesCount.add(c2);
				if (c1 != c2 && valuesCount.size() == 26) {
					// here we are trying to break the cycle and make changes and again recreate the cycle
					return false;
				}
			} else if (map[c1] != c2) {
				return false;
			}
		}
		return true;
	}

	// Not needed
	static boolean hasCycle (int[] map, int a, int b) {
		int slow = a;
		int fast = b;

		while (slow != -1 && fast != -1) {
			slow = map[slow];
			fast = map[fast];
			if (fast != -1) {
				fast = map[fast];
			}
			if (slow == fast && a != -1 && b != -1) {
				return true;
			}
		}
		return false;
	}
}