// 809. Expressive Words
// https://leetcode.com/problems/expressive-words/

class S809 {

	public static void main (String[] args) {
		String s;
		String[] words;

		s = "heeellooo";
		words = new String[]{"hello", "hi", "helo"};
		// s = "zzzzzyyyyy";
		// words = new String[]{"zzyy", "zy", "zyy"};

		int res = expressiveWords(s, words);

		System.out.println(res);
	}

	public static int expressiveWords (String s, String[] words) {
		int res = 0;
		for (int k = 0; k < words.length; k++) {
			String word = words[k];
			int i, j = i = 0;
			boolean isSame = false;
			while (i < s.length() && j < word.length()) {
				if (s.charAt(i) != word.charAt(j)) {
					isSame = false;
					break;
				}
				int ie = i;
				while (ie < s.length() && s.charAt(i) == s.charAt(ie)) {
					ie++;
				}
				int je = j;
				while (je < word.length() && word.charAt(j) == word.charAt(je)) {
					je++;
				}

				int sLen = ie - i;
				int wLen = je - j;
				int diff = sLen - wLen;
				if (diff > 0 && wLen + diff >= 3) {
					isSame = true;
				} else if (sLen != wLen) {
					isSame = false;
					break;
				}

				i = ie;
				j = je;
			}

			if (i < s.length() || j < word.length()) {
				isSame = false;
			}

			if (isSame) {
				res++;
			}
		}

		return res;
	}

	// public static int expressiveWords (String s, String[] words) {
	// 	Node sList = getList(s);
	//
	// 	for (int i = 0; i < words.length; i++) {
	// 		Node wlist = getList(words[i]);
	// 		Node sPtr = sList;
	// 		Node wPtr = wlist;
	// 		while (sPtr != null && wPtr != null) {
	// 			if (sPtr.c != wPtr.c) {
	// 				break;
	// 			}
	//
	// 		}
	// 		if (sPtr != null || wPtr != null) {
	// 			break;
	// 		}
	// 	}
	// }
	//
	// public static Node getList (String word) {
	// 	Node HEAD = null;
	// 	Node curr, prev = null;
	// 	for (int i = 0; i < word.length(); i++) {
	// 		if (i == 0 || word.charAt(i) != word.charAt(i - 1)) {
	// 			curr = new Node(i, word.charAt(i));
	// 			if (HEAD == null) {
	// 				HEAD = curr;
	// 				prev = HEAD;
	// 			} else {
	// 				prev.end = i - 1;
	// 				prev.next = curr;
	// 				curr = curr.next;
	// 			}
	// 		}
	// 	}
	// 	prev.end = word.length() - 1;
	// 	return HEAD;
	// }
	//
	// static class Node {
	// 	char c;
	// 	int start;
	// 	int end;
	// 	Node next;
	//
	// 	Node (int start, char c) {
	// 		this.start = start;
	// 		this.c = c;
	// 		// this.end = end;
	// 		// this.next = next;
	// 	}
	// }
}