// 347. Top K Frequent Elements
// https://leetcode.com/problems/top-k-frequent-elements/

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicInteger;

class S347 {
	public static void main (String args[]) {
		// int[] nums = new int[]{1, 1, 1, 2, 2, 3};
		// int k = 2;
		int[] nums = new int[]{4, 1, -1, 2, -1, 2, 3};
		int k = 2;
		int[] res = topKFrequent(nums, k);
		Arrays.stream(res).boxed().forEach(i -> System.out.println(i));
	}

	public static int[] topKFrequent (int[] nums, int k) {
		HashMap<Integer, Integer> map = new HashMap<>();
		int len = nums.length;

		for (int i = 0; i < len; i++) {
			int val = map.getOrDefault(nums[i], 0);
			map.put(nums[i], val + 1);
		}

		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);

		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (pq.size() == k) {
				if (pq.peek()[1] < entry.getValue()) {
					pq.poll();
					pq.add(new int[]{entry.getKey(), entry.getValue()});
				}
			} else {
				pq.add(new int[]{entry.getKey(), entry.getValue()});
			}
		}
		int[] res = new int[k];
		AtomicInteger i = new AtomicInteger(0);
		pq.forEach(o -> res[i.getAndIncrement()] = o[0]);
		return res;
	}
}