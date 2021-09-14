// 407. Trapping Rain Water II
// https://leetcode.com/problems/trapping-rain-water-ii/

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

class S407 {
	public static void main (String[] args) {
		int[][] heightMap;

		heightMap = new int[][]{{1, 4, 3, 1, 3, 2}, {3, 2, 1, 3, 2, 4}, {2, 3, 3, 2, 3, 1}};
		heightMap = new int[][]{{3, 3, 3, 3, 3}, {3, 2, 2, 2, 3}, {3, 2, 1, 2, 3}, {3, 2, 2, 2, 3}, {3, 3, 3, 3, 3}};
		heightMap = new int[][]{{12, 13, 1, 12}, {13, 4, 13, 12}, {13, 8, 10, 12}, {12, 13, 12, 12}, {13, 13, 13, 13}};
		heightMap = new int[][]{{5, 5, 5, 1}, {5, 1, 1, 5}, {5, 1, 5, 5}, {5, 2, 5, 8}};
		heightMap = new int[][]{{9, 9, 9, 9, 9, 9, 8, 9, 9, 9, 9}, {9, 0, 0, 0, 0, 0, 1, 0, 0, 0, 9},
		                        {9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9}, {9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9},
		                        {9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9}};
		heightMap = new int[][]{{14, 20, 11, 19, 19, 16}, {11, 10, 7, 4, 9, 6}, {17, 2, 2, 6, 10, 9}, {15, 9, 2, 1, 4, 1},
		                        {15, 5, 5, 5, 8, 7}, {14, 2, 8, 6, 10, 7}};

		int res = trapRainWater(heightMap);

		System.out.println(res);
	}

	public static int trapRainWater (int[][] heightMap) {
		if (heightMap.length == 0) {
			return 0;
		}

		PriorityQueue<Cell> pq = new PriorityQueue<>(new Comparator<Cell>() {
			@Override
			public int compare (Cell o1, Cell o2) {
				return o1.height - o2.height;
			}
		});
		boolean[][] visited = new boolean[heightMap.length][heightMap[0].length];

		for (int i = 0; i < heightMap.length; i++) {
			visited[i][0] = true;
			visited[i][heightMap[0].length - 1] = true;
			pq.add(new Cell(i, 0, heightMap[i][0]));
			pq.add(new Cell(i, heightMap[0].length - 1, heightMap[i][heightMap[0].length - 1]));
		}

		for (int i = 1; i < heightMap[0].length - 1; i++) {
			visited[0][i] = true;
			visited[heightMap.length - 1][i] = true;
			pq.add(new Cell(0, i, heightMap[0][i]));
			pq.add(new Cell(heightMap.length - 1, i, heightMap[heightMap.length - 1][i]));
		}

		int sum = 0;
		int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
		while (!pq.isEmpty()) {
			Cell cell = pq.poll();
			for (int i = 0; i < 4; i++) {
				int row = cell.row + directions[i][0];
				int col = cell.col + directions[i][1];
				if (row >= 0 && row < heightMap.length && col >= 0 && col < heightMap[0].length && !visited[row][col]) {
					visited[row][col] = true;
					sum += Math.max(0, cell.height - heightMap[row][col]);
					pq.offer(new Cell(row, col, Math.max(heightMap[row][col], cell.height)));
				}
			}
		}
		return sum;
	}

	static class Cell {
		int row;
		int col;
		int height;

		Cell (int row, int col, int height) {
			this.row = row;
			this.col = col;
			this.height = height;
		}
	}
}