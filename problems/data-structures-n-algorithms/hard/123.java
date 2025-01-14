// 123. Best Time to Buy and Sell Stock III
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/

class S123 {
	public static void main (String args[]) {
		// int[] prices = new int[]{3,3,5,0,0,3,1,4};
		int[] prices = new int[]{1,2,3,4,5};

		int res = maxProfit(prices);
		System.out.println(res);
	}

	public static int maxProfit(int[] prices) {
		int len = prices.length;
		int firstBuy = Integer.MAX_VALUE, secondBuy = Integer.MAX_VALUE;
		int firstProfit = 0, secondProfit = 0;
		for (int i =0; i < len; i++) {
			firstBuy = Math.min(prices[i] ,firstBuy);
			firstProfit = Math.max(firstProfit, prices[i] - firstBuy);
			secondBuy = Math.min(secondBuy, prices[i] - firstProfit);
			secondProfit = Math.max(secondProfit, prices[i] - secondBuy);
		}
		return secondProfit;
	}
}