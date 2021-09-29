// 1135. Connecting Cities With Minimum Cost
// https://leetcode.com/problems/connecting-cities-with-minimum-cost/

import java.util.Arrays;
import java.util.Comparator;

class S1135 {
	public static void main (String[] args) {
		int[][] connections;
		int n;

		connections = new int[][]{{1, 2, 5}, {1, 3, 6}, {2, 3, 1}};
		n = 3;
		// connections = new int[][]{{1, 2, 3}, {3, 4, 4}};
		// n = 4;
		// connections = new int[][]{{2, 1, 50459}, {3, 2, 47477}, {4, 2, 52585}, {5, 3, 16477}};
		// n = 5;
		// connections = new int[][]{{2, 1, 18793}, {3, 1, 63472}, {4, 1, 31371}, {5, 2, 26501}, {6, 3, 78269}};
		// n = 6;

		int res = minimumCost(n, connections);

		System.out.println(res);
	}

	public static int minimumCost (int n, int[][] connections) {
		Arrays.sort(connections, new Comparator<int[]>() {
			@Override
			public int compare (int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}
		});

		int[] parent = new int[n + 1];
		for (int i = 0; i < parent.length; i++) {
			parent[i] = i;
		}

		int cost = 0;

		for (int i = 0; i < connections.length; i++) {
			if (union(connections[i][0], connections[i][1], parent)) {
				cost += connections[i][2];
			}
		}

		for (int i = 1; i < parent.length; i++) {
			find(i, parent);
		}

		boolean isSpanning = true;
		int p = parent[1];
		for (int i = 1; i < parent.length; i++) {
			if (parent[i] != p) {
				isSpanning = false;
				break;
			}
		}

		return isSpanning ? cost : -1;
	}

	public static int find (int i, int[] parent) {
		while (parent[i] != i) {
			return parent[i] = find(parent[i], parent);
		}
		return i;
	}

	public static boolean union (int a, int b, int[] parent) {
		int parentA = find(a, parent);
		int parentB = find(b, parent);

		if (parentA == parentB) {
			return false;
		}

		if (parentB != b) {
			parent[parentA] = parentB;
		} else {
			parent[b] = parentA;
		}

		return true;
	}
}