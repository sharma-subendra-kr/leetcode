// 199. Binary Tree Right Side View
// https://leetcode.com/problems/binary-tree-right-side-view/

import java.util.ArrayList;
import java.util.List;

class S199 {
	public static void main (String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.left.left = new TreeNode(5);
		List<Integer> list = rightSideView(root);
		list.forEach(o -> System.out.print(o));
		System.out.println();

	}

	public static List<Integer> rightSideView (TreeNode root) {
		List<Integer> list = new ArrayList<>();
		int[] viewHeight = new int[]{0};
		recursion(root, viewHeight, 0, list);
		return list;
	}

	public static void recursion (TreeNode root, int[] viewHeight, int height, List<Integer> list) {
		if (root == null) {
			return;
		}
		if (viewHeight[0] == height) {
			viewHeight[0]++;
			list.add(root.val);
		}
		recursion(root.right, viewHeight, height + 1, list);
		recursion(root.left, viewHeight, height + 1, list);
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