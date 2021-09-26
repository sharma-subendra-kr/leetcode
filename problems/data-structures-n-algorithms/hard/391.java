// 391. Perfect Rectangle
// https://leetcode.com/problems/perfect-rectangle/

import java.util.HashSet;

class S391 {
	public static void main (String[] args) {

		int[][] rectangles;

		rectangles = new int[][]{{1, 1, 3, 3}, {3, 1, 4, 2}, {3, 2, 4, 4}, {1, 3, 2, 4}, {2, 3, 3, 4}};
		rectangles = new int[][]{{1, 1, 2, 3}, {1, 3, 2, 4}, {3, 1, 4, 2}, {3, 2, 4, 4}};
		rectangles = new int[][]{{1, 1, 3, 3}, {3, 1, 4, 2}, {1, 3, 2, 4}, {3, 2, 4, 4}};
		rectangles = new int[][]{{1, 1, 3, 3}, {3, 1, 4, 2}, {1, 3, 2, 4}, {3, 2, 4, 4}};
		rectangles = new int[][]{{1, 1, 3, 3}, {3, 1, 4, 2}, {1, 3, 2, 4}, {2, 2, 4, 4}};
		rectangles = new int[][]{{0, 0, 1, 1}, {0, 1, 3, 2}, {1, 0, 2, 2}};

		boolean res = isRectangleCover(rectangles);

		System.out.println(res);
	}

	public static boolean isRectangleCover (int[][] rectangles) {
		HashSet<String> points = new HashSet<>();
		int x1 = Integer.MAX_VALUE, x2 = Integer.MIN_VALUE, y1 = Integer.MAX_VALUE, y2 = Integer.MIN_VALUE;

		int area = 0;
		for (int i = 0; i < rectangles.length; i++) {
			int[] rect = rectangles[i];
			x1 = Math.min(x1, rect[0]);
			x2 = Math.max(x2, rect[2]);
			y1 = Math.min(y1, rect[1]);
			y2 = Math.max(y2, rect[3]);

			area += ((rect[2] - rect[0]) * (rect[3] - rect[1]));

			String a = rect[0] + ", " + rect[1];
			String b = rect[2] + ", " + rect[1];
			String c = rect[2] + ", " + rect[3];
			String d = rect[0] + ", " + rect[3];

			if (!points.add(a)) points.remove(a);
			if (!points.add(b)) points.remove(b);
			if (!points.add(c)) points.remove(c);
			if (!points.add(d)) points.remove(d);
		}
		if (!points.contains(x1 + ", " + y1) || !points.contains(x2 + ", " + y1) || !points.contains(x2 + ", " + y2) ||
		    !points.contains(x1 + ", " + y2) || points.size() != 4) {
			return false;
		}
		return area == ((x2 - x1) * (y2 - y1));
	}
}