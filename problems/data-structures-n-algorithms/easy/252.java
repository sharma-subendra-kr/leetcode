// 252. Meeting Rooms
// https://leetcode.com/problems/meeting-rooms/

import java.util.Arrays;
import java.util.Comparator;

class S252 {
	public static void main (String[] args) {
		int[][] intervals;

		intervals = new int[][]{{0, 30}, {5, 10}, {15, 20}};
		// intervals = new int[][]{{7, 10}, {2, 4}};
		boolean res = canAttendMeetings(intervals);

		System.out.println(res);
	}

	public static boolean canAttendMeetings (int[][] intervals) {
		Arrays.sort(intervals, new Comparator<int[]>() {
			@Override
			public int compare (int[] o1, int[] o2) {
				return Integer.compare(o1[0], o2[0]);
			}
		});

		for (int i = 0; i < intervals.length; i++) {
			if (i < intervals.length - 1 && intervals[i][1] > intervals[i + 1][0]) {
				return false;
			}
		}
		return true;
	}
}