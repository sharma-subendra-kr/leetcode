// 683. K Empty Slots
// https://leetcode.com/problems/k-empty-slots/

class S683 {
	public static void main (String[] args) {
		int[] bulbs;
		int k;

		bulbs = new int[]{1, 3, 2};
		k = 1;
		bulbs = new int[]{1, 2, 3};
		k = 1;

		int res = kEmptySlots(bulbs, k);

		System.out.println(res);

	}

	public static int kEmptySlots (int[] bulbs, int k) {
		int[] daysMap = new int[bulbs.length];

		for (int i = 0; i < bulbs.length; i++) {
			daysMap[bulbs[i] - 1] = i + 1;
		}

		int res = Integer.MAX_VALUE;
		int left = 0;
		int right = k + 1;
		for (int i = 0; right < bulbs.length; i++) {
			if (daysMap[i] < daysMap[left] || daysMap[i] <= daysMap[right]) {
				if (i == right) {
					res = Math.min(Math.max(daysMap[left], daysMap[right]), res);
				}
				left = i;
				right = i + k + 1;
			}
		}
		return res == Integer.MAX_VALUE ? -1 : res;
	}
}