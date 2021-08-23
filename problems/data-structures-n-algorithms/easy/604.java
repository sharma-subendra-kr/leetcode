// 604. Design Compressed String Iterator
// https://leetcode.com/problems/design-compressed-string-iterator/

class StringIterator {
	String str;
	int counter;
	int charIndex;

	public StringIterator (String compressedString) {
		str = compressedString;
		counter = 0;
		charIndex = 0;
	}

	public char next () {
		if (this.charIndex == this.str.length()) {
			return ' ';
		}

		int start = charIndex + 1;
		int end = charIndex + 1;
		while (end < str.length() && Character.isDigit(str.charAt(end))) {
			end++;
		}
		int num = Integer.parseInt(str.substring(start, end));

		char res = ' ';
		if (counter < num) {
			res = str.charAt(charIndex);
			counter++;
			if (counter == num) {
				counter = 0;
				charIndex = end;
			}
		}
		return res;
	}

	public boolean hasNext () {
		if (charIndex == str.length()) {
			return false;
		}
		return true;
	}
}