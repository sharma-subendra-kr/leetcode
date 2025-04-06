// 56. Merge Intervals
// https://leetcode.com/problems/merge-intervals/

import java.util.Arrays;
import java.util.Map;

class S56 {
	public static void main (String args[]) {
		// int[][] intervals = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
		// int[][] intervals = new int[][]{{1, 4}, {0, 4}};
		int[][] intervals = new int[][]{{1, 3}, {0, 2}, {2, 3}, {4, 6}, {4, 5}, {5, 5}, {0, 2}, {3, 3}};
		int[][] res = merge(intervals);
		Arrays.stream(res).forEach(o -> System.out.println(o[0] + " " + o[1]));
	}

	public static int[][] merge (int[][] intervals) {
		Arrays.sort(intervals, (a, b) -> {
			if (a[0] == b[0]) {
				return a[1] - b[1];
			}
			return a[0] - b[0];
		});

		int len = intervals.length;
		int j = 0;
		int res[][] = new int[len][2];
		res[0] = new int[]{intervals[0][0], intervals[0][1]};
		for (int i = 0; i < len; i++) {
			if (intervals[i][0] <= res[j][1]) {
				res[j][1] = Math.max(res[j][1], intervals[i][1]);
			} else {
				res[++j] = new int[]{intervals[i][0], intervals[i][1]};
			}
		}
		return Arrays.copyOfRange(res, 0, j + 1);
	}
}