// 57. Insert Interval
// https://leetcode.com/problems/insert-interval/

import java.util.Arrays;

class S57 {
	public static void main (String[] args) {
		int[][] intervals = new int[][]{{1, 3}, {6, 9}};
		int[] newInterval = new int[]{2, 5};
		// int[][] intervals = new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
		// int[] newInterval = new int[]{4, 8};
		// int[][] intervals = new int[][]{};
		// int[] newInterval = new int[]{5, 7};
		// int[][] intervals = new int[][]{{1, 5}};
		// int[] newInterval = new int[]{2, 3};
		// int[][] intervals = new int[][]{{1, 5}};
		// int[] newInterval = new int[]{6, 8};
		// int[][] intervals = new int[][]{{1, 5}};
		// int[] newInterval = new int[]{0, 0};

		int res[][] = insert(intervals, newInterval);
		int len = res.length;
		for (int i = 0; i < len; i++) {
			System.out.print(Arrays.toString(res[i]));
		}
		System.out.println();
	}

	public static int[][] insert (int[][] intervals, int[] newInterval) {
		int len = intervals.length;
		int[][] res = new int[len + 1][2];
		int i = 0;
		int left = 0;

		while (i < len && intervals[i][1] < newInterval[0]) {
			res[left++] = intervals[i++];
		}

		int[] interval = new int[]{newInterval[0], newInterval[1]};
		while (i < len && intervals[i][0] <= newInterval[1]) {
			interval[0] = Math.min(intervals[i][0], interval[0]);
			interval[1] = Math.max(intervals[i][1], interval[1]);
			i++;
		}
		res[left++] = interval;
		while (i < len) {
			res[left++] = intervals[i++];
		}

		int[][] result = new int[left][2];
		for (i = 0; i < left; i++) {
			result[i] = res[i];
		}

		return result;
	}

	// public static int[][] insert (int[][] intervals, int[] newInterval) {
	// 	int len = intervals.length;
	// 	int[][] res = new int[len + 1][2];
	// 	int i = 0;
	// 	int left = 0;
	//
	// 	while (i < len && intervals[i][1] < newInterval[0]) {
	// 		res[left++] = intervals[i++];
	// 	}
	// 	if (i < len) {
	// 		if (intervals[i][0] > newInterval[1]) {
	// 			res[left++] = newInterval;
	// 		} else {
	// 			res[left] = intervals[i];
	// 			res[left][0] = Math.min(newInterval[0], intervals[i][0]);
	//
	// 			while (i < len && intervals[i][0] <= newInterval[1]) {
	// 				i++;
	// 			}
	// 			res[left++][1] = Math.max(Math.max(res[left][1], newInterval[1]), intervals[i - 1][1]);
	// 		}
	// 		while (i < len) {
	// 			res[left++] = intervals[i++];
	// 		}
	// 	} else {
	// 		res[left++] = newInterval;
	// 	}
	//
	// 	int[][] result = new int[left][2];
	// 	for (i = 0; i < left; i++) {
	// 		result[i] = res[i];
	// 	}
	//
	// 	return result;
	// }
}