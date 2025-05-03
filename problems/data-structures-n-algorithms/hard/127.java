// 127. Word Ladder
// https://leetcode.com/problems/word-ladder/

import java.util.*;

class S127 {
	public static void main (String[] args) {
		String beginWord = "hit";
		String endWord = "cog";
		// List<String> wordList = new ArrayList<>(Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
		List<String> wordList = new ArrayList<>(Arrays.asList("hot", "dot", "dog", "lot", "log"));
		// String beginWord = "a";
		// String endWord = "c";
		// List<String> wordList = new ArrayList<>(Arrays.asList("a", "b", "c"));
		// String beginWord = "hot";
		// String endWord = "dog";
		// List<String> wordList = new ArrayList<>(Arrays.asList("hot", "dog", "dot"));

		int res = ladderLength(beginWord, endWord, wordList);
		System.out.println(res);
	}

	public static int ladderLength (String beginWord, String endWord, List<String> wordList) {
		HashMap<String, Integer> map = new HashMap<>();
		Queue<String> queue = new LinkedList<>();
		Queue<Integer> intQueue = new LinkedList<>();
		int len = wordList.size();
		boolean[] visited = new boolean[len];
		int min = Integer.MAX_VALUE;

		for (int i = 0; i < wordList.size(); i++) {
			map.put(wordList.get(i), i);
		}

		if (map.containsKey(beginWord)) {
			visited[map.get(beginWord)] = true;
		}

		queue.add(beginWord);
		intQueue.add(1);
		char[] carr;
		while (!queue.isEmpty()) {
			String curr = queue.poll();
			int count = intQueue.poll();
			carr = curr.toCharArray();
			for (int i = 0; i < beginWord.length(); i++) {
				char currChar = carr[i];
				for (char j = 'a'; j <= 'z'; j++) {
					carr[i] = (char) j;
					String str = String.valueOf(carr);
					Integer idx = map.get(str);
					if (idx != null && !visited[idx]) {
						queue.add(str);
						intQueue.add(count + 1);
						visited[idx] = true;
						if (str.equals(endWord)) {
							return count + 1;
						}
					}
				}
				carr[i] = currChar;
			}
		}
		if (min == Integer.MAX_VALUE) {
			return 0;
		}
		return min;
	}

	// public static int ladderLength (String beginWord, String endWord, List<String> wordList) {
	// 	HashMap<String, Integer> map = new HashMap<>();
	// 	HashMap<String, Integer> depthMap = new HashMap<>();
	// 	int len = wordList.size();
	// 	boolean[] visited = new boolean[len];
	// 	int[] res = new int[]{Integer.MAX_VALUE};
	//
	// 	for (int i = 0; i < wordList.size(); i++) {
	// 		map.put(wordList.get(i), i);
	// 	}
	//
	// 	if (map.containsKey(beginWord)) {
	// 		visited[map.get(beginWord)] = true;
	// 		depthMap.put(beginWord, 1);
	// 	}
	//
	// 	dfs(beginWord, endWord, 1, visited, map, depthMap, res);
	//
	// 	if (res[0] == Integer.MAX_VALUE) {
	// 		return 0;
	// 	}
	// 	return res[0];
	// }
	//
	// public static void dfs (String curr, String endWord, int count, boolean[] visited, HashMap<String, Integer> map,
	//                         HashMap<String, Integer> depthMap,
	//                         int[] res) {
	// 	if (curr.equals(endWord)) {
	// 		if (res[0] > count) {
	// 			res[0] = count;
	// 		}
	// 		return;
	// 	}
	//
	// 	int len = curr.length();
	// 	char[] carr = curr.toCharArray();
	// 	for (int i = 0; i < len; i++) {
	// 		char currChar = carr[i];
	// 		for (char j = 'a'; j <= 'z'; j++) {
	// 			carr[i] = j;
	// 			String str = String.valueOf(carr);
	// 			Integer idx = map.get(str);
	// 			if (idx != null && !visited[idx]) {
	// 				if (depthMap.containsKey(str) && depthMap.get(str) <= count + 1) {
	// 					continue;
	// 				}
	// 				depthMap.put(str, count + 1);
	// 				visited[idx] = true;
	// 				dfs(str, endWord, count + 1, visited, map, depthMap, res);
	// 				visited[idx] = false;
	// 			}
	// 		}
	// 		carr[i] = currChar;
	// 	}
	// }
}