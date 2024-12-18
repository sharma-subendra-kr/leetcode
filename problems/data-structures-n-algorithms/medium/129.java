// 129. Sum Root to Leaf Numbers
// https://leetcode.com/problems/sum-root-to-leaf-numbers/

class S129 {
	public static void main (String[] args) {
		// TreeNode root = new TreeNode(1);
		// root.left = new TreeNode(2);
		// root.right = new TreeNode(3);

		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(9);
		root.right = new TreeNode(0);
		root.left.left = new TreeNode(5);
		root.left.right = new TreeNode(1);
		int res = sumNumbers(root);
		System.out.println(res);
	}

	public static int sumNumbers (TreeNode root) {
		if (root == null) {
			return 0;
		}
		int[] sum = new int[]{0};
		recursive(root, 0, sum);
		return sum[0];
	}

	public static void recursive (TreeNode node, int current, int[] sum) {
		current = current * 10 + node.val;

		if (node.left == null && node.right == null) {
			sum[0] += current;
			return;
		}
		if (node.left != null) {
			recursive(node.left, current, sum);
		}
		if (node.right != null) {
			recursive(node.right, current, sum);
		}
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