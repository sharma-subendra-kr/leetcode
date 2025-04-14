// 54. Spiral Matrix
// https://leetcode.com/problems/spiral-matrix/

import java.util.ArrayList;
import java.util.List;

class S54 {
	public static void main (String[] args) {
		// int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		int[][] matrix = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
		List<Integer> res = spiralOrder(matrix);
		System.out.println(res);
	}

	public static List<Integer> spiralOrder (int[][] matrix) {
		int rows = matrix.length;
		int cols = matrix[0].length;
		List<Integer> res = new ArrayList<>();

		int i = 0;
		int j = 0;
		int minI = 0;
		int minJ = 0;
		int maxI = rows - 1;
		int maxJ = cols - 1;
		int count = 0;

		while (count < rows * cols) {
			i = minI;
			for (j = minJ; j <= maxJ; j++) {
				res.add(matrix[i][j]);
				count++;
			}
			minI++;
			j = maxJ;
			if (count == rows * cols) break;
			for (i = minI; i <= maxI; i++) {
				res.add(matrix[i][j]);
				count++;
			}
			maxJ--;
			i = maxI;
			if (count == rows * cols) break;
			for (j = maxJ; j >= minJ; j--) {
				res.add(matrix[i][j]);
				count++;
			}
			maxI--;
			j = minJ;
			if (count == rows * cols) break;
			for (i = maxI; i >= minI; i--) {
				res.add(matrix[i][j]);
				count++;
			}
			minJ++;
		}

		return res;
	}
}