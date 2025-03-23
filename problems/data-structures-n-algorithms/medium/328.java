// 328. Odd Even Linked List
// https://leetcode.com/problems/odd-even-linked-list/

class S328 {
	public static void main (String[] args) {
		ListNode node = null;
		ListNode head = node = new ListNode(3);
		node.next = new ListNode(2);
		node = node.next;
		node.next = new ListNode(0);
		node = node.next;
		node.next = new ListNode(-4);
		node = node.next;

		ListNode res = oddEvenList(head);
		while (res != null) {
			System.out.println(res.val);
			res = res.next;
		}
	}

	public static ListNode oddEvenList (ListNode head) {
		if (head == null) {
			return null;
		} else if (head.next == null) {
			return head;
		}
		ListNode odd = head;
		ListNode even = head.next;
		ListNode rem = even.next;

		odd.next = null;
		even.next = null;
		ListNode oCurr = odd;
		ListNode eCurr = even;

		int cnt = 1;
		while (rem != null) {
			if (cnt % 2 == 1) {
				oCurr.next = rem;
				oCurr = oCurr.next;
				rem = rem.next;
				oCurr.next = null;
			} else {
				eCurr.next = rem;
				eCurr = eCurr.next;
				rem = rem.next;
				eCurr.next = null;
			}
			cnt++;
		}
		oCurr.next = even;

		return odd;
	}

	public static class ListNode {
		int val;
		ListNode next;

		ListNode () {
		}

		ListNode (int val) {
			this.val = val;
		}

		ListNode (int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}
}