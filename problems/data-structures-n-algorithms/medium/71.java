// 71. Simplify Path
// https://leetcode.com/problems/simplify-path/

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

class S71 {
	public static void main (String[] args) {
		// String path = "/home/";
		// String path = "/home//foo/";
		// String path = "/home/user/Documents/../Pictures";
		String path = "/../";
		String res = simplifyPath(path);

		System.out.println(res);
	}

	public static String simplifyPath (String path) {
		Stack<String> s = new Stack<>();
		String[] arr = path.split("/");

		arr = Arrays.stream(arr).filter(o -> !o.isEmpty()).toArray(size -> new String[size]);
		int len = arr.length;
		for (int i = 0; i < len; i++) {
			if (arr[i].equals(".")) {
				continue;
			} else if (arr[i].equals("..")) {
				if (!s.isEmpty()) {
					s.pop();
				}
			} else {
				s.push(arr[i]);
			}
		}

		return "/" + String.join("/", s);
	}

	// public static String simplifyPath (String path) {
	// 	Deque<String> s = new ArrayDeque<>();
	// 	StringBuffer res = new StringBuffer();
	// 	String[] arr = path.split("/");
	//
	// 	arr = Arrays.stream(arr).filter(o -> !o.isEmpty()).toArray(size -> new String[size]);
	// 	int len = arr.length;
	// 	for (int i = 0; i < len; i++) {
	// 		if (arr[i].equals(".")) {
	// 			continue;
	// 		} else if (arr[i].equals("..")) {
	// 			s.pollLast();
	// 		} else {
	// 			s.add(arr[i]);
	// 		}
	// 	}
	//
	// 	if (s.isEmpty()) {
	// 		res.append("/");
	// 	}
	//
	// 	while (!s.isEmpty()) {
	// 		String str = s.poll();
	// 		res.append("/" + str);
	// 	}
	// 	return res.toString();
	// }
}