// 274. H-Index
// https://leetcode.com/problems/h-index/

import java.util.Arrays;
import java.util.Collections;

class S274 {
	public static void main (String[] args) {
		int[] citations = new int[]{3, 0, 6, 1, 5};
		// int[] citations = new int[]{1, 3, 1};
		// int[] citations = new int[]{100};
		int res = hIndex(citations);
		System.out.println(res);
	}

	public static int hIndex (int[] citations) {
		int len = citations.length;
		Arrays.sort(citations);
		int count = 0;
		for (int i = len - 1; i >= 0; i--) {
			if (citations[i] > count) {
				count++;
			}
		}
		return count;
	}
}