// 1197. Minimum Knight Moves
// https://leetcode.com/problems/minimum-knight-moves/

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

class S1197 {
	static int[][] moves = {{2, 1}, {2, -1}, {-2, 1}, {-2, -1}, {1, 2}, {-1, 2}, {1, -2}, {-1, -2}};

	public static void main (String[] args) {
		int x, y;

		x = 2;
		y = 1;
		// x = 5;
		// y = 5;
		// x = 1;
		// y = 1;
		x = 2;
		y = 112;
		// x = 0;
		// y = 6;
		x = 114;
		y = -179;

		int res = minKnightMoves(x, y);

		System.out.println(res);
	}

	public static int minKnightMoves (int x, int y) {
		Queue<Point> queue = new LinkedList<>();
		HashSet<String> set = new HashSet<>();

		Point end = new Point(x, y, 0);
		Point start = new Point(0, 0, 0);
		queue.add(start);
		set.add(0 + "-" + 0);

		while (!queue.isEmpty()) {
			Point point = queue.poll();
			if (point.x == x && point.y == y) {
				return point.step;
			}

			for (int i = 0; i < 8; i++) {
				int nx = point.x + moves[i][0];
				int ny = point.y + moves[i][1];
				if (set.contains(nx + "-" + ny)) {
					continue;
				}
				if (Math.abs(end.x) - Math.abs(end.x - nx) >= -3 && Math.abs(end.y) - Math.abs(end.y - ny) >= -3) {
					queue.add(new Point(nx, ny, point.step + 1));
					set.add(nx + "-" + ny);
				}
			}
		}
		return 0;
	}

	static class Point {
		int x, y;
		int step;

		Point (int x, int y, int step) {
			this.x = x;
			this.y = y;
			this.step = step;
		}

	}
}