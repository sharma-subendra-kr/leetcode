// 120. Triangle
// https://leetcode.com/problems/triangle/

import java.util.*;

class S120 {
	public static void main (String[] args) {
		System.out.println("Start!");
		List<List<Integer>> triangle = List.of(List.of(2), List.of(3, 4), List.of(6, 5, 7), List.of(4, 1, 8, 3));
		int result = minimumTotal((triangle));
		System.out.println(result);
	}

	public static int minimumTotal (List<List<Integer>> triangle) {
		Stack<Integer> yStack = new Stack<>();
		Stack<Integer> xStack = new Stack<>();
		Stack<Integer> directionStack = new Stack<>();
		Stack<Integer> sumStack = new Stack<>();
		Integer minSum = Integer.MAX_VALUE;

		// List<List<Integer>> memo = new ArrayList<>();
		// for (int i = 0; i < triangle.size(); i++) {
		// 	memo.set(i, new ArrayList<>(Collections.nCopies(triangle.get(i).size(), -1)));
		// }

		yStack.push(0);
		xStack.push(0);
		directionStack.push(-1);
		sumStack.push(0);

		while (!yStack.empty()) {
			Integer topY = yStack.peek();
			Integer topX = xStack.peek();
			Integer direction = directionStack.pop();
			Integer sum = sumStack.peek();
			Integer top = -1;
			if (topY < triangle.size() && topX < triangle.get(topY).size()) {
				top = triangle.get(topY).get(topX);
			}
			if (topY == triangle.size() || direction == 1) {
				yStack.pop();
				xStack.pop();
				sumStack.pop();
				if (topY == triangle.size() && sum < minSum) {
					minSum = sum;
				}
				// if (direction == 1) {
				// 	if (topY < triangle.size() - 1) {
				// 		int left = memo.get(topY + 1).get(topX);
				// 		int right = memo.get(topY + 1).get(topX + 1);
				// 		memo.get(topY).set(topX, Math.min(left, right) + top);
				// 	} else if (topY == triangle.size() - 1) {
				// 		memo.get(topY).set(topX, top);
				// 	}
				// }
			} else if (direction == -1) {
				directionStack.push(++direction);
				sum += top;
				yStack.push(topY + 1);
				xStack.push(topX);
				sumStack.push(sum);
				directionStack.push(-1);
			} else if (direction == 0) {
				directionStack.push(++direction);
				sum += top;
				yStack.push(topY + 1);
				xStack.push(topX + 1);
				sumStack.push(sum);
				directionStack.push(-1);
			}
		}

		return minSum;
	}
}