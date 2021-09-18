// 68. Text Justification
// https://leetcode.com/problems/text-justification/

import java.util.ArrayList;
import java.util.List;

class S68 {
	public static void main (String[] args) {
		String[] words;
		int maxWidth;

		words = new String[]{"This", "is", "an", "example", "of", "text", "justification."};
		maxWidth = 16;
		words = new String[]{"What", "must", "be", "acknowledgment", "shall", "be"};
		maxWidth = 16;
		// words = new String[]{"Science", "is", "what", "we", "understand", "well", "enough", "to", "explain", "to", "a",
		//                      "computer.", "Art", "is", "everything", "else", "we", "do"};
		// maxWidth = 20;
		// words = new String[]{"What", "must", "be", "acknowledgment", "shall", "be"};
		// maxWidth = 16;

		List<String> res = fullJustify(words, maxWidth);

		for (String str : res) {
			System.out.println(str);
		}
	}

	public static List<String> fullJustify (String[] words, int maxWidth) {
		ArrayList<String> just = new ArrayList<>();

		for (int i = 0; i < words.length; ) {
			int start = i;
			int len = 0;
			int end = 0;
			while (len < maxWidth && i < words.length) {
				if (words[i].length() + len <= maxWidth) {
					len += words[i].length();
					len++; // for space
					end = i;
					i++;
					continue;
				}
				break;
			}
			int spaces = (maxWidth - (len - 1)) + (end - start);
			int s = spaces;
			if (end - start > 0) {
				s = spaces / (end - start);
			}
			if (end == words.length - 1) {
				s = 1;
			}
			int extra = spaces - s * (end - start);

			int curr = start;
			String str = "";
			int length = 0;
			while (curr <= end) {
				int sp = s;
				if (curr != end && extra > 0 && end != words.length - 1) {
					sp += 1;
					extra--;
				} else if (curr == end) {
					sp = length + words[curr].length() < maxWidth ? maxWidth - (length + words[curr].length()) : 0;
				}
				String temp = (words[curr] + new String(new char[sp]).replace('\0', ' '));
				str += temp;
				length += temp.length();
				curr++;
			}
			just.add(str);
		}
		return just;
	}
}