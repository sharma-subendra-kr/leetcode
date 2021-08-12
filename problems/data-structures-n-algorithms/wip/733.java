// 733. Flood Fill
// https://leetcode.com/problems/flood-fill/

class S733 {

	public static void main (String[] args) {
		int[][] image;
		int sr, sc, newColor;

		image = new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
		sr = 1;
		sc = 1;
		newColor = 2;

		image = new int[][]{{0, 0, 0}, {0, 1, 1}};
		sr = 1;
		sc = 1;
		newColor = 1;

		int[][] res = floodFill(image, sr, sc, newColor);

		for (int i = 0; i < res.length; i++) {
			for (int j = 0; j < res[i].length; j++) {
				System.out.print(res[i][j]);
				System.out.print("\t");
			}
			System.out.println("\n");
		}

	}

	public static void dfs (int[][] image, int sr, int sc, int newColor, int originalColor) {
		if (sr < 0 || sr >= image.length) {
			return;
		} else if (sc < 0 || sc >= image[sr].length) {
			return;
		} else if (image[sr][sc] != originalColor || image[sr][sc] == newColor) {
			return;
		}

		image[sr][sc] = newColor;
		dfs(image, sr + 1, sc, newColor, originalColor);
		dfs(image, sr - 1, sc, newColor, originalColor);
		dfs(image, sr, sc + 1, newColor, originalColor);
		dfs(image, sr, sc - 1, newColor, originalColor);
	}

	public static int[][] floodFill (int[][] image, int sr, int sc, int newColor) {
		// visited is not required
		// int[][] visited;
		// visited = new int[image.length][];
		// for (int i = 0; i < image.length; i++) {
		// 	visited[i] = new int[image[i].length];
		// }

		dfs(image, sr, sc, newColor, image[sr][sc]);
		return image;
	}
}