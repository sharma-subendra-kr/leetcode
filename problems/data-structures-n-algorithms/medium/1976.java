// 1976. Number of Ways to Arrive at Destination
// https://leetcode.com/problems/number-of-ways-to-arrive-at-destination/

import java.util.*;

class S1976 {
	public static void main (String args[]) {
		// int n = 7;
		// int[][] roads =
		// 	new int[][]{{0, 6, 7}, {0, 1, 2}, {1, 2, 3}, {1, 3, 3}, {6, 3, 3}, {3, 5, 1}, {6, 5, 1}, {2, 5, 1}, {0, 4, 5},
		// 	            {4, 6, 2}};
		int n = 6;
		int[][] roads =
			new int[][]{{0, 1, 1000000000}, {0, 3, 1000000000}, {1, 3, 1000000000}, {1, 2, 1000000000}, {1, 5, 1000000000},
			            {3, 4, 1000000000}, {4, 5, 1000000000}, {2, 5, 1000000000}};
		int res = countPaths(n, roads);
		System.out.println(res);
	}

	public static int countPaths (int n, int[][] roads) {
		int MOD = 1000000007;
		List<List<int[]>> graph = new ArrayList<>();
		int len = roads.length;
		for (int i = 0; i < n; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < len; i++) {
			graph.get(roads[i][0]).add(new int[]{roads[i][1], roads[i][2]});
			graph.get(roads[i][1]).add(new int[]{roads[i][0], roads[i][2]});
		}

		PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> (int) (a[1] - b[1]));
		// PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
		pq.add(new long[]{0, 0});
		long[] shortestPath = new long[n];
		int[] pathCount = new int[n];
		Arrays.fill(shortestPath, Long.MAX_VALUE);
		Arrays.fill(pathCount, 0);
		pathCount[0] = 1;
		shortestPath[0] = 0;

		while (!pq.isEmpty()) {
			long[] curr = pq.poll();
			List<int[]> data = graph.get((int) curr[0]);
			int cLen = data.size();
			for (int i = 0; i < cLen; i++) {
				int[] neighbour = data.get(i);
				if (curr[1] + neighbour[1] < shortestPath[neighbour[0]]) {
					shortestPath[neighbour[0]] = curr[1] + neighbour[1];
					pathCount[neighbour[0]] = pathCount[(int) curr[0]] % MOD;
					pq.offer(new long[]{neighbour[0], curr[1] + neighbour[1]});
				} else if (curr[1] + neighbour[1] == shortestPath[neighbour[0]]) {
					pathCount[neighbour[0]] = (pathCount[neighbour[0]] + pathCount[(int) curr[0]]) % MOD;
				}
			}
		}

		return pathCount[n - 1];
	}
}