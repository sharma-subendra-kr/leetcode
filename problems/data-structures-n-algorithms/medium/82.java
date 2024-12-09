// 82. Remove Duplicates from Sorted List II
// https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/

import java.util.List;

class S82 {
	public static void main (String[] args) {
		// ListNode head = new ListNode(new int[]{1, 2, 3, 3, 4, 4, 5});
		// ListNode head = new ListNode(new int[]{1, 1, 1, 2, 3});
		// ListNode head = new ListNode(new int[]{1, 1, 1, 2, 2, 3});
		ListNode head = new ListNode(new int[]{-1, 0, 0, 0, 0, 3, 3});
		ListNode res = deleteDuplicates(head);
		res.print();
	}

	public static ListNode deleteDuplicates (ListNode head) {
		if (head == null) {
			return head;
		}
		ListNode curr = head;
		ListNode prev = null;
		int prevDeleted = Integer.MIN_VALUE;
		while (curr != null) {
			if (curr.next != null && curr.val == curr.next.val) {
				prevDeleted = curr.val;
				if (prev != null) {
					prev.next = curr.next;
				} else {
					head = curr.next;
					curr.next = null;
					curr = head;
					continue;
				}
			} else if (prevDeleted == curr.val) {
				if (prev != null) {
					prev.next = curr.next;
				} else {
					head = curr.next;
					curr.next = null;
					curr = head;
					continue;
				}
			} else {
				prev = curr;
			}
			curr = curr.next;
		}
		return head;
	}

	// Definition for singly-linked list.
	public static class ListNode {
		int val;
		ListNode next;

		ListNode () {
		}

		ListNode (int[] arr) {
			if (arr.length == 0) {
				return;
			}
			this.val = arr[0];
			ListNode curr = this;
			for (int i = 1; i < arr.length; i++) {
				curr.next = new ListNode(arr[i]);
				curr = curr.next;
			}
		}

		ListNode (int val) {
			this.val = val;
		}

		ListNode (int val, ListNode next) {
			this.val = val;
			this.next = next;
		}

		void print () {
			ListNode curr = this;
			while (curr != null) {
				System.out.print(curr.val + " ");
				curr = curr.next;
			}
			System.out.println();
		}
	}
}