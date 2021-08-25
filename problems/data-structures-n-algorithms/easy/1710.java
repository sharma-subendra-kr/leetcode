// 1710. Maximum Units on a Truck
// https://leetcode.com/problems/maximum-units-on-a-truck/

import java.util.Arrays;
import java.util.Comparator;

// use bucket sort for better performance
class S1710 {
	public static void main (String[] args) {
		int[][] boxTypes;
		int truckSize;

		// boxTypes = new int[][]{{1, 3}, {2, 2}, {3, 1}};
		// truckSize = 4;

		boxTypes = new int[][]{{5, 10}, {2, 5}, {4, 7}, {3, 9}};
		truckSize = 10;

		int res = maximumUnits(boxTypes, truckSize);

		System.out.println(res);
	}

	public static int maximumUnits (int[][] boxTypes, int truckSize) {
		Arrays.sort(boxTypes, new Comparator<int[]>() {
			@Override
			public int compare (int[] o1, int[] o2) {
				return o2[1] - o1[1];
			}
		});

		int sum = 0;
		int boxes = 0;
		int i = 0;
		while (boxes < truckSize && i < boxTypes.length) {
			if (boxTypes[i][0] <= truckSize - boxes) {
				sum += (boxTypes[i][0] * boxTypes[i][1]);
				boxes += boxTypes[i][0];
			} else {
				int num = truckSize - boxes;
				sum += num * boxTypes[i][1];
				boxes += num;
			}
			i++;
		}
		return sum;
	}
}