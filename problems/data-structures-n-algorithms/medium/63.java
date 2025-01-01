// 63. Unique Paths II
// https://leetcode.com/problems/unique-paths-ii/

import java.util.Arrays;
import java.util.HashMap;

class S63 {

	public static void main(String[] args) {
//		int[][] obstacleGrid = new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
//		int[][] obstacleGrid = new int[][]{{0, 1}, {0, 0}};
//		int[][] obstacleGrid = new int[][]{{0, 0, 0, 0}, {0, 1, 0, 0}, {0, 0, 0, 0}, {0, 0, 1, 0}, {0, 0, 0, 0}};
		int[][] obstacleGrid = new int[][]{{0, 0, 0, 0, 0}, {0, 0, 0, 0, 1}, {0, 0, 0, 1, 0}, {0, 0, 0, 0, 0}};
		int res = uniquePathsWithObstacles(obstacleGrid);
		System.out.println(res);
	}

	public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int rLen = obstacleGrid.length;
		int cLen = obstacleGrid[0].length;
		int[][] memo = new int[rLen][cLen];
		for (int i = 0; i < rLen; i++) {
			memo[i] = new int[cLen];
			Arrays.fill(memo[i], 0);
		}

		int[] count = new int[]{0};
		recursion(0, 0, obstacleGrid, rLen, cLen, memo, count);
		return count[0];
	}

	public static int recursion(int i, int j, int[][] obstacleGrid, int rLen, int cLen, int[][] memo, int[] count) {
		if (i == rLen || j == cLen) {
			return -1;
		} else if (obstacleGrid[i][j] == 1) {
			return -1;
		} else if (i == rLen - 1 && j == cLen - 1) {
			count[0]++;
			return 1;
		} else if (memo[i][j] != 0) {
			int val = memo[i][j];
			if (val != -1) {
				count[0] += val;
			}
			return val;
		}
		int val = memo[i][j];
		int res = recursion(i + 1, j, obstacleGrid, rLen, cLen, memo, count);
		if (res != -1) {
			val += res;
			memo[i][j] = val;
		}

		int res2 = recursion(i, j + 1, obstacleGrid, rLen, cLen, memo, count);
		if (res2 != -1) {
			val += res2;
			memo[i][j] = val;
		}

		return val;
	}
}