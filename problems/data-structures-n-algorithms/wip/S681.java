// 681. Next Closest Time
// https://leetcode.com/problems/next-closest-time/

// better use sorted sets to find next number
// find number in sorted set and get the next one

import java.util.Arrays;

class S681 {
	public static void main (String[] args) {
		String time;

		// time = "19:34";
		// time = "23:59";
		// time = "01:32";
		// time = "00:00";
		// time = "01:11";
		time = "18:42";

		String res = nextClosestTime(time);

		System.out.println(res);
	}

	public static int getNext (int[] arr, int n, int max, int min) {
		for (int i = 0; i < 4; i++) {
			if (arr[i] > n && arr[i] <= max) {
				return arr[i];
			}
		}
		return min;
	}

	public static int getNextFirstHr (int[] arr, int n, int min) {
		boolean hasLt2 = false;
		for (int i = 0; i < 4; i++) {
			if (arr[i] < 2) {
				hasLt2 = true;
			}
		}

		for (int i = 0; i < 4; i++) {
			if (arr[i] > n) {
				if (arr[i] > 4 && hasLt2 || arr[i] < 4) {
					return arr[i];
				}
			}
		}
		return min;
	}

	public static String nextClosestTime (String time) {
		int[] arr = new int[]{Character.getNumericValue(time.charAt(0)), Character.getNumericValue(time.charAt(1)),
		                      Character.getNumericValue(time.charAt(3)), Character.getNumericValue(time.charAt(4))};
		int[] sarr = arr.clone();
		Arrays.sort(sarr);
		int[] res = arr.clone();
		int min = Integer.MAX_VALUE;

		for (int i = 0; i < 4; i++) {
			if (arr[i] < min) {
				min = arr[i];
			}
		}

		for (int i = 3; i >= 0; i--) {
			if (i == 3) {
				res[3] = getNext(sarr, arr[3], 9, min);
			} else if (i == 2) {
				res[2] = getNext(sarr, arr[2], 5, min);
			} else if (i == 1) {
				res[1] = getNextFirstHr(sarr, arr[1], min);
			} else if (i == 0) {
				res[0] = getNext(sarr, arr[0], 2, min);
			}
			if (res[i] != arr[i] && res[i] != min) {
				break;
			}
		}

		return Integer.toString(res[0]) + Integer.toString(res[1]) + ":" + Integer.toString(res[2]) +
		       Integer.toString(res[3]);
	}
}
