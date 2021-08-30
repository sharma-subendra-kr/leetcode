// 42. Trapping Rain Water
// https://leetcode.com/problems/trapping-rain-water/

import java.util.Stack;

class S42 {
	public static void main (String[] args) {
		int[] height;

		// height = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
		height = new int[]{4, 2, 0, 3, 2, 5};

		int res = trap(height);

		System.out.println(res);
	}

	public static int trap (int[] height) {
		Stack<Item> stack = new Stack<>();

		if (height.length == 0) {
			return 0;
		}

		int sum = 0;
		int prev = 0;

		stack.push(new Item(0, height[0]));
		for (int i = 1; i < height.length; i++) {
			if (stack.peek().height > height[i]) {
				sum += (i - stack.peek().index - 1) * height[i];
				stack.push(new Item(i, height[i]));
			} else {
				prev = 0;
				while (!stack.isEmpty() && stack.peek().height <= height[i]) {
					sum += (i - stack.peek().index - 1) * (stack.peek().height - prev);
					prev = stack.pop().height;
				}
				if (!stack.isEmpty() && stack.peek().height >= height[i]) {
					sum += (i - stack.peek().index - 1) * (height[i] - prev);
				}
				stack.push(new Item(i, height[i]));
			}
		}
		return sum;
	}

	static class Item {
		int height;
		int index;

		Item (int index, int height) {
			this.index = index;
			this.height = height;
		}
	}
}