// 151. Reverse Words in a String
// https://leetcode.com/problems/reverse-words-in-a-string/

class S151 {
	public static void main (String[] args) {
		// String s = "the sky is blue";
		String s = "  hello world  ";
		// String s = "a good   example";
		String r = reverseWords(s);
		System.out.println(r);
	}

	public static String reverseWords (String s) {
		int len = s.length();
		StringBuffer rev = new StringBuffer();
		// rev.setLength(len);

		int i = len - 1;
		int j;
		int shortLen = 0;
		boolean first = true;
		boolean space = false;
		while (s.charAt(i) == ' ') i--;
		while (i >= 0) {
			space = false;
			while (i >= 0 && s.charAt(i) == ' ') {
				i--;
				space = true;
			}
			if (i >= 0 && space && !first) {
				rev.append(' ');
				shortLen++;
			}
			if (i >= 0) {
				rev.append(s.charAt(i));
				shortLen++;
			}
			first = false;
			i--;
		}

		int next;
		i = j = 0;
		while (i < shortLen) {
			if (rev.charAt(i) == ' ') {
				i++;
				continue;
			}
			j = i;
			while (j < shortLen && rev.charAt(j) != ' ') {
				j++;
			}
			next = j;
			j--;
			while (i < j) {
				char temp = rev.charAt(i);
				rev.setCharAt(i, rev.charAt(j));
				rev.setCharAt(j, temp);
				i++;
				j--;
			}
			i = next;
		}
		return rev.toString();
	}
}