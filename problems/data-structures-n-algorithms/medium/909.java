// 909. Snakes and Ladders
// https://leetcode.com/problems/snakes-and-ladders/

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

class S909 {
	public static void main (String[] args) {
		// int[][] board = new int[][]{{-1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1},
		//                             {-1, 35, -1, -1, 13, -1}, {-1, -1, -1, -1, -1, -1}, {-1, 15, -1, -1, -1, -1}};
		// int[][] board = new int[][]{{-1, -1}, {-1, 3}};
		// int[][] board = new int[][]{{-1, -1, -1}, {-1, 9, 8}, {-1, 8, 9}};
		// int[][] board = new int[][]{{-1, 7, -1}, {-1, 6, 9}, {-1, -1, 2}};
		// int[][] board = new int[][]{{1, 1, -1}, {1, 1, 1}, {-1, 1, 1}};
		// int[][] board = new int[][]{{-1, 4, -1}, {6, 2, 6}, {-1, 3, -1}};
		// int[][] board = new int[][]{{-1, 11, 6, -1}, {-1, 15, 16, -1}, {-1, 7, -1, 8}, {-1, -1, -1, 8}};//2
		// int[][] board = new int[][]{{-1, -1, 2, -1}, {14, 2, 12, 3}, {4, 9, 1, 11}, {-1, 2, 1, 16}};
		// int[][] board = new int[][]{{-1, 1, 2, -1}, {2, 13, 15, -1}, {-1, 10, -1, -1}, {-1, 6, 2, 8}};
		// int[][] board = new int[][]{{-1, -1, 27, 13, -1, 25, -1}, {-1, -1, -1, -1, -1, -1, -1}, {44, -1, 8, -1, -1, 2, -1},
		//                             {-1, 30, -1, -1, -1, -1, -1}, {3, -1, 20, -1, 46, 6, -1}, {-1, -1, -1, -1, -1, -1, 29},
		//                             {-1, 29, 21, 33, -1, -1, -1}};
		int[][] board = new int[][]{{-1, -1, -1, 63, -1, -1, -1, 62, -1}, {53, 52, 13, 32, -1, -1, -1, -1, -1},
		                            {-1, -1, 26, -1, 73, -1, -1, -1, 55},
		                            {-1, -1, -1, -1, 74, -1, -1, -1, -1}, {-1, -1, 35, 42, -1, 45, -1, -1, -1},
		                            {81, -1, 3, 46, -1, -1, -1, -1, 59},
		                            {74, -1, 66, 16, -1, -1, -1, -1, -1}, {-1, -1, -1, 28, -1, -1, 81, -1, 22},
		                            {-1, -1, -1, -1, 61, 17, 39, 21, -1}};
		int res = snakesAndLadders(board);
		System.out.println(res);
	}

	public static int snakesAndLadders (int[][] board) {
		Queue<int[]> queue = new LinkedList<>();
		int len = board.length;
		int[] visited = new int[len * len + 2];
		Arrays.fill(visited, 0);

		int res = Integer.MAX_VALUE;
		int steps = 0;
		int start;
		queue.add(new int[]{1, 0});
		while (!queue.isEmpty()) {
			int[] front = queue.poll();
			start = front[0];
			steps = front[1];
			for (int i = start + 1; i <= len * len && i <= start + 6; i++) {
				int[] idx = getIndex(i, len);
				int r = idx[0];
				int c = idx[1];
				int dest = board[r][c];
				if (dest != -1 && (visited[dest] == 0 || visited[dest] > steps + 1) && i != start) {
					queue.add(new int[]{dest, steps + 1});
					visited[dest] = steps + 1;
				} else if (dest == -1 && (visited[i] == 0 || visited[i] > steps + 1)) {
					queue.add(new int[]{i, steps + 1});
					visited[i] = steps + 1;
				}
			}
			if (start == len * len) {
				res = Math.min(steps, res);
			}
		}

		return res == Integer.MAX_VALUE ? -1 : res;
	}

	public static int[] getIndex (int i, int len) {
		int nr = (len - 1) - (i - 1) / len;
		int nc = (i - 1) % len;
		if ((len % 2 == 1 && nr % 2 == 1) || (len % 2 == 0 && nr % 2 == 0)) {
			nc = (len - 1) - nc;
		}
		return new int[]{nr, nc};
	}
}