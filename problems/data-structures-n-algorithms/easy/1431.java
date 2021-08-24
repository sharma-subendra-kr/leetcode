// 1431. Kids With the Greatest Number of Candies
// https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class S1431 {
	public static void main (String[] args) {
		int[] candles;
		int extraCandles;

		candles = new int[]{2, 3, 5, 1, 3};
		extraCandles = 3;

		candles = new int[]{4, 2, 1, 1, 2};
		extraCandles = 1;

		candles = new int[]{12, 1, 12};
		extraCandles = 10;

		List<Boolean> res = kidsWithCandies(candles, extraCandles);

		System.out.println(res);
	}

	public static List<Boolean> kidsWithCandies (int[] candies, int extraCandies) {
		ArrayList<Boolean> res = new ArrayList<>();
		int max = Arrays.stream(candies).max().getAsInt();

		for (int i = 0; i < candies.length; i++) {
			res.add(candies[i] + extraCandies >= max ? true : false);
		}
		return res;
	}
}