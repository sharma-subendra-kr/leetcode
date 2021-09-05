// 460. LFU Cache
// https://leetcode.com/problems/lfu-cache/

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

class LFUCache {
	HashMap<Integer, DoublyLinkedList> freqMap;
	HashMap<Integer, Node> valueMap;
	int capacity = 0;
	int minFrequency = 0;

	public LFUCache (int capacity) {
		freqMap = new HashMap<>();
		valueMap = new HashMap<>();
		this.capacity = capacity;
	}

	public int get (int key) {
		if (!valueMap.containsKey(key)) {
			return -1;
		}
		Node node = valueMap.get(key);

		DoublyLinkedList prevFreqList = null;
		if (freqMap.containsKey(node.freq)) {
			prevFreqList = freqMap.get(node.freq);
			prevFreqList.remove(node);
		}

		if (prevFreqList != null && node.freq == minFrequency && prevFreqList.size == 0) {
			minFrequency = node.freq + 1;
		}

		node.freq++;

		DoublyLinkedList freqList = null;
		if (freqMap.containsKey(node.freq)) {
			freqList = freqMap.get(node.freq);
		} else {
			freqList = new DoublyLinkedList();
			freqMap.put(node.freq, freqList);
		}

		freqList.add(node);

		return node.value;
	}

	public void put (int key, int value) {
		Node keyNode = null;
		if (valueMap.containsKey(key)) {
			keyNode = valueMap.get(key);
			keyNode.value = value;
		} else if (capacity > 0) {
			keyNode = new Node(key, value, 0, null, null);
			valueMap.put(key, keyNode);

			if (valueMap.size() > capacity) {
				Node tail = freqMap.get(minFrequency).removeTail();
				valueMap.remove(tail.key);
			}
			minFrequency = 1;
		}
		get(key);
	}

	class Node {
		int key;
		int value;
		int freq;
		Node next;
		Node prev;

		public Node (int key, int value, int freq, Node next, Node prev) {
			this.key = key;
			this.value = value;
			this.freq = freq;
			this.next = next;
			this.prev = prev;
		}
	}

	class DoublyLinkedList {
		int size = 0;
		Node HEAD = null;
		Node TAIL = null;

		public void add (Node node) {
			if (HEAD == null) {
				HEAD = node;
				TAIL = node;
			} else {
				node.next = HEAD;
				HEAD.prev = node;
				HEAD = node;
			}
			size++;
		}

		public void remove (Node node) {
			if (HEAD == node) {
				HEAD = node.next;
			}

			if (TAIL == node) {
				TAIL = node.prev;
			}

			Node prev = node.prev;
			Node next = node.next;

			if (prev != null) {
				prev.next = next;
			}

			if (next != null) {
				next.prev = prev;
			}

			node.next = null;
			node.prev = null;
			size--;
		}

		public Node removeTail () {
			if (TAIL == null) {
				return null;
			}
			Node prevTail = TAIL;

			TAIL = TAIL.prev;
			if (TAIL != null) {
				TAIL.next = null;
			}
			if (prevTail == HEAD) {
				HEAD = TAIL;
			}
			size--;
			return prevTail;
		}
	}
}

class S460 {
	public static void main (String[] args) {
		// LFUCache lfuCache = new LFUCache(2);
		// lfuCache.put(1, 1);
		// lfuCache.put(2, 2);
		// System.out.println(lfuCache.get(1));
		// lfuCache.put(3, 3);
		// System.out.println(lfuCache.get(2));
		// System.out.println(lfuCache.get(3));
		// lfuCache.put(4, 4);
		// System.out.println(lfuCache.get(1));
		// System.out.println(lfuCache.get(3));
		// System.out.println(lfuCache.get(4));

		// LFUCache lfuCache = new LFUCache(3);
		// lfuCache.put(2, 2);
		// lfuCache.put(1, 1);
		// System.out.println(lfuCache.get(2));
		// System.out.println(lfuCache.get(1));
		// System.out.println(lfuCache.get(2));
		// lfuCache.put(3, 3);
		// lfuCache.put(4, 4);
		// System.out.println(lfuCache.get(3));
		// System.out.println(lfuCache.get(2));
		// System.out.println(lfuCache.get(1));
		// System.out.println(lfuCache.get(4));

		LFUCache lfuCache = new LFUCache(0);
		lfuCache.put(0, 0);
		System.out.println(lfuCache.get(0));
	}
}