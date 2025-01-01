// 63. Unique Paths II
// https://leetcode.com/problems/unique-paths-ii/

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
		HashMap<String, Integer> memo = new HashMap<>();
		int rLen = obstacleGrid.length;
		int cLen = obstacleGrid[0].length;
		int[] count = new int[]{0};
		recursion(0, 0, obstacleGrid, rLen, cLen, memo, count);
		return count[0];
	}

	public static int recursion(int i, int j, int[][] obstacleGrid, int rLen, int cLen, HashMap<String, Integer> memo, int[] count) {
		String key = i + "," + j;
		if (i == rLen || j == cLen) {
			return -1;
		} else if (obstacleGrid[i][j] == 1) {
			return -1;
		} else if (i == rLen - 1 && j == cLen - 1) {
			count[0]++;
			return 1;
		} else if (memo.containsKey(key)) {
			int val = memo.get(key);
			if (val != -1) {
				count[0] += val;
			}
			return val;
		}
		int val = memo.getOrDefault(key, 0);
		int res = recursion(i + 1, j, obstacleGrid, rLen, cLen, memo, count);
		if (res != -1) {
			val += res;
			memo.put(key, val);
		}

		int res2 = recursion(i, j + 1, obstacleGrid, rLen, cLen, memo, count);
		if (res2 != -1) {
			val += res2;
			memo.put(key, val);
		}
		
		return val;
	}
}