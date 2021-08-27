// 1002. Find Common Characters
// https://leetcode.com/problems/find-common-characters/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class S1002 {
	public static void main (String args[]) {
		String[] words;

		words = new String[]{"bella", "label", "roller"};
		words = new String[]{"cool", "lock", "cook"};

		List<String> res = commonChars(words);

		System.out.println(res);
	}

	// use arrays instead of hashmap
	// public static List<String> commonChars (String[] words) {
	// 	HashMap<Character, Integer> commonMap = new HashMap<>();
	// 	HashMap<Character, Integer> map = new HashMap<>();
	//
	// 	if (words.length == 0) {
	// 		return new ArrayList<>();
	// 	}
	//
	// 	for (int j = 0; j < words[0].length(); j++) {
	// 		commonMap.put(words[0].charAt(j), commonMap.getOrDefault(words[0].charAt(j), 0) + 1);
	// 	}
	//
	// 	for (String str : words) {
	// 		map.clear();
	// 		for (int j = 0; j < str.length(); j++) {
	// 			map.put(str.charAt(j), map.getOrDefault(str.charAt(j), 0) + 1);
	// 		}
	// 		for (Character i : commonMap.keySet()) {
	// 			if (commonMap.get(i) > map.getOrDefault(i, 0)) {
	// 				commonMap.put(i, map.getOrDefault(i, 0));
	// 			} else {
	// 				commonMap.put(i, commonMap.getOrDefault(i, 0));
	// 			}
	// 		}
	// 	}
	//
	// 	ArrayList<String> res = new ArrayList<>();
	// 	for (Character c : commonMap.keySet()) {
	// 		int count = commonMap.get(c);
	// 		while (count != 0) {
	// 			res.add(c + "");
	// 			count--;
	// 		}
	// 	}
	// 	return res;
	// }

	public static List<String> commonChars (String[] words) {
		int[] commonMap = new int[26];
		int[] map = new int[26];

		if (words.length == 0) {
			return new ArrayList<>();
		}

		for (int j = 0; j < words[0].length(); j++) {
			int index = words[0].charAt(j) - 'a';
			commonMap[index] = commonMap[index] + 1;
		}

		for (String str : words) {
			for (int j = 0; j < str.length(); j++) {
				int index = str.charAt(j) - 'a';
				map[index] = map[index] + 1;
			}
			for (int i = 0; i < 26; i++) {
				commonMap[i] = Integer.min(commonMap[i], map[i]);
				map[i] = 0;
			}
		}

		ArrayList<String> res = new ArrayList<>();
		for (int i = 0; i < 26; i++) {
			int count = commonMap[i];
			while (count != 0) {
				res.add((char) (i + 'a') + "");
				count--;
			}
		}
		return res;
	}
}