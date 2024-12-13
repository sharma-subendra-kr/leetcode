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
		String s = "aaaaaaaaaa";
		String[] words = new String[]{"a", "a", "a", "a", "a"};

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
		int[] memo = new int[slen];
		List<HashMap<String, Integer>> mapMemo = new ArrayList<>(Collections.nCopies(slen, null));

		Arrays.fill(memo, -1);

		HashMap<String, Integer> wMap = new HashMap<>();

		for (int i = 0; i < wslen; i++) {
			Integer no = wMap.get(words[i]);
			if (no != null) {
				wMap.put(words[i], ++no);
			} else {
				wMap.put(words[i], 1);
			}

		}

		for (int i = 0; i <= slen - wlen * wslen; i++) {
			int count = 0;
			HashMap<String, Integer> map = new HashMap<>();
			for (int j = i + (wslen - 1) * wlen; j >= i; j -= wlen) {
				String str = s.substring(j, j + wlen);
				Integer wMapVal = wMap.get(str);
				Integer mapVal = map.get(str);
				if (memo[j] != -1 && memo[i] == wslen - count) {
					HashMap<String, Integer> begin = mapMemo.get(i);
					HashMap<String, Integer> part = mapMemo.get(j + wlen);
					AtomicBoolean ok = new AtomicBoolean(true);
					wMap.forEach((key, val) -> {
						if (!begin.containsKey(key) || !part.containsKey(key) || begin.get(key) + part.get(key) != val) {
							ok.set(false);
						}
					});
					if (ok.get()) {
						count = wslen;
						map = begin;
						break;
					}
				}
				if (wMapVal != null && (mapVal == null || mapVal < wMapVal)) {
					map.put(str, mapVal == null ? 1 : ++mapVal);
					memo[j] = ++count;
					mapMemo.set(j, map);
				} else if (wMap.containsKey(str)) {
					mapMemo.set(j, new HashMap<>());
					count = 0;
					map.put(str, 1);
					memo[j] = ++count;
				}
			}

			if (count == wslen) {
				res.add(i);

				String str2 = s.substring(i, i + wlen);
				Integer v = map.get(str2);
				if (v != null) {
					v--;
					map.put(str2, v);
				}
			}
		}
		return res;
	}
}