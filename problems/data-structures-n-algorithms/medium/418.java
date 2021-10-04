// 418. Sentence Screen Fitting
// https://leetcode.com/problems/sentence-screen-fitting/

class S418 {
	public static void main (String[] args) {
		String[] sentence;
		int rows, cols;

		sentence = new String[]{"hello", "world"};
		rows = 2;
		cols = 8;
		sentence = new String[]{"a", "bcd", "e"};
		rows = 3;
		cols = 6;
		sentence = new String[]{"i", "had", "apple", "pie"};
		rows = 4;
		cols = 5;
		sentence = new String[]{"f", "p", "a"};
		rows = 8;
		cols = 7;
		sentence = new String[]{"a", "bcd", "e"};
		rows = 4;
		cols = 6;

		sentence = new String[]{"a", "b", "c"};
		rows = 3;
		cols = 1;

		int res = wordsTyping(sentence, rows, cols);

		System.out.println(res);
	}

	public static int wordsTyping (String[] sentence, int rows, int cols) {
		int j, count, i = j = count = 0;
		int[][] cache = new int[sentence.length][];

		while (i < rows) {
			int[] res = null;

			if (cache[j] != null) {
				res = cache[j];
			} else {
				res = getResult(sentence, cols, j);
				cache[j] = res;
			}

			j = res[0];
			count += res[1];

			i++;
		}
		return count;
	}

	public static int[] getResult (String[] sentence, int cols, int j) {
		int i = 0;
		int curr = j;
		int count = 0;
		while (i < cols) {
			int len = sentence[curr].length();

			i = i + len + 1;
			if (i - 2 >= cols) {
				break;
			}

			curr++;
			if (curr == sentence.length) {
				curr = 0;
				count++;
			}
		}
		return new int[]{curr, count};
	}
}