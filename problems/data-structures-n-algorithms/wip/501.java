// 501. Find Mode in Binary Search Tree
// https://leetcode.com/problems/find-mode-in-binary-search-tree/

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.Stack;

class S501 {

	public static void main (String[] args) {
		// TreeNode root = new TreeNode(1);
		// TreeNode node1 = new TreeNode(2);
		// TreeNode node2 = new TreeNode(2);
		// root.right = node1;
		// node1.left = node2;

		// TreeNode root = new TreeNode(2);
		// TreeNode node1 = new TreeNode(1);
		// root.left = node1;

		TreeNode root = new TreeNode(1);
		TreeNode node1 = new TreeNode(0);
		TreeNode node2 = new TreeNode(1);
		TreeNode node3 = new TreeNode(0);
		TreeNode node4 = new TreeNode(0);
		TreeNode node5 = new TreeNode(1);
		TreeNode node6 = new TreeNode(1);
		TreeNode node7 = new TreeNode(0);
		root.left = node1;
		root.right = node2;
		node1.left = node3;
		node1.right = node4;
		node2.left = node5;
		node2.right = node6;
		node3.left = node7;

		int[] res = findMode(root);

		for (int i : res) {
			System.out.println(i);
		}
	}

	public static int[] findMode (TreeNode root) {
		int max = 0;
		int currentCount = 0;
		ArrayList<Integer> res = new ArrayList<Integer>();

		TreeNode curr = root;
		TreeNode prev = null;
		Stack<TreeNode> stk = new Stack<>();

		stk.push(root);
		while (!stk.isEmpty()) {
			while (curr != null && curr.left != null) {
				curr = curr.left;
				stk.push(curr);
			}
			curr = stk.pop();

			if (prev == null || curr.val != prev.val) {
				currentCount = 1;
			} else {
				currentCount++;
			}
			if (currentCount > max) {
				res.clear();
				res.add(curr.val);
				max = currentCount;
			} else if (currentCount == max) {
				res.add(curr.val);
			}

			prev = curr;
			if (curr.right != null) {
				stk.push(curr.right);
				curr = curr.right;
			} else {
				curr = null;
			}
		}

		return res.stream().mapToInt(i -> i).toArray();
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