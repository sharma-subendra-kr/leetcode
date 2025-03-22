// 141. Linked List Cycle
// https://leetcode.com/problems/linked-list-cycle/

class S141 {
	public static void main (String[] args) {
		ListNode node;
		ListNode head = node = new ListNode(3);
		node.next = new ListNode(2);
		node = node.next;
		node.next = new ListNode(0);
		node = node.next;
		node.next = new ListNode(4);
		node = node.next;

		boolean res = hasCycle(head);
		System.out.println(res);
	}

	public static boolean hasCycle (ListNode head) {
		if (head == null) {
			return false;
		}
		ListNode slow = head;
		ListNode fast = head.next;

		while (slow != fast && fast != null) {
			slow = slow.next;
			fast = fast.next;
			if (fast != null) {
				fast = fast.next;
			}
		}
		return slow == fast;
	}

	static class ListNode {
		int val;
		ListNode next;

		ListNode (int x) {
			val = x;
			next = null;
		}
	}
}