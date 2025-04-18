// 239. Sliding Window Maximum
// https://leetcode.com/problems/sliding-window-maximum/

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

class S239 {
	public static void main (String[] args) {
		// int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
		// int k = 3;
		// int[] nums = new int[]{9, 11};
		// int k = 2;
		// int[] nums = new int[]{1, -1};
		// int k = 1;
		int[] nums = new int[]{7, 2, 4};
		int k = 2;
		int[] res = maxSlidingWindow(nums, k);
		Arrays.stream(res).forEach(o -> System.out.println(o));
	}

	public static int[] maxSlidingWindow (int[] nums, int k) {
		Deque<Integer> deque = new ArrayDeque<>();
		int len = nums.length;
		List<Integer> res = new ArrayList<>();

		for (int i = 0; i < len; i++) {
			while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
				deque.pollLast();
			}
			deque.add(nums[i]);
			if (i >= k && nums[i - k] == deque.peekFirst()) {
				deque.pollFirst();
			}
			if (i >= k - 1) {
				res.add(deque.peekFirst());
			}
		}
		return res.stream().mapToInt(o -> o).toArray();
	}
	
	// public static int[] maxSlidingWindow (int[] nums, int k) {
	// 	PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
	// 	int len = nums.length;
	// 	List<Integer> res = new ArrayList<>();
	//
	// 	for (int i = 0; i < len; i++) {
	// 		if (pq.size() < k) {
	// 			pq.add(nums[i]);
	// 			if (pq.size() == k) {
	// 				res.add(pq.peek());
	// 			}
	// 		} else {
	// 			pq.remove(nums[i - k]);
	// 			pq.add(nums[i]);
	// 			res.add(pq.peek());
	// 		}
	// 	}
	//
	// 	AtomicInteger j = new AtomicInteger();
	// 	int[] fres = new int[res.size()];
	// 	res.forEach(o -> fres[j.getAndIncrement()] = o);
	// 	return fres;
	// }
}