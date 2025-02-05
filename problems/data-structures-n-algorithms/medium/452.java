// 452. Minimum Number of Arrows to Burst Balloons
// https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/

import java.util.Arrays;
import java.util.Collections;

class S452 {
	public static void main (String[] args) {
		int[][] points = new int[][]{{10, 16}, {2, 8}, {1, 6}, {7, 12}};
		// int[][] points = new int[][]{{1, 2}, {3, 4}, {5, 6}, {7, 8}};
		// int[][] points = new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}};
		// int[][] points = new int[][]{{-2147483646, -2147483645}, {2147483646, 2147483647}};
		// int[][] points = new int[][]{{0, 9}, {1, 8}, {7, 8}, {1, 6}, {9, 16}, {7, 13}, {7, 10}, {6, 11}, {6, 9}, {9, 13}};
		int res = findMinArrowShots(points);
		System.out.println(res);
	}

	public static int findMinArrowShots (int[][] points) {
		int len = points.length;
		int overlap = 0;
		int arrows = 0;
		int end = Integer.MAX_VALUE;

		Arrays.sort(points, (a, b) -> a[0] > b[0] ? 1 : -1);

		for (int i = 0; i < len; i++) {
			if (points[i][0] <= end) {
				overlap++;
				if (points[i][1] < end) {
					end = points[i][1];
				}
			} else if (points[i][0] > end) {
				arrows++;
				overlap = 1;
				end = points[i][1];
			}
		}
		return overlap > 0 ? arrows + 1 : arrows;
	}
}