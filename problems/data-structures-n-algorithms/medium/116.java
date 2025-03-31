// 116. Populating Next Right Pointers in Each Node
// https://leetcode.com/problems/populating-next-right-pointers-in-each-node/

class S116 {
	public static void main (String args[]) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);

		Node res = connect(root);
		System.out.println(res);
	}

	public static Node connect (Node root) {
		recursion(root, null);
		return root;
	}

	public static Node getRight (Node parent, Node node) {
		if (parent == null) {
			return null;
		}
		if (parent.right != node) {
			return parent.right;
		}

		Node curr = parent.next;
		while (curr != null && curr.left == null && curr.right == null) {
			curr = curr.next;
		}

		if (curr != null && curr.left != null) {
			return curr.left;
		} else if (curr != null && curr.right != null) {
			return curr.right;
		}
		return null;
	}

	public static void recursion (Node node, Node parent) {
		if (node == null) {
			return;
		}

		node.next = getRight(parent, node);
		recursion(node.right, node);
		recursion(node.left, node);
	}

	public static class Node {
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

	;
}