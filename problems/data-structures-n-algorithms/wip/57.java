// 57. Insert Interval
// https://leetcode.com/problems/insert-interval/

class S57 {
	public static void main (String[] args) {
		int[][] intervals = new int[][]{{1, 3}, {6, 9}};
		int[] newInterval = new int[]{2, 5};

		int[][] res = insert(intervals, newInterval);
		System.out.println(res.toString());
	}

	public static int[][] insert (int[][] intervals, int[] newInterval) {
		int len = intervals.length + 1;
		int[][] res = new int[len][2];
		int idx = 0;

		// int low = 0;
		// int high = len - 1;
		// int mid = (high - low) / 2;
		//
		// while (low < high) {
		// 	mid = (high + low) / 2;
		// 	if (intervals[mid][0] < newInterval[0]) {
		//
		// 	}
		// }

		if (newInterval[0] < intervals[0][0] && newInterval[1] < intervals[0][1]) {
			res[idx++] = newInterval;
		}

		int front = -1;
		int back = -1;
		for (int i = 0; i < len; i++) {
			if (newInterval[0] >= intervals[i][0] && newInterval[0] <= intervals[i][1]) {
				front = i;
			}
			if (newInterval[1] >= intervals[i][0] && newInterval[1] <= intervals[i][1]) {
				back = i;
			}
		}

		int[] temp = new int[2];
		if (front == -1 && back == -1) {
			temp = newInterval;
		} else if (front == -1) {
			temp[0] = newInterval[0];
		}
		if (front >= 0) {
			if (newInterval[0] <= intervals[front][1]) {

			}
		}
		return res;
	}
}