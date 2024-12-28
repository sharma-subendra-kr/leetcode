// 373. Find K Pairs with Smallest Sums
// https://leetcode.com/problems/find-k-pairs-with-smallest-sums/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class S373 {
	public static void main (String[] args) {
		// int[] nums1 = new int[]{1, 7, 11};
		// int[] nums2 = new int[]{2, 4, 6};
		// int k = 3;
		int[] nums1 = new int[]{1, 2, 4, 5, 6};
		int[] nums2 = new int[]{3, 5, 7, 9};
		int k = 20;

		List<List<Integer>> res = kSmallestPairs(nums1, nums2, k);
		res.forEach(o -> {
			System.out.print("[" + o.get(0) + " ," + o.get(1) + "]");
		});
		System.out.println();
	}

	public static List<List<Integer>> kSmallestPairs (int[] nums1, int[] nums2, int k) {
		int len1 = nums1.length;
		int len2 = nums2.length;
		List<List<Integer>> res = new ArrayList<>();
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] + a[1]) - (b[0] + b[1]));
		for (int i = 0; i < len1 && i < k; i++) {
			pq.add(new int[]{nums1[i], nums2[0], 0});
		}

		while (!pq.isEmpty() && k > 0) {
			int[] top = pq.poll();
			res.add(Arrays.asList(top[0], top[1]));
			k--;
			if (top[2] != len2 - 1) {
				pq.add(new int[]{top[0], nums2[top[2] + 1], top[2] + 1});
			}
		}
		return res;
	}
}