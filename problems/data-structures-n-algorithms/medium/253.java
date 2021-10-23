// 253. Meeting Rooms II
// https://leetcode.com/problems/meeting-rooms-ii/

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class S253 {

	public static void main (String[] args) {
		int[][] intervals;

		intervals = new int[][]{{0, 30}, {5, 10}, {15, 20}};
		intervals = new int[][]{{1, 5}, {8, 9}, {8, 9}};
		intervals = new int[][]{{2, 15}, {36, 45}, {9, 29}, {16, 23}, {4, 9}};

		int res = minMeetingRooms(intervals);

		System.out.println(res);
	}

	public static int minMeetingRooms (int[][] intervals) {
		if (intervals.length == 0) {
			return 0;
		}

		Arrays.sort(intervals, new Comparator<int[]>() {
			@Override
			public int compare (int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int right = intervals[0][1];
		int rooms = 1;

		pq.add(right);
		for (int i = 1; i < intervals.length; i++) {
			pq.add(intervals[i][1]);
			if (intervals[i][0] < right) {
				rooms++;
				right = Math.min(right, intervals[i][1]);
			} else {
				while (!pq.isEmpty() && pq.peek() <= right) {
					pq.poll();
				}
				right = pq.isEmpty() ? intervals[i][1] : pq.peek();
			}
		}

		return rooms;
	}
}