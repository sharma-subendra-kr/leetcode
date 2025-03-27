// 105. Construct Binary Tree from Preorder and Inorder Traversal
// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/

import java.util.HashMap;
import java.util.List;

class S105 {

	public static void main (String args[]) {
		// int[] preorder = new int[]{3, 9, 20, 15, 7};
		// int[] inorder = new int[]{9, 3, 15, 20, 7};
		// int[] preorder = new int[]{1, 2};
		// int[] inorder = new int[]{1, 2};
		// int[] preorder = new int[]{1, 2, 3};
		// int[] inorder = new int[]{3, 2, 1};
		// int[] preorder = new int[]{1, 2, 3};
		// int[] inorder = new int[]{2, 3, 1};
		// int[] preorder = new int[]{4, 1, 2, 3};
		// int[] inorder = new int[]{1, 2, 3, 4};
		int[] preorder = new int[]{3, 2, 1, 4};
		int[] inorder = new int[]{1, 2, 3, 4};
		TreeNode res = buildTree(preorder, inorder);
		System.out.println(res);
	}

	public static TreeNode buildTree (int[] preorder, int[] inorder) {
		int len = preorder.length;
		if (len == 0) {
			return null;
		}
		HashMap<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < len; i++) {
			map.put(inorder[i], i);
		}
		TreeNode root = new TreeNode(preorder[0]);
		recursion(root, 0, 0, len - 1, preorder, inorder, map);
		return root;
	}

	public static void recursion (TreeNode root, int preOrdRootIdx, int start, int end, int[] preorder, int[] inorder,
	                              HashMap<Integer, Integer> map) {
		if (end - start <= 0) {
			return;
		}
		int inOdrRootIdx = map.get(preorder[preOrdRootIdx]);
		int leftSize = inOdrRootIdx - start;
		int rightSize = end - inOdrRootIdx;
		int rightIndex = preOrdRootIdx + leftSize + 1;
		int leftIndex = preOrdRootIdx + 1;

		if (leftSize > 0) {
			root.left = new TreeNode(preorder[leftIndex]);
			recursion(root.left, leftIndex, start, inOdrRootIdx - 1, preorder, inorder, map);
		}

		if (rightSize > 0) {
			root.right = new TreeNode(preorder[rightIndex]);
			recursion(root.right, rightIndex, inOdrRootIdx + 1, end, preorder, inorder, map);
		}
	}
}

class TreeNode {
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