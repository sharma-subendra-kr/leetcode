// 11. Container With Most Water
// https://leetcode.com/problems/container-with-most-water/

class S11 {
	public static void main (String[] args) {
		int[] height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
		int res = maxArea(height);
		System.out.println(res);
	}

	public static int maxArea (int[] height) {
		int len = height.length;
		int left = 0;
		int right = len - 1;
		int max = 0;
		while (left < right) {
			int min = Math.min(height[left], height[right]);
			max = Math.max(max, min * (right - left));
			if (height[left] < height[right]) {
				left++;
			} else {
				right--;
			}
		}
		return max;
	}
}