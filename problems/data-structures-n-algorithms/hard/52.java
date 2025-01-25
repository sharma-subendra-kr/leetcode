// 52. N-Queens II
// https://leetcode.com/problems/n-queens-ii/

class S52 {
	public static void main (String[] args) {
		int n = 5;
		int res = totalNQueens(n);
		System.out.println(res);
	}

	public static int totalNQueens (int n) {
		int[] map = new int[n];
		int[] leftMap = new int[n * 2 + 1];
		int[] rightMap = new int[n * 2 + 1];
		int[] res = new int[1];
		res[0] = 0;
		if (n == 1) {
			return 1;
		}
		recursion(n, map, leftMap, rightMap, 0, res);
		return res[0];
	}

	public static void recursion (int n, int[] map, int[] leftMap, int[] rightMap, int i, int[] res) {
		if (i == n) {
			res[0]++;
			return;
		}
		int left = 0;
		int right = 0;
		for (int j = 0; j < n; j++) {
			left = n - i + j;
			right = i + j;
			if (map[j] == 0 && leftMap[left] == 0 && rightMap[right] == 0) {
				map[j] = 1;
				leftMap[left] = 1;
				rightMap[right] = 1;
				recursion(n, map, leftMap, rightMap, i + 1, res);
				map[j] = 0;
				leftMap[left] = 0;
				rightMap[right] = 0;
			}
		}
	}
}