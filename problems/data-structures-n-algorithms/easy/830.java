// 830. Positions of Large Groups
// https://leetcode.com/problems/positions-of-large-groups/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
	public static void main (String[] args) {
		String s;

		s = "abbxxxxzyy";
		s = "abc";
		s = "abcdddeeeeaabbbcd";
		// s = "aaa";
		s = "aba";

		List<List<Integer>> res = largeGroupPositions(s);

		System.out.println(res);
	}

	// public static List<List<Integer>> largeGroupPositions (String s) {
	// 	List<List<Integer>> res = new ArrayList<>();
	//
	// 	char begin = '\0';
	// 	int beginIndex = 0;
	// 	for (int i = 0; i <= s.length(); i++) {
	// 		if (i == s.length() || (i < s.length() && begin != s.charAt(i))) {
	// 			if (i - 1 - beginIndex >= 2) {
	// 				res.add(new ArrayList<>(Arrays.asList(beginIndex, i - 1)));
	// 			}
	//
	// 			if (i < s.length()) {
	// 				begin = s.charAt(i);
	// 				beginIndex = i;
	// 			}
	// 		}
	// 	}
	// 	return res;
	// }

	public static List<List<Integer>> largeGroupPositions (String s) {
		List<List<Integer>> res = new ArrayList<>();

		int beginIndex = 0;
		for (int i = 0; i < s.length(); i++) {
			if (i == s.length() - 1 || s.charAt(i) != s.charAt(i + 1)) {
				if (i - beginIndex + 1 >= 3) {
					res.add(new ArrayList<>(Arrays.asList(beginIndex, i)));
				}
				beginIndex = i + 1;
			}
		}
		return res;
	}
}