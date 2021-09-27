// 685. Redundant Connection II
// https://leetcode.com/problems/redundant-connection-ii/

import java.util.Arrays;

public class S685 {
	public static void main (String[] args) {
		int[][] edges;

		edges = new int[][]{{1, 2}, {1, 3}, {2, 3}};
		edges = new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 1}, {1, 5}};
		// edges = new int[][]{{2, 1}, {3, 1}, {4, 2}, {1, 4}};

		int[] res = findRedundantDirectedConnection(edges);

		System.out.println(res[0]);
		System.out.println(res[1]);
	}

	public static int getRoot (int n, int[] parent) {
		while (parent[n] != n) {
			n = parent[n];
		}
		return n;
	}

	public static int[] findRedundantDirectedConnection (int[][] edges) {
		int[] parent = new int[edges.length + 1];

		int[] e1 = {-1, -1};
		int[] e2 = {-1, -1};

		for (int i = 0; i < edges.length; i++) {
			if (parent[edges[i][1]] == 0) {
				parent[edges[i][1]] = edges[i][0];
			} else {
				e2 = new int[]{edges[i][0], edges[i][1]};
				e1 = new int[]{parent[edges[i][1]], edges[i][1]};
				edges[i][1] = 0;
			}
		}

		for (int i = 0; i < edges.length + 1; i++) {
			parent[i] = i;
		}

		for (int i = 0; i < edges.length; i++) {
			int child = edges[i][1];
			int p = edges[i][0];
			if (getRoot(p, parent) == child) {
				if (e1[0] == -1) {
					return edges[i];
				}
				return e1;
			}
			parent[edges[i][1]] = edges[i][0];
		}
		return e2;
	}
}
