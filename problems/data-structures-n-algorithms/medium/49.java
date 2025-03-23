// 49. Group Anagrams
// https://leetcode.com/problems/group-anagrams/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class S49 {
	public static int[] aMap = new int[26];

	public static void main (String args[]) {
		String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
		List<List<String>> res = groupAnagrams(strs);
		System.out.println(res);
	}

	public static String getAnagram (String str) {
		for (int i = 0; i < 26; i++) {
			aMap[i] = 0;
		}

		int len = str.length();
		for (int i = 0; i < len; i++) {
			aMap[str.charAt(i) - 'a']++;
		}

		return Arrays.toString(aMap);
	}

	public static List<List<String>> groupAnagrams (String[] strs) {
		List<List<String>> res = new ArrayList<>();
		HashMap<String, List<String>> map = new HashMap<>();

		int len = strs.length;
		String anagram;
		for (int i = 0; i < len; i++) {
			anagram = getAnagram(strs[i]);

			List<String> obj = map.get(anagram);
			if (obj == null) {
				obj = new ArrayList<>();
				map.put(anagram, obj);
			}
			obj.add(strs[i]);
		}
		map.values().forEach(o -> res.add(o));

		return res;
	}
}