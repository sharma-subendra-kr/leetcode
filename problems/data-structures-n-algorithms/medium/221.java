// 221. Maximal Square
// https://leetcode.com/problems/maximal-square/description/

import java.util.Arrays;

class S221 {
	public static void main(String[] args) {
		char[][] matrix = new char[][]{{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
//		char[][] matrix = new char[][]{{'0', '1'}, {'1', '0'}};
//		char[][] matrix = new char[][]{{'1', '1', '1', '1', '0'}, {'1', '1', '1', '1', '0'}, {'1', '1', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'0', '0', '1', '1', '1'}};
//		char[][] matrix = new char[][]{{'0', '0', '0', '1'}, {'1', '1', '0', '1'}, {'1', '1', '1', '1'}, {'0', '1', '1', '1'}, {'0', '1', '1', '1'}};
//		char[][] matrix = new char[][]{{'1', '1', '1', '0', '0'}, {'1', '1', '1', '0', '0'}, {'1', '1', '1', '1', '1'}, {'0', '1', '1', '1', '1'}, {'0', '1', '1', '1', '1'}, {'0', '1', '1', '1', '1'}};
		int res = maximalSquare(matrix);
		System.out.println(res);
	}

	public static int maximalSquare(char[][] matrix) {
		int rows = matrix.length;
		int cols = matrix[0].length;
		int[][] dp = new int[rows][cols];
		int res = 0;

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				dp[i][j] = 0;
				if (matrix[i][j] == '1') {
					dp[i][j] = 1;
					res = 1;
				}
			}
		}

		for (int i = 1; i < rows; i++) {
			for (int j = 1; j < cols; j++) {
				int tl = dp[i - 1][j - 1];
				int tr = dp[i - 1][j];
				int bl = dp[i][j - 1];
				int br = dp[i][j];
				if (tl > 0 && tr > 0 && bl > 0 && br > 0) {
					if (tl == tr && tl == bl) {
						dp[i][j] = tl + 1;
					} else {
						int m1 = Math.min(dp[i - 1][j - 1], dp[i - 1][j]);
						int m2 = Math.min(m1, dp[i][j - 1]);
						dp[i][j] = m2 + 1;
					}
					if (dp[i][j] > res) {
						res = dp[i][j];
					}
				}
			}
		}
		return res * res;
	}
}