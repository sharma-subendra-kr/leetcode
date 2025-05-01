// 23. Merge k Sorted Lists
// https://leetcode.com/problems/merge-k-sorted-lists/

import java.util.List;
import java.util.PriorityQueue;

class S23 {
	public static void main (String[] args) {
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(5);
		ListNode l2 = new ListNode(1);
		l2.next = new ListNode(3);
		l2.next.next = new ListNode(4);
		ListNode l3 = new ListNode(2);
		l3.next = new ListNode(6);
		ListNode[] lists = new ListNode[]{l1, l2, l3};
		// ListNode[] lists = new ListNode[]{};
		ListNode res = mergeKLists(lists);

		while (res != null) {
			System.out.println(res.val);
			res = res.next;
		}
	}

	public static ListNode mergeKLists (ListNode[] lists) {
		PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
		int len = lists.length;
		if (len == 0) {
			return null;
		}
		ListNode res = null;
		ListNode head = null;

		for (int i = 0; i < len; i++) {
			if (lists[i] != null) {
				pq.add(lists[i]);
			}
		}

		while (!pq.isEmpty()) {
			ListNode curr = pq.poll();
			if (curr.next != null) {
				pq.add(curr.next);
			}
			if (res == null) {
				res = curr;
				curr = curr.next;
				res.next = null;
				head = res;
			} else {
				res.next = curr;
				res = res.next;
				curr = curr.next;
			}
		}

		return head;
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

	// public static ListNode mergeKLists (ListNode[] lists) {
	// 	int len = lists.length;
	// 	if (len == 0) {
	// 		return null;
	// 	}
	// 	ListNode[] curr = new ListNode[len];
	// 	ListNode res = null;
	// 	ListNode head = null;
	//
	// 	for (int i = 0; i < len; i++) {
	// 		curr[i] = lists[i];
	// 	}
	//
	// 	while (true) {
	// 		int min = Integer.MAX_VALUE;
	// 		int idx = 0;
	// 		for (int i = 0; i < len; i++) {
	// 			if (curr[i] != null && curr[i].val < min) {
	// 				min = curr[i].val;
	// 				idx = i;
	// 			}
	// 		}
	// 		if (curr[idx] == null) {
	// 			break;
	// 		}
	// 		if (res == null) {
	// 			res = curr[idx];
	// 			curr[idx] = curr[idx].next;
	// 			res.next = null;
	// 			head = res;
	// 		} else {
	// 			res.next = curr[idx];
	// 			res = res.next;
	// 			curr[idx] = curr[idx].next;
	// 		}
	// 	}
	// 	return head;
	// }
}