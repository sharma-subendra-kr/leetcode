// 717. 1-bit and 2-bit Characters
// https://leetcode.com/problems/1-bit-and-2-bit-characters/

class S717 {
	public static void main (String[] args) {
		int[] bits;

		bits = new int[]{1, 0, 0};
		bits = new int[]{1, 1, 1, 0};

		boolean res = isOneBitCharacter(bits);

		System.out.println(res);
	}

	public static boolean isOneBitCharacter (int[] bits) {
		for (int i = 0; i < bits.length; i++) {
			if (i == bits.length - 1) {
				return true;
			}
			if (bits[i] == 1) {
				i++;
			}
		}
		return false;
	}
}