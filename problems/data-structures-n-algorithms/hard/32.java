// 32. Longest Valid Parentheses
// https://leetcode.com/problems/longest-valid-parentheses/

import java.util.Stack;

class S32 {
	public static void main (String[] args) {
		String s;

		s = "(()";
		// s = ")()())";
		// s = "";
		// s = "()(()";
		// s = "(()(((()";
		s = "()(())";
		s = ")(((((()())()()))()(()))(";
		s = "(()()(())((";

		int res = longestValidParentheses(s);

		System.out.println(res);
	}

	public static int longestValidParentheses (String s) {
		int i = 0;
		Stack<Integer> builder = new Stack<>();
		Stack<Item> stack = new Stack<>();

		while (i < s.length()) {
			if (s.charAt(i) == '(') {
				builder.push(i);
			} else if (builder.size() > 0) {
				int j = i;
				int start = -1;
				while (!builder.isEmpty() && j < s.length() && s.charAt(j) != '(') {
					start = builder.pop();
					j++;
				}
				if (start != -1) {
					Item item = new Item(start, j - 1);
					while (!stack.isEmpty() && isInside(stack.peek(), item)) {
						stack.pop();
					}
					stack.push(item);
				}
				i = j;
				continue;
			}
			i++;
		}

		int MAX = 0;
		Item prev = null;
		while (!stack.isEmpty()) {
			Item item = stack.pop();
			int len = item.end - item.start + 1;
			if (prev != null) {
				if (prev.start == item.end + 1) {
					len = prev.end - item.start + 1;
					item.end = prev.end;
				}
			}
			prev = item;
			MAX = Math.max(MAX, len);
		}

		return MAX;
	}

	static boolean isInside (Item a, Item b) {
		if (a.start > b.start && a.end < b.end) {
			return true;
		}
		return false;
	}

	static class Item {
		int start;
		int end;

		Item (int start, int end) {
			this.start = start;
			this.end = end;
		}

		int getStart () {
			return start;
		}

		void setStart (int start) {
			this.start = start;
		}

		int getEnd () {
			return end;
		}

		void setEnd (int end) {
			this.end = end;
		}
	}
}