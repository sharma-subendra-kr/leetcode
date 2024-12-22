// 133. Clone Graph
// https://leetcode.com/problems/clone-graph/

import java.util.*;

class S133 {
	public static void main (String[] args) {
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		n1.neighbors = Arrays.asList(n2, n4);
		n2.neighbors = Arrays.asList(n1, n3);
		n3.neighbors = Arrays.asList(n2, n4);
		n4.neighbors = Arrays.asList(n1, n3);

		Node res = cloneGraph(n1);
		System.out.println(res);
	}

	public static Node cloneGraph (Node node) {
		if (node == null) {
			return null;
		}
		HashMap<Integer, Node> visited = new HashMap<>();
		return clone(node, visited);
	}

	public static Node clone (Node node, HashMap<Integer, Node> visited) {
		if (node == null) {
			return null;
		}
		Node cnode = new Node(node.val);
		visited.put(node.val, cnode);
		node.neighbors.forEach(o -> {
			if (!visited.containsKey(o.val)) {
				cnode.neighbors.add(clone(o, visited));
			} else {
				cnode.neighbors.add(visited.get(o.val));
			}
		});
		return cnode;
	}

	// Definition for a Node.
	static class Node {
		public int val;
		public List<Node> neighbors;

		public Node () {
			val = 0;
			neighbors = new ArrayList<Node>();
		}

		public Node (int _val) {
			val = _val;
			neighbors = new ArrayList<Node>();
		}

		public Node (int _val, ArrayList<Node> _neighbors) {
			val = _val;
			neighbors = _neighbors;
		}
	}
}