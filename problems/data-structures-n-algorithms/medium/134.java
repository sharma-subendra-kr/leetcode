// 134. Gas Station
// https://leetcode.com/problems/gas-station/

class S134 {
	public static void main (String[] args) {
		// int[] gas = new int[]{1, 2, 3, 4, 5};
		// int[] cost = new int[]{3, 4, 5, 1, 2};
		// int[] gas = new int[]{2, 3, 4};
		// int[] cost = new int[]{3, 4, 3};
		// int[] gas = new int[]{3, 1, 1};
		// int[] cost = new int[]{1, 2, 2};
		// int[] gas = new int[]{0, 0, 0};
		// int[] cost = new int[]{0, 0, 0};
		int[] gas = new int[]{0, 0, 0, 2};
		int[] cost = new int[]{0, 0, 1, 0};

		int res = canCompleteCircuit(gas, cost);
		System.out.println(res);
	}

	public static int canCompleteCircuit (int[] gas, int[] cost) {
		int len = gas.length;
		int gasSum = 0;
		int costSum = 0;
		int diff = 0;
		int idx = -1;
		for (int i = 0; i < len; i++) {
			if (gas[i] - cost[i] + diff >= 0) {
				diff = diff + (gas[i] - cost[i]);
				if (idx == -1) {
					idx = i;
				}
			} else if (gas[i] < cost[i]) {
				gasSum += gas[i];
				costSum += cost[i];
				if (diff >= 0) {
					gasSum += diff;
					diff = 0;
					idx = -1;
				}
			}
		}
		if (diff + gasSum - costSum >= 0) {
			return idx;
		}
		return -1;
	}
}