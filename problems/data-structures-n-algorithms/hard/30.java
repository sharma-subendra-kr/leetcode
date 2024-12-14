// 30. Substring with Concatenation of All Words
// https://leetcode.com/problems/substring-with-concatenation-of-all-words/

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

class S30 {
	public static void main (String[] args) {
		// String s = "barfoothefoobarman";
		// String[] words = new String[]{"foo", "bar"};
		// String s = "wordgoodgoodgoodbestword";
		// String[] words = new String[]{"word", "good", "best", "word"};
		// String s = "barfoofoobarthefoobarman";
		// String[] words = new String[]{"bar", "foo", "the"};
		// String s = "wordgoodgoodgoodbestword";
		// String[] words = new String[]{"word", "good", "best", "good"};
		// String s = "aaabbbc";
		// String[] words = new String[]{"a", "a", "b", "b", "c"};
		// String s = "abababab";
		// String[] words = new String[]{"a", "b", "a"};
		// String s = "aaaccccaab";
		// String[] words = new String[]{"cc", "cc"};
		// String s = "aaaaaaaaaaaaaaaaaaaa";
		// String[] words = new String[]{"a", "a", "a", "a", "a"};
		// String s = "a";
		// String[] words = new String[]{"a", "a"};
		// String s = "ababababab";
		// String[] words = new String[]{"ababa", "babab"};
		// String s = "aaaaaaaaaaaaaa";
		// String[] words = new String[]{"aa", "aa"};
		String s =
			"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
		String[] words =
			new String[]{"a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a",
			             "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a",
			             "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a",
			             "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a",
			             "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a",
			             "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a",
			             "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a",
			             "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a",
			             "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a",
			             "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a",
			             "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a",
			             "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a",
			             "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a",
			             "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a",
			             "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a",
			             "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a",
			             "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a",
			             "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a",
			             "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a",
			             "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a",
			             "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a",
			             "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a",
			             "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a",
			             "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a",
			             "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a"};

		List<Integer> res = findSubstring(s, words);
		res.forEach(o -> System.out.print(o + " "));
		System.out.println();
	}

	public static List<Integer> findSubstring (String s, String[] words) {
		List<Integer> res = new ArrayList<>();
		if (words.length == 0 || s.length() == 0) {
			return res;
		}

		int wslen = words.length;
		int wlen = words[0].length();
		int slen = s.length();
		HashMap<String, Integer> map = new HashMap<>();
		HashMap<String, Integer> wMap = new HashMap<>();

		for (int i = 0; i < wslen; i++) {
			Integer no = wMap.get(words[i]);
			if (no != null) {
				wMap.put(words[i], ++no);
			} else {
				wMap.put(words[i], 1);
			}
		}

		for (int i = 0; i < wlen; i++) {
			map.clear();
			for (int k = i; k < i + wslen * wlen && k + wlen <= slen; k += wlen) {
				String str = s.substring(k, k + wlen);
				Integer val = map.get(str);
				if (val != null) {
					map.put(str, ++val);
				} else {
					map.put(str, 1);
				}
			}
			int start = i - wlen;
			int end = i + ((wslen - 1) * wlen);
			while (end <= slen - wlen) {
				if (start < 0) {
					if (compare(wMap, map)) {
						res.add(start + wlen);
					}
				} else {
					String startStr = s.substring(start, start + wlen);
					String endStr = s.substring(end, end + wlen);

					Integer startVal = map.get(startStr);
					startVal--;
					map.put(startStr, startVal);
					Integer endVal = map.get(endStr);
					if (endVal != null) {
						endVal++;
					} else {
						endVal = 1;
					}
					map.put(endStr, endVal);

					if (compare(wMap, map)) {
						res.add(start + wlen);
					}
				}
				start += wlen;
				end += wlen;
			}
		}
		res.sort((a, b) -> a - b);
		return res;
	}

	public static boolean compare (HashMap<String, Integer> wMap, HashMap<String, Integer> map) {
		AtomicBoolean isSame = new AtomicBoolean(true);
		wMap.forEach((key, val) -> {
			if (map.get(key) == null || !map.get(key).equals(val)) {
				isSame.set(false);
			}
		});
		return isSame.get();
	}
}