// 547. Number of Provinces
// https://leetcode.com/problems/number-of-provinces/

import java.util.HashSet;

class S547 {
	public static void main (String[] args) {
		int[][] isConnected;

		isConnected = new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
		isConnected = new int[][]{{1, 0, 0, 1}, {0, 1, 1, 0}, {0, 1, 1, 1}, {1, 0, 1, 1}};

		int res = findCircleNum(isConnected);

		System.out.println(res);
	}

	public static int findCircleNum (int[][] isConnected) {
		int[] parent = new int[isConnected.length + 1];

		for (int i = 0; i < parent.length; i++) {
			parent[i] = i;
		}

		for (int i = 0; i < isConnected.length; i++) {
			for (int j = 0; j < isConnected.length; j++) {
				if (isConnected[i][j] == 1) {
					union(i + 1, j + 1, parent);
				}
			}
		}

		for (int i = 1; i < parent.length; i++) {
			find(i, parent);
		}

		HashSet<Integer> set = new HashSet<>();

		for (int i = 1; i < parent.length; i++) {
			set.add(parent[i]);
		}

		return set.size();
	}

	public static int find (int i, int[] parent) {
		while (parent[i] != i) {
			return parent[i] = find(parent[i], parent);
		}
		return parent[i];
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