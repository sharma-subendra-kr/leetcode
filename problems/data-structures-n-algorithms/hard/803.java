// 803. Bricks Falling When Hit
// https://leetcode.com/problems/bricks-falling-when-hit/

class S803 {

	static int cols;
	static int rows;
	static int directions[][] = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

	public static void main (String[] args) {
		int[][] grid;
		int[][] hits;

		grid = new int[][]{{1, 0, 0, 0}, {1, 1, 1, 0}};
		hits = new int[][]{{1, 0}};

		grid = new int[][]{{1, 1, 1}, {0, 1, 0}, {0, 0, 0}};
		hits = new int[][]{{0, 2}, {2, 0}, {0, 1}, {1, 2}};

		int res[] = hitBricks(grid, hits);

		for (int i : res) {
			System.out.println(i);
		}
	}

	public static int[] hitBricks (int[][] grid, int[][] hits) {
		if (grid.length == 0) {
			return new int[0];
		}

		int[] res = new int[hits.length];

		rows = grid.length;
		cols = grid[0].length;

		Disjoint disjoint = new Disjoint(rows * cols + 1);

		for (int i = 0; i < hits.length; i++) {
			if (grid[hits[i][0]][hits[i][1]] == 1) {
				grid[hits[i][0]][hits[i][1]] = 2;
			}
		}

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					unionAround(grid, i, j, disjoint);
				}
			}
		}

		int totalFall = 0;
		int prevAttached = disjoint.size[disjoint.find(0)];
		for (int i = hits.length - 1; i >= 0; i--) {
			int x = hits[i][0];
			int y = hits[i][1];
			if (grid[x][y] == 0) {
				continue;
			}
			grid[x][y] = 1;
			unionAround(grid, x, y, disjoint);
			int currentAttached = disjoint.size[disjoint.find(0)];
			totalFall = Math.max(currentAttached - prevAttached - 1, 0);
			res[i] = totalFall;
			prevAttached = currentAttached;
		}
		return res;
	}

	static void unionAround (int[][] grid, int i, int j, Disjoint disjoint) {
		int currentIndex = getIndex(i, j);
		for (int k = 0; k < directions.length; k++) {
			int row = i + directions[k][0];
			int col = j + directions[k][1];
			if (row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && grid[row][col] == 1) {
				disjoint.union(currentIndex, getIndex(row, col));
			}
		}
		if (i == 0) {
			disjoint.union(0, currentIndex);
		}
	}

	static int getIndex (int x, int y) {
		return x * cols + y + 1;
	}

	static class Disjoint {
		int[] parent;
		int[] size;

		Disjoint (int n) {
			parent = new int[n];
			size = new int[n];

			for (int i = 0; i < n; i++) {
				parent[i] = i;
				size[i] = 1;
			}
		}

		int find (int x) {
			if (x != parent[x]) {
				return parent[x] = find(parent[x]);
			}
			return x;
		}

		void union (int x, int y) {
			int parentX = find(x);
			int parentY = find(y);
			if (parentX != parentY) {
				parent[parentY] = parentX;
				size[parentX] += size[parentY];
			}
		}
	}
}