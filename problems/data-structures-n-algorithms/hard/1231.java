// 1231. Divide Chocolate
// https://leetcode.com/problems/divide-chocolate/

class S1231 {
	public static void main (String[] args) {
		int[] sweetness;
		int k;

		sweetness = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
		k = 5;
		sweetness = new int[]{5, 6, 7, 8, 9, 1, 2, 3, 4};
		k = 8;
		sweetness = new int[]{1, 2, 2, 1, 2, 2, 1, 2, 2};
		k = 2;
		sweetness = new int[]{90670, 55382, 95298, 95795, 73204, 41464, 18675, 30104, 47442, 55307};
		k = 6;
		sweetness =
			new int[]{87002, 22650, 61737, 4432, 87341, 67643, 13454, 83823, 87836, 2978, 99313, 82797, 77350, 55994, 31403,
			          73836, 54451, 54807, 60146, 72381, 7271, 37633, 32603, 33752, 78004, 76288, 94608, 3516, 98287, 16577,
			          36186, 40401, 70733, 35764, 76303, 74279, 18351, 74113, 26480, 64253, 49402, 47512, 37185, 42488, 43068,
			          3542, 55773, 91365, 86770, 52915};
		k = 3;
		sweetness =
			new int[]{93138, 60229, 11179, 91723, 85722, 58195, 95146, 85049, 33816, 96902, 90688, 49428, 12942, 92258, 79248,
			          34754, 84744, 36020, 92601, 27208, 28080, 47608, 56185, 30986, 99000, 75061, 86087, 81803, 49219, 97866,
			          40688, 45222, 13997, 38184, 93314, 39449, 11014, 45643, 34874, 12590, 92531, 41891, 4581, 19342, 4254,
			          65419, 74418, 37309, 72577, 29710, 70849, 48726, 4065, 8711, 65258, 66877, 61625, 2362, 78453, 44042,
			          15437, 69222, 53745, 18492, 34470, 95699, 14178, 24256, 86504, 63646, 34805, 84171, 30979, 784, 35720,
			          4666, 86966, 82187, 44100, 75253, 60649, 96874, 55457, 76446, 53927, 45725, 11740, 12169, 70093, 89884,
			          98535, 44881, 94654, 70810, 56558, 43993, 26318, 86350, 42786, 26313};
		k = 81;

		int res = maximizeSweetness(sweetness, k);

		System.out.println(res);

	}

	public static int maximizeSweetness (int[] sweetness, int k) {
		int left = Integer.MAX_VALUE;
		int right = 0;
		k += 1;

		for (int i = 0; i < sweetness.length; i++) {
			left = Math.min(left, sweetness[i]);
			right += sweetness[i];
		}

		int maxSum = Integer.MIN_VALUE;
		while (left <= right) {
			int mid = (left + right) / 2;

			int sum = 0;
			int count = 0;
			int minSum = Integer.MAX_VALUE;
			for (int i = 0; i < sweetness.length; i++) {
				sum += sweetness[i];
				if (sum >= mid) {
					minSum = Math.min(sum, minSum);
					sum = 0;
					count++;
				}
			}

			if (count < k) {
				right = mid - 1;
			} else if (count >= k) {
				left = mid + 1;
			}

			if (count >= k) {
				maxSum = Math.max(minSum, maxSum);
			}
		}
		return maxSum;
	}
}