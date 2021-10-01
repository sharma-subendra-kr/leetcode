// 1152. Analyze User Website Visit Pattern
// https://leetcode.com/problems/analyze-user-website-visit-pattern/

import java.util.*;

class S1152 {

	public static void main (String[] args) {
		String[] username;
		int[] timestamp;
		String[] website;

		username = new String[]{"joe", "joe", "joe", "james", "james", "james", "james", "mary", "mary", "mary"};
		timestamp = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		website = new String[]{"home", "about", "career", "home", "cart", "maps", "home", "home", "about", "career"};

		// username = new String[]{"ua", "ua", "ua", "ub", "ub", "ub"};
		// timestamp = new int[]{1, 2, 3, 4, 5, 6};
		// website = new String[]{"a", "b", "a", "a", "b", "c"};

		// username = new String[]{"zkiikgv", "zkiikgv", "zkiikgv", "zkiikgv"};
		// timestamp = new int[]{436363475, 710406388, 386655081, 797150921};
		// website = new String[]{"wnaaxbfhxp", "mryxsjc", "oz", "wlarkzzqht"};

		// username = new String[]{"h", "eiy", "cq", "h", "cq", "txldsscx", "cq", "txldsscx", "h", "cq", "cq"};
		// timestamp =
		// 	new int[]{527896567, 334462937, 517687281, 134127993, 859112386, 159548699, 51100299, 444082139, 926837079,
		// 	          317455832, 411747930};
		// website = new String[]{"hibympufi", "hibympufi", "hibympufi", "hibympufi", "hibympufi", "hibympufi", "hibympufi",
		//                        "hibympufi", "yljmntrclw", "hibympufi", "yljmntrclw"};

		List<String> mostVisited = mostVisitedPattern(username, timestamp, website);

		for (String str : mostVisited) {
			System.out.println(str);
		}
	}

	public static List<String> mostVisitedPattern (String[] username, int[] timestamp, String[] website) {
		HashMap<String, ArrayList<Data>> map = new HashMap<>();
		for (int i = 0; i < username.length; i++) {
			Data data = new Data(timestamp[i], website[i]);
			ArrayList<Data> temp = map.getOrDefault(username[i], new ArrayList<>());
			temp.add(data);
			map.put(username[i], temp);
		}

		HashMap<String, Integer> mp = new HashMap<>();
		int max = 0;
		for (String key : map.keySet()) {
			ArrayList<Data> data = map.get(key);
			Collections.sort(data, new Comparator<Data>() {
				@Override
				public int compare (Data o1, Data o2) {
					return o1.timeStamp - o2.timeStamp;
				}
			});
			HashSet<String> set = new HashSet<>();
			for (int i = 0; i < data.size(); i++) {
				for (int j = i + 1; j < data.size(); j++) {
					for (int k = j + 1; k < data.size(); k++) {
						String key2 = data.get(i).website + "," + data.get(j).website + "," + data.get(k).website;
						set.add(key2);
					}
				}
			}
			for (String k : set) {
				mp.put(k, mp.getOrDefault(k, 0) + 1);
				if (mp.get(k) > max) {
					max = mp.get(k);
				}
			}
		}

		String min = "";
		for (String key : mp.keySet()) {
			if (mp.get(key) == max) {
				if (min.length() == 0) {
					min = key;
					continue;
				}
				if (min.compareToIgnoreCase(key) > 0) {
					min = key;
				}
			}
		}

		return new ArrayList<>(Arrays.asList(min.split(",")));
	}

	static class Data {
		int timeStamp;
		String website;

		Data (int timeStamp, String website) {
			this.timeStamp = timeStamp;
			this.website = website;
		}
	}
}