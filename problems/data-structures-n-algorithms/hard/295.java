// 295. Find Median from Data Stream
// https://leetcode.com/problems/find-median-from-data-stream/

import jdk.jfr.MemoryAddress;

import java.util.ArrayList;
import java.util.PriorityQueue;

class S295 {
	public static void main (String[] args) {
		double res;
		MedianFinder obj = new MedianFinder();
		obj.addNum(1);
		obj.addNum(2);
		res = obj.findMedian();
		System.out.println(res);
		obj.addNum(3);
		res = obj.findMedian();
		System.out.println(res);
	}

	static class MedianFinder {
		/**
		 * Your MedianFinder object will be instantiated and called as such: MedianFinder obj = new MedianFinder();
		 * obj.addNum(num); double param_2 = obj.findMedian();
		 */

		PriorityQueue<Integer> left;
		PriorityQueue<Integer> right;
		int lSize = 0;
		int rSize = 0;

		public MedianFinder () {
			this.left = new PriorityQueue<>((a, b) -> b - a);
			this.right = new PriorityQueue<>((a, b) -> a - b);
		}

		public void addNum (int num) {
			if (lSize == 0) {
				this.left.add(num);
				lSize++;
			} else if (lSize > rSize) {
				int top = this.left.peek();
				if (top > num) {
					this.left.poll();
					this.left.add(num);
					this.right.add(top);
				} else {
					this.right.add(num);
				}
				rSize++;
			} else if (rSize > lSize) {
				int top = this.right.peek();
				if (top < num) {
					this.right.poll();
					this.right.add(num);
					this.left.add(top);
				} else {
					this.left.add(num);
				}
				lSize++;
			} else {
				int lTop = this.left.peek();
				if (num < lTop) {
					this.left.add(num);
					this.lSize++;
				} else {
					this.right.add(num);
					this.rSize++;
				}
			}
		}

		public double findMedian () {
			double median;
			if (this.lSize == this.rSize) {
				int lTop = this.left.peek();
				int rTop = this.right.peek();
				median = (double) (lTop + rTop) / 2;
			} else if (lSize > rSize) {
				int lTop = this.left.peek();
				median = lTop;
			} else {
				int rTop = this.right.peek();
				median = rTop;
			}
			return median;
		}
	}
}