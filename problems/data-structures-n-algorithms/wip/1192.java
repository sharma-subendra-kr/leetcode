// 1192. Critical Connections in a Network
// https://leetcode.com/problems/critical-connections-in-a-network/

import java.util.*;

class S1192 {
	public static void main (String[] args) {
		List<List<Integer>> connections;
		int n;

		// connections =
		// 	new ArrayList<>(
		// 		Arrays.asList(new ArrayList<>(Arrays.asList(0, 1)), new ArrayList<>(Arrays.asList(1, 2)),
		// 		              new ArrayList<>(Arrays.asList(2, 0)), new ArrayList<>(Arrays.asList(1, 3))));
		// n = 4;

		// connections =
		// 	new ArrayList<>(Arrays.asList(new ArrayList<>(Arrays.asList(0, 1))));
		// n = 2;

		connections =
			new ArrayList<>(
				Arrays.asList(new ArrayList<>(Arrays.asList(0, 1)), new ArrayList<>(Arrays.asList(1, 2)),
				              new ArrayList<>(Arrays.asList(2, 0)), new ArrayList<>(Arrays.asList(1, 3)),
				              new ArrayList<>(Arrays.asList(3, 4)), new ArrayList<>(Arrays.asList(4, 5)),
				              new ArrayList<>(Arrays.asList(5, 3))));
		n = 6;

		List<List<Integer>> res = criticalConnections(n, connections);

		for (List<Integer> i : res) {
			System.out.println(i.get(0) + " " + i.get(1));
		}
	}

	public static List<List<Integer>> criticalConnections (int n, List<List<Integer>> connections) {
		List<List<Integer>> res = new ArrayList<>();
		boolean[][] critical = new boolean[n][n];
		boolean[] visited;
		HashMap<Integer, HashSet<Integer>> map = new HashMap<>();

		for (List<Integer> l : connections) {
			if (map.containsKey(l.get(0))) {
				map.get(l.get(0)).add(l.get(1));
			} else {
				map.put(l.get(0), new HashSet<>(Set.of(l.get(1))));
			}

			if (map.containsKey(l.get(1))) {
				map.get(l.get(1)).add(l.get(0));
			} else {
				map.put(l.get(1), new HashSet<>(Set.of(l.get(0))));
			}
		}

		for (int i = 0; i < n; i++) {
			visited = new boolean[n];
			dfs(i, map, critical, visited, res, i, -1, 0);
		}
		return res;
	}

	public static boolean dfs (Integer current, HashMap<Integer, HashSet<Integer>> map, boolean[][] critical,
	                           boolean[] visited, List<List<Integer>> res, int start, int prev, int length) {
		if (prev != -1 && current == start) {
			return true;
		}

		boolean hasCycle = false;
		HashSet<Integer> st = map.get(current);
		for (Integer i : st) {
			if (critical[i][current]) {
				continue;
			}
			if (length == 0) {
				visited[start] = false;
			}
			if (visited[i] || i == prev) {
				continue;
			}

			visited[i] = true;
			boolean _hasCycle = dfs(i, map, critical, visited, res, start, current, length + 1);
			if (!_hasCycle && current == start && !critical[i][current]) {
				critical[current][i] = true;
				critical[i][current] = true;
				res.add(new ArrayList<>(Arrays.asList(current, i)));
				critical[current][i] = true;
				critical[i][current] = true;
			}
			hasCycle = hasCycle || _hasCycle;
		}
		return hasCycle;
	}
}