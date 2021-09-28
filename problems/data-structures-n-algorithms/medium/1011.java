// 1011. Capacity To Ship Packages Within D Days
// https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/

import java.util.Arrays;
import java.util.Comparator;

class S1011 {
	public static void main (String[] args) {
		int[] weights;
		int days;

		weights = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		days = 5;
		weights = new int[]{3, 2, 2, 4, 1, 4};
		days = 3;
		weights = new int[]{1, 2, 3, 1, 1};
		days = 4;
		weights =
			new int[]{498, 78, 152, 317, 349, 450, 429, 328, 33, 409, 287, 446, 88, 87, 155, 395, 13, 383, 89, 145, 274, 164,
			          430, 181, 113, 397, 273, 361, 279, 496, 271, 448, 420, 494};
		days = 1;
		weights =
			new int[]{361, 321, 186, 186, 67, 283, 36, 471, 304, 218, 60, 78, 149, 166, 282, 384, 61, 242, 426, 275, 236, 221,
			          27, 261, 487, 90, 468, 19, 453, 241};
		days = 15;

		int res = shipWithinDays(weights, days);

		System.out.println(res);
	}

	public static int shipWithinDays (int[] weights, int days) {
		int[] weightSum = new int[weights.length];
		int max = weights[0];
		weightSum[0] = weights[0];
		for (int i = 1; i < weights.length; i++) {
			weightSum[i] = weightSum[i - 1] + weights[i];
			if (weights[i] > max) {
				max = weights[i];
			}
		}

		while (!isCapacityPossible(max, weightSum, days)) {
			max++;
		}

		return max;
	}

	public static boolean isCapacityPossible (int capacity, int[] weightSum, int days) {
		int count = 0;
		int searchCapacity = capacity;
		int index = 0;
		while (count < days) {
			index = search(searchCapacity, weightSum);
			searchCapacity = weightSum[index] + capacity;
			count++;
		}

		return index == weightSum.length - 1;
	}

	public static int search (int capacity, int[] weightSum) {
		int low = 0;
		int high = weightSum.length - 1;

		while (low < high) {
			int mid = (high + low) / 2;
			if (weightSum[mid] > capacity) {
				high = mid - 1;
			} else if (weightSum[mid] < capacity) {
				low = mid + 1;
			} else {
				return mid;
			}
		}
		return weightSum[low] > capacity ? low - 1 : low;
	}
}