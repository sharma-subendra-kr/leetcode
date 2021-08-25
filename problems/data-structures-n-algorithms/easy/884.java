// 884. Uncommon Words from Two Sentences
// https://leetcode.com/problems/uncommon-words-from-two-sentences/

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

class S884 {
	public static void main (String[] args) {
		String s1, s2;

		s1 = "this apple is sweet";
		s2 = "this apple is sour";

		s1 = "apple apple";
		s2 = "banana";

		s1 = "abcd def abcd xyz";
		s2 = "ijk def ijk";

		String[] res = uncommonFromSentences(s1, s2);

		System.out.println(Arrays.asList(res));
	}

	public static String[] uncommonFromSentences (String s1, String s2) {
		HashMap<String, Integer> hashMap = new HashMap<>();

		String[] s1arr = s1.split(" ");
		String[] s2arr = s2.split(" ");

		for (String str : s1arr) {
			hashMap.put(str, hashMap.getOrDefault(str, 0) + 1);
		}
		for (String str : s2arr) {
			hashMap.put(str, hashMap.getOrDefault(str, 0) + 1);
		}

		return hashMap.entrySet().stream().filter(item -> item.getValue() == 1).map(item -> item.getKey())
		              .toArray(String[]::new);
	}
}