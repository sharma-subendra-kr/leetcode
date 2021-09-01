// 1192. Critical Connections in a Network
// https://leetcode.com/problems/critical-connections-in-a-network/

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

class S1192 {
	public static void main (String[] args) {
		List<List<Integer>> connections;
		int n;

		connections =
			new ArrayList<>(
				Arrays.asList(new ArrayList<>(Arrays.asList(0, 1)), new ArrayList<>(Arrays.asList(1, 2)),
				              new ArrayList<>(Arrays.asList(2, 0)), new ArrayList<>(Arrays.asList(1, 3))));
		n = 4;

		// connections =
		// 	new ArrayList<>(Arrays.asList(new ArrayList<>(Arrays.asList(0, 1))));
		// n = 2;

		// connections =
		// 	new ArrayList<>(
		// 		Arrays.asList(new ArrayList<>(Arrays.asList(0, 1)), new ArrayList<>(Arrays.asList(1, 2)),
		// 		              new ArrayList<>(Arrays.asList(2, 0)), new ArrayList<>(Arrays.asList(1, 3)),
		// 		              new ArrayList<>(Arrays.asList(3, 4)), new ArrayList<>(Arrays.asList(4, 5)),
		// 		              new ArrayList<>(Arrays.asList(5, 3))));
		// n = 6;

		connections =
			new ArrayList<>(
				Arrays.asList(new ArrayList<>(Arrays.asList(0, 1)), new ArrayList<>(Arrays.asList(1, 2)),
				              new ArrayList<>(Arrays.asList(2, 0)), new ArrayList<>(Arrays.asList(1, 3)),
				              new ArrayList<>(Arrays.asList(3, 4)), new ArrayList<>(Arrays.asList(4, 5)),
				              new ArrayList<>(Arrays.asList(5, 3)), new ArrayList<>(Arrays.asList(2, 5)),
				              new ArrayList<>(Arrays.asList(0, 5)), new ArrayList<>(Arrays.asList(0, 6))));
		n = 7;

		List<List<Integer>> res = criticalConnections(n, connections);

		for (List<Integer> i : res) {
			System.out.println(i.get(0) + " " + i.get(1));
		}
	}

	// Working Solution with very high memory usage
	public static List<List<Integer>> criticalConnections (int n, List<List<Integer>> connections) {
		List<List<Integer>> res = new ArrayList<>();
		HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
		int[] rank = new int[n];
		Arrays.fill(rank, -2);

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

		rank[0] = 0;
		dfs(0, map, rank, new AtomicInteger(0), -1);

		for (Integer key : map.keySet().stream().collect(Collectors.toList())) {
			HashSet<Integer> item = map.get(key);
			for (Integer value : item) {
				res.add(new ArrayList<>(Arrays.asList(key, value)));
				map.get(value).remove(key);
			}
		}

		return res;
	}

	public static int dfs (Integer current, HashMap<Integer, HashSet<Integer>> map, int[] rank, AtomicInteger counter,
	                       int prev) {
		int minCycle = -1;
		HashSet<Integer> st = map.get(current);
		for (Integer i : st.stream().collect(Collectors.toList())) {
			if (i.intValue() == prev) {
				continue;
			}
			if (rank[i.intValue()] != -2) {
				st.remove(i);
				map.get(i).remove(current);
				if (minCycle > rank[i.intValue()] || minCycle < 0) {
					minCycle = rank[i.intValue()];
				}
				continue;
			}

			rank[i.intValue()] = counter.incrementAndGet();
			int cycle = dfs(i, map, rank, counter, current.intValue());
			if (rank[current.intValue()] >= cycle && cycle >= 0) {
				st.remove(i);
				map.get(i).remove(current);
			}
			if (cycle < minCycle && cycle >= 0 || minCycle < 0) {
				minCycle = cycle;
			}
		}

		return minCycle;
	}

	// Wrong answer
	// public static List<List<Integer>> criticalConnections (int n, List<List<Integer>> connections) {
	// 	List<List<Integer>> res = new ArrayList<>();
	// 	boolean[] visited = new boolean[n];
	// 	HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
	//
	// 	for (List<Integer> l : connections) {
	// 		if (map.containsKey(l.get(0))) {
	// 			map.get(l.get(0)).add(l.get(1));
	// 		} else {
	// 			map.put(l.get(0), new HashSet<>(Set.of(l.get(1))));
	// 		}
	//
	// 		if (map.containsKey(l.get(1))) {
	// 			map.get(l.get(1)).add(l.get(0));
	// 		} else {
	// 			map.put(l.get(1), new HashSet<>(Set.of(l.get(0))));
	// 		}
	// 	}
	//
	// 	for (int i = 0; i < n; i++) {
	// 		if (visited[i]) {
	// 			continue;
	// 		}
	// 		visited[i] = true;
	// 		dfs(i, map, visited, -1);
	// 	}
	//
	// 	for (Integer key : map.keySet().stream().collect(Collectors.toList())) {
	// 		HashSet<Integer> item = map.get(key);
	// 		for (Integer value : item) {
	// 			res.add(new ArrayList<>(Arrays.asList(key, value)));
	// 			map.get(value).remove(key);
	// 		}
	// 	}
	//
	// 	return res;
	// }
	//
	// public static HashSet<Integer> dfs (Integer current, HashMap<Integer, HashSet<Integer>> map, boolean[] visited,
	//                                     int prev) {
	// 	HashSet<Integer> allCycles = new HashSet<>();
	// 	HashSet<Integer> st = map.get(current);
	// 	for (Integer i : st.stream().collect(Collectors.toList())) {
	// 		if (i.intValue() == prev) {
	// 			continue;
	// 		}
	// 		if (visited[i.intValue()] && st.contains(i)) {
	// 			st.remove(i);
	// 			map.get(i).remove(current);
	// 			allCycles.add(i);
	// 			continue;
	// 		}
	//
	// 		if (visited[i.intValue()]) {
	// 			continue;
	// 		}
	//
	// 		visited[i.intValue()] = true;
	// 		HashSet<Integer> cycles = dfs(i, map, visited, current.intValue());
	// 		if (!cycles.isEmpty()) {
	// 			st.remove(i);
	// 			map.get(i).remove(current);
	// 		}
	//
	// 		for (Integer c : cycles) {
	// 			allCycles.add(c);
	// 		}
	// 	}
	//
	// 	if (allCycles.contains(current)) {
	// 		allCycles.remove(current);
	// 	}
	//
	// 	return allCycles;
	// }

	// Memory limit exceeded
	// public static List<List<Integer>> criticalConnections (int n, List<List<Integer>> connections) {
	// 	List<List<Integer>> res = new ArrayList<>();
	// 	boolean[] visited = new boolean[n];
	// 	HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
	//
	// 	for (List<Integer> l : connections) {
	// 		if (map.containsKey(l.get(0))) {
	// 			map.get(l.get(0)).add(l.get(1));
	// 		} else {
	// 			map.put(l.get(0), new HashSet<>(Set.of(l.get(1))));
	// 		}
	//
	// 		if (map.containsKey(l.get(1))) {
	// 			map.get(l.get(1)).add(l.get(0));
	// 		} else {
	// 			map.put(l.get(1), new HashSet<>(Set.of(l.get(0))));
	// 		}
	// 	}
	//
	// 	for (int i = 0; i < n; i++) {
	// 		if (visited[i]) {
	// 			continue;
	// 		}
	// 		visited[i] = true;
	// 		dfs(i, map, visited, res, new HashSet<Integer>(), -1);
	// 	}
	// 	return res;
	// }
	//
	// public static HashSet<Integer> dfs (Integer current, HashMap<Integer, HashSet<Integer>> map, boolean[] visited,
	//                                     List<List<Integer>> res, HashSet<Integer> visitedSet, int prev) {
	// 	HashSet<Integer> result = new HashSet<>();
	//
	// 	HashSet<Integer> st = map.get(current);
	// 	for (Integer i : st) {
	// 		if (i.intValue() == prev) {
	// 			continue;
	// 		}
	// 		if (visited[i.intValue()]) {
	// 			result.add(i);
	// 			continue;
	// 		}
	//
	// 		visited[i.intValue()] = true;
	// 		HashSet<Integer> v = new HashSet<Integer>();
	// 		for (Integer k : visitedSet) {
	// 			v.add(k);
	// 		}
	// 		v.add(current);
	// 		HashSet<Integer> temp = dfs(i, map, visited, res, v, current.intValue());
	//
	// 		boolean isCritical = true;
	// 		for (Integer j : temp) {
	// 			if (visitedSet.contains(j)) {
	// 				isCritical = false;
	// 			}
	// 			result.add(j);
	// 		}
	// 		if (temp.contains(current)) {
	// 			isCritical = false;
	// 		}
	// 		result.add(i);
	// 		if (isCritical || temp.isEmpty()) {
	// 			res.add(new ArrayList<>(Arrays.asList(current, i)));
	// 		}
	// 	}
	//
	// 	return result;
	// }

	// Time limit exceeded
	// public static List<List<Integer>> criticalConnections (int n, List<List<Integer>> connections) {
	// 	List<List<Integer>> res = new ArrayList<>();
	// 	boolean[][] critical = new boolean[n][n];
	// 	boolean[] visited;
	// 	HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
	//
	// 	for (List<Integer> l : connections) {
	// 		if (map.containsKey(l.get(0))) {
	// 			map.get(l.get(0)).add(l.get(1));
	// 		} else {
	// 			map.put(l.get(0), new HashSet<>(Set.of(l.get(1))));
	// 		}
	//
	// 		if (map.containsKey(l.get(1))) {
	// 			map.get(l.get(1)).add(l.get(0));
	// 		} else {
	// 			map.put(l.get(1), new HashSet<>(Set.of(l.get(0))));
	// 		}
	// 	}
	//
	// 	for (int i = 0; i < n; i++) {
	// 		visited = new boolean[n];
	// 		dfs(i, map, critical, visited, res, i, -1, 0);
	// 	}
	// 	return res;
	// }
	//
	// public static boolean dfs (Integer current, HashMap<Integer, HashSet<Integer>> map, boolean[][] critical,
	//                            boolean[] visited, List<List<Integer>> res, int start, int prev, int length) {
	// 	if (prev != -1 && current == start) {
	// 		return true;
	// 	}
	//
	// 	boolean hasCycle = false;
	// 	HashSet<Integer> st = map.get(current);
	// 	for (Integer i : st) {
	// 		if (critical[i][current]) {
	// 			continue;
	// 		}
	// 		if (length == 0) {
	// 			visited[start] = false;
	// 		}
	// 		if (visited[i] || i == prev) {
	// 			continue;
	// 		}
	//
	// 		visited[i] = true;
	// 		boolean _hasCycle = dfs(i, map, critical, visited, res, start, current, length + 1);
	// 		if (!_hasCycle && current == start && !critical[i][current]) {
	// 			critical[current][i] = true;
	// 			critical[i][current] = true;
	// 			res.add(new ArrayList<>(Arrays.asList(current, i)));
	// 			critical[current][i] = true;
	// 			critical[i][current] = true;
	// 		}
	// 		hasCycle = hasCycle || _hasCycle;
	// 	}
	// 	return hasCycle;
	// }
}