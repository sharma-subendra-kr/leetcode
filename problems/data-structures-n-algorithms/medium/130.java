// 130. Surrounded Regions
// https://leetcode.com/problems/surrounded-regions/

import java.util.Arrays;
import java.util.stream.Collectors;

class S130 {
	public static void main (String[] args) {
		char[][] board =
			new char[][]{{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
		solve(board);
		for (char[] row : board) {
			for (char c : row) {
				System.out.print(c);
				System.out.print(" ");
			}
			System.out.println();
		}
	}

	public static void solve (char[][] board) {
		int rLen = board.length;
		if (rLen == 0) {
			return;
		}
		int cLen = board[0].length;
		for (int i = 0; i < rLen; i++) {
			dfs(i, 0, board, rLen, cLen);
			dfs(i, cLen - 1, board, rLen, cLen);
		}

		for (int j = 0; j < cLen; j++) {
			dfs(0, j, board, rLen, cLen);
			dfs(rLen - 1, j, board, rLen, cLen);
		}

		for (int i = 1; i < rLen - 1; i++) {
			for (int j = 1; j < cLen - 1; j++) {
				if (board[i][j] == 'O') {
					board[i][j] = 'X';
				}
			}
		}

		for (int i = 0; i < rLen; i++) {
			for (int j = 0; j < cLen; j++) {
				if (board[i][j] == '1') {
					board[i][j] = 'O';
				}
			}
		}
	}

	public static void dfs (int i, int j, char[][] board, int rLen, int cLen) {
		if (i < 0 || i == rLen || j < 0 || j == cLen) {
			return;
		} else if (board[i][j] == 'X' || board[i][j] == '1') {
			return;
		}
		
		board[i][j] = '1';

		dfs(i - 1, j, board, rLen, cLen);
		dfs(i, j - 1, board, rLen, cLen);
		dfs(i + 1, j, board, rLen, cLen);
		dfs(i, j + 1, board, rLen, cLen);
	}
}