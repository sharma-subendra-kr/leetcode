// 427. Construct Quad Tree
// https://leetcode.com/problems/construct-quad-tree/

class S427 {
	static public void main (String args[]) {
		int[][] grid = new int[][]{{0, 1}, {1, 0}};
		// int[][] grid = new int[][]{{1, 1, 1, 1, 0, 0, 0, 0}, {1, 1, 1, 1, 0, 0, 0, 0}, {1, 1, 1, 1, 1, 1, 1, 1},
		//                            {1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 0, 0, 0, 0}, {1, 1, 1, 1, 0, 0, 0, 0},
		//                            {1, 1, 1, 1, 0, 0, 0, 0}, {1, 1, 1, 1, 0, 0, 0, 0}};
		Node res = construct(grid);
	}

	static public Node construct (int[][] grid) {
		int len = grid.length;
		return recursion(grid, 0, 0, len, len);
	}

	static public Node recursion (int[][] grid, int startR, int startC, int endR, int endC) {
		int prev = grid[startR][startC];
		boolean traverse = false;
		for (int i = startR; i < endR; i++) {
			for (int j = startC; j < endC; j++) {
				if (grid[i][j] != prev) {
					traverse = true;
					break;
				}
			}
		}
		Node node = new Node(prev == 1, true);
		if (traverse) {
			node.val = true;
			node.isLeaf = false;
			node.topLeft = recursion(grid, startR, startC, (startR + endR) / 2, (startC + endC) / 2);
			node.topRight = recursion(grid, startR, (startC + endC) / 2, (startR + endR) / 2, endC);
			node.bottomLeft = recursion(grid, (startR + endR) / 2, startC, endR, (startC + endC) / 2);
			node.bottomRight = recursion(grid, (startR + endR) / 2, (startC + endC) / 2, endR, endC);
		}
		return node;
	}

	static class Node {
		public boolean val;
		public boolean isLeaf;
		public Node topLeft;
		public Node topRight;
		public Node bottomLeft;
		public Node bottomRight;

		public Node () {
			this.val = false;
			this.isLeaf = false;
			this.topLeft = null;
			this.topRight = null;
			this.bottomLeft = null;
			this.bottomRight = null;
		}

		public Node (boolean val, boolean isLeaf) {
			this.val = val;
			this.isLeaf = isLeaf;
			this.topLeft = null;
			this.topRight = null;
			this.bottomLeft = null;
			this.bottomRight = null;
		}

		public Node (boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
			this.val = val;
			this.isLeaf = isLeaf;
			this.topLeft = topLeft;
			this.topRight = topRight;
			this.bottomLeft = bottomLeft;
			this.bottomRight = bottomRight;
		}
	}
}