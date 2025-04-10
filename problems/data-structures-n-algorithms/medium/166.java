// 166. Fraction to Recurring Decimal
// https://leetcode.com/problems/fraction-to-recurring-decimal/

import java.util.HashMap;
import java.util.HashSet;

class S166 {
	public static void main (String[] args) {
		// int numerator = 1;
		// int denominator = 2;
		// int numerator = 2;
		// int denominator = 1;
		// int numerator = 4;
		// int denominator = 333;
		// int numerator = 22;
		// int denominator = 7;
		// int numerator = 1;
		// int denominator = 6;
		// int numerator = -50;
		// int denominator = 8;
		// int numerator = 1;
		// int denominator = -1;
		// int numerator = -1;
		// int denominator = -2147483648;
		// int numerator = 103937;
		// int denominator = 333000;
		// int numerator = 0;
		// int denominator = 3;
		int numerator = 0;
		int denominator = -5;

		String res = fractionToDecimal(numerator, denominator);
		System.out.println(res);
	}

	public static String fractionToDecimal (int numerator, int denominator) {
		boolean neg = numerator > 0 ^ denominator > 0;

		long num = Math.abs((long) numerator);
		long den = Math.abs((long) denominator);
		StringBuilder sb = new StringBuilder();
		if (num >= den) {
			sb.append(num / den);
			num = num % den;
		} else {
			sb.append('0');
		}

		if (num > 0) {
			sb.append('.');
		}

		HashMap<Long, Integer> map = new HashMap<>();
		long rem = num * 10;
		while (rem != 0) {
			if (map.containsKey(rem)) {
				sb.insert((int) map.get(rem), '(');
				sb.append(')');
				break;
			}

			map.put(rem, sb.length());
			long q = rem / den;
			sb.append(q);
			rem = rem % den * 10;
		}

		if (neg && numerator != 0) {
			sb.insert(0, '-');
		}

		return sb.toString();
	}
}