// 50. Pow(x, n)
// https://leetcode.com/problems/powx-n/

class S50 {
	public static void main (String[] args) {
		// double x = 2;
		// int n = -2147483648;
		// double x = 2;
		// int n = 10;
		// double x = 2.1;
		// int n = 3;
		// double x = 2;
		// int n = -2;
		double x = 0.44528;
		int n = 0;
		double res = myPow(x, n);
		System.out.println(res);
	}

	public static double myPow (double x, int n) {
		if (n == 1) {
			return x;
		} else if (n == -1) {
			return 1 / x;
		} else if (n == 0) {
			return 1;
		} else if (n == 2) {
			return x * x;
		} else if (n == -2) {
			return 1 / x * 1 / x;
		}

		if (n % 2 == 1) {
			return x * myPow(x, n - 1);
		} else if (n % 2 == -1) {
			return 1 / x * myPow(x, n + 1);
		} else {
			return myPow(myPow(x, n / 2), 2);
		}
	}
}