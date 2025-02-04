// 502. IPO
// https://leetcode.com/problems/ipo/

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Stack;

class S502 {
	public static void main (String[] args) {
		// int k = 2;
		// int w = 0;
		// int[] profits = new int[]{1, 2, 3};
		// int[] capital = new int[]{0, 0, 1};

		// int k = 3;
		// int w = 0;
		// int[] profits = new int[]{1, 2, 3};
		// int[] capital = new int[]{0, 1, 2};

		// int k = 1;
		// int w = 0;
		// int[] profits = new int[]{1, 2, 3};
		// int[] capital = new int[]{1, 1, 2};

		int k = 10;
		int w = 0;
		int[] profits = new int[]{1, 2, 3};
		int[] capital = new int[]{0, 1, 2};

		int res = findMaximizedCapital(k, w, profits, capital);
		System.out.println(res);
	}

	public static int findMaximizedCapital (int k, int w, int[] profits, int[] capital) {
		int len = profits.length;
		int count = 0;
		int ptr = 0;
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (b[0] - a[0]));
		int[][] arr = new int[len][2];
		for (int i = 0; i < len; i++) {
			arr[i][0] = profits[i];
			arr[i][1] = capital[i];
		}
		Arrays.sort(arr, (a, b) -> a[1] - b[1]);
		for (int i = 0; i < len; i++) {
			if (arr[i][1] > w) {
				break;
			}
			pq.add(arr[i]);
			ptr++;
		}

		while (count != k) {
			if (pq.isEmpty()) {
				return w;
			}
			int[] item = pq.poll();
			w += item[0];

			while (ptr < len) {
				if (arr[ptr][1] > w) {
					break;
				}
				pq.add(arr[ptr]);
				ptr++;
			}
			count++;
		}

		return w;
	}
}