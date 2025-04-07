// 980. Unique Paths III
// https://leetcode.com/problems/unique-paths-iii/

class S980 {
	public static void main (String[] args) {
		// int[][] grid = new int[][]{{1, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 2, -1}};
		// int[][] grid = new int[][]{{1, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 2}};
		int[][] grid = new int[][]{{0, 1}, {2, 0}};
		int res = uniquePathsIII(grid);
		System.out.println(res);
	}

	public static int uniquePathsIII (int[][] grid) {
		int rows = grid.length - 1;
		int cols = grid[0].length - 1;
		int[][] visited = new int[rows + 1][cols + 1];
		int res[] = new int[3];
		int startRow = 0, startCol = 0;
		for (int i = 0; i <= rows; i++) {
			for (int j = 0; j <= cols; j++) {
				if (grid[i][j] != -1) {
					res[2]++;
				}
				if (grid[i][j] == 1) {
					startRow = i;
					startCol = j;
				}
			}
		}

		recursion(startRow, startCol, rows, cols, grid, visited, res);
		return res[0];
	}

	public static void recursion (int i, int j, int rows, int cols, int[][] grid, int[][] visited, int[] res) {
		if (visited[i][j] == 1) {
			return;
		} else if (grid[i][j] == 2 && res[1] + 1 == res[2]) {
			res[0]++;
		} else if (grid[i][j] == 2) {
			return;
		}

		visited[i][j] = 1;
		res[1]++;
		if (i + 1 <= rows && grid[i + 1][j] != -1) {
			recursion(i + 1, j, rows, cols, grid, visited, res);
		}
		if (i - 1 >= 0 && grid[i - 1][j] != -1) {
			recursion(i - 1, j, rows, cols, grid, visited, res);
		}
		if (j + 1 <= cols && grid[i][j + 1] != -1) {
			recursion(i, j + 1, rows, cols, grid, visited, res);
		}
		if (j - 1 >= 0 && grid[i][j - 1] != -1) {
			recursion(i, j - 1, rows, cols, grid, visited, res);
		}
		visited[i][j] = 0;
		res[1]--;
	}
}