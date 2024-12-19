// 173. Binary Search Tree Iterator
// https://leetcode.com/problems/binary-search-tree-iterator/

import java.util.Stack;

class S173 {
	public static void main (String args[]) {
		TreeNode root = new TreeNode(7);
		root.left = new TreeNode(3);
		root.right = new TreeNode(15);
		root.right.left = new TreeNode(9);
		root.right.right = new TreeNode(20);

		BSTIterator itr = new BSTIterator(root);
		System.out.println(itr.next());
		System.out.println(itr.next());
		System.out.println(itr.hasNext());
		System.out.println(itr.next());
		System.out.println(itr.hasNext());
		System.out.println(itr.next());
		System.out.println(itr.hasNext());
		System.out.println(itr.next());
		System.out.println(itr.hasNext());
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

	public static class BSTIterator {
		TreeNode root, curr;
		Stack<TreeNode> stack;

		public BSTIterator (TreeNode root) {
			this.root = root;
			this.curr = this.root;
			this.stack = new Stack<>();
			while (this.curr != null) {
				this.stack.push(this.curr);
				this.curr = this.curr.left;
			}
		}

		public int next () {
			this.curr = this.stack.pop();
			int val = this.curr.val;
			if (this.curr.right != null) {
				this.curr = this.curr.right;
				while (this.curr != null) {
					this.stack.push(this.curr);
					this.curr = this.curr.left;

				}
			}
			return val;
		}

		public boolean hasNext () {
			if (!this.stack.isEmpty()) {
				return true;
			}
			return false;
		}
	}
}