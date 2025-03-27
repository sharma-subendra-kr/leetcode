// 94. Binary Tree Inorder Traversal
// https://leetcode.com/problems/binary-tree-inorder-traversal/

import java.util.ArrayList;
import java.util.List;

class S94 {
	public static void main (String args[]) {
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(3);
		List<Integer> res = inorderTraversal(root);
		System.out.println(res);
	}

	public static List<Integer> inorderTraversal (TreeNode root) {
		List<Integer> res = new ArrayList<>();
		recursion(root, res);
		return res;
	}

	public static void recursion (TreeNode node, List<Integer> res) {
		if (node == null) {
			return;
		}
		recursion(node.left, res);
		res.add(node.val);
		recursion(node.right, res);
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