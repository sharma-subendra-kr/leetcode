// 289. Game of Life
// https://leetcode.com/problems/game-of-life/description/

class S289 {
	public static void main (String[] args) {
		int[][] board = new int[][]{{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}};
		gameOfLife(board);
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				System.out.print(board[i][j]);
				System.out.print(" ");
			}
			System.out.println();
		}
	}

	public static void gameOfLife (int[][] board) {
		int rLen = board.length;
		if (rLen == 0) {
			return;
		}
		int cLen = board[0].length;

		for (int i = 0; i < rLen; i++) {
			for (int j = 0; j < cLen; j++) {
				int live = 0;
				int dead = 0;
				int temp;
				// if (j - 1 >= 0) {
				// 	if (i - 1 >= 0) {
				// 		temp = (board[i - 1][j - 1] & 1) == 1 ? live++ : dead++;
				// 	}
				// 	if (i + 1 < rLen) {
				// 		temp = (board[i + 1][j - 1] & 1) == 1 ? live++ : dead++;
				// 	}
				// 	temp = (board[i][j - 1] & 1) == 1 ? live++ : dead++;
				// }
				// if (j + 1 < cLen) {
				// 	if (i - 1 >= 0) {
				// 		temp = (board[i - 1][j + 1] & 1) == 1 ? live++ : dead++;
				// 	}
				// 	if (i + 1 < rLen) {
				// 		temp = (board[i + 1][j + 1] & 1) == 1 ? live++ : dead++;
				// 	}
				// 	temp = (board[i][j + 1] & 1) == 1 ? live++ : dead++;
				// }
				// if (i - 1 >= 0) {
				// 	temp = (board[i - 1][j] & 1) == 1 ? live++ : dead++;
				// }
				// if (i + 1 < rLen) {
				// 	temp = (board[i + 1][j] & 1) == 1 ? live++ : dead++;
				// }

				for (int k = i - 1; k <= i + 1 && k < rLen; k++) {
					for (int l = j - 1; l <= j + 1 && l < cLen; l++) {
						if (k >= 0 && l >= 0 && !(k == i && l == j)) {
							temp = (board[k][l] & 1) == 1 ? live++ : dead++;
						}
					}
				}

				if (board[i][j] == 1) {
					if (live == 2 || live == 3) {
						board[i][j] = 3;
					}
				} else if (board[i][j] == 0) {
					if (live == 3) {
						board[i][j] = 2;
					}
				}
			}
		}

		for (int i = 0; i < rLen; i++) {
			for (int j = 0; j < cLen; j++) {
				board[i][j] >>= 1;
			}
		}
	}
}