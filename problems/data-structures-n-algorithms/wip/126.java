// 126. Word Ladder II
// https://leetcode.com/problems/word-ladder-ii/

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

class S126 {
	public static void main (String[] args) {
		String beginWord, endWord;
		List<String> wordList;

		beginWord = "hit";
		endWord = "cog";
		wordList = new ArrayList<>(Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));

		List<List<String>> res = findLadders(beginWord, endWord, wordList);

		for (List<String> list : res) {
			for (String str : list) {
				System.out.print(str + ",");
			}
			System.out.println();
		}
	}

	// Time limit exceeded - 19 cases passed
	// public static List<List<String>> findLadders (String beginWord, String endWord, List<String> wordList) {
	// 	List<List<String>> result = new ArrayList<>();
	// 	AtomicInteger minLength = new AtomicInteger(Integer.MAX_VALUE);
	//
	// 	for (int i = 0; i < wordList.size(); i++) {
	// 		if (compareString(beginWord, wordList.get(i))) {
	// 			LinkedHashSet<String> set = new LinkedHashSet<>();
	// 			set.add(beginWord);
	// 			dfs(endWord, wordList, set, i, result, minLength);
	// 		}
	// 	}
	//
	// 	return result.stream().filter(item -> item.size() == minLength.get()).collect(Collectors.toList());
	// }
	//
	// public static boolean compareString (String a, String b) {
	// 	if (a.length() != b.length()) {
	// 		return false;
	// 	}
	// 	int count = 0;
	// 	for (int i = 0; i < a.length(); i++) {
	// 		if (a.charAt(i) != b.charAt(i)) {
	// 			count++;
	// 		}
	// 	}
	// 	return count == 1 ? true : false;
	// }
	//
	// public static void dfs (String endWord, List<String> wordList, LinkedHashSet<String> set,
	//                         int current, List<List<String>> result, AtomicInteger minLength) {
	// 	if (minLength.get() == set.size()) {
	// 		return;
	// 	}
	// 	if (wordList.get(current).equalsIgnoreCase(endWord)) {
	// 		set.add(wordList.get(current));
	// 		List<String> temp = set.stream().collect(Collectors.toList());
	// 		if (temp.size() <= minLength.get()) {
	// 			minLength.set(temp.size());
	// 			result.add(temp);
	// 		}
	// 		return;
	// 	}
	//
	// 	for (int i = 0; i < wordList.size(); i++) {
	// 		if (!set.contains(wordList.get(i)) && compareString(wordList.get(current), wordList.get(i))) {
	// 			LinkedHashSet<String> temp = new LinkedHashSet<>();
	// 			temp.addAll(set);
	// 			temp.add(wordList.get(current));
	// 			dfs(endWord, wordList, temp, i, result, minLength);
	// 		}
	// 	}
	// }

	// Time limit exceeded - 21 cases passed
	// public static List<List<String>> findLadders (String beginWord, String endWord, List<String> wordList) {
	// 	List<List<String>> result = new ArrayList<>();
	// 	AtomicInteger minLength = new AtomicInteger(Integer.MAX_VALUE);
	//
	// 	LinkedHashSet<String> set = new LinkedHashSet<>();
	// 	set.add(beginWord);
	// 	dfs(endWord, wordList, set, beginWord, result, minLength);
	//
	// 	return result.stream().filter(item -> item.size() == minLength.get()).collect(Collectors.toList());
	// }
	//
	// public static boolean compareString (String a, String b) {
	// 	if (a.length() != b.length()) {
	// 		return false;
	// 	}
	// 	int count = 0;
	// 	for (int i = 0; i < a.length(); i++) {
	// 		if (a.charAt(i) != b.charAt(i)) {
	// 			count++;
	// 		}
	// 	}
	// 	return count == 1 ? true : false;
	// }
	//
	// public static void dfs (String endWord, List<String> wordList, LinkedHashSet<String> set,
	//                         String prev, List<List<String>> result, AtomicInteger minLength) {
	// 	if (minLength.get() == set.size()) {
	// 		return;
	// 	}
	//
	// 	boolean flag = false;
	// 	ArrayList<String> level = new ArrayList<>();
	// 	for (int i = 0; i < wordList.size(); i++) {
	// 		if (!set.contains(wordList.get(i)) && compareString(prev, wordList.get(i))) {
	// 			if (wordList.get(i).equalsIgnoreCase(endWord)) {
	// 				flag = true;
	// 				set.add(wordList.get(i));
	// 				List<String> temp = set.stream().collect(Collectors.toList());
	// 				result.add(temp);
	// 				minLength.set(set.size());
	// 			} else {
	// 				level.add(wordList.get(i));
	// 			}
	// 		}
	// 	}
	//
	// 	if (flag == true) {
	// 		return;
	// 	}
	//
	// 	for (String str : level) {
	// 		LinkedHashSet<String> temp = new LinkedHashSet<>();
	// 		temp.addAll(set);
	// 		temp.add(str);
	// 		dfs(endWord, wordList, temp, str, result, minLength);
	// 	}
	// }

	public static List<List<String>> findLadders (String beginWord, String endWord, List<String> wordList) {
		List<List<String>> result = new ArrayList<>();
		LinkedBlockingQueue<ArrayList<String>> queue = new LinkedBlockingQueue<>();
		HashSet<String> set = new HashSet<>(wordList);
		int minLen = Integer.MAX_VALUE;

		queue.offer(new ArrayList<>(Arrays.asList(beginWord)));

		while (!queue.isEmpty()) {
			ArrayList<String> current = queue.poll();
			String top = current.get(current.size() - 1);

			if (current.size() >= minLen) {
				break;
			}

			for (int i = 0; i < top.length(); i++) {
				StringBuffer str = new StringBuffer(top);
				for (int j = 0; j < 26; j++) {
					str.setCharAt(i, (char) ('a' + j));
					String tempStr = str.toString();
					if (set.contains(tempStr) && !tempStr.equalsIgnoreCase(top)) {
						ArrayList<String> temp = new ArrayList<>(current);
						temp.add(tempStr);
						queue.offer(temp);
						if (tempStr.equalsIgnoreCase(endWord) && temp.size() <= minLen) {
							result.add(temp);
							minLen = temp.size();
						}
					}
				}
			}
			set.remove(top);
		}
		return result;
	}
}