// 393. UTF-8 Validation
// https://leetcode.com/problems/utf-8-validation/

import java.util.Arrays;

class S393 {
	public static void main (String[] args) {
		int[] data;
		data = new int[]{197, 130, 1};
		data = new int[]{235, 140, 4};
		data = new int[]{255};
		data = new int[]{230, 136, 145};
		data = new int[]{145};
		data = new int[]{250, 145, 145, 145, 145};

		boolean res = validUtf8(data);

		System.out.println(res);
	}

	public static boolean validUtf8 (int[] data) {
		int shouldBeMultiByte = 0;
		for (int i = 0; i < data.length; i++) {
			if (shouldBeMultiByte == 0) {
				if (data[i] >> 5 == 0b110) {
					shouldBeMultiByte = 1;
				} else if (data[i] >> 4 == 0b1110) {
					shouldBeMultiByte = 2;
				} else if (data[i] >> 3 == 0b11110) {
					shouldBeMultiByte = 3;
				} else if (data[i] >> 7 == 0b1) {
					return false;
				}
			} else {
				if (data[i] >> 6 == 0b10 && shouldBeMultiByte > 0) {
					shouldBeMultiByte--;
				} else if (shouldBeMultiByte > 0) {
					return false;
				}
			}
		}
		return shouldBeMultiByte == 0;
	}

	// public static boolean validUtf8 (int[] data) {
	// 	int[] bits = new int[8];
	// 	int shouldBeMultiByte = 0;
	// 	for (int i = 0; i < data.length; i++) {
	// 		Arrays.fill(bits, 0);
	// 		bits = getBits(data[i], bits);
	// 		if (shouldBeMultiByte > 0) {
	// 			if (isOneByte(bits)) {
	// 				return false;
	// 			} else {
	// 				shouldBeMultiByte--;
	// 			}
	// 		} else if (shouldBeMultiByte == 0 && !isOneByte(bits)) {
	// 			shouldBeMultiByte = getMultiByteCount(bits);
	// 			if (shouldBeMultiByte > 4 || shouldBeMultiByte == 1) {
	// 				return false;
	// 			}
	// 			shouldBeMultiByte--;
	// 		}
	// 	}
	// 	return shouldBeMultiByte > 0 ? false : true;
	// }
	//
	// public static int getMultiByteCount (int[] bits) {
	// 	int i = 7;
	// 	while (i >= 0 && bits[i] != 0) i--;
	// 	return 7 - i;
	// }
	//
	// public static boolean isOneByte (int[] bits) {
	// 	if (bits[7] == 0) {
	// 		return true;
	// 	}
	// 	return false;
	// }
	//
	// public static int[] getBits (int num, int[] bits) {
	// 	int i = 0;
	// 	while (num > 0) {
	// 		int rem = num % 2;
	// 		num = num >> 1;
	// 		bits[i++] = rem;
	// 	}
	// 	return bits;
	// }
}