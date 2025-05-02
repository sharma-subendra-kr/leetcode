// 138. Copy List with Random Pointer
// https://leetcode.com/problems/copy-list-with-random-pointer/

import java.util.HashMap;

class S138 {
	public static void main (String[] args) {
		Node head = new Node(7);
		head.next = new Node(13);
		head.next.random = head;
		head.next.next = new Node(11);
		head.next.next.next = new Node(10);
		head.next.next.next.next = new Node(1);
		head.next.next.random = head.next.next.next.next;
		head.next.next.next.random = head.next.next;
		head.next.next.next.next.random = head;

		Node res = copyRandomList(head);
		while (res != null) {
			System.out.println("****");
			System.out.println(res.val);
			System.out.println(res.random);
			res = res.next;
		}
	}

	public static Node copyRandomList (Node head) {
		HashMap<Node, Integer> map = new HashMap<>();
		HashMap<Integer, Node> cmap = new HashMap<>();
		Node res = null;
		Node rcurr = null;

		Node curr = head;
		int idx = 0;
		while (curr != null) {
			Node copy = new Node(curr.val);
			if (res == null) {
				res = copy;
				rcurr = res;
			} else {
				rcurr.next = copy;
				rcurr = rcurr.next;
			}
			map.put(curr, idx);
			cmap.put(idx, copy);
			idx++;
			curr = curr.next;
		}

		curr = head;
		rcurr = res;
		while (curr != null) {
			if (curr.random != null) {
				idx = map.get(curr.random);
				rcurr.random = cmap.get(idx);
			}
			curr = curr.next;
			rcurr = rcurr.next;
		}

		return res;
	}

	static class Node {
		int val;
		Node next;
		Node random;

		public Node (int val) {
			this.val = val;
			this.next = null;
			this.random = null;
		}
	}
}