// 2. Add Two Numbers
// https://leetcode.com/problems/add-two-numbers/description/

class S2 {
	public static void main (String args[]) {
		ListNode l1 = new ListNode(2);
		ListNode l2 = new ListNode(5);
		ListNode curr = l1;
		curr.next = new ListNode(4);
		curr = curr.next;
		curr.next = new ListNode(3);
		curr = curr.next;
		curr = l2;
		curr.next = new ListNode(6);
		curr = curr.next;
		curr.next = new ListNode(4);
		curr = curr.next;

		ListNode res = addTwoNumbers(l1, l2);
		while (res != null) {
			System.out.println(res.val);
			res = res.next;
		}

	}

	public static ListNode addTwoNumbers (ListNode l1, ListNode l2) {
		int carry = 0;
		ListNode iL1 = l1;
		ListNode iL2 = l2;
		ListNode res = null;
		ListNode curr = null;

		while (iL1 != null || iL2 != null || carry != 0) {
			int sum = 0;
			sum += carry;
			if (iL1 != null) {
				sum += iL1.val;
				iL1 = iL1.next;
			}
			if (iL2 != null) {
				sum += iL2.val;
				iL2 = iL2.next;
			}

			if (sum >= 10) {
				sum = sum % 10;
				carry = 1;
			} else {
				carry = 0;
			}

			if (curr == null) {
				curr = new ListNode(sum);
				res = curr;
			} else {
				curr.next = new ListNode(sum);
				curr = curr.next;
			}
		}

		return res;
	}
}

class ListNode {
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