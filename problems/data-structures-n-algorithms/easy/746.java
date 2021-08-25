// 746. Min Cost Climbing Stairs
// https://leetcode.com/problems/min-cost-climbing-stairs/

class S746 {
	public static void main (String[] args) {
		int[] cost;

		cost = new int[]{10, 15, 20};
		// cost = new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
		// cost = new int[]{0, 2, 2, 1};

		int res = minCostClimbingStairs(cost);

		System.out.println(res);
	}

	public static int minCostClimbingStairs (int[] cost) {
		if (cost.length == 0) {
			return 0;
		} else if (cost.length == 1) {
			return 1;
		} else if (cost.length == 2) {
			return Integer.min(cost[0], cost[1]);
		}
		int sum = 0;
		int[] arr = new int[]{cost[0], cost[1]};
		for (int i = 2; i < cost.length; i++) {
			sum = cost[i] + Integer.min(arr[0], arr[1]);
			arr[0] = arr[1];
			arr[1] = sum;
		}
		return Integer.min(arr[0], arr[1]);
	}
}