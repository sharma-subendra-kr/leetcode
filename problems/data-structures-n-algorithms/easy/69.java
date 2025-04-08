// 69. Sqrt(x)
// https://leetcode.com/problems/sqrtx/

class S69 {
	public static void main (String[] args) {
		int x = 2147395599;
		int res = mySqrt(x);
		System.out.println(res);
	}

	public static int mySqrt (int x) {
		int low = 0;
		int high = x;
		int mid;
		while (low < high) {
			mid = (low + high) / 2 + 1;
			if ((long) mid * mid > (long) x) {
				high = mid - 1;
			} else {
				low = mid;
			}
		}
		return low;
	}

	// Very show solution
	// public static int mySqrt (int x) {
	// 	return recursion(x, 1);
	// }
	//
	// public static int recursion (int x, int sub) {
	// 	if (x - sub == 0) {
	// 		return 1;
	// 	} else if (x - sub < 0) {
	// 		return 0;
	// 	}
	// 	return recursion(x - sub, sub + 2) + 1;
	// }
}