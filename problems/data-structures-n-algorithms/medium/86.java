// 86. Partition List
// https://leetcode.com/problems/partition-list/

class S86 {
	public static void main (String[] args) {
		// ListNode head = new ListNode(new int[]{1, 4, 3, 2, 5, 2});
		// int x = 3;
		// ListNode head = new ListNode(new int[]{2, 1});
		// int x = 2;
		// ListNode head = new ListNode(new int[]{4, 3, 2, 5, 2});
		// int x = 3;
		ListNode head = new ListNode(new int[]{1});
		int x = 0;
		ListNode res = partition(head, x);
		res.print();
	}

	public static ListNode partition (ListNode head, int x) {
		if (head == null) {
			return null;
		}
		ListNode greater = null;
		ListNode lesser = null;
		ListNode greaterIter = null;
		ListNode lesserIter = null;
		ListNode curr = head;

		while (curr != null) {
			if (curr.val < x) {
				if (lesser == null) {
					lesser = curr;
					curr = curr.next;
					lesser.next = null;
					lesserIter = lesser;
				} else {
					lesserIter.next = curr;
					curr = curr.next;
					lesserIter = lesserIter.next;
					lesserIter.next = null;
				}
			} else {
				if (greater == null) {
					greater = curr;
					curr = curr.next;
					greater.next = null;
					greaterIter = greater;
				} else {
					greaterIter.next = curr;
					curr = curr.next;
					greaterIter = greaterIter.next;
					greaterIter.next = null;
				}
			}
		}

		if (lesser != null) {
			lesserIter.next = greater;
			return lesser;
		} else {
			return greater;
		}
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