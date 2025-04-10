// 172. Factorial Trailing Zeroes
// https://leetcode.com/problems/factorial-trailing-zeroes/

class S172 {
	public static void main (String[] args) {
		int n = 20;
		int res = trailingZeroes(n);
		System.out.println(res);
	}

	public static int trailingZeroes (int n) {
		int res = 0;
		int d = 5;
		while (d <= n) {
			res += n / d;
			d *= 5;
		}
		return res;
	}
}