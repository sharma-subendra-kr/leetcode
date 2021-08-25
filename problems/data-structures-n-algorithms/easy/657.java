// 657. Robot Return to Origin
// https://leetcode.com/problems/robot-return-to-origin/

class S657 {
	public static void main (String[] args) {
		String moves;

		moves = "LL";
		moves = "UD";

		boolean res = judgeCircle(moves);

		System.out.println(res);
	}

	public static boolean judgeCircle (String moves) {
		int x = 0, y = 0;

		for (int i = 0; i < moves.length(); i++) {
			if (moves.charAt(i) == 'U') {
				y++;
			} else if (moves.charAt(i) == 'D') {
				y--;
			} else if (moves.charAt(i) == 'L') {
				x--;
			} else {
				x++;
			}
		}
		if (x == 0 && y == 0) {
			return true;
		}
		return false;
	}
}