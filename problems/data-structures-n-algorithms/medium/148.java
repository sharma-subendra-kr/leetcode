// 148. Sort List
// https://leetcode.com/problems/sort-list/

class S148 {
	public static void main (String[] args) {
		ListNode node = new ListNode(4);
		node.next = new ListNode(2);
		node.next.next = new ListNode(1);
		node.next.next.next = new ListNode(3);

		ListNode res = sortList(node);

		while (res != null) {
			System.out.println(res.val);
			res = res.next;
		}
	}

	public static ListNode sortList (ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode slow = head;
		ListNode fast = head;
		ListNode prev = null;
		while (fast != null) {
			prev = slow;
			slow = slow.next;
			fast = fast.next;
			if (fast != null) {
				fast = fast.next;
			}
		}
		prev.next = null;

		ListNode l1 = sortList(head);
		ListNode l2 = sortList(slow);

		return mergeList(l1, l2);
	}

	public static ListNode mergeList (ListNode l1, ListNode l2) {
		ListNode res = new ListNode();
		ListNode curr = res;
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				curr.next = l1;
				l1 = l1.next;
			} else {
				curr.next = l2;
				l2 = l2.next;
			}
			curr = curr.next;
		}

		if (l1 != null) {
			curr.next = l1;
		} else if (l2 != null) {
			curr.next = l2;
		}

		curr = res.next;
		res.next = null;
		return curr;
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