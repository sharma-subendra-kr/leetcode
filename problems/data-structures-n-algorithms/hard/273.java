// 273. Integer to English Words
// https://leetcode.com/problems/integer-to-english-words/

class S273 {
	static String[] LESS_THAN_20 =
		new String[]{"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven",
		             "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};

	// First Solution
	// public static String getTens (int tens, int ones) {
	// 	switch (tens) {
	// 		case 0:
	// 			return "";
	// 		case 2:
	// 			return "Twenty";
	// 		case 3:
	// 			return "Thirty";
	// 		case 4:
	// 			return "Forty";
	// 		case 5:
	// 			return "Fifty";
	// 		case 6:
	// 			return "Sixty";
	// 		case 7:
	// 			return "Seventy";
	// 		case 8:
	// 			return "Eighty";
	// 		case 9:
	// 			return "Ninety";
	// 	}
	// 	switch (ones) {
	// 		case 0:
	// 			return "Ten";
	// 		case 1:
	// 			return "Eleven";
	// 		case 2:
	// 			return "Twelve";
	// 		case 3:
	// 			return "Thirteen";
	// 		case 4:
	// 			return "Fourteen";
	// 		case 5:
	// 			return "Fifteen";
	// 		case 6:
	// 			return "Sixteen";
	// 		case 7:
	// 			return "Seventeen";
	// 		case 8:
	// 			return "Eighteen";
	// 		case 9:
	// 			return "Nineteen";
	// 	}
	// 	return "";
	// }
	//
	// public static String getNumber (int n) {
	// 	switch (n) {
	// 		case 0:
	// 			return "";
	// 		case 1:
	// 			return "One";
	// 		case 2:
	// 			return "Two";
	// 		case 3:
	// 			return "Three";
	// 		case 4:
	// 			return "Four";
	// 		case 5:
	// 			return "Five";
	// 		case 6:
	// 			return "Six";
	// 		case 7:
	// 			return "Seven";
	// 		case 8:
	// 			return "Eight";
	// 		case 9:
	// 			return "Nine";
	// 	}
	// 	return "";
	// }
	//
	// public static String getName (int count) {
	// 	if (count == 9) {
	// 		return "Billion";
	// 	} else if (count == 6) {
	// 		return "Million";
	// 	} else if (count == 3) {
	// 		return "Thousand";
	// 	}
	// 	return "";
	// }
	//
	// public static String numberToWords (int num) {
	// 	if (num == 0) {
	// 		return "Zero";
	// 	}
	//
	// 	String res = "";
	// 	int count = 0;
	// 	int prev = 0;
	//
	// 	while (num > 0) {
	// 		int n = num % 10;
	// 		num = num / 10;
	// 		int next = num % 10;
	// 		int nextNext = (num / 10) % 10;
	// 		int mod = count % 3;
	//
	// 		String curr = "";
	// 		if (mod == 0 && next != 1) {
	// 			curr = getNumber(n);
	// 		} else if (mod == 1) {
	// 			curr = getTens(n, prev);
	// 		} else if (mod == 2 && n != 0) {
	// 			curr = getNumber(n) + " Hundred";
	// 		}
	//
	// 		if (mod == 0 && (nextNext != 0 || next != 0 || n != 0)) {
	// 			curr += (curr.length() == 0 || count == 0 ? "" : " ") + getName(count);
	// 		}
	//
	// 		res = curr + (curr.length() == 0 || res.length() == 0 ? "" : " ") + res;
	//
	// 		prev = n;
	// 		count++;
	// 	}
	//
	// 	return res;
	// }
	static String[] TENS = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
	static String[] NAMES = {"", "Thousand", "Million", "Billion"};

	public static void main (String[] args) {
		int num;

		num = 123;
		num = 12345;
		num = 1234567;
		num = 1234567891;
		num = 10;
		num = 101;
		num = 1000;
		num = 100009000;
		num = 1000000;
		num = 1000010;

		String res = numberToWords(num);

		System.out.println(res);
	}

	public static String numberToWords (int num) {
		if (num == 0) {
			return "Zero";
		}

		String res = "";

		int count = 0;
		while (num != 0) {
			int mod = num % 1000;
			if (mod != 0) {
				res = process(mod) + NAMES[count] + " " + res;
			}
			num = num / 1000;
			count++;
		}
		return res.trim();
	}

	public static String process (int n) {
		if (n == 0) {
			return "";
		} else if (n < 20) {
			return LESS_THAN_20[n] + " ";
		} else if (n < 100) {
			return TENS[n / 10] + " " + process(n % 10);
		} else if (n < 1000) {
			return LESS_THAN_20[n / 100] + " " + "Hundred " + process(n % 100);
		}
		return "";
	}
}