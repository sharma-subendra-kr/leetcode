// 703. Kth Largest Element in a Stream
// https://leetcode.com/problems/kth-largest-element-in-a-stream/

import java.util.Comparator;
import java.util.PriorityQueue;

class KthLargest {
	PriorityQueue<Integer> pq;
	int k;

	public KthLargest (int k, int[] nums) {
		pq = new PriorityQueue<>();
		this.k = k;

		for (int i = 0; i < nums.length; i++) {
			add(nums[i]);
		}
	}

	public int add (int val) {
		if (pq.size() < k) {
			pq.add(val);
		} else if (pq.peek() < val) {
			pq.remove();
			pq.add(val);
		}
		return pq.peek();
	}
}