// 211. Design Add and Search Words Data Structure
// https://leetcode.com/problems/design-add-and-search-words-data-structure/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

class S211 {
	public static void main (String[] args) {
		WordDictionary wd = new WordDictionary();
		boolean res;
		wd.addWord("bad");
		wd.addWord("dad");
		wd.addWord("mad");
		res = wd.search("pad");
		System.out.println(res);
		res = wd.search("bad");
		System.out.println(res);
		res = wd.search(".ad");
		System.out.println(res);
		res = wd.search("b..");
		System.out.println(res);

		// wd.addWord("at");
		// wd.addWord("and");
		// wd.addWord("an");
		// wd.addWord("add");
		// res = wd.search("a");
		// System.out.println(res);
		// res = wd.search(".at");
		// System.out.println(res);
		// wd.addWord("bat");
		// res = wd.search(".at");
		// System.out.println(res);
		// res = wd.search("an.");
		// System.out.println(res);
		// res = wd.search("a.d.");
		// System.out.println(res);
		// res = wd.search("b.");
		// System.out.println(res);
		// res = wd.search("a.d");
		// System.out.println(res);
		// res = wd.search(".");
		// System.out.println(res);

	}

	public static class WordDictionary {
		Node root;

		public WordDictionary () {
			this.root = null;
		}

		public void addWord (String word) {
			if (this.root == null) {
				this.root = new Node();
			}
			int len = word.length();
			int i = 0;
			Node curr = this.root;
			while (i < len) {
				if (!curr.children.containsKey(word.charAt(i))) {
					Node node = new Node(word.charAt(i));
					curr.children.put(word.charAt(i), node);
				}
				curr = curr.children.get(word.charAt(i));
				i++;
			}
			curr.isWord = true;
		}

		public boolean search (String word) {
			int len = word.length();
			if (len == 0) {
				return false;
			} else if (this.root == null) {
				return false;
			}
			Node curr = this.root;
			return recursion(curr, 0, word, len);
		}

		public boolean recursion (Node node, int i, String word, int len) {
			if (node.isWord && i == len) {
				return true;
			} else if (i >= len || node == null) {
				return false;
			}
			if (word.charAt(i) == '.') {
				AtomicInteger ai = new AtomicInteger(i);
				AtomicBoolean ab = new AtomicBoolean(false);
				for (Node n : node.children.values()) {
					if (recursion(n, ai.get() + 1, word, len)) {
						ab.set(true);
						break;
					}
				}
				return ab.get();
			} else {
				if (node.children.containsKey(word.charAt(i))) {
					return recursion(node.children.get(word.charAt(i)), i + 1, word, len);
				} else {
					return false;
				}
			}
		}

		static class Node {
			char val;
			boolean isWord;
			HashMap<Character, Node> children;

			Node () {
				this.children = new HashMap<Character, Node>();
				this.isWord = false;
			}

			Node (char val) {
				this.val = val;
				this.children = new HashMap<Character, Node>();
				this.isWord = false;
			}
		}
	}
}