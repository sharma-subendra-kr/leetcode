// 709. To Lower Case
// https://leetcode.com/problems/to-lower-case/

import java.util.Arrays;

class S709 {
	public static void main (String[] args) {
		String s;

		s = "Hello";

		String res = toLowerCase(s);

		System.out.println(res);

	}

	public static String toLowerCase (String s) {
		Character[] arr = new Character[s.length()];
		StringBuilder stringBuilder = new StringBuilder();

		for (int i = 0; i < s.length(); i++) {
			stringBuilder.append((char) getAasciValue(s.charAt(i)));
		}

		return stringBuilder.toString();
	}

	static int getAasciValue (char c) {
		if (c - 'a' <= -7 && c - 'a' >= -32) {
			return (int) c + 32;
		}
		return (int) c;
	}
}