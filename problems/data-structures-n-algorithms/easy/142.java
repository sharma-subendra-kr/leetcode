// 142. Linked List Cycle II
// https://leetcode.com/problems/linked-list-cycle-ii/

class S142 {
	public static void main (String[] args) {
		ListNode node, cycle = null;
		ListNode head = node = new ListNode(3);
		node.next = cycle = new ListNode(2);
		node = node.next;
		node.next = new ListNode(0);
		node = node.next;
		node.next = new ListNode(-4);
		node = node.next;
		node.next = cycle;

		ListNode res = detectCycle(head);
		if (res != null) {
			System.out.println(res.val);
		}
	}

	public static ListNode detectCycle (ListNode head) {
		if (head == null) {
			return null;
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

		if (fast == null) {
			return null;
		}

		ListNode cut = slow;
		ListNode cutHead = slow.next;
		slow.next = null;

		ListNode list1 = head;
		ListNode list2 = cutHead;
		ListNode p1 = list1, p2 = list2;
		int len1 = 0, len2 = 0;

		while (p1 != null) {
			len1++;
			p1 = p1.next;
		}

		while (p2 != null) {
			len2++;
			p2 = p2.next;
		}

		int diff = Math.abs(len1 - len2);

		ListNode longer = list1;
		ListNode shorter = list2;
		if (len1 < len2) {
			longer = list2;
			shorter = list1;
		}
		while (diff != 0) {
			diff--;
			longer = longer.next;
		}

		while (shorter != longer) {
			shorter = shorter.next;
			longer = longer.next;
		}
		cut.next = cutHead;

		return shorter;
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