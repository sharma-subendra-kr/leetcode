// 1122. Relative Sort Array
// https://leetcode.com/problems/relative-sort-array/

import java.util.*;
import java.util.stream.Collectors;

class S1122 {

	public static void main (String[] args) {
		int[] arr1;
		int[] arr2;

		arr1 = new int[]{2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
		arr2 = new int[]{2, 1, 4, 3, 9, 6};

		arr1 = new int[]{28, 6, 22, 8, 44, 17};
		arr2 = new int[]{22, 28, 8, 6};

		int[] res = relativeSortArray(arr1, arr2);

		for (int i : res) {
			System.out.println(i);
		}
	}

	public static int[] relativeSortArray (int[] arr1, int[] arr2) {
		HashMap<Integer, Integer> map = new HashMap<>();

		for (int i : arr1) {
			if (map.containsKey(i)) {
				map.put(i, map.get(i) + 1);
			} else {
				map.put(i, 1);
			}
		}
		int iter = 0;
		for (int i : arr2) {
			int count = map.get(i);
			while (count != 0) {
				arr1[iter++] = i;
				count--;
			}
			map.remove(i);
		}
		List<Integer> remaining = map.keySet().stream().collect(Collectors.toList());
		Collections.sort(remaining);

		for (Integer i : remaining) {
			int count = map.get(i);
			while (count != 0) {
				arr1[iter++] = i;
				count--;
			}
			map.remove(i);
		}
		return arr1;
	}
}