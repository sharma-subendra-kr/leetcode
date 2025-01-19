// 135. Candy
// https://leetcode.com/problems/candy/

class S135 {
	public static void main (String[] args) {
		int[] ratings = new int[]{1, 0, 2};
		// int[] ratings = new int[]{1, 2, 2};
		// int[] ratings = new int[]{1, 3, 2, 2, 1}; // 7
		// int[] ratings = new int[]{1, 2, 87, 87, 87, 2, 1}; // 13
		// int[] ratings = new int[]{1, 6, 10, 8, 7, 3, 2}; // 18
		// int[] ratings = new int[]{1, 3, 4, 5, 2}; // 11
		int res = candy(ratings);
		System.out.println(res);
	}

	public static int candy (int[] ratings) {
		int len = ratings.length;
		int prev = 0;
		int sum = 0;
		int[] cache = new int[len];

		if (len == 0) {
			return 0;
		} else if (len == 1) {
			return 1;
		}

		cache[len - 1] = 0;
		for (int i = len - 2; i >= 0; i--) {
			if (ratings[i] > ratings[i + 1]) {
				cache[i] = cache[i + 1] + 1;
			} else {
				cache[i] = 0;
			}
		}

		for (int i = 0; i < len; i++) {
			if (cache[i] != 0) {
				if (i > 0 && ratings[i - 1] < ratings[i]) {
					prev = Math.max(prev + 1, cache[i] + 1);
				} else {
					prev = cache[i] + 1;
				}
				sum += prev;
			} else if (i > 0 && ratings[i - 1] < ratings[i]) {
				sum += ++prev;
			} else {
				prev = 1;
				sum += prev;
			}
		}

		return sum;
	}

}