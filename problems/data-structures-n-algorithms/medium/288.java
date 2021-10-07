// 288. Unique Word Abbreviation
// https://leetcode.com/problems/unique-word-abbreviation/

import java.util.HashMap;
import java.util.HashSet;

class ValidWordAbbr {
	HashMap<String, String> map;

	public ValidWordAbbr (String[] dictionary) {
		map = new HashMap<>();
		for (String str : dictionary) {
			String abbreviation = getAbbreviation(str);
			if (map.containsKey(abbreviation) && str.length() > 2) {
				map.put(abbreviation, "");
				continue;
			}
			map.put(abbreviation, str);
		}
	}

	public static String getAbbreviation (String str) {
		if (str.length() <= 2) {
			return str;
		}
		return str.substring(0, 1) + (str.length() - 2 + "") + str.substring(str.length() - 1);
	}

	public boolean isUnique (String word) {
		String abbreviation = getAbbreviation(word);

		if (map.containsKey(abbreviation)) {
			if (map.getOrDefault(abbreviation, "").equals(word)) {
				return true;
			}
			return false;
		}
		return true;
	}
}