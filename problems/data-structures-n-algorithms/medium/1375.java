// 1375. Bulb Switcher III
// https://leetcode.com/problems/bulb-switcher-iii/

class S1375 {

	public static void main (String[] args) {
		int[] light;

		light = new int[]{2, 1, 3, 5, 4};
		light = new int[]{3, 2, 4, 1, 5};
		light = new int[]{4, 1, 2, 3};
		light = new int[]{2, 1, 4, 3, 6, 5};
		light = new int[]{1, 2, 3, 4, 5, 6};

		int res = numTimesAllBlue(light);

		System.out.println(res);
	}

	public static int numTimesAllBlue (int[] light) {
		int left = 0;
		int right = 0;
		int[] on = new int[light.length];
		int count = 0;

		for (int i = 0; i < light.length; i++) {
			int l = light[i] - 1;
			on[l] = 1;
			if (l > right) {
				right = l;
			}

			boolean decr = false;
			while (left < light.length && on[left] != 0) {
				left++;
				decr = true;
			}
			if (decr) {
				left--;
			}

			if (left == right) {
				count++;
			}
		}

		return count;
	}
}