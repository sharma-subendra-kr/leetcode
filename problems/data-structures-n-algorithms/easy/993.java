// 993. Cousins in Binary Tree
// https://leetcode.com/problems/cousins-in-binary-tree/

import com.sun.source.tree.Tree;

import java.util.concurrent.atomic.AtomicInteger;

class S993 {
	public static void main (String[] args) {
		TreeNode root;
		int x, y;

		// root = new TreeNode(1);
		// TreeNode node1 = new TreeNode(2);
		// TreeNode node2 = new TreeNode(4);
		// TreeNode node3 = new TreeNode(3);
		// root.left = node1;
		// root.right = node3;
		// node1.left = node2;
		// x = 4;
		// y = 3;

		root = new TreeNode(1);
		TreeNode node1 = new TreeNode(2);
		TreeNode node2 = new TreeNode(4);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(5);
		root.left = node1;
		root.right = node3;
		node1.left = node2;
		node3.right = node4;
		x = 4;
		y = 5;

		boolean res = isCousins(root, x, y);

		System.out.println(res);
	}

	public static Result find (TreeNode root, int val, TreeNode parent) {
		if (root == null) {
			return null;
		}

		if (root.val == val && parent != null) {
			return new Result(parent.val, 0);
		} else if (root.val == val) {
			return null;
		}

		Result result = null;

		result = find(root.left, val, root);
		if (result == null) {
			result = find(root.right, val, root);
		}

		if (result != null) {
			result.depth++;
		}
		return result;
	}

	public static boolean isCousins (TreeNode root, int x, int y) {
		Result res1 = find(root, x, null);
		Result res2 = find(root, y, null);

		if (res1 != null && res2 != null && res1.depth == res2.depth && res1.parent != res2.parent) {
			return true;
		}
		return false;
	}

	public static class Result {
		int parent;
		int depth;

		Result (int parent, int depth) {
			this.parent = parent;
			this.depth = depth;
		}
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