// 909. Snakes and Ladders
// https://leetcode.com/problems/snakes-and-ladders/

import java.util.HashMap;

class S909 {
	public static void main (String[] args) {
		// int[][] board = new int[][]{{-1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1},
		//                             {-1, 35, -1, -1, 13, -1}, {-1, -1, -1, -1, -1, -1}, {-1, 15, -1, -1, -1, -1}};
		// int[][] board = new int[][]{{-1, 7, -1}, {-1, 6, 9}, {-1, -1, 2}};
		int[][] board = new int[][]{{1, 1, -1}, {1, 1, 1}, {-1, 1, 1}};
		// int[][] board = new int[][]{{-1, 4, -1}, {6, 2, 6}, {-1, 3, -1}};
		// int[][] board = new int[][]{{-1, 11, 6, -1}, {-1, 15, 16, -1}, {-1, 7, -1, 8}, {-1, -1, -1, 8}};//2
		// int[][] board = new int[][]{{-1, -1, 2, -1}, {14, 2, 12, 3}, {4, 9, 1, 11}, {-1, 2, 1, 16}};
		int res = snakesAndLadders(board);
		System.out.println(res);
	}

	public static int snakesAndLadders (int[][] board) {
		HashMap<Integer, Integer> memo = new HashMap<>();
		int len = board.length;
		int res = recursion(1, board, len, memo);
		if (res == Integer.MAX_VALUE) {
			return -1;
		}
		return res;
	}

	public static int recursion (int start, int[][] board, int len, HashMap<Integer, Integer> memo) {
		int count = 0;
		int steps = 0;
		int jumpSteps = Integer.MAX_VALUE;
		int miss = 0;

		for (int i = start; i < len * len; i++) {
			if (miss == 6) {
				return Integer.MAX_VALUE;
			}
			int[] idx = getIndex(i, len);
			int r = idx[0];
			int c = idx[1];
			if (board[r][c] != -1 && !memo.containsKey(i)) {
				memo.put(i, Integer.MAX_VALUE);
				int s = recursion(board[r][c], board, len, memo);
				if (s != Integer.MAX_VALUE) {
					jumpSteps = Math.min(steps + 1 + s, jumpSteps);
					memo.put(i, s);
				} else {
					memo.remove(i);
					miss++;
				}
			} else if (board[r][c] != -1 && memo.get(i) != Integer.MAX_VALUE) {
				jumpSteps = Math.min(steps + 1 + memo.get(i), jumpSteps);
			} else if (memo.get(i) != null && memo.get(i) == Integer.MAX_VALUE) {
				return Integer.MAX_VALUE;
			}
			count++;
			if (count == 6) {
				steps++;
				count = 0;
			}
		}
		return Math.min(steps + (count > 0 ? 1 : 0), jumpSteps);
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

/*
class Solution {
    public int snakesAndLadders(int[][] board) {
        HashMap<Integer, Integer> memo = new HashMap<>();
        int len = board.length;
        return recursion(1, board, len, memo);
    }

    public static int recursion (int start, int[][] board, int len, HashMap<Integer, Integer> memo) {
        int count = 0;
        int steps = 0;
        int jumpSteps = Integer.MAX_VALUE;

        for (int i = start; i < len * len; i++) {
          int[] idx = getIndex(i, len);
          int r = idx[0];
          int c = idx[1];
          if (board[r][c] != -1 && !memo.containsKey(i)) {
            memo.put(i, Integer.MAX_VALUE);
            int s = recursion(board[r][c], board, len, memo);
            jumpSteps = Math.min(steps + 1 + s, jumpSteps);
            memo.put(i, s);
          } else if (board[r][c] != -1 && memo.get(i) != Integer.MAX_VALUE) {
            jumpSteps = Math.min(steps + 1 + memo.get(i), jumpSteps);
          }
          count++;
          if (count == 6) {
            steps++;
            count = 0;
          }
        }
        return Math.min(steps + (count > 0 ? 1 : 0), jumpSteps);
	  }

    public static int[] getIndex (int i, int len) {
        int nr = (len - 1) - (i - 1) / len;
        int nc = (i - 1) % len;
        if ((len % 2 == 1 && nr % 2 == 1) || (len % 2 == 0 && nr % 2 == 0)) {
          nc = (len - 1) - nc;
        }
        return new int[]{nr, nc};
	  }
}*/