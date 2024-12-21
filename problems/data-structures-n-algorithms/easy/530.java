// 530. Minimum Absolute Difference in BST
// https://leetcode.com/problems/minimum-absolute-difference-in-bst/

class S530 {
	public static void main (String[] args) {
		// TreeNode root = new TreeNode(4);
		// root.left = new TreeNode(2);
		// root.right = new TreeNode(6);
		// root.left.left = new TreeNode(1);
		// root.left.right = new TreeNode(3);

		TreeNode root = new TreeNode(236);
		root.left = new TreeNode(104);
		root.right = new TreeNode(701);
		root.left.right = new TreeNode(227);
		root.right.right = new TreeNode(911);
		int res = getMinimumDifference(root);
		System.out.println(res);
	}

	public static int getMinimumDifference (TreeNode root) {
		int[] res = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
		TreeNode[] prev = new TreeNode[]{null};
		recursion(root, prev, res);

		return res[0];
	}

	public static void recursion (TreeNode node, TreeNode[] prev, int[] res) {
		if (node == null) {
			return;
		}
		recursion(node.left, prev, res);
		if (prev[0] != null && Math.abs(prev[0].val - node.val) < res[0]) {
			res[0] = Math.abs(prev[0].val - node.val);
		}
		prev[0] = node;
		recursion(node.right, prev, res);
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