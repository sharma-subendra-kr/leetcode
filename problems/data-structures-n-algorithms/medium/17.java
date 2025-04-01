// 17. Letter Combinations of a Phone Number
// https://leetcode.com/problems/letter-combinations-of-a-phone-number/

import java.util.ArrayList;
import java.util.List;

class S17 {
	public static void main (String args[]) {
		String digits = "23";
		List<String> res = letterCombinations(digits);
		System.out.println(res);
	}

	public static List<String> letterCombinations (String digits) {
		String[] map = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
		int[] lens = new int[]{0, 0, 3, 3, 3, 3, 3, 4, 3, 4};
		List<String> res = new ArrayList<>();
		if (digits.equals("")) {
			return res;
		}
		recursion(digits, 0, map, lens, new StringBuffer(), res);
		return res;
	}

	public static void recursion (String digits, int idx, String[] map, int[] lens, StringBuffer curr, List<String> res) {
		if (idx == digits.length()) {
			res.add(curr.toString());
			return;
		}
		int num = digits.charAt(idx) - '0';
		int len = lens[num];

		for (int i = 0; i < len; i++) {
			curr.append(map[num].charAt(i));
			recursion(digits, idx + 1, map, lens, curr, res);
			curr.deleteCharAt(idx);
		}
	}
}