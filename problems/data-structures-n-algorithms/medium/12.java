// 12. Integer to Roman
// https://leetcode.com/problems/integer-to-roman/

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class S12 {
	public static void main (String[] args) {
		// int num = 3749;
		// int num = 58;
		int num = 1994;
		String res = intToRoman(num);
		System.out.println(res);
	}

	public static String intToRoman (int num) {
		String[] a1000s = new String[]{"", "M", "MM", "MMM"};
		String[] a100s = new String[]{"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
		String[] a10s = new String[]{"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
		String[] a1s = new String[]{"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

		return a1000s[num / 1000] + a100s[num / 100 % 10] + a10s[num / 10 % 10] + a1s[num % 10];
	}

	// public static String intToRoman (int num) {
	// 	Stack<StringBuffer> res = new Stack();
	// 	int place = 1;
	// 	int rem;
	// 	Map<Integer, String> m1s =
	// 		Map.ofEntries(Map.entry(1, "I"), Map.entry(4, "IV"), Map.entry(5, "V"), Map.entry(9, "IX"));
	// 	Map<Integer, String> m10s =
	// 		Map.ofEntries(Map.entry(1, "X"), Map.entry(4, "XL"), Map.entry(5, "L"), Map.entry(9, "XC"));
	// 	Map<Integer, String> m100s =
	// 		Map.ofEntries(Map.entry(1, "C"), Map.entry(4, "CD"), Map.entry(5, "D"), Map.entry(9, "CM"));
	// 	Map<Integer, String> m1000s = Map.ofEntries(Map.entry(1, "M"));
	// 	Map<Integer, String> current = null;
	// 	while (num > 0) {
	// 		rem = num % 10;
	// 		if (place == 1) {
	// 			current = m1s;
	// 		} else if (place == 10) {
	// 			current = m10s;
	// 		} else if (place == 100) {
	// 			current = m100s;
	// 		} else if (place == 1000) {
	// 			current = m1000s;
	// 		}
	//
	// 		StringBuffer s = new StringBuffer();
	// 		if (rem < 4) {
	// 			StringBuffer temp = new StringBuffer();
	// 			for (int i = 0; i < rem; i++) {
	// 				temp.append(current.get(1));
	// 			}
	// 			s.append(temp);
	// 		} else if (rem < 5) {
	// 			s.append(current.get(4));
	// 		} else if (rem == 5) {
	// 			s.append(current.get(5));
	// 		} else if (rem <= 8) {
	// 			StringBuffer temp = new StringBuffer();
	// 			temp.append(current.get(5));
	// 			for (int i = 0; i < rem - 5; i++) {
	// 				temp.append(current.get(1));
	// 			}
	// 			s.append(temp);
	// 		} else if (rem == 9) {
	// 			s.append(current.get(9));
	// 		}
	//
	// 		res.push(s);
	//
	// 		place *= 10;
	// 		num /= 10;
	// 	}
	//
	// 	Collections.reverse(res);
	// 	return String.join("", res);
	// }
}