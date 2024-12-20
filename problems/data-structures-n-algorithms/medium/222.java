// 222. Count Complete Tree Nodes
// https://leetcode.com/problems/count-complete-tree-nodes/

import java.util.List;

class S222 {
	public static void main (String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		int count = countNodes(root);
		System.out.println(count);
	}

	public static int countNodes (TreeNode root) {
		int[] count = new int[]{0};
		recursion(root, count);
		return count[0];
	}

	public static void recursion (TreeNode root, int[] count) {
		if (root == null) {
			return;
		}
		count[0]++;
		recursion(root.left, count);
		recursion(root.right, count);
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