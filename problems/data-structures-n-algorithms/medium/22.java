// 22. Generate Parentheses
// https://leetcode.com/problems/generate-parentheses/

import java.util.ArrayList;
import java.util.List;

class S22 {
	public static void main (String args[]) {
		int n = 3;
		List<String> res = generateParenthesis(n);
		System.out.println(res);
	}

	public static List<String> generateParenthesis (int n) {
		List<String> res = new ArrayList<>();
		recursion(0, 0, 0, n, new StringBuilder(), res);
		return res;
	}

	public static void recursion (int begin, int end, int idx, int n, StringBuilder sb, List<String> res) {
		if (idx == n * 2) {
			res.add(sb.toString());
			return;
		}
		if (begin < n) {
			sb.append('(');
			recursion(begin + 1, end, idx + 1, n, sb, res);
			sb.deleteCharAt(idx);
		}
		if (begin > end) {
			sb.append(')');
			recursion(begin, end + 1, idx + 1, n, sb, res);
			sb.deleteCharAt(idx);
		}
	}
}