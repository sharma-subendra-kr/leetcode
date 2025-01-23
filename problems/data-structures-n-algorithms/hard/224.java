// 224. Basic Calculator
// https://leetcode.com/problems/basic-calculator/

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

class S224 {
	public static void main (String[] args) {
		String s = "1+1";
		// String s = " 2-1 + 2 ";
		// String s = "(1+(4+5+2)-3)+(6+8)";
		// String s = "2147483647";
		// String s = "1-(     -2)";
		int res = calculate(s);
		System.out.println(res);
	}

	public static int calculate (String s) {
		int len = s.length();
		Stack<Integer> stack = new Stack<>();
		int res = 0;
		int operator = 1;

		int i = 0;
		while (i < len) {
			if (Character.isDigit(s.charAt(i))) {
				int j = i;
				int no = 0;
				while (j < len && Character.isDigit(s.charAt(j))) {
					no = no * 10 + (s.charAt(j) - '0');
					j++;
				}
				no *= operator;
				res += no;
				operator = 1;
				i = j - 1;
			} else if (s.charAt(i) == ' ') {
				i++;
				continue;
			} else if (s.charAt(i) == '(') {
				stack.push(res);
				stack.push(operator);
				res = 0;
				operator = 1;
			} else if (s.charAt(i) == ')') {
				res *= stack.pop();
				res += stack.pop();
			} else {
				operator = 1;
				if (s.charAt(i) == '-') {
					operator = -1;
				}
			}
			i++;
		}

		return res;
	}

	// public static int calculate (String s) {
	// 	int len = s.length();
	// 	Stack<String> stack = new Stack<>();
	// 	Stack<String> temp = new Stack<>();
	// 	HashSet<Character> mp = new HashSet(Arrays.asList('1', '2', '3', '4', '5', '6', '7', '8', '9', '0'));
	//
	// 	int i = 0;
	// 	while (i < len) {
	// 		if (mp.contains(s.charAt(i))) {
	// 			int j = i;
	// 			while (j < len && mp.contains(s.charAt(j))) {
	// 				j++;
	// 			}
	// 			stack.push(s.substring(i, j));
	// 			i = j - 1;
	// 		} else if (s.charAt(i) != ')' && s.charAt(i) != ' ') {
	// 			stack.push("" + s.charAt(i));
	// 		} else if (s.charAt(i) != '(' && s.charAt(i) != ' ') {
	// 			processExp(stack, temp, mp);
	// 		}
	// 		i++;
	// 	}
	// 	return processExp(stack, temp, mp);
	// }
	//
	// public static int processExp (Stack<String> stack, Stack<String> temp, HashSet<Character> mp) {
	// 	temp.empty();
	// 	while (!stack.isEmpty()) {
	// 		String top = stack.pop();
	// 		if (top.equals("(")) {
	// 			break;
	// 		}
	// 		temp.push(top);
	// 	}
	// 	int currSum = 0;
	// 	int operation = 0;
	// 	while (!temp.isEmpty()) {
	// 		String top = temp.pop();
	// 		if (mp.contains(top.charAt(0)) || (top.length() > 1 && mp.contains(top.charAt(1)))) {
	// 			int curr = Integer.parseInt(top);
	// 			if (operation == 1) {
	// 				currSum -= curr;
	// 			} else {
	// 				currSum += curr;
	// 			}
	// 			operation = 0;
	// 		} else if (top.equals("-")) {
	// 			operation = 1;
	// 		} else if (top.equals("+")) {
	// 			operation = 2;
	// 		}
	// 	}
	// 	stack.push(Integer.toString(currSum));
	// 	return currSum;
	// }
}