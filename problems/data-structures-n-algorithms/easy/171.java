// 171. Excel Sheet Column Number
// https://leetcode.com/problems/excel-sheet-column-number/

class S171 {
	public static void main (String[] args) {
		String columnTitle = "ABA";
		int res = titleToNumber(columnTitle);
		System.out.println(res);
	}

	public static int titleToNumber (String columnTitle) {
		int len = columnTitle.length();
		int res = 0;
		for (int i = len - 1; i >= 0; i--) {
			res = res + (((columnTitle.charAt(i) - 'A') + 1) * (int) Math.pow(26, len - 1 - i));
		}
		return res;
	}
}