// 149. Max Points on a Line
// https://leetcode.com/problems/max-points-on-a-line/

import java.util.HashMap;
import java.util.HashSet;

class S149 {
	public static void main (String[] args) {
		int[][] points;

		// points = new int[][]{{1, 1}, {2, 2}, {3, 3}};
		points = new int[][]{{1, 1}, {3, 2}, {5, 3}, {4, 1}, {2, 3}, {1, 4}};
		points = new int[][]{{3, 3}, {1, 4}, {1, 1}, {2, 1}, {2, 2}};
		points = new int[][]{{0, 0}, {4, 5}, {7, 8}, {8, 9}, {5, 6}, {3, 4}, {1, 1}};
		points = new int[][]{{0, 0}, {0, 1}};
		int res = maxPoints(points);

		System.out.println(res);
	}

	public static double getSlope (int[] pt1, int[] pt2) {
		if (pt2[0] - pt1[0] == 0) {
			return Double.MAX_VALUE;
		}
		double slope = (double) (pt2[1] - pt1[1]) / (pt2[0] - pt1[0]);
		if (slope == -0.0) {
			return 0.0;
		}
		return slope;
	}

	public static int getGCD (int a, int b) {
		while (b != 0) {
			a = a % b;

			int temp = a;
			a = b;
			b = temp;
		}
		return a;
	}

	// No duplicates
	// public static int maxPoints (int[][] points) {
	//  No duplicates
	// 	if (points.length < 2) {
	// 		return points.length;
	// 	}
	//
	// 	int max = 0;
	// 	for (int i = 0; i < points.length - 1; i++) {
	// 		HashMap<String, Integer> uniq = new HashMap<>();
	// 		int currentMax = 0;
	// 		int vertical = 1;
	// 		for (int j = i + 1; j < points.length; j++) {
	// 			if (points[i][0] == points[j][0]) {
	// 				vertical++;
	// 				continue;
	// 			}
	// 			int dy = points[j][1] - points[i][1];
	// 			int dx = points[j][0] - points[i][0];
	// 			int gcd = getGCD(dy, dx);
	// 			String str = (dy / gcd) + "," + (dx / gcd);
	// 			Integer val = uniq.getOrDefault(str, 1) + 1;
	// 			uniq.put(str, val);
	// 			currentMax = Math.max(currentMax, val);
	// 		}
	// 		currentMax = Math.max(currentMax, vertical);
	// 		max = Math.max(currentMax, max);
	// 	}
	// 	return max;
	// }

	// Duplicates present
	public static int maxPoints (int[][] points) {
		// duplicates present
		if (points.length < 2) {
			return points.length;
		}

		int max = 0;
		for (int i = 0; i < points.length - 1; i++) {
			HashMap<String, Integer> uniq = new HashMap<>();
			int currentMax = 0;
			int vertical = 1;
			int duplicate = 0;
			for (int j = i + 1; j < points.length; j++) {
				if (points[i][0] == points[j][0]) {
					vertical++;
					continue;
				}
				if (points[i][0] == points[j][0] && points[i][1] == points[j][1]) {
					duplicate++;
					continue;
				}
				int dy = points[j][1] - points[i][1];
				int dx = points[j][0] - points[i][0];
				int gcd = getGCD(dy, dx);
				String str = (dy / gcd) + "," + (dx / gcd);
				Integer val = uniq.getOrDefault(str, 1) + 1;
				uniq.put(str, val);
				currentMax = Math.max(currentMax, val);
			}
			currentMax = Math.max(currentMax, vertical);
			max = Math.max(currentMax + duplicate, max);
		}
		return max;
	}
}