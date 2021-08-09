// 937. Reorder Data in Log Files
// https://leetcode.com/problems/reorder-data-in-log-files/

import java.util.Arrays;
import java.util.Comparator;

class S937 {

	public static void main (String[] args) {
		String[] arr;
		// arr = new String[]{
		// 	"dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero"
		// };
		arr = new String[]{
			"a1 9 2 3 1", "g1 act car", "zo4 4 7", "ab1 off key dog", "a8 act zoo", "a2 act car"
		};

		String[] res = reorderLogFiles(arr);

		for (String s : res) {
			System.out.println(s);
		}
	}

	public static String[] reorderLogFiles (String[] logs) {
		Arrays.sort(logs, new Compare());
		return logs;
	}

	static class Compare implements Comparator<String> {
		public int compare (String a, String b) {
			if (Character.isDigit(a.charAt(a.length() - 1)) && Character.isAlphabetic(b.charAt(b.length() - 1))) {
				return 1;
			} else if (Character.isAlphabetic(a.charAt(a.length() - 1)) && Character.isDigit(b.charAt(b.length() - 1))) {
				return -1;
			} else if (Character.isDigit(a.charAt(a.length() - 1)) && Character.isDigit(b.charAt(b.length() - 1))) {
				return 0;
			}
			int ia = 0;
			int ib = 0;
			while (ia < a.length() && a.charAt(ia) != ' ') {
				ia++;
			}
			while (ib < b.length() && b.charAt(ib) != ' ') {
				ib++;
			}
			while (ia < a.length() && ib < b.length() && a.charAt(ia) == b.charAt(ib)) {
				ia++;
				ib++;
			}

			if (ia == a.length() && ib < b.length()) {
				return -1;
			} else if (ib == b.length() && ia < a.length()) {
				return 1;
			} else if (ia < a.length() && ib < b.length()) {
				return a.charAt(ia) - b.charAt(ib);
			}

			ia = 0;
			ib = 0;
			while (a.charAt(ia) != ' ' && b.charAt(ib) != ' ' && a.charAt(ia) == b.charAt(ib)) {
				ia++;
				ib++;
			}
			return a.charAt(ia) - b.charAt(ib);
		}
	}
}
