// 74. Search a 2D Matrix
// https://leetcode.com/problems/search-a-2d-matrix/

class S74 {
	public static void main (String[] args) {
		// int[][] matrix = new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
		// int target = 3;
		int[][] matrix = new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
		int target = 13;
		boolean res = searchMatrix(matrix, target);
		System.out.println(res);
	}

	public static boolean searchMatrix (int[][] matrix, int target) {
		int m = matrix.length;
		int n = matrix[0].length;

		int low = 0;
		int high = m - 1;
		int mid = 0;
		while (low < high) {
			mid = (low + high) / 2 + 1;
			if (target < matrix[mid][0]) {
				high = mid - 1;
			} else {
				low = mid;
			}
		}

		if (low == high) {
			mid = low;
		}

		int row = mid;
		low = 0;
		high = n - 1;
		mid = 0;
		while (low < high) {
			mid = (low + high) / 2;
			if (target > matrix[row][mid]) {
				low = mid + 1;
			} else {
				high = mid;
			}
		}

		if (low == high) {
			mid = low;
		}

		if (matrix[row][mid] == target) {
			return true;
		}
		return false;
	}
}