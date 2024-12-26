// 201. Bitwise AND of Numbers Range
// https://leetcode.com/problems/bitwise-and-of-numbers-range/

class S201 {
	public static void main (String[] args) {
		// int left = 5;
		// int right = 7;
		// int left = 0;
		// int right = 0;
		int left = 1;
		int right = 2147483647;
		// int left = 1;
		// int right = 2;

		int res = rangeBitwiseAnd(left, right);
		System.out.println(res);
	}

	public static int rangeBitwiseAnd (int left, int right) {
		int cleft = left;
		int cright = right;
		int count = 0;
		while (cleft != cright) {
			cleft = cleft >> 1;
			cright = cright >> 1;
			count++;
		}
		right = right >> count;
		right = right << count;

		return right;
	}
}