// 6. Zigzag Conversion
// https://leetcode.com/problems/zigzag-conversion/

import java.util.Arrays;

class S6 {
	public static void main (String[] args) {
		// String s = "PAYPALISHIRING"; // PAHNAPLSIIGYIR
		// int numRows = 3;
		// String s = "PAYPALISHIRING"; // PINALSIGYAHRPI
		// int numRows = 4;
		// String s = "A"; // A
		// int numRows = 1;
		// String s = "PAYPALISHIRING"; // PYAIHRNAPLSIIG
		// int numRows = 2;
		// String s = "ABCD"; // ABDC
		// int numRows = 3;
		String s = "PAYPALISHIRING"; //PHASIYIRPLIGAN
		int numRows = 5;
		String res = convert(s, numRows);
		System.out.println(s);
		System.out.println(res);
	}

	public static String convert (String s, int numRows) {
		StringBuffer res = new StringBuffer();
		int len = s.length();

		if (numRows == 1) {
			return s;
		}

		int sectionNums = numRows + (numRows - 2);
		int sectionColumns = len / sectionNums + (len % sectionNums > 0 ? 1 : 0);
		int columns = sectionColumns + (sectionColumns * (numRows - 2));
		char arr[][] = new char[numRows][columns];

		for (int i = 0; i < numRows; i++) {
			Arrays.fill(arr[i], '-');
		}

		int idx = 0;
		for (int j = 0; j < columns; j++) {
			if (j == 0 || (j) % (numRows - 1) == 0) {
				for (int i = 0; i < numRows && idx < len; i++) {
					arr[i][j] = s.charAt(idx++);
				}
			} else if (idx < len) {
				int i = (numRows - 1) - j % (numRows - 1);
				arr[i][j] = s.charAt(idx++);
			}
		}

		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < columns; j++) {
				if (arr[i][j] != '-') {
					res.append(arr[i][j]);
				}
			}
		}
		return res.toString();
	}

	// doesnt work
	// public static String convert (String s, int numRows) {
	// 	StringBuffer res = new StringBuffer();
	// 	int len = s.length();
	// 	res.setLength(len);
	//
	// 	int sectionNums = numRows + (numRows - 2);
	// 	int columns = len / sectionNums + (len % sectionNums > 0 ? 1 : 0);
	// 	int start = 0;
	// 	int i = 0;
	// 	while (start < sectionNums) {
	// 		int idx = 0;
	// 		int count = 0;
	// 		while (count <= start) {
	// 			if (count == 1) {
	// 				idx += columns;
	// 			} else if (count != 0 && count <= numRows - 1) {
	// 				idx += (columns * 2 - 1);
	// 			} else if (count >= numRows) {
	// 				idx -= (columns * 2 - 1);
	// 			}
	// 			count++;
	// 		}
	// 		if (start >= numRows) {
	// 			idx++;
	// 		}
	// 		i = start;
	// 		while (i < len && idx < len) {
	// 			res.setCharAt(idx, s.charAt(i));
	//
	// 			i += sectionNums;
	// 			idx += (start == 0 || start == numRows - 1) ? 1 : 2;
	// 		}
	// 		start++;
	// 	}
	//
	// 	return res.toString();
	// }
}