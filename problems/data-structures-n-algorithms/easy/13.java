// https://leetcode.com/problems/roman-to-integer/
// 13. Roman to Integer

class S13 {
	public static void main (String args[]) {
		String s = "IV";
		int res = romanToInt(s);
		System.out.println(res);
	}

	public static int romanToInt (String s) {
		int len = s.length();
		int sum = 0;
		for (int i = 0; i < len; i++) {
			if (i != len - 1 && getValue(s.charAt(i + 1)) > getValue(s.charAt(i))) {
				sum -= getValue(s.charAt(i));
				continue;
			}
			sum += getValue(s.charAt(i));
		}
		return sum;
	}

	public static int getValue (char c) {
		if (c == 'I') {
			return 1;
		} else if (c == 'V') {
			return 5;
		} else if (c == 'X') {
			return 10;
		} else if (c == 'L') {
			return 50;
		} else if (c == 'C') {
			return 100;
		} else if (c == 'D') {
			return 500;
		} else if (c == 'M') {
			return 1000;
		}
		return 0;
	}
}