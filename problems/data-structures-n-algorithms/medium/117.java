// 117. Populating Next Right Pointers in Each Node II
// https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

class S117 {
	public static void main (String[] args) {
		// Node root = new Node(1);
		// root.left = new Node(2);
		// root.right = new Node(3);
		// root.left.left = new Node(4);
		// root.left.right = new Node(5);
		// root.right.right = new Node(7);

		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.right = new Node(6);
		root.left.left.left = new Node(7);
		root.right.right.right = new Node(8);

		Node res = connect(root);
	}

	public static Node connect (Node root) {
		if (root == null) {
			return null;
		}
		recursion(root);
		return root;
	}

	public static Node findLink (Node node, Node curr, Node left) {
		if (node == null) {
			return null;
		}
		if (curr != node.left && left != node.left && node.left != null) {
			return node.left;
		} else if (curr != node.right && node.right != null) {
			return node.right;
		}
		return findLink(node.next, null, null);
	}

	public static void recursion (Node node) {
		if (node == null) {
			return;
		}

		if (node.left != null) {
			node.left.next = findLink(node, node.left, null);
		}
		if (node.right != null) {
			node.right.next = findLink(node, node.right, node.left);
		}

		recursion(node.right);
		recursion(node.left);
	}

	// public static Node connect (Node root) {
	// 	if (root == null) {
	// 		return root;
	// 	}
	// 	Deque<Node> deque1 = new ArrayDeque<>();
	// 	Deque<Node> deque2 = new ArrayDeque<>();
	//
	// 	Node curr = root;
	// 	deque1.add(curr);
	// 	while (!deque1.isEmpty()) {
	// 		curr = deque1.poll();
	// 		if (curr.left != null) {
	// 			deque2.add(curr.left);
	// 		}
	// 		if (curr.right != null) {
	// 			deque2.add(curr.right);
	// 		}
	// 		if (deque1.isEmpty() && !deque2.isEmpty()) {
	// 			Node head = deque2.poll();
	// 			deque1.add(head);
	// 			Node itr;
	// 			while (!deque2.isEmpty()) {
	// 				itr = deque2.poll();
	// 				deque1.add(itr);
	// 				head.next = itr;
	// 				head = head.next;
	// 			}
	// 		}
	// 	}
	// 	return root;
	// }

	static class Node {
		public int val;
		public Node left;
		public Node right;
		public Node next;

		public Node () {
		}

		public Node (int _val) {
			val = _val;
		}

		public Node (int _val, Node _left, Node _right, Node _next) {
			val = _val;
			left = _left;
			right = _right;
			next = _next;
		}
	}
}