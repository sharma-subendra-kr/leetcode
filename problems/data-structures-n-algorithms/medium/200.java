// 200. Number of Islands
// https://leetcode.com/problems/number-of-islands/

import java.util.LinkedList;
import java.util.Queue;

class S200 {
	public static void main (String args[]) {
		char[][] grid = new char[][]{{'1', '1', '1', '1', '0'},
		                             {'1', '1', '0', '1', '0'},
		                             {'1', '1', '0', '0', '0'},
		                             {'0', '0', '0', '0', '0'}};
		int res = numIslands(grid);
		System.out.println(res);
	}

	public static int numIslands (char[][] grid) {
		int rLen = grid.length;
		if (rLen == 0) {
			return 0;
		}
		int cLen = grid[0].length;
		boolean visited[][] = new boolean[rLen][cLen];
		Queue<int[]> queue = new LinkedList();
		int res = 0;

		for (int i = 0; i < rLen; i++) {
			for (int j = 0; j < cLen; j++) {
				if (visited[i][j] == true || grid[i][j] == '0') {
					continue;
				}

				queue.add(new int[]{i, j});

				while (!queue.isEmpty()) {
					int[] curr = queue.poll();
					int ci = curr[0];
					int cj = curr[1];

					if (cj - 1 >= 0 && !visited[ci][cj - 1] && grid[ci][cj - 1] == '1') {
						queue.add(new int[]{ci, cj - 1});
						visited[ci][cj - 1] = true;
					}
					if (cj + 1 < cLen && !visited[ci][cj + 1] && grid[ci][cj + 1] == '1') {
						queue.add(new int[]{ci, cj + 1});
						visited[ci][cj + 1] = true;
					}
					if (ci - 1 >= 0 && !visited[ci - 1][cj] && grid[ci - 1][cj] == '1') {
						queue.add(new int[]{ci - 1, cj});
						visited[ci - 1][cj] = true;
					}
					if (ci + 1 < rLen && !visited[ci + 1][cj] && grid[ci + 1][cj] == '1') {
						queue.add(new int[]{ci + 1, cj});
						visited[ci + 1][cj] = true;
					}
				}
				res++;
			}
		}
		return res;
	}
}