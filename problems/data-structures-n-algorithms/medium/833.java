// 833. Find And Replace in String
// https://leetcode.com/problems/find-and-replace-in-string/

import java.util.Arrays;
import java.util.Comparator;

class S833 {

	public static void main (String[] args) {
		String s;
		int[] indices;
		String[] sources, targets;

		s = "abcd";
		indices = new int[]{0, 2};
		sources = new String[]{"a", "cd"};
		targets = new String[]{"eee", "ffff"};
		// s = "abcd";
		// indices = new int[]{0, 2};
		// sources = new String[]{"ab", "ec"};
		// targets = new String[]{"eee", "ffff"};

		String res = findReplaceString(s, indices, sources, targets);

		System.out.println(res);
	}

	public static String findReplaceString (String s, int[] indices, String[] sources, String[] targets) {
		StringBuffer sb = new StringBuffer();

		int sorted[][] = new int[indices.length][];
		for (int i = 0; i < indices.length; i++) {
			sorted[i] = new int[]{indices[i], i};
		}
		Arrays.sort(sorted, new Comparator<int[]>() {
			@Override
			public int compare (int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});

		int si = 0;
		for (int i = 0; i < s.length(); ) {
			if (si < sorted.length && i == sorted[si][0]) {
				String str = s.substring(i, i + sources[sorted[si][1]].length());
				if (str.equals(sources[sorted[si][1]])) {
					sb.append(targets[sorted[si][1]]);
					i += str.length();
					si++;
					continue;
				}
				si++;
			}
			sb.append(s.charAt(i));
			i++;
		}
		return sb.toString();
	}

	// This solution is very very slow, have to use StringBuffer
	// public static String findReplaceString (String s, int[] indices, String[] sources, String[] targets) {
	// 	int sorted[][] = new int[indices.length][];
	// 	for (int i = 0; i < indices.length; i++) {
	// 		sorted[i] = new int[]{indices[i], i};
	// 	}
	// 	Arrays.sort(sorted, new Comparator<int[]>() {
	// 		@Override
	// 		public int compare (int[] o1, int[] o2) {
	// 			return o2[0] - o1[0];
	// 		}
	// 	});
	//
	// 	for (int i = 0; i < indices.length; i++) {
	// 		int idx = sorted[i][0];
	// 		String str = s.substring(idx, idx + sources[sorted[i][1]].length());
	// 		if (str.equals(sources[sorted[i][1]])) {
	// 			s = s.substring(0, idx) + targets[sorted[i][1]] + s.substring(idx + str.length());
	// 		}
	// 	}
	// 	return s;
	// }
}