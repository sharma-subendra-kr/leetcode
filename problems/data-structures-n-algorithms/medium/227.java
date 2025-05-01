// 227. Basic Calculator II
// https://leetcode.com/problems/basic-calculator-ii/description/

import java.util.Collections;
import java.util.HashMap;
import java.util.Stack;

class S227 {
	public static void main (String[] args) {
		// String s = "3+2*2";
		// String s = " 3/2 ";
		String s = " 3+5 / 2 ";
		int res = calculate(s);
		System.out.println(res);
	}

	public static int calculate (String s) {
		Stack<Integer> stack = new Stack<>();
		int num = 0;
		int len = s.length();
		char op = '+';
		for (int i = 0; i < len; i++) {
			if (Character.isDigit(s.charAt(i))) {
				num = num * 10 + (s.charAt(i) - '0');
			}
			if (!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i == len - 1) {
				if (op == '+') {
					stack.push(num);
				} else if (op == '-') {
					stack.push(-num);
				} else if (op == '*') {
					stack.push(stack.pop() * num);
				} else {
					stack.push(stack.pop() / num);
				}
				num = 0;
				op = s.charAt(i);
			}
		}

		int res = 0;
		while (!stack.isEmpty()) {
			res += stack.pop();
		}
		return res;
	}
}