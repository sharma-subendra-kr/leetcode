// 433. Minimum Genetic Mutation
// https://leetcode.com/problems/minimum-genetic-mutation/

import java.util.*;

class S433 {
	public static void main (String[] args) {
		// String startGene = "AACCGGTT";
		// String endGene = "AACCGGTA";
		// String[] bank = new String[]{"AACCGGTA"};

		// String startGene = "AACCGGTT";
		// String endGene = "AAACGGTA";
		// String[] bank = new String[]{"AACCGGTA", "AACCGCTA", "AAACGGTA"};

		// String startGene = "AACCGGTT";
		// String endGene = "AACCGGTA";
		// String[] bank = new String[]{};

		String startGene = "AACCTTGG";
		String endGene = "AATTCCGG";
		String[] bank = new String[]{"AATTCCGG", "AACCTGGG", "AACCCCGG", "AACCTACC"};

		int res = minMutation(startGene, endGene, bank);
		System.out.println(res);
	}

	public static int minMutation (String startGene, String endGene, String[] bank) {
		int count = 0;
		int iter = 1;
		int depth = 0;
		HashSet<String> set = new HashSet<>(Arrays.asList(bank));
		Deque<String> q = new ArrayDeque<>();
		q.add(startGene);
		while (!q.isEmpty()) {
			String top = q.poll();
			iter--;
			if (top.equals(endGene)) {
				return depth;
			}

			String temp;
			for (int i = 0; i < 8; i++) {
				StringBuffer sb = new StringBuffer(top);
				sb.setCharAt(i, 'A');
				temp = sb.toString();
				if (set.contains(temp)) {
					set.remove(temp);
					q.add(temp);
					count++;
				}

				sb.setCharAt(i, 'C');
				temp = sb.toString();
				if (set.contains(temp)) {
					set.remove(temp);
					q.add(temp);
					count++;
				}

				sb.setCharAt(i, 'G');
				temp = sb.toString();
				if (set.contains(temp)) {
					set.remove(temp);
					q.add(temp);
					count++;
				}

				sb.setCharAt(i, 'T');
				temp = sb.toString();
				if (set.contains(temp)) {
					set.remove(temp);
					q.add(temp);
					count++;
				}
			}
			if (iter == 0) {
				iter = count;
				count = 0;
				depth++;
			}
		}
		return -1;
	}
}