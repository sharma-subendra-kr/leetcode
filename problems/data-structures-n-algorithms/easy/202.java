// 202. Happy Number
// https://leetcode.com/problems/happy-number/

import java.util.HashSet;

class S202 {
	public static void main (String[] args) {
		// int n = 19;
		// int n = 2;
		int n = 10;
		boolean res = isHappy(n);
		System.out.println(res);
	}

	public static int getNext (int n) {
		int next = 0;
		while (n != 0) {
			int rem = n % 10;
			n /= 10;
			next += rem * rem;
		}
		return next;
	}

	public static boolean isHappy (int n) {
		int next = getNext(n);
		int nextNext = getNext(getNext(n));

		while (next != nextNext) {
			next = getNext(next);
			nextNext = getNext(getNext(nextNext));
			if (nextNext == 1) {
				return true;
			}
		}

		if (next == 1 && nextNext == 1) {
			return true;
		}
		return false;
	}

	// public static boolean isHappy (int n) {
	// 	int next = 0;
	// 	HashSet<Integer> set = new HashSet<>();
	//
	// 	while (n != 1) {
	// 		if (set.contains(n)) {
	// 			return false;
	// 		}
	// 		set.add(n);
	// 		while (n != 0) {
	// 			int rem = n % 10;
	// 			n /= 10;
	// 			next += rem * rem;
	// 		}
	// 		n = next;
	// 		next = 0;
	// 	}
	// 	return true;
	// }

}