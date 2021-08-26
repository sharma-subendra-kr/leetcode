// 1046. Last Stone Weight
// https://leetcode.com/problems/last-stone-weight/

import java.util.*;

class S1046 {
	public static void main (String[] args) {
		int[] stones;

		stones = new int[]{2, 7, 4, 1, 8, 1};
		stones = new int[]{1};
		stones = new int[]{2, 2};

		int res = lastStoneWeight(stones);

		System.out.println(res);
	}

	public static int lastStoneWeight (int[] stones) {
		PriorityQueue<Integer> pq = new PriorityQueue<>(stones.length, new Comparator<Integer>() {
			@Override
			public int compare (Integer o1, Integer o2) {
				return o2 - o1;
			}
		});

		for (int i : stones) {
			pq.add(i);
		}

		while (pq.size() > 1) {
			int a = pq.poll();
			int b = pq.poll();

			if (a == b) {
				continue;
			} else {
				pq.add(a - b);
			}
		}

		return pq.size() == 1 ? pq.poll() : 0;
	}
}