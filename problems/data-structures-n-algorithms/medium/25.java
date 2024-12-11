// 25. Reverse Nodes in k-Group
// https://leetcode.com/problems/reverse-nodes-in-k-group/

class S25 {
	public static void main (String[] args) {
		ListNode head = new ListNode(new int[]{1, 2, 3, 4, 5});
		int k = 2;
		ListNode res = reverseKGroup(head, k);
		res.print();
	}

	public static ListNode reverseKGroup (ListNode head, int k) {
		ListNode curr = head;
		ListNode prev = null;
		ListNode temp = null;
		ListNode rev = null;
		ListNode revTail = null;
		ListNode rHead = null;
		ListNode rTail = null;
		int count = 0;
		while (curr != null) {
			count = 0;
			ListNode pHead = curr;
			while (curr != null && count < k) {
				prev = curr;
				curr = curr.next;
				count++;
			}
			if (prev != null) {
				prev.next = null;
			}
			if (count == k) {
				rev = null;
				while (pHead != null) {
					if (rev == null) {
						rev = pHead;
						pHead = pHead.next;
						rev.next = null;
						revTail = rev;
					} else {
						temp = pHead;
						pHead = pHead.next;
						temp.next = rev;
						rev = temp;
					}
				}
				if (rHead == null) {
					rHead = rev;
					rTail = revTail;
				} else {
					rTail.next = rev;
					rTail = revTail;
				}
			} else {
				if (rHead == null) {
					rHead = pHead;
				} else {
					rTail.next = pHead;
				}
			}
		}
		return rHead;
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