// 777. Swap Adjacent in LR String
// https://leetcode.com/problems/swap-adjacent-in-lr-string/

import java.util.Arrays;

class S777 {
	public static void main (String[] args) {
		String start, end;

		start = "RXXLRXRXL";
		end = "XRLXXRRLX";
		start = "X";
		end = "L";
		start = "LLR";
		end = "RRL";
		start = "XL";
		end = "LX";
		start = "XLLR";
		end = "LXLX";
		start = "XXXXXLXXXX";
		end = "LXXXXXXXXX";
		start = "XLXRRXXRXX";
		end = "LXXXXXXRRR";

		boolean res = canTransform(start, end);

		System.out.println(res);
	}

	public static boolean canTransform (String start, String end) {
		StringBuffer _start = new StringBuffer(start);

		int endPointer = start.length() - 1;
		int startPointer = start.length() - 1;
		while (startPointer >= 0) {
			if (end.charAt(endPointer) != 'R') {
				endPointer--;
				startPointer = endPointer;
				continue;
			}
			if (_start.charAt(startPointer) == 'L') {
				return false;
			}
			if (_start.charAt(startPointer) == 'R') {
				_start.setCharAt(startPointer, _start.charAt(endPointer));
				_start.setCharAt(endPointer, 'R');
				endPointer--;
			}
			startPointer--;
		}

		endPointer = 0;
		startPointer = 0;
		while (startPointer < start.length()) {
			if (end.charAt(endPointer) != 'L') {
				endPointer++;
				startPointer = endPointer;
				continue;
			}
			if (_start.charAt(startPointer) == 'R') {
				return false;
			}
			if (_start.charAt(startPointer) == 'L') {
				_start.setCharAt(startPointer, _start.charAt(endPointer));
				_start.setCharAt(endPointer, 'L');
				endPointer++;
			}
			startPointer++;
		}
		return _start.toString().equals(end);
	}

	// public static boolean canTransform (String start, String end) {
	// 	int right = start.length() - 1;
	// 	int left = 0;
	//
	// 	StringBuffer _start = new StringBuffer(start);
	//
	// 	int leftInLeftSide = 0;
	// 	int leftInRightSide = 0;
	// 	int rightInLeftSide = 0;
	// 	int rightInRightSide = 0;
	// 	int leftSeenInLeft = 0;
	// 	// int leftSeenInRight = 0;
	// 	// int rightSeenInLeft = 0;
	// 	int rightSeenInRight = 0;
	//
	// 	while (left > 0 || right < start.length()) {
	// 		if (left < end.length() && end.charAt(left) == 'L') {
	// 			leftInLeftSide++;
	// 		}
	// 		if (right >= 0 && end.charAt(right) == 'L') {
	// 			leftInRightSide++;
	// 		}
	// 		if (left < end.length() && end.charAt(left) == 'R') {
	// 			rightInLeftSide++;
	// 		}
	// 		if (right >= 0 && end.charAt(right) == 'R') {
	// 			rightInRightSide++;
	// 		}
	//
	// 		if (right >= 0 && right < end.length() - 1 && _start.charAt(right) == 'R' && _start.charAt(right + 1) == 'X' &&
	// 		    rightInRightSide > rightSeenInRight) {
	// 			_start.setCharAt(right, 'X');
	// 			_start.setCharAt(right + 1, 'R');
	// 			if (end.charAt(right + 1) == 'R') {
	// 				rightInRightSide--;
	// 			}
	// 			if (end.charAt(right) == 'R') {
	// 				rightInRightSide--;
	// 			}
	// 			right += 2;
	// 		}
	// 		if (left < start.length() && left > 0 && _start.charAt(left) == 'L' && _start.charAt(left - 1) == 'X' &&
	// 		    leftInLeftSide > leftSeenInLeft) {
	// 			_start.setCharAt(left, 'X');
	// 			_start.setCharAt(left - 1, 'L');
	// 			if (end.charAt(left - 1) == 'L') {
	// 				leftInLeftSide--;
	// 			}
	// 			if (end.charAt(left) == 'L') {
	// 				leftInLeftSide--;
	// 			}
	// 			left -= 2;
	// 		}
	//
	// 		if (left >= 0 && left < end.length() && _start.charAt(left) == 'L') {
	// 			leftSeenInLeft++;
	// 		}
	// 		if (right >= 0 && right < end.length() && _start.charAt(right) == 'R') {
	// 			rightSeenInRight++;
	// 		}
	//
	// 		right--;
	// 		left++;
	// 	}
	// 	return _start.toString().equals(end) ? true : false;
	// }

	// public static boolean canTransform (String start, String end) {
	// 	int[] rightCount = new int[end.length()];
	// 	int[] leftCount = new int[end.length()];
	//
	// 	int sum = 0;
	// 	for (int i = end.length() - 1; i >= 0; i--) {
	// 		if (end.charAt(i) == 'R') {
	// 			sum = sum + 1;
	// 		}
	// 		rightCount[i] = sum;
	// 	}
	// 	sum = 0;
	// 	for (int i = 0; i < end.length(); i++) {
	// 		if (end.charAt(i) == 'L') {
	// 			sum = sum + 1;
	// 		}
	// 		leftCount[i] = sum;
	// 	}
	//
	// 	int right = start.length() - 1;
	// 	int left = 0;
	//
	// 	StringBuffer _start = new StringBuffer(start);
	//
	// 	int leftSeenInLeft = 0;
	// 	int rightSeenInRight = 0;
	//
	// 	while (left < start.length() || right >= 0) {
	// 		if (right >= 0 && right < end.length() - 1 && _start.charAt(right) == 'R' && _start.charAt(right + 1) == 'X' &&
	// 		    rightCount[right + 1] > rightSeenInRight) {
	// 			_start.setCharAt(right, 'X');
	// 			_start.setCharAt(right + 1, 'R');
	// 			right++;
	// 			continue;
	// 		}
	// 		if (left < start.length() && left > 0 && _start.charAt(left) == 'L' && _start.charAt(left - 1) == 'X' &&
	// 		    leftCount[left - 1] > leftSeenInLeft) {
	// 			_start.setCharAt(left, 'X');
	// 			_start.setCharAt(left - 1, 'L');
	// 			left--;
	// 			continue;
	// 		}
	//
	// 		if (left >= 0 && left < end.length() && _start.charAt(left) == 'L') {
	// 			leftSeenInLeft++;
	// 		}
	// 		if (right >= 0 && right < end.length() && _start.charAt(right) == 'R') {
	// 			rightSeenInRight++;
	// 		}
	//
	// 		right--;
	// 		left++;
	// 	}
	// 	return _start.toString().equals(end) ? true : false;
	// }
}