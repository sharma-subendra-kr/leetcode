// 682. Baseball Game
// https://leetcode.com/problems/baseball-game/

class S682 {
	public static void main (String[] args) {
		String[] ops;

		// ops = new String[]{"5", "2", "C", "D", "+"};
		ops = new String[]{"5", "-2", "4", "C", "D", "9", "+", "+"};

		int res = calPoints(ops);

		System.out.println(res);
	}

	public static int calPoints (String[] ops) {
		int[] res = new int[ops.length];
		int count = 0;

		for (int i = 0; i < ops.length; i++) {
			if (ops[i].equalsIgnoreCase("C")) {
				count--;
				continue;
			} else if (ops[i].equalsIgnoreCase("D")) {
				res[count] = res[count - 1] * 2;
			} else if (ops[i].equalsIgnoreCase("+")) {
				res[count] = res[count - 1] + res[count - 2];
			} else {
				res[count] = Integer.parseInt(ops[i]);
			}
			count++;
		}

		int sum = 0;
		for (int i = 0; i < count; i++) {
			sum = sum + res[i];
		}

		return sum;
	}
}