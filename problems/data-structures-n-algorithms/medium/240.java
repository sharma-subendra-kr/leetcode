// 240. Search a 2D Matrix II
// https://leetcode.com/problems/search-a-2d-matrix-ii/

class S240 {
	public static void main (String args[]) {
		// int[][] matrix =
		// 	new int[][]{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
		// int target = 5;
		// int[][] matrix =
		// 	new int[][]{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
		// int target = 20;
		int[][] matrix =
			new int[][]{{1, 1}};
		int target = 0;
		boolean res = searchMatrix(matrix, target);
		System.out.println(res);
	}

	public static boolean searchMatrix (int[][] matrix, int target) {
		int rows = matrix.length;
		int cols = matrix[0].length - 1;
		int r = 0;
		int c = cols;

		while (r < rows && c >= 0) {
			if (matrix[r][c] > target) {
				c--;
			} else if (matrix[r][c] < target) {
				r++;
			} else if (matrix[r][c] == target) {
				return true;
			}
		}
		return false;
	}

	// public static boolean searchMatrix (int[][] matrix, int target) {
	// 	int len = matrix.length;
	// 	int cols = matrix[0].length;
	// 	int low = 0;
	// 	int high = cols - 1;
	// 	int mid;
	//
	// 	for (int i = 0; i < len; i++) {
	// 		low = 0;
	// 		high = cols - 1;
	// 		while (low < high) {
	// 			mid = (low + high) / 2;
	// 			if (target > matrix[i][mid]) {
	// 				low = mid + 1;
	// 			} else {
	// 				high = mid;
	// 			}
	// 		}
	// 		if (matrix[i][low] == target) {
	// 			return true;
	// 		}
	// 	}
	//
	// 	return false;
	// }
}