// 637. Average of Levels in Binary Tree
// https://leetcode.com/problems/average-of-levels-in-binary-tree/

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class S637 {
	public static void main (String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		List<Double> res = averageOfLevels(root);
		res.forEach(o -> System.out.print(o));
		System.out.println();
	}

	public static List<Double> averageOfLevels (TreeNode root) {
		List<Double> res = new ArrayList<>();
		Deque<TreeNode> queue = new ArrayDeque<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			TreeNode start = queue.peekLast();
			TreeNode curr;

			long sum = 0;
			int count = 0;
			do {
				curr = queue.poll();
				sum += curr.val;
				count++;

				if (curr.left != null) {
					queue.add(curr.left);
				}
				if (curr.right != null) {
					queue.add(curr.right);
				}
			} while (curr != start);
			res.add(((double) sum / (double) count));
		}
		return res;
	}

	// Definition for a binary tree node.
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode () {
		}

		TreeNode (int val) {
			this.val = val;
		}

		TreeNode (int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
}