// 103. Binary Tree Zigzag Level Order Traversal
// https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/

import java.util.*;

class S103 {
	public static void main (String args[]) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		List<List<Integer>> res = zigzagLevelOrder(root);
		System.out.println(res);
	}

	public static List<List<Integer>> zigzagLevelOrder (TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> subRes = new ArrayList<>();
		int count = 0;
		int size = 1;
		int newCount = 0;
		int level = 0;

		if (root == null) {
			return res;
		}

		Deque<TreeNode> queue = new ArrayDeque<>();
		queue.offer(root);

		while (!queue.isEmpty()) {
			TreeNode curr = queue.poll();
			subRes.add(curr.val);

			if (curr.left != null) {
				queue.offer(curr.left);
				newCount++;
			}
			if (curr.right != null) {
				queue.offer(curr.right);
				newCount++;
			}
			count++;

			if (count == size) {
				if (level % 2 == 1) {
					Collections.reverse(subRes);
				}
				res.add(subRes);
				subRes = new ArrayList<>();

				count = 0;
				size = newCount;
				newCount = 0;
				level++;
			}
		}
		return res;
	}

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