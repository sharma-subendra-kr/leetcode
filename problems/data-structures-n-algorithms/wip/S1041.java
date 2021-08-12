// 1041. Robot Bounded In Circle
// https://leetcode.com/problems/robot-bounded-in-circle/

import java.util.LinkedList;

// This is a valid solution. but its slightly LONG but nothing wrong with it!
// class S1041 {
//
// 	public static void main (String[] args) {
// 		String inst;
//
// 		// inst = "GGLLGG";
// 		inst = "GG";
// 		inst = "GL";
//
// 		boolean res = isRobotBounded(inst);
//
// 		System.out.println(res);
// 	}
//
// 	public static void processInput (char c, Data data) {
// 		if (c == 'G') {
// 			if (data.direction == 'n') {
// 				data.y++;
// 			} else if (data.direction == 'e') {
// 				data.x++;
// 			} else if (data.direction == 'w') {
// 				data.x--;
// 			} else {
// 				data.y--;
// 			}
// 		} else if (c == 'L') {
// 			if (data.direction == 'n') {
// 				data.direction = 'w';
// 			} else if (data.direction == 'w') {
// 				data.direction = 's';
// 			} else if (data.direction == 's') {
// 				data.direction = 'e';
// 			} else {
// 				data.direction = 'n';
// 			}
// 		} else if (c == 'R') {
// 			if (data.direction == 'n') {
// 				data.direction = 'e';
// 			} else if (data.direction == 'e') {
// 				data.direction = 's';
// 			} else if (data.direction == 's') {
// 				data.direction = 'w';
// 			} else {
// 				data.direction = 'n';
// 			}
// 		}
// 	}
//
// 	public static boolean isRobotBounded (String instructions) {
// 		Data data = new Data();
//
// 		for (int i = 0; i < instructions.length(); i++) {
// 			processInput(instructions.charAt(i), data);
// 		}
//
// 		if (data.direction == 'n' && (data.x != 0 || data.y != 0)) {
// 			return false;
// 		}
// 		return true;
// 	}
//
// 	static class Data {
// 		int x = 0;
// 		int y = 0;
// 		char direction = 'n';
// 	}
// }

class S1041 {

	public static void main (String[] args) {
		String inst;

		inst = "GGLLGG";
		// inst = "GG";
		// inst = "GL";

		boolean res = isRobotBounded(inst);

		System.out.println(res);
	}

	public static boolean isRobotBounded (String instructions) {
		int d[][] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
		int x = 0;
		int y = 0;
		int i = 0;
		for (int j = 0; j < instructions.length(); j++) {
			if (instructions.charAt(j) == 'R') {
				i = (i + 1) % 4;
			} else if (instructions.charAt(j) == 'L') {
				i = (i + 3) % 4;
			} else {
				x += d[i][0];
				y += d[i][1];
			}
		}

		if (i == 0 && (x != 0 || y != 0)) {
			return false;
		}
		return true;
	}
}