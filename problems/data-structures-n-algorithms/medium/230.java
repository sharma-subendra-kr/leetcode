// 230. Kth Smallest Element in a BST
// https://leetcode.com/problems/kth-smallest-element-in-a-bst/

class S230 {
	public static void main (String args[]) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(1);
		root.left.right = new TreeNode(2);
		root.right = new TreeNode(4);
		int k = 1;

		int res = kthSmallest(root, k);
		System.out.println(res);
	}

	public static int kthSmallest (TreeNode root, int k) {
		int[] res = new int[1];
		recursion(root, k, new int[1], res);
		return res[0];
	}

	public static void recursion (TreeNode node, int k, int[] count, int[] res) {
		if (node == null) {
			return;
		}
		recursion(node.left, k, count, res);
		count[0]++;
		if (count[0] == k) {
			res[0] = node.val;
		}
		recursion(node.right, k, count, res);
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