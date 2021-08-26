// 1165. Single-Row Keyboard
// https://leetcode.com/problems/single-row-keyboard/

import java.util.HashMap;

class S1165 {
	public static void main (String args[]) {
		String keyboard;
		String word;

		keyboard = "abcdefghijklmnopqrstuvwxyz";
		word = "cba";

		int res = calculateTime(keyboard, word);

		System.out.println(res);
	}

	public static int calculateTime (String keyboard, String word) {
		Integer[] index = new Integer[26];
		int sum = 0;
		int pos = 0;

		for (int i = 0; i < keyboard.length(); i++) {
			index[keyboard.charAt(i) - 'a'] = i;
		}

		for (int i = 0; i < word.length(); i++) {
			int charPos = index[word.charAt(i) - 'a'];
			sum += Math.abs(pos - charPos);
			pos = charPos;
		}

		return sum;
	}
}