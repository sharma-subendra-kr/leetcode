// 496. Next Greater Element I
// https://leetcode.com/problems/next-greater-element-i/

class S496 {
	public static void main (String args[]) {
		int[] nums1, nums2;

		nums1 = new int[]{4, 1, 2};
		nums2 = new int[]{1, 3, 4, 2};

		int[] res = nextGreaterElement(nums1, nums2);

		for (int i : res) {
			System.out.println(i);
		}
	}

	public static int[] nextGreaterElement (int[] nums1, int[] nums2) {
		int[] map = new int[10000];
		int[] res = new int[nums1.length];

		for (int i = 0; i < nums2.length; i++) {
			map[nums2[i]] = i;
		}

		for (int i = 0; i < nums1.length; i++) {
			int result = -1;
			int j = map[nums1[i]] + 1;
			while (j < nums2.length) {
				if (nums2[j] > nums1[i]) {
					result = nums2[j];
					break;
				}
				j++;
			}
			res[i] = result;
		}
		return res;
	}
}