// 236. Lowest Common Ancestor of a Binary Tree
// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/

import java.util.HashMap;
import java.util.HashSet;

class S236 {
	public static void main (String[] args) {
		// TreeNode root = new TreeNode(3);
		// root.left = new TreeNode(5);
		// root.right = new TreeNode(1);
		// root.left.left = new TreeNode(6);
		// root.left.right = new TreeNode(2);
		// root.left.right.left = new TreeNode(7);
		// root.left.right.right = new TreeNode(4);
		// root.right.left = new TreeNode(0);
		// root.right.right = new TreeNode(8);
		// TreeNode res = lowestCommonAncestor(root, root.left, root.left.right.right);
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(2);
		TreeNode res = lowestCommonAncestor(root, root.right, root);
		System.out.println(res.val);

	}

	public static TreeNode lowestCommonAncestor (TreeNode root, TreeNode p, TreeNode q) {
		HashSet<TreeNode> set = new HashSet<>();
		boolean res = findBranch(root, p, set);
		if (!res) {
			return null;
		}
		TreeNode[] anc = new TreeNode[1];
		find(root, q, set, anc);
		return anc[0];
	}

	public static boolean findBranch (TreeNode node, TreeNode sNode, HashSet<TreeNode> set) {
		if (node == null) {
			return false;
		} else if (node.val == sNode.val) {
			set.add(node);
			return true;
		}
		boolean res = findBranch(node.left, sNode, set);
		if (res == true) {
			set.add(node);
			return true;
		}
		res = findBranch(node.right, sNode, set);
		if (res == true) {
			set.add(node);
			return true;
		}
		return false;
	}

	public static boolean find (TreeNode node, TreeNode sNode, HashSet<TreeNode> set, TreeNode[] anc) {
		if (node == null) {
			return false;
		} else if (node.val == sNode.val) {
			if (anc[0] == null && set.contains(node)) {
				anc[0] = node;
			}
			return true;
		}
		boolean res = find(node.left, sNode, set, anc);
		if (res == true) {
			if (anc[0] == null && set.contains(node)) {
				anc[0] = node;
			}
			return true;
		}
		res = find(node.right, sNode, set, anc);
		if (res == true) {
			if (anc[0] == null && set.contains(node)) {
				anc[0] = node;
			}
			return true;
		}
		return false;
	}

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode (int x) {
			val = x;
		}
	}
}