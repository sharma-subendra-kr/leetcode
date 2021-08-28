// 997. Find the Town Judge
// https://leetcode.com/problems/find-the-town-judge/

import java.util.HashSet;

class S997 {
	public static void main (String[] args) {
		int n;
		int[][] trust;

		n = 2;
		trust = new int[][]{{1, 2}};

		// n = 3;
		// trust = new int[][]{{1, 3}, {2, 3}};

		// n = 3;
		// trust = new int[][]{{1, 3}, {2, 3}, {3, 1}};

		int res = findJudge(n, trust);

		System.out.println(res);
	}

	// public static int findJudge (int n, int[][] trust) {
	// 	HashSet<Integer> set = new HashSet<>();
	// 	HashSet<Integer> judge = new HashSet<>();
	//
	// 	for (int[] a : trust) {
	// 		set.add(a[0]);
	// 		judge.add(a[1]);
	// 	}
	//
	// 	int sum = n * (n + 1) / 2;
	// 	int s = 0;
	// 	for (Integer i : set) {
	// 		s += i;
	// 	}
	//
	// 	for (int[] a : trust) {
	// 		if (a[1] == sum - s) {
	// 			judge.add(a[0]);
	// 		}
	// 	}
	//
	// 	if (set.size() == n - 1 && judge.size() == n - 1) {
	// 		return sum - s;
	// 	}
	// 	return -1;
	// }

	public static int findJudge (int n, int[][] trust) {
		int[] trustScore = new int[n + 1];

		if (trust.length < n - 1) {
			return -1;
		}

		for (int[] a : trust) {
			trustScore[a[0]]--;
			trustScore[a[1]]++;
		}

		for (int i = 1; i <= n; i++) {
			if (trustScore[i] == n - 1) {
				return i;
			}
		}
		return -1;
	}
}